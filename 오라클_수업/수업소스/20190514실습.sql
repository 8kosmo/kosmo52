SELECT empno, ename as "�̸�"
 FROM emp
 WHERE �̸� = 'SMITH'
 
SELECT empno, ename "�̸�"
 FROM emp
 WHERE �̸� = 'SMITH' 

��������
�÷��� ��Ī�� �ο����� ��� WHERE������ ��Ī�� ����� �� ����.
 
�ذ���
�ζ��κ並 ����ϸ� ������.

�����:FROM�� �Ʒ� SELECT���� �� ���

SELECT

  FROM (
         SELECT��  --�ζ��κ�(View�� ����-���̺��� �ƴϰ� SELECT��)
       ) 
       
SELECT
       "�̸�"
  FROM (
        SELECT empno, ename as "�̸�"
        FROM emp  
       )     
 WHERE �̸� = 'SMITH'
 
SELECT ename FROM emp

SELECT ename FROM emp GROUP BY ename 

Ȯ���� ����
���� �����Ͱ� ������ group by�� ȿ���� ����.
���ĵ� ������ �ٸ���.-�����ϴ�.

SELECT deptno FROM emp

SELECT deptno FROM emp GROUP BY deptno 

SELECT hiredate FROM emp GROUP BY hiredate 

SELECT deptno,max(ename),min(ename),count(ename) FROM emp GROUP BY deptno 
 
SELECT distinct deptno FROM emp
 
SELECT deptno FROM emp GROUP BY deptno 
HAVING deptno =10

SELECT *
  FROM t_giftmem, t_giftpoint

SELECT
       *
  FROM t_giftpoint pot, t_giftmem mem
 WHERE mem.point_nu >= pot.point_nu
   AND pot.name_vc='��ȭƼ��'
       
   
SELECT
       mem.name_vc as "ȸ����"
      ,mem.point_nu as "��������Ʈ"
      ,pot.point_nu as "�������Ʈ"
      ,(mem.point_nu-pot.point_nu) as "�ܿ� ����Ʈ"
  FROM t_giftpoint pot, t_giftmem mem
 WHERE mem.point_nu >= pot.point_nu
   AND pot.name_vc='��ȭƼ��'   
   
SELECT DECODE(1,1,'T','F')
  FROM dual   
  
decode �� ���� �͸� ���� �� �ִ�. -  ���

�����-�����>0

�ռ���-�ڼ���<0

SELECT DECODE(1,1,DECODE(2,3,'T','X'),'F') FROM dual

1.�ִ� ���ǽð��� ������ ������ '�Ϲݰ���'�� ����ϰ��� �Ѵ�.
  �����? - �̻�
  
SELECT DECODE (LEC_TIME,LEC_POINT,'�Ϲݰ���','�������')
 FROM LECTURE;  
  
2.�ִ� ���ǽð��� ������ ���� ������ ���ڸ� �˰� �ʹ�.
  �ݵ�� decode�� ����Ͻÿ�. - �̱���
  
  
/* Formatted on 2019/05/14 ���� 12:33:38 (QP5 v5.215.12089.38647) */
SELECT COUNT (DECODE(lec_time, lec_point, '�Ϲݰ���')) 
  FROM lecture 
  
SELECT  count(lec_id)
  FROM lecture
 WHERE lec_time = lec_point

   
  
3.���� �ð��� ������ ������ '�Ϲݰ���'�� ���Ϲ��� �� ���ĵ� �ϰ� ���� ��쿡�� 
��� �ؾ��ϳ�? - �̰��

SELECT LEC_ID,DECODE(LEC_TIME,LEC_POINT,'�Ϲݰ���','')
FROM LECTURE
ORDER BY DECODE(LEC_TIME,LEC_POINT,'�Ϲݰ���','') asc,LEC_ID desc;

4.lec_time�� ũ�� '�������', lec_point�� ũ�� '��Ÿ����'
  ���� ������ '�Ϲݰ���'���� ���� �����ް��� �Ѵ�. -  �̰ǿ�    
  
select lec_id
     , decode(lec_time,lec_point
             ,'�Ϲݰ���'
             ,decode(lec_time-lec_point,1,'�������',decode(lec_time-lec_point,2,'�������','��Ÿ����'))) as "��������"
 from lecture
    
SELECT SIGN(1-5), SIGN(-560), SIGN(5+19),SIGN(1000-1000)
  FROM dual 
  
SIGN(DECODE(lec_time-lec_point))) 

DECODE(SIGN(lec_time-lec_point),1,'',0,'',-1,''))

SELECT lec_id, lec_time, lec_point
      ,decode(sign(lec_time-lec_point),0,'�Ϲݰ���'
                                    ,1,'�������'
                                    ,-1,'��Ÿ����') as "����Ÿ��"
  FROM lecture

��������
�����Ͽ� �ش����ڿ� 01�� �ٿ��� 4�ڸ� ��ȣ�� �����
ȭ���Ͽ� 11, �����Ͽ� 21, ����Ͽ� 31, �ݿ��Ͽ� 41, ����Ͽ� 51
�Ͽ��Ͽ� 61�� �ٿ��� 4�ڸ� ��ȣ�� ����ٰ� �� �� 
���ÿ� �ش��ϴ� ��� 4�ڸ��� ����ϴ� sql���� �ۼ��Ͻÿ�.

SELECT 14||'11' FROM dual

SELECT TO_CHAR(sysdate,'DD')
      ,TO_CHAR(sysdate,'day')
      ,TO_CHAR(sysdate,'YYYY')
      ,TO_CHAR(sysdate,'MM')
      ,TO_CHAR(sysdate,'MI')
  FROM dual

SELECT DECODE(TO_CHAR(sysdate,'day'),'������','01'
                                  ,'ȭ����','11'
                                  ,'������','21'
                                  ,'�����','31'
                                  ,'�ݿ���','41'
                                  ,'�����','51'
                                  ,'�Ͽ���','61'
             ) 
  FROM dual

SELECT TO_CHAR(sysdate,'YYYY-MM-DD') as "���ó�¥"
      ,TO_CHAR(sysdate,'DD')||DECODE(TO_CHAR(sysdate,'day'),'������','01'
                                  ,'ȭ����','11'
                                  ,'������','21'
                                  ,'�����','31'
                                  ,'�ݿ���','41'
                                  ,'�����','51'
                                  ,'�Ͽ���','61'
                                   ) as "���"
  FROM dual

��������2
������̺��� job�� clerk�� ����� �޿� ��
          job�� salesman�� ����� �޿��� ���� ���ϰ�
          ������ job�� ���ؼ��� ��Ÿ ������ ���Ͻÿ�.
          
edit t_giftmem

edit t_giftpoint          




