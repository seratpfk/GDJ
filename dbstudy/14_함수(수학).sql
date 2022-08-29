-- 숫자 함수

-- 1. 제곱
--    POWER(A, B) : A의 B제곱
SELECT POWER(2, 10) FROM DUAL;

-- 2. 제곱근(루트)
--    SQRT(A) : 루트 A
SELECT SQRT(25) FROM DUAL;

-- 3. 절대값
--    ABS(A) : A의 절대값
SELECT ABS(5) FROM DUAL;
SELECT ABS(-5) FROM DUAL;

-- 4. 나머지
--    MOD(A, B) : A를 B로 나눈 나머지
SELECT MOD(7, 2) FROM DUAL;

-- 5. 부호 판별
--    SIGN(A) : A의 부호가 +이면 1, -이면 -1, 0이면 0을 반환
SELECT SIGN(5), SIGN(-5), SIGN(0) FROM DUAL;

-- 6. 정수 올림
--    CEIL(A) : 실수 A를 정수로 올림
SELECT CEIL(1, 1), CEIL(-1, 1) FROM DUAL;

-- 7. 정수로 내림
--    FLOOR(A) : 실수 A를 정수로 내림
SELECT FLOOR(1, 1), FLOOR(-1, 1) FROM DUAL;

-- 8. 원하는 자리수로 절사
--    TRUNC(A, [DIGIT]) : 실수 A를 DIGIT 자리수로 절사, DIGIT 생략하면 정수로 절사
SELECT 
        TRUNC(1.9999)
      , TRUNC(1.9999, 1)
      , TRUNC(1.9999, 2)
   FROM
        DUAL;
SELECT
        TRUNC(9999, -1) -- 9990 (원 단위 절사)
      , TRUNC(9999, -2) -- 9900
   FROM
        DUAL;
        
-- 9. 원하는 자릿수로 반올림
--    ROUND(A, [DIGIT]) : 실수 A를 DIGIT 자리수로 절사, DIGIT 생략하면 정수로 반올림
SELECT 
        ROUND(145.45) -- 145
      , ROUND(145.45, 1) --145.5
      , ROUND(145.45, -1) -- 150
   FROM
        DUAL;
        
-- 문제발생
-- 1. 원하는 자릿수로 올림                         DIGIT
--    1) 소수1자리 : CEIL(값 * 10) / 10               1
--    2) 소수2자리 : CEIL(값 * 100) / 100              2
--    3) 소수3자리 : CEIL(값 * 1000) / 1000            3
--    4) 정수      : CEIL(값 * 1) / 1                 0
--    5) 일의자리  : CEIL(값 * 0.1) / 0.1             -1
--    6) 십의자리  : CEIL(값 * 0.01) / 0.01           -2
--    7) 백의자리  : CEIL(값 * 0.001) / 0.001         -3
--    일반화       : CEIL(값 * POWER(10, DIGIT)) / POWER(10, DIGIT)
SELECT
        CEIL(1.111 * POWER(10, 1)) / POWER(10, 1)  -- 1.2
      , CEIL(1.111 * POWER(10, 2)) / POWER(10, 2)  -- 1.12
      , CEIL(11111 * POWER(10, -1)) / POWER(10, -1) -- 11120
      , CEIL(11111 * POWER(10, -2)) / POWER(10, -2) -- 11200
   FROM
        DUAL;
        
-- 2. 원하는 자릿수로 내림
--    CEIL 대신 FLOOR 함수를 사용하면 됨
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- 2. 원하는 형식으로 날짜와 시간 조회
--    TO_CHAR 함수 : 날짜를 문자로 변환해서 조회
SELECT 
       TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS') -- 12시간
     , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') -- 24시간
  FROM
       DUAL;
      
-- 3. 단위(년, 월, 일, 시, 분, 초) 추출 함수
--    EXTRACT(단위 FROM 날짜)
SELECT
     EXTRACT(YEAR FROM SYSDATE) AS 년도
   , EXTRACT(MONTH FROM SYSDATE) AS 월
   , EXTRACT(DAY FROM SYSDATE) AS 일
   , EXTRACT(HOUR FROM SYSTIMESTAMP) AS 시
   , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS 분
   , EXTRACT(SECOND FROM SYSTIMESTAMP) AS 초
   , EXTRACT(TIMEZONE_HOUR FROM SYSTIMESTAMP) AS 시 -- 우선 TIMEZONE 설정이 필요
   , FLOOR(EXTRACT(SECOND FROM SYSTIMESTAMP)) AS 초
 FROM
    DUAL; 
    
-- 단위(년,월,일,시,분,초) 추출은 ? 함수로도 가능함
SELECT
        TO_CHAR(SYSDATE, 'YYYY')
      , TO_CHAR(SYSDATE, 'M')
      , TO_CHAR(SYSDATE, 'D')
      , TO_CHAR(SYSDATE, 'HH24')
      , TO_CHAR(SYSDATE, 'MI')
      , TO_CHAR(SYSDATE, 'SS')
   FROM
        DUAL;
        
-- 4. 날짜 연산
--    1) 하루(1일)를 숫자 1로 처리
--       (12시간을 숫자 0.5로 처리)
--    2) 특정 단위 후 날짜
--       (1) 1년 후 : + 365, 함수 없음
--       (2) 1개월 후 : ADD_MONTHS 함수 사용
--       (3) 1일 후 : + 1, 함수 없음
SELECT
        SYSDATE - 1 AS 어제
      , SYSDATE + 1 AS 내일
      , SYSDATE - 0.5 AS "12시간전"
      , SYSDATE + 0.5 AS "12시간후"
      , TO_CHAR(SYSDATE - 0.5, 'MM/DD AM HH:MI:SS') AS "12시간전"
      , TO_CHAR(SYSDATE + 0.5, 'MM/DD AM HH:MI:SS') AS "12시간후"
      , TO_CHAR(SYSDATE + (1 / 24), 'MM/DD AM HH:MI:SS') AS "1시간후"
   FROM
        DUAL;
        
-- 5. N개월 전후 날짜
--    ADD_MONTHS(날짜, N)
SELECT
       ADD_MONTHS(SYSDATE, -1) AS "1개월전"
     , ADD_MONTHS(SYSDATE, 1) AS "1개월후"
  FROM 
       DUAL;
       
-- 6. 경과한 개월 수
--    MONTHS_BETWEEN(최근날짜, 이전날짜) : 두 날짜 사이의 경과한 개월 수
SELECT
        MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
  FROM 
        EMPLOYEE;
    
