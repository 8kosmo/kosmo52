CREATE OR REPLACE PROCEDURE proc_empnoUpdate(p_empno IN number, msg OUT varchar2)
IS
--선언부
  v_ename varchar2(30);--사원명담기
  n_sal number(7,2);--사원의급여
  n_rate number(3,1);--적용할 요율
  n_avgsal number(7,2);--평균급여
BEGIN
--프로그래밍
  SELECT ename, sal INTO v_ename, n_sal
    FROM emp
   WHERE empno = p_empno;  
  SELECT avg(sal) INTO n_avgsal FROM emp
   WHERE deptno=(SELECT deptno FROM emp
                  WHERE empno=p_empno);
  IF n_sal > n_avgsal THEN
     n_rate := 1.1;
  ELSE
     n_rate := 1.2;
  END IF; 
  UPDATE emp
    SET sal= n_sal/n_rate
   WHERE empno = p_empno;
  commit;
  msg:=v_ename||'사원의 급여가 '||n_rate||'적용으로'||n_sal * n_rate||'인상되었습니다.';                
END;

rollback;