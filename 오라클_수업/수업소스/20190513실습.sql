테이블의 오른쪽을 증가시키려면?

SELECT 1,2,3,4 FROM dual

테이블의 로우를 증가시키려면?
insert문 실행시킴 - 한개 컬럼만 추가, 여러개 컬럼

emp

PK - 유일해야함, Unique, Not NULL, 인덱스제공(자동)

FK - 중복됨, 인덱스제공안됨, Not NULL



SELECT 1 FROM dual
UNION ALL
SELECT 2 FROM dual
UNION ALL
SELECT 3 FROM dual

집합

MINUS

INTERSECT

UNION ALL, UNION(중복제거) - 정렬이 일어남.

ORDER BY를 사용하면 정렬을 할 수 있다.
NULL있을 경우 정렬
2차가공이 필수다.

emp

SELECT empno FROM emp

파싱 - DBMS실행계획세운다 - 옵티마이저 - OPEN-CURSOR-FETCH

SELECT empno,ename FROM emp

hint문
hint문에 오타나 문법에러가 있을 경우 무시당함.

SELECT /*+index_desc(emp pk_emp)*/ empno FROM emp

조건 검색 단위테스트하기

SELECT ename FROM emp WHERE deptno =:x
                       AND sal> =:y
                       
                       
SELECT
  FROM
 WHERE
GROUP BY 
ORDER BY                       

SELECT
       max(sal), min(ename), count(deptno)
  FROM emp
  
김대리 우리회사에 근무하는 사원들 중에서 급여를 제일 많이 받는 사원의 이름이 뭐니?

SELECT max(sal)
  FROM emp


SELECT max(sal), ename
  FROM emp  
  
SELECT max(sal), min(ename)
  FROM emp   
  
SELECT ename
  FROM emp
 WHERE sal = (SELECT max(sal) FROM emp)
 
WHERE절 아래 SELECT문이 올 수 있다. ->  서브쿼리    
  

김대리 우리회사에 근무하는 사원들 중에서 부서별로 급여를 제일 많이 받는 사원의 이름이 
뭐니?  

SELECT deptno,max(sal), min(sal), ename
  FROM emp
GROUP BY deptno  

문법에러가 발생함.
1)ename에도 동일하게 그룹함수를 씌운다. - 의미가 없다.
2)group by 아래 ename컬럼 추가함. - group by한 의미가 없다.

SELECT deptno,max(sal), min(sal), max(ename)
  FROM emp
GROUP BY deptno  

SELECT deptno,max(sal), min(sal), ename
  FROM emp
GROUP BY deptno, ename 


SELECT ename, sal
  FROM emp
 WHERE sal IN (SELECT max(sal) FROM emp GROUP BY deptno)
 
UNION ALL을 사용하면 정렬없이 두 집합을 있는 그대로 합친다.
중복이 제거안됨.
동일한 집합을 두 번 스캔

IN은 여러개 로우를 비교할 때 가능하다.
집합을 한번만 읽고 처리

SELECT deptno, job, count(*), sum(sal)
 FROM emp
GROUP BY deptno, job

SELECT deptno, job
 FROM emp
GROUP BY deptno, job

group by아래 2개 이상 컬럼도 사용할 수 있다.
 
 
SELECT ename, sal
  FROM emp
 WHERE deptno IN (10,20)
 
SELECT ename, sal
  FROM emp
 WHERE deptno = 10
UNION ALL 
SELECT ename, sal
  FROM emp
 WHERE deptno = 20
  
edit emp 

SELECT count(comm), count(*) FROM emp

count시 주의사항
NULL이 있는 경우에는 카운트 하지 않는다.
결론 - *를 사용하거나 pk를 count해야 전체 갯수를 센다.

SELECT sum(comm) FROM emp

SELECT SUM(NVL(comm,0)) FROM emp

결론
그룹함수 사용시 NULL인 경우는 계산대상이 아니다.
그것을 굳이 NULL체크를 하여 0으로 치환한 후 계산할 필요는 없다.

테이블 설계관점에서 본다면 comm의 경우 디폴트로 0이 들어가도록 설계하는 것이 맞다.
NULL로 둘 경우 의미가 모호하기 때문이다.

실행계획 보는 방법
Ctrl+e

ALL ROWS의 경우 조건을 만족하는 모든 데이터를 조회하는데 유리한 실행계획을 
세웠다는 것을 의미함.

COST- 실행시간

