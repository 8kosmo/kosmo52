select * from t_orderbasket

1�ܰ�
�������̺��̿��ؼ� �������� �ο� ���� 3����� ����
1���϶� - ��¥��
2���϶� - �Ѱ�
3���϶� - �Ұ�

SELECT rownum rno FROM dept WHERE rownum <4

īŸ�þȰ� = cross join
:���� ���̺��� �����͸� �����ϴµ� ����� �� �ִ�.
������ �� �ؾߵ���?
- ���̺� �״�ΰ� �ƴ� ����������� �䱸���׿� �°� ����ؾߵǴϱ�?
- �м��Լ��� ����� �� ���� ȯ���϶�
  NoSQL��ǰ - ���̺����.
- ����ڷ�, �б⺰�ڷ�, �ݱ⺰ �ڷ�, �⺰, ����׷���, ���̱׷���

- ������ �����Ͽ���.
  ���� ������ �� �� ����
  1�϶� - ��¥�����
  2�϶� - �Ѱ�
  
- DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�')

FROM ���� ������ ��� ���� ���

GROUP BY�� ����� ��

GROUP BY DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�')

SELECT deptno,ename FROM emp
GROUP BY deptno,ename

ORDER BY�� ����� ��  

ORDER BY BY DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�') 

SELECT * FROM temp
ORDER BY emp_id asc, lev desc

DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�') 

��ǰ���� - �����ϰڴ�

DECODE(rno,3,gubun_vc||'��',1,gubun_vc) as "��ǰ����" 

SUM(qty_nu)||'EA' as "�ǸŰ���"

�ܰ�*����

SUM(qty_nu*price_nu)||'��' as "�ǸŰ���"

SELECT
      DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�')
     ,DECODE(rno,3,gubun_vc||'��',1,gubun_vc) as "��ǰ����" 
     ,SUM(qty_nu)||'EA' as "�ǸŰ���"
     ,SUM(qty_nu*price_nu)||'��' as "�ǸŰ���"
  FROM t_orderbasket A
      ,(SELECT rownum rno FROM dept WHERE rownum <4)B      
GROUP BY DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�')
        ,DECODE(rno,3,gubun_vc||'��',1,gubun_vc)
ORDER BY DECODE(rno,1,a.indate_vc,2,'�Ѱ�',3,'�Ұ�')  

SELECT
      DECODE(rno,1,'����',2,a.indate_vc||'��',a.indate_vc)
     ,DECODE(rno,3,gubun_vc||'��',4,gubun_vc) as "��ǰ����" 
     ,DECODE(rno,4,a.name_vc) as "��ǰ��"
     ,SUM(qty_nu)||'EA' as "�ǸŰ���"
     ,SUM(qty_nu*price_nu)||'��' as "�ǸŰ���"
  FROM t_orderbasket A
      ,(SELECT rownum rno FROM dept WHERE rownum <5)B      
GROUP BY DECODE(rno,1,'����',2,a.indate_vc||'��',a.indate_vc)
        ,DECODE(rno,3,gubun_vc||'��',4,gubun_vc)
        ,DECODE(rno,4,a.name_vc)
ORDER BY DECODE(rno,1,'����',2,a.indate_vc||'��',a.indate_vc)