���̺��� �������� ������Ű����?

SELECT 1,2,3,4 FROM dual

���̺��� �ο츦 ������Ű����?
insert�� �����Ŵ - �Ѱ� �÷��� �߰�, ������ �÷�

emp

PK - �����ؾ���, Unique, Not NULL, �ε�������(�ڵ�)

FK - �ߺ���, �ε��������ȵ�, Not NULL



SELECT 1 FROM dual
UNION ALL
SELECT 2 FROM dual
UNION ALL
SELECT 3 FROM dual

����

MINUS

INTERSECT

UNION ALL, UNION(�ߺ�����) - ������ �Ͼ.

ORDER BY�� ����ϸ� ������ �� �� �ִ�.
NULL���� ��� ����
2�������� �ʼ���.

emp

SELECT empno FROM emp

�Ľ� - DBMS�����ȹ����� - ��Ƽ������ - OPEN-CURSOR-FETCH

SELECT empno,ename FROM emp

hint��
hint���� ��Ÿ�� ���������� ���� ��� ���ô���.

SELECT /*+index_desc(emp pk_emp)*/ empno FROM emp

���� �˻� �����׽�Ʈ�ϱ�

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
  
��븮 �츮ȸ�翡 �ٹ��ϴ� ����� �߿��� �޿��� ���� ���� �޴� ����� �̸��� ����?

SELECT max(sal)
  FROM emp


SELECT max(sal), ename
  FROM emp  
  
SELECT max(sal), min(ename)
  FROM emp   
  
SELECT ename
  FROM emp
 WHERE sal = (SELECT max(sal) FROM emp)
 
WHERE�� �Ʒ� SELECT���� �� �� �ִ�. ->  ��������    
  

��븮 �츮ȸ�翡 �ٹ��ϴ� ����� �߿��� �μ����� �޿��� ���� ���� �޴� ����� �̸��� 
����?  

SELECT deptno,max(sal), min(sal), ename
  FROM emp
GROUP BY deptno  

���������� �߻���.
1)ename���� �����ϰ� �׷��Լ��� �����. - �ǹ̰� ����.
2)group by �Ʒ� ename�÷� �߰���. - group by�� �ǹ̰� ����.

SELECT deptno,max(sal), min(sal), max(ename)
  FROM emp
GROUP BY deptno  

SELECT deptno,max(sal), min(sal), ename
  FROM emp
GROUP BY deptno, ename 


SELECT ename, sal
  FROM emp
 WHERE sal IN (SELECT max(sal) FROM emp GROUP BY deptno)
 
UNION ALL�� ����ϸ� ���ľ��� �� ������ �ִ� �״�� ��ģ��.
�ߺ��� ���žȵ�.
������ ������ �� �� ��ĵ

IN�� ������ �ο츦 ���� �� �����ϴ�.
������ �ѹ��� �а� ó��

SELECT deptno, job, count(*), sum(sal)
 FROM emp
GROUP BY deptno, job

SELECT deptno, job
 FROM emp
GROUP BY deptno, job

group by�Ʒ� 2�� �̻� �÷��� ����� �� �ִ�.
 
 
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

count�� ���ǻ���
NULL�� �ִ� ��쿡�� ī��Ʈ ���� �ʴ´�.
��� - *�� ����ϰų� pk�� count�ؾ� ��ü ������ ����.

SELECT sum(comm) FROM emp

SELECT SUM(NVL(comm,0)) FROM emp

���
�׷��Լ� ���� NULL�� ���� ������� �ƴϴ�.
�װ��� ���� NULLüũ�� �Ͽ� 0���� ġȯ�� �� ����� �ʿ�� ����.

���̺� ����������� ���ٸ� comm�� ��� ����Ʈ�� 0�� ������ �����ϴ� ���� �´�.
NULL�� �� ��� �ǹ̰� ��ȣ�ϱ� �����̴�.

�����ȹ ���� ���
Ctrl+e

ALL ROWS�� ��� ������ �����ϴ� ��� �����͸� ��ȸ�ϴµ� ������ �����ȹ�� 
�����ٴ� ���� �ǹ���.

COST- ����ð�

