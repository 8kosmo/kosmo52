각 행에 1학년 부터 4학년 까지를 분리해서 한 행에 하나의 학년만
나오도록 한다.
현재 12행이 있으니 총 48행의 결과가 대학별/학과별로 인원수가
나와야 한다.

더미테이블

SELECT rownum rno FROM emp
 WHERE rownum <5
 
SELECT *
  FROM test11,
      (
       SELECT rownum rno FROM emp
        WHERE rownum <5
      )a 
      
DECODE(a.rno,1,'1학년',2,'2학년',3,'3학년',4,'4학년')

DECODE(a.rno,1,fre,2,sup,3,jun,4,sen)      


SELECT coll, dept 
      ,DECODE(a.rno,1,'1학년',2,'2학년',3,'3학년',4,'4학년') "학년"
      ,DECODE(a.rno,1,fre,2,sup,3,jun,4,sen) "정원수"  
  FROM test11,
      (
       SELECT rownum rno FROM emp
        WHERE rownum <5
      )a 
ORDER BY dept asc, 학년 asc

연습문제2

1,2학년과 3,4학년의 인원수가 각각 같은 줄에 나오도록 해보시오.     