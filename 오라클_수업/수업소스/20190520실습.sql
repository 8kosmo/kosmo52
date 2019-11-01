우리회사에 근무하는 사원들의 급여명세서를 출력하는 SQL문을 작성하시오.

사원번호(emp)   사원명(emp)    부서명(dept)
------------------------

연습문제1

2019년 5월 20일 DVD를 대여한 사람들의 명단을 출력하는 SQL문을
작성하시오.

날짜  이름  DVD명 전화번호 주소 반납일자
---------------------------------




연습문제2
어벤져스 DVD를 대여한 사람들 중 반납을 안 한 사람들의 명단을
출력하는 SQL문을 작성하시오.

edit emp

edit dept

SELECT 
       emp.deptno, dept.deptno, dept.dname
  FROM emp, dept
 WHERE emp.deptno(+) = dept.deptno
 
SELECT 
       emp.deptno, dept.deptno, dept.dname
  FROM emp RIGHT OUTER JOIN dept
    ON emp.deptno = dept.deptno 
    
SELECT 
       emp.deptno, dept.deptno, dept.dname
  FROM dept LEFT OUTER JOIN emp
    ON emp.deptno = dept.deptno     
    
non-equal 조인

조인 조건이 '='이 아닌 다른 연산기호로 주어지는 경우

temp와 emp_level을 이용해 emp_level의 과장 직급의 연봉
상한/하한 범위 내에 드는 직원의 사번과 성명, 직급, salary를
출력하는 sql문을 작성하시오.

SELECT temp.emp_id, temp.emp_name, TEMP.LEV
      ,temp.salary
  FROM temp, emp_level
 WHERE emp_level.lev='과장'
   AND temp.salary BETWEEN from_sal AND to_sal


연습문제
각 사번의 성명, salary, 연봉하한금액, 연봉상한금액을 보고자 한다.
이 정보를 출력하는 select문은 어떤 조인을 걸어야 할까?

SELECT * FROM emp_level

    