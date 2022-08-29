-- 함수 확인용 기초데이터
DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NAME VARCHAR2(20 BYTE),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MATH NUMBER(3)
);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES(NULL, 100, 100, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('영숙', NULL, 100, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('정수', 100, NULL, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('지영', 100, 100, NULL);
COMMIT;

--NULL값의 연산에서 사용되면 결과가 NULL이다.
SELECT 1 + NULL FROM DUAL;

-- NULL 처리 함수
-- 1. NVL 
--    NVL(칼럼, 칼럼값이 NULL일 때 대신 사용할 값)

-- NAME이 없으면 '아무개', KOR, ENG, MATH가 없으면 0으로 조회
SELECT
        NVL(NAME, '아무개') AS STU_NAME
      , NVL(KOR, 0)
      , NVL(ENG, 0)
      , NVL(MATH, 0)
   FROM
        SAMPLE
  ORDER BY
        NVL(NAME, '아무개') ASC;
        
-- 이름과 총점을 조회하기
-- 이름이 없으면 '아무개', 점수가 없으면 0점 처리
-- 결과
-- 아무개 300
-- 영숙   200
-- 정수   200
-- 지영   200
SELECT
        NVL(NAME, '아무개') AS 이름
      , NVL(KOR, 0) + NVL(ENG, 0) + NVL(MATH, 0) AS 총점
   FROM 
        SAMPLE;
    
-- 2. NVL2 함수
--    NVL2(칼럼, NULL이 아닐 때 사용할 값, NULL일 때 사용할 값)
SELECT
        NVL2(NAME, NAME || '님', '아무개')
      , NVL2(KOR, '응시', '결시')
      , NVL2(ENG, '응시', '결시')
      , NVL2(MATH, '응시', '결시')
  FROM
        SAMPLE;