�츮ȸ�翡 �ٹ��ϴ� ������� �޿������� ����ϴ� SQL���� �ۼ��Ͻÿ�.

�����ȣ(emp)   �����(emp)    �μ���(dept)
------------------------

��������1

2019�� 5�� 20�� DVD�� �뿩�� ������� ����� ����ϴ� SQL����
�ۼ��Ͻÿ�.

��¥  �̸�  DVD�� ��ȭ��ȣ �ּ� �ݳ�����
---------------------------------




��������2
����� DVD�� �뿩�� ����� �� �ݳ��� �� �� ������� �����
����ϴ� SQL���� �ۼ��Ͻÿ�.

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
    
non-equal ����

���� ������ '='�� �ƴ� �ٸ� �����ȣ�� �־����� ���

temp�� emp_level�� �̿��� emp_level�� ���� ������ ����
����/���� ���� ���� ��� ������ ����� ����, ����, salary��
����ϴ� sql���� �ۼ��Ͻÿ�.

SELECT temp.emp_id, temp.emp_name, TEMP.LEV
      ,temp.salary
  FROM temp, emp_level
 WHERE emp_level.lev='����'
   AND temp.salary BETWEEN from_sal AND to_sal


��������
�� ����� ����, salary, �������ѱݾ�, �������ѱݾ��� ������ �Ѵ�.
�� ������ ����ϴ� select���� � ������ �ɾ�� �ұ�?

SELECT * FROM emp_level

    