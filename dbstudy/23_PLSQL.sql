/*
    PL/SQL
    
    1. 오라클의 프로그래밍 처리가 가능한 SQL
    2. 프로그래밍 형식
        [DECLARE]
            [변수 선언]
        BEGIN
            수행할 PL/SQL
        END;
    3. PL/SQL의 데이터(변수, 상수)는 서버메시지로 출력
    4. 서버메시지 출력을 위해서 최초 1회 설정이 필요(디폴트 SET SERVEROUTPUT OFF)
        SET SERVEROUTPUT ON;
*/

-- 기초 데이터 준비
-- HR 계정의 EMPLOYEES 테이블을 SCOTT 계정으로 복사해 오기
CREATE TABLE EMPLOYEES
    AS (SELECT *
          FROM HR.EMPLOYEES);
-- 기본키 다시 생성
ALTER TABLE EMPLOYEES
    ADD CONSTRAINT PK_EMPLOYEES PRIMARY KEY(EMPLOYEE_ID);
    
-- 서버메시지 출력 가능 상태로 변경
-- 한 번만 실행하면 됨
SET SERVEROUTPUT ON;

-- 서버메시지 출력
BEGIN
    DBMS_OUTPUT.PUT('Hello'); -- Hello 출력
END;

-- 스칼라 변수 선언
-- 스칼라 변수 : 직접 타입을 명시하는 변수
-- 대입 연산자 : 콜론등호(:=)
-- 변수 선언은 DECLARE에서 처리
DECLARE
    -- 변수 선언
    NAME VARCHAR2(20 BYTE);
    AGE NUMBER(3);
BEGIN
    NAME := '민경태';
    AGE := 45;
    DBMS_OUTPUT.PUT_LINE('내 이름은 ' || NAME || '입니다.');
    DBMS_OUTPUT.PUT_LINE('내 나이는 ' || AGE || '살입니다.');
END;

-- 참조 변수 선언
-- 참조 변수 : 특정 칼럼의 타입을 그대로 사용하는 변수
-- 선언 방법
-- 테이블명.칼럼%TYPE

DECLARE
    -- 참조 변수 선언
    NAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    NAME := '민경태';
    DBMS_OUTPUT.PUT_LINE('내 이름은 ' || NAME || '입니다.');
END;

-- 참조 변수 활용
-- 테이블의 데이터를 읽어 참조 변수에 저장
-- SELECT 칼럼 INTO 변수 FROM 테이블 WHERE 조건식

-- 문제. EMPLOYEE_ID가 100인 회원의 FIRST_NAME, LAST_NAME, SALARY 정보를 참조 변수에 저장
DECLARE
    F_NAME EMPLOYEES.FIRST_NAME%TYPE;
    L_NAME EMPLOYEES.LAST_NAME%TYPE;
    V_SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT
            FIRST_NAME, LAST_NAME, SALARY 
    INTO 
            F_NAME, L_NAME, V_SALARY
       FROM
            EMPLOYEES
      WHERE
            EMPLOYEE_ID = 100;
      DBMS_OUTPUT.PUT_LINE(F_NAME || L_NAME || V_SALARY);
END;

-- 레코드 변수 선언
-- 레코드 : 필드의 모임
-- DB에서 레코드란? 행(ROW)
-- 레코드 변수 : 여러 칼럼을 동시에 저장하는 변수
-- 레코드 변수 정의와 선언 과정으로 진행

DECLARE
    -- 레코드 변수 타입 정의(타입 만들기)
    TYPE MY_TYPE IS RECORD(
        V_FNAME EMPLOYEES.FIRST_NAME%TYPE,
        V_LNAME EMPLOYEES.LAST_NAME%TYPE,
        V_SALARY EMPLOYEES.SALARY%TYPE
    );
    -- 레코드 변수 선언(변수 만들기)
    V_ROW MY_TYPE;
BEGIN
    SELECT
            FIRST_NAME, LAST_NAME, SALARY
      INTO
            V_ROW
      FROM
            EMPLOYEES
     WHERE
            EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT_LINE(V_ROW.V_FNAME || V_ROW.V_LNAME || V_ROW.V_SALARY);
END;

-- 4. 행 변수 선언하기
-- 행(ROW) 전체를 저장할 수 있는 타입
-- 선언 방법
-- 테이블%ROWTYPE

DECLARE
    -- 행 변수 선언
    V_ROW EMPLOYEES%ROWTYPE;
BEGIN
    SELECT *
      INTO V_ROW
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT_LINE(V_ROW.FIRST_NAME || V_ROW.LAST_NAME || V_ROW.SALARY);
END;
    
-- 5. IF
/*
    IF 조건식 THEN
        실행문
    ELSIF 조건식 THEN
        실행문
    ELSE
        실행문
    END IF;
*/

-- 1) 성인/미성년자
DECLARE
    AGE NUMBER(3);
    RESULT VARCHAR2(20 BYTE);
BEGIN
    AGE := 45;
    IF AGE >= 20 THEN
        RESULT := '성인';
    ELSE
        RESULT := '미성년자';
    END IF;
    DBMS_OUTPUT.PUT_LINE(AGE || '살은' || RESULT || '입니다.');
END;

-- 2) 학점(A, B, C, D, F)
DECLARE
    SCORE NUMBER(3);
    GRADE VARCHAR2(1 BYTE);
BEGIN
    SCORE := 100;
    IF SCORE >= 90 THEN
        GRADE := 'A';
    ELSIF SCORE >= 80 THEN
        GRADE := 'B';
    ELSIF SCORE >= 70 THEN
        GRADE := 'C';
    ELSIF SCORE >= 70 THEN
        GRADE := 'D';
    ELSE
        GRADE := 'F';
    END IF;
    DBMS_OUTPUT.PUT_LINE(SCORE || '점은' || GRADE || '학점입니다.');
END;

-- 3) EMPLOYEE_ID가 150인 사원의 연봉을 참조하여
-- 15000 이상이면 '고연봉', 10000 이상이면 '중연봉', 나머지는 '저연봉'
DECLARE
    SAL EMPLOYEES.SALARY%TYPE;
    RES VARCHAR2(20 BYTE);
BEGIN
    SELECT SALARY
      INTO SAL
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 150;
    IF SAL >= 15000 THEN
        RES := '고연봉';
    ELSIF SAL >= 10000 THEN
        RES := '중연봉';
    ELSE 
        RES := '저연봉';
    END IF;
    DBMS_OUTPUT.PUT_LINE('연봉' || SAL || '은 ' || RES || '입니다.');
END;

-- 6. CASE문
/*
    CASE
        WHEN 조건식 THEN
            실행문
        WHEN 조건식 THEN
            실행문
        ELSE
            실행문
    END CASE;
*/

-- 주민번호를 이용해 성별 조회하기
DECLARE
    SNO VARCHAR2(14 BYTE);
    GENDER_NUM VARCHAR2(1 BYTE);
    GENDER VARCHAR2(1 BYTE);
BEGIN
  SNO := '901010-1234567';
  SELECT SUBSTR(SNO, 8, 1)
    INTO GENDER_NUM
    FROM DUAL;
  CASE
    WHEN GENDER_NUM = '1' THEN
        GENDER := 'M';
    WHEN GENDER_NUM = '2' THEN
        GENDER := 'F';
  END CASE;
  DBMS_OUTPUT.PUT_LINE('성별은 ' || GENDER || '입니다.');
END;

-- WHILE문
/*
    WHILE 조건식 LOOP
        실행문
    END LOOP;
*/

-- 1) 1 ~ 5 출력하기
DECLARE
    N NUMBER(1);
BEGIN
    N := 1;
    WHILE N <= 5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
    END LOOP;
END;

-- 2) EMPLOYEES 테이블의 모든 사원의 FIRST_NAME, LAST_NAME 조회
-- FIRST_NAME과 LAST_NAME을 레코드 변수에 저장하고 해당 값을 조회
-- 레코드 변수는 사원 한 명의 정보만 저장할 수 있으므로 한 명씩 저장 후 출력
-- 사원번호는 100 ~ 206 값을 가짐
DECLARE
    -- 참조 변수 선언
    EMP_NO EMPLOYEES.EMPLOYEE_ID%TYPE;
    -- 레코드 변수 정의
    TYPE NAME_TYPE IS RECORD(
        FNAME EMPLOYEES.FIRST_NAME%TYPE,
        LNAME EMPLOYEES.LAST_NAME%TYPE
    );
    -- 레코드 변수 선언
    FULL_NAME NAME_TYPE;
BEGIN

    -- 사원번호(100 ~ 106) 기준으로 WHILE LOOP
    
    EMP_NO := 100;
    WHILE EMP_NO <= 206 LOOP
        SELECT FIRST_NAME, LAST_NAME
          INTO FULL_NAME
          FROM EMPLOYEES
         WHERE EMPLOYEE_ID = EMP_NO;
        DBMS_OUTPUT.PUT_LINE(FULL_NAME.FNAME || ' ' || FULL_NAME.LNAME);
        EMP_NO := EMP_NO + 1;
    END LOOP;
END;
    



