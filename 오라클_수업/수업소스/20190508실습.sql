SELECT ename, dname FROM emp, dept
WHERE EMP.DEPTNO = dept.deptno
AND emp.ename='SMITH'

commit;

DELETE FROM  emp WHERE ename='SMITH'

rollback;

DELETE FROM dept WHERE deptno=20

SELECT empno FROM emp   --��Ƽ������

SELECT ename FROM emp

�츮ȸ�翡 �ٹ��ϴ� ����߿��� �޿��� 2500�� �̻��� ����� �̸��� �޿�����
����ϴ� SQL���� �ۼ��Ͻÿ�.

�������� �м�
�����̸� ����? ������� - emp
� ������ ��������ϴ°Ŵ�? - �̸��� �޿�, ename, sal
����� � ������ �����ָ� �ɱ�?
���ϴ� ������ �ִ� �Ŵ�?

WHERE sal >=2000

SELECT ename, sal
  FROM emp
 WHERE sal >=2500
 
 
����2 - �䱸���� IN������ ����Ͻÿ�.
�츮 ȸ�翡 �ٹ��ϴ� ����� �߿��� �μ���ȣ�� 20 Ȥ�� 30�� �μ��� �ٹ��ϴ�
������� �����, �μ���ȣ, sal�� ����ϴ� SQL���� �ۼ��Ͻÿ�.

SELECT ename, deptno, sal
  FROM emp
WHERE deptno IN(20,30);

SELECT ename, deptno, sal
  FROM emp
WHERE deptno = 20
   OR deptno = 30
   
�츮ȸ�翡 �ٹ��ϴ� ����� �߿��� �μ�Ƽ�긦 �޴� ������� �̸�,�μ�Ƽ��ݾ���
����ϴ� SQL���� �ۼ��Ͻÿ�.

SELECT ename, comm FROM emp  14��

NULL�� ���� �����Ѵ�.

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

dual:�÷��ϳ��� �ο��ϳ�¥�� ���� ���̺�

SELECT sysdate, TO_CHAR(sysdate,'YYYY')
      ,TO_CHAR(sysdate,'day') 
  FROM dual   
  
SELECT �� FROM�� ���̿� �÷��� �´�.
SELECT �� FROM�� ��Ģ������ �����ϴ�.
SELECT �� FROM�� ���̿� �Լ��� ����� �� �ִ�.  
SELECT�� FROM�� ���̿� �÷��� �߰��ϸ� ���̺��� �������� �þ��.
���̺��� �Ʒ����� ���Ϸ��� insert�Ѵ�.
  
��������ڴ� ���̺� ���� �״�� �����ֱ⸦ �ٶ��� �ʴ´�.

SELECT empno, ename, job, sal,comm ,hiredate,deptno,mgr 
  FROM emp



SELECT 1,2,3,4,5,6,7,'�ȳ�' FROM dual

SELECT 1+2, 3*5, 5/10, sysdate+1 FROM dual  
  