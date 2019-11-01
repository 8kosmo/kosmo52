SELECT empno, ename as "이름"
 FROM emp
 WHERE 이름 = 'SMITH'
 
SELECT empno, ename "이름"
 FROM emp
 WHERE 이름 = 'SMITH' 

문제제기
컬럼명에 별칭을 부여했을 경우 WHERE절에서 별칭을 사용할 수 없다.
 
해결방법
인라인뷰를 사용하면 가능함.

생긴꼴:FROM절 아래 SELECT문이 온 경우

SELECT

  FROM (
         SELECT문  --인라인뷰(View의 일종-테이블이 아니고 SELECT문)
       ) 
       
SELECT
       "이름"
  FROM (
        SELECT empno, ename as "이름"
        FROM emp  
       )     
 WHERE 이름 = 'SMITH'
 
SELECT ename FROM emp

SELECT ename FROM emp GROUP BY ename 

확인한 내용
같은 데이터가 없으면 group by한 효과가 없다.
정렬된 내용이 다르다.-랜덤하다.

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
   AND pot.name_vc='영화티켓'
       
   
SELECT
       mem.name_vc as "회원명"
      ,mem.point_nu as "보유포인트"
      ,pot.point_nu as "사용포인트"
      ,(mem.point_nu-pot.point_nu) as "잔여 포인트"
  FROM t_giftpoint pot, t_giftmem mem
 WHERE mem.point_nu >= pot.point_nu
   AND pot.name_vc='영화티켓'   
   
SELECT DECODE(1,1,'T','F')
  FROM dual   
  
decode 는 같은 것만 비교할 수 있다. -  장애

어떤숫자-어떤숫자>0

앞숫자-뒤숫자<0

SELECT DECODE(1,1,DECODE(2,3,'T','X'),'F') FROM dual

1.주당 강의시간과 학점이 같으면 '일반과목'을 출력하고자 한다.
  어떡하지? - 이상만
  
SELECT DECODE (LEC_TIME,LEC_POINT,'일반과목','교양과목')
 FROM LECTURE;  
  
2.주당 강의시간과 학점이 같은 강의의 숫자를 알고 싶다.
  반드시 decode를 사용하시오. - 이광현
  
  
/* Formatted on 2019/05/14 오후 12:33:38 (QP5 v5.215.12089.38647) */
SELECT COUNT (DECODE(lec_time, lec_point, '일반과목')) 
  FROM lecture 
  
SELECT  count(lec_id)
  FROM lecture
 WHERE lec_time = lec_point

   
  
3.강의 시간과 학점이 같으면 '일반과목'을 리턴받은 후 정렬도 하고 싶은 경우에는 
어떻게 해야하나? - 이경애

SELECT LEC_ID,DECODE(LEC_TIME,LEC_POINT,'일반과목','')
FROM LECTURE
ORDER BY DECODE(LEC_TIME,LEC_POINT,'일반과목','') asc,LEC_ID desc;

4.lec_time이 크면 '실험과목', lec_point가 크면 '기타과목'
  둘이 같으면 '일반과목'으로 값을 돌려받고자 한다. -  이건우    
  
select lec_id
     , decode(lec_time,lec_point
             ,'일반과목'
             ,decode(lec_time-lec_point,1,'실험과목',decode(lec_time-lec_point,2,'실험과목','기타과목'))) as "과목종류"
 from lecture
    
SELECT SIGN(1-5), SIGN(-560), SIGN(5+19),SIGN(1000-1000)
  FROM dual 
  
SIGN(DECODE(lec_time-lec_point))) 

DECODE(SIGN(lec_time-lec_point),1,'',0,'',-1,''))

SELECT lec_id, lec_time, lec_point
      ,decode(sign(lec_time-lec_point),0,'일반과목'
                                    ,1,'실험과목'
                                    ,-1,'기타과목') as "과목타입"
  FROM lecture

실전문제
월요일엔 해당일자에 01을 붙여서 4자리 암호를 만들고
화요일엔 11, 수요일엔 21, 목요일엔 31, 금요일엔 41, 토요일엔 51
일요일엔 61을 붙여서 4자리 암호를 만든다고 할 때 
오늘에 해당하는 비번 4자리를 출력하는 sql문을 작성하시오.

SELECT 14||'11' FROM dual

SELECT TO_CHAR(sysdate,'DD')
      ,TO_CHAR(sysdate,'day')
      ,TO_CHAR(sysdate,'YYYY')
      ,TO_CHAR(sysdate,'MM')
      ,TO_CHAR(sysdate,'MI')
  FROM dual

SELECT DECODE(TO_CHAR(sysdate,'day'),'월요일','01'
                                  ,'화요일','11'
                                  ,'수요일','21'
                                  ,'목요일','31'
                                  ,'금요일','41'
                                  ,'토요일','51'
                                  ,'일요일','61'
             ) 
  FROM dual

SELECT TO_CHAR(sysdate,'YYYY-MM-DD') as "오늘날짜"
      ,TO_CHAR(sysdate,'DD')||DECODE(TO_CHAR(sysdate,'day'),'월요일','01'
                                  ,'화요일','11'
                                  ,'수요일','21'
                                  ,'목요일','31'
                                  ,'금요일','41'
                                  ,'토요일','51'
                                  ,'일요일','61'
                                   ) as "비번"
  FROM dual

실전문제2
사원테이블에서 job이 clerk인 사람의 급여 합
          job이 salesman인 사람의 급여의 합을 구하고
          나머지 job에 대해서는 기타 합으로 구하시오.
          
edit t_giftmem

edit t_giftpoint          




