SELECT 
    * 
    FROM T_ORDERBASKET;
    
    
-- 1�ܰ�
�������̺��� �̿��ؼ� �������� �ο� ���� 3����� ���� - 1�� ��¥�� - 2�� �Ѱ� - 3�� �Ұ�

SELECT rownum ron FROM dept WHERE rownum<4

īŸ�þ��� �� = cross join : ���� ���̺��� �����͸� �����ϴµ� ����� �� �ִ�.
������ �� �ؾߵ��� ? - ���̺� �״�ΰ� �ƴ� ����������� �䱸���׿� �°� ����ؾ� �Ǵϱ�?
              - �м��Լ��� ����� �� ���� ȯ���϶�
                �� NoSQL��ǰ - ���̺��� ����.
              - ����ڷ�, �б⺰�ڷ�, �ݱ⺰ �ڷ�, �⺰, ����׷���, ���̱׷���
              - �����͸� �����Ͽ��µ� ���� ������ �ΰ� �����϶� 1�϶��� 2�϶��� ���̸� �����ؾ��Ѵ�.
                �� 1�϶� ��¥�� ���, 2�϶� �Ѱ� 
              - ����) DECODE(rno,1,a.indate_vc,'�Ѱ�',3,'�Ұ�')
                �� FROM���� ������ ��� ���� ��� GROUP BY�� ����Ҷ�, ORDER BY�� ����� ��

SELECT * FROM temp
ORDER BY emp_id asc, lev desc;

��ǰ���� - �����ϰڴ�

DECODE(rno,3,gubun_vc||'��',1,gubun_vc) as "��ǰ����"

SUM(qty_nu)||'EA' AS "�ǸŰ���"

�ܰ� * ���� 

SUM(qty_nu*price_nu)||'��' as "�ǸŰ���"

05.22

SELECT 
        DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�') AS "�Ǹų�¥"
       ,DECODE(rno,3,gubun_vc||'��',1,gubun_vc) as "��ǰ����"
       ,SUM(qty_nu)||'EA' AS "�ǸŰ���",SUM(qty_nu*price_nu)||'��' as "�ǸŰ���"
    FROM t_orderbasket A
        ,(SELECT rownum rno FROM dept WHERE rownum <4) B
GROUP BY DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�')
        ,DECODE(rno,3,gubun_vc||'��',1,gubun_vc)   
ORDER BY DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�');



05.23

SELECT 
        DECODE(rno,1,'����',2,a.indate_vc||'��',a.indate_vc) AS "�Ǹų�¥"
       ,DECODE(rno,3,gubun_vc||'��',4,gubun_vc) as "��ǰ����"
       ,DECODE(rno,4,a.name_vc) as "��ǰ��"
       ,SUM(qty_nu)||'EA' AS "�ǸŰ���",SUM(qty_nu*price_nu)||'��' as "�ǸŰ���"
    FROM t_orderbasket A
        ,(SELECT rownum rno FROM dept WHERE rownum <5) B
GROUP BY DECODE(rno,1,'����',2,a.indate_vc||'��',a.indate_vc)
        ,DECODE(rno,3,gubun_vc||'��',4,gubun_vc)   
        ,DECODE(rno,4,a.name_vc)
ORDER BY DECODE(rno,1,'����',2,a.indate_vc||'��',a.indate_vc);


ROLLUP�� GROUP BY���� ���Ǹ� GROUP�� ������ ���� ��Ƽ ������ �Ұ� �� �հ踦 �����ִ� �Լ�
ROLLUP�̳� CUBE�� �ٷ�鼭�� GROUPPING�Լ��� ���� �� �� �ִµ� �̰���
��� ���� SET�� ǥ���Կ� �־� NULL�̸� 1 �ƴϸ� 0�� RETURN�����ν� �Ұ�� �Ѱ� �κ��� ��Ÿ���ִ� ��Ȱ�� ��.

���� ���� �Ǹ���Ȳ�� ��¥�� ��ǰ��� ����� ������ �Ѵٸ�

SELECT indate_vc, gubun_vc, name_vc
      , sum(qty_nu*price_nu)||'��'
    FROM t_orderbasket
GROUP BY ROLLUP(indate_vc, gubun_vc, name_vc);


SELECT 
       indate_vc, gubun_vc, name_vc
      ,sum(qty_nu), sum(qty_nu*price_nu)||'��'
    FROM t_orderbasket
GROUP BY CUBE(indate_vc, gubun_vc, name_vc)
ORDER BY indate_vc;


SELECT DECODE(GROUPING(indate_vc),1,'ALL Days',indate_vc)
     , DECODE(GROUPING(gubun_vc),1
     , DECODE(LAG(GROUPING(gubun_vc),1)
       OVER(ORDER BY indate_vc),1,'Total','�Ұ�'),gubun_vc) gubun_vc
     , name_vc
     , sum(qty_nu*price_nu)||'��'
  FROM t_orderbasket
GROUP BY ROLLUP(indate_vc, gubun_vc, name_vc)

05.24



SELECT
    DECODE(rno,1,B.DNAME,2,'�Ѱ�') "DNAME"
   ,SUM(DECODE(JOB,'CLERK',SAL,NULL)) "CLERK"
   ,SUM(DECODE(JOB,'MANAGER',SAL,NULL)) "MANAGER"
   ,SUM(DECODE(JOB,'CLERK',NULL,'MANAGER',NULL,SAL)) "ETC"
   ,SUM(DECODE(JOB,'CLERK',SAL,NULL))+
    SUM(DECODE(JOB,'MANAGER',SAL,NULL))+
    SUM(DECODE(JOB,'CLERK',NULL,'MANAGER',NULL,SAL)) "DEPT_SAL"
    FROM EMP A, DEPT B
    ,(SELECT rownum rno FROM EMP_LEVEL WHERE rownum<3)
   WHERE A.DEPTNO=B.DEPTNO
GROUP BY DECODE(rno,1,B.DNAME,2,'�Ѱ�')
ORDER BY DECODE(rno,1,B.DNAME,2,'�Ѱ�')
