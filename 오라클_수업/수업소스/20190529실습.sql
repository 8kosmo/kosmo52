CREATE OR REPLACE PROCEDURE proc_empnoUpdate(p_empno IN number, msg OUT varchar2)
IS
--�����
  v_ename varchar2(30);--�������
  n_sal number(7,2);--����Ǳ޿�
  n_rate number(3,1);--������ ����
  n_avgsal number(7,2);--��ձ޿�
BEGIN
--���α׷���
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
  msg:=v_ename||'����� �޿��� '||n_rate||'��������'||n_sal * n_rate||'�λ�Ǿ����ϴ�.';                
END;

rollback;