SELECT 
    * 
    FROM T_ORDERBASKET;
    
    
-- 1단계
더미테이블을 이용해서 데이터의 로우 수를 3배수로 만듦 - 1번 날짜별 - 2번 총계 - 3번 소계

SELECT rownum ron FROM dept WHERE rownum<4

카타시안의 곱 = cross join : 기존 테이블의 데이터를 복제하는데 사용할 수 있다.
복제를 왜 해야되지 ? - 테이블 그대로가 아닌 업무담당자의 요구사항에 맞게 출력해야 되니까?
              - 분석함수를 사용할 수 없는 환경일때
                ㆍ NoSQL제품 - 테이블이 없다.
              - 통계자료, 분기별자료, 반기별 자료, 년별, 막대그래프, 파이그래프
              - 테이터를 복제하였는데 같은 정보가 두개 존재일때 1일때와 2일때의 차이를 구분해야한다.
                ㆍ 1일때 날짜별 계산, 2일때 총계 
              - 예시) DECODE(rno,1,a.indate_vc,'총계',3,'소계')
                ㆍ FROM절을 제외한 모든 곳에 사용 GROUP BY에 사용할때, ORDER BY에 사용할 때

SELECT * FROM temp
ORDER BY emp_id asc, lev desc;

물품구분 - 발주하겠다

DECODE(rno,3,gubun_vc||'계',1,gubun_vc) as "물품구분"

SUM(qty_nu)||'EA' AS "판매갯수"

단가 * 수량 

SUM(qty_nu*price_nu)||'원' as "판매가격"

05.22

SELECT 
        DECODE(rno,1,a.indate_vc,2,'총계',3,'소계') AS "판매날짜"
       ,DECODE(rno,3,gubun_vc||'계',1,gubun_vc) as "물품구분"
       ,SUM(qty_nu)||'EA' AS "판매갯수",SUM(qty_nu*price_nu)||'원' as "판매가격"
    FROM t_orderbasket A
        ,(SELECT rownum rno FROM dept WHERE rownum <4) B
GROUP BY DECODE(rno,1,a.indate_vc,2,'총계',3,'소계')
        ,DECODE(rno,3,gubun_vc||'계',1,gubun_vc)   
ORDER BY DECODE(rno,1,a.indate_vc,2,'총계',3,'소계');



05.23

SELECT 
        DECODE(rno,1,'총합',2,a.indate_vc||'계',a.indate_vc) AS "판매날짜"
       ,DECODE(rno,3,gubun_vc||'계',4,gubun_vc) as "물품구분"
       ,DECODE(rno,4,a.name_vc) as "물품명"
       ,SUM(qty_nu)||'EA' AS "판매갯수",SUM(qty_nu*price_nu)||'원' as "판매가격"
    FROM t_orderbasket A
        ,(SELECT rownum rno FROM dept WHERE rownum <5) B
GROUP BY DECODE(rno,1,'총합',2,a.indate_vc||'계',a.indate_vc)
        ,DECODE(rno,3,gubun_vc||'계',4,gubun_vc)   
        ,DECODE(rno,4,a.name_vc)
ORDER BY DECODE(rno,1,'총합',2,a.indate_vc||'계',a.indate_vc);


ROLLUP은 GROUP BY절에 사용되면 GROUP의 순서에 의한 멀티 레벨의 소계 및 합계를 구해주는 함수
ROLLUP이나 CUBE를 다루면서는 GROUPPING함수를 종종 볼 수 있는데 이것은
모든 값의 SET을 표현함에 있어 NULL이면 1 아니면 0을 RETURN함으로써 소계와 총계 부분을 나타내주는 역활을 함.

만일 가게 판매현황을 날짜와 물품뷴류 목록을 가지고 한다면

SELECT indate_vc, gubun_vc, name_vc
      , sum(qty_nu*price_nu)||'원'
    FROM t_orderbasket
GROUP BY ROLLUP(indate_vc, gubun_vc, name_vc);


SELECT 
       indate_vc, gubun_vc, name_vc
      ,sum(qty_nu), sum(qty_nu*price_nu)||'원'
    FROM t_orderbasket
GROUP BY CUBE(indate_vc, gubun_vc, name_vc)
ORDER BY indate_vc;


SELECT DECODE(GROUPING(indate_vc),1,'ALL Days',indate_vc)
     , DECODE(GROUPING(gubun_vc),1
     , DECODE(LAG(GROUPING(gubun_vc),1)
       OVER(ORDER BY indate_vc),1,'Total','소계'),gubun_vc) gubun_vc
     , name_vc
     , sum(qty_nu*price_nu)||'원'
  FROM t_orderbasket
GROUP BY ROLLUP(indate_vc, gubun_vc, name_vc)

05.24



SELECT
    DECODE(rno,1,B.DNAME,2,'총계') "DNAME"
   ,SUM(DECODE(JOB,'CLERK',SAL,NULL)) "CLERK"
   ,SUM(DECODE(JOB,'MANAGER',SAL,NULL)) "MANAGER"
   ,SUM(DECODE(JOB,'CLERK',NULL,'MANAGER',NULL,SAL)) "ETC"
   ,SUM(DECODE(JOB,'CLERK',SAL,NULL))+
    SUM(DECODE(JOB,'MANAGER',SAL,NULL))+
    SUM(DECODE(JOB,'CLERK',NULL,'MANAGER',NULL,SAL)) "DEPT_SAL"
    FROM EMP A, DEPT B
    ,(SELECT rownum rno FROM EMP_LEVEL WHERE rownum<3)
   WHERE A.DEPTNO=B.DEPTNO
GROUP BY DECODE(rno,1,B.DNAME,2,'총계')
ORDER BY DECODE(rno,1,B.DNAME,2,'총계')
