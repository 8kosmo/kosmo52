�� �࿡ 1�г� ���� 4�г� ������ �и��ؼ� �� �࿡ �ϳ��� �г⸸
�������� �Ѵ�.
���� 12���� ������ �� 48���� ����� ���к�/�а����� �ο�����
���;� �Ѵ�.

�������̺�

SELECT rownum rno FROM emp
 WHERE rownum <5
 
SELECT *
  FROM test11,
      (
       SELECT rownum rno FROM emp
        WHERE rownum <5
      )a 
      
DECODE(a.rno,1,'1�г�',2,'2�г�',3,'3�г�',4,'4�г�')

DECODE(a.rno,1,fre,2,sup,3,jun,4,sen)      


SELECT coll, dept 
      ,DECODE(a.rno,1,'1�г�',2,'2�г�',3,'3�г�',4,'4�г�') "�г�"
      ,DECODE(a.rno,1,fre,2,sup,3,jun,4,sen) "������"  
  FROM test11,
      (
       SELECT rownum rno FROM emp
        WHERE rownum <5
      )a 
ORDER BY dept asc, �г� asc

��������2

1,2�г�� 3,4�г��� �ο����� ���� ���� �ٿ� �������� �غ��ÿ�.     