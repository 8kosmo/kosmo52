SELECT ename, dname FROM emp, dept
WHERE EMP.DEPTNO = dept.deptno
AND emp.ename='SMITH'

commit;

DELETE FROM  emp WHERE ename='SMITH'

rollback;

DELETE FROM dept WHERE deptno=20

SELECT empno FROM emp   --옵티마이저

SELECT ename FROM emp

우리회사에 근무하는 사원중에서 급여가 2500불 이상인 사원의 이름과 급여액을
출력하는 SQL문을 작성하시오.

문제뜻을 분석
집합이름 뭐지? 사원집합 - emp
어떤 정보를 보여줘야하는거니? - 이름과 급여, ename, sal
결과는 어떤 폼으로 보여주면 될까?
원하는 조건이 있는 거니?

WHERE sal >=2000

SELECT ename, sal
  FROM emp
 WHERE sal >=2500
 
 
문제2 - 요구사항 IN구문을 사용하시오.
우리 회사에 근무하는 사원들 중에서 부서번호가 20 혹은 30번 부서에 근무하는
사원들의 사원명, 부서번호, sal를 출력하는 SQL문을 작성하시오.

SELECT ename, deptno, sal
  FROM emp
WHERE deptno IN(20,30);

SELECT ename, deptno, sal
  FROM emp
WHERE deptno = 20
   OR deptno = 30
   
우리회사에 근무하는 사원들 중에서 인센티브를 받는 사원들의 이름,인센티브금액을
출력하는 SQL문을 작성하시오.

SELECT ename, comm FROM emp  14건

NULL인 경우는 제외한다.

SELECT ename, comm FROM emp
WHERE comm IS NOT NULL
AND comm <>0

SELECT ename, comm FROM emp
MINUS
SELECT ename, comm FROM emp
WHERE comm=0
MINUS
SELECT ename, comm FROM emp
WHERE comm IS NULL

SELECT 1+2,2+NULL FROM dual

dual:컬럼하나에 로우하나짜리 가상 테이블

SELECT sysdate, TO_CHAR(sysdate,'YYYY')
      ,TO_CHAR(sysdate,'day') 
  FROM dual   
  
SELECT 와 FROM절 사이에 컬럼이 온다.
SELECT 와 FROM절 사칙연산이 가능하다.
SELECT 와 FROM절 사이에 함수를 사용할 수 있다.  
SELECT와 FROM절 사이에 컬럼을 추가하면 테이블의 오른쪽이 늘어나요.
테이블의 아래쪽을 늘일려면 insert한다.
  
업무담당자는 테이블 구조 그대로 보여주기를 바라지 않는다.

SELECT empno, ename, job, sal,comm ,hiredate,deptno,mgr 
  FROM emp



SELECT 1,2,3,4,5,6,7,'안녕' FROM dual

SELECT 1+2, 3*5, 5/10, sysdate+1 FROM dual  
  