select * from t_orderbasket

1단계
더미테이블이용해서 데이터의 로우 수를 3배수로 만듦
1번일때 - 날짜별
2번일땐 - 총계
3번일땐 - 소계

SELECT rownum rno FROM dept WHERE rownum <4

카타시안곱 = cross join
:기존 테이블의 데이터를 복제하는데 사용할 수 있다.
복제를 왜 해야되지?
- 테이블 그대로가 아닌 업무담당자의 요구사항에 맞게 출력해야되니까?
- 분석함수를 사용할 수 없는 환경일때
  NoSQL제품 - 테이블없다.
- 통계자료, 분기별자료, 반기별 자료, 년별, 막대그래프, 파이그래프

- 데이터 복제하였다.
  같은 정보가 두 개 존재
  1일때 - 날짜별계산
  2일때 - 총계
  
- DECODE(rno,1,a.indate_vc,2,'총계',3,'소계')

FROM 절을 제외한 모든 곳에 사용

GROUP BY에 사용할 때

GROUP BY DECODE(rno,1,a.indate_vc,2,'총계',3,'소계')

SELECT deptno,ename FROM emp
GROUP BY deptno,ename

ORDER BY에 사용할 때  

ORDER BY BY DECODE(rno,1,a.indate_vc,2,'총계',3,'소계') 

SELECT * FROM temp
ORDER BY emp_id asc, lev desc

DECODE(rno,1,a.indate_vc,2,'총계',3,'소계') 

물품구분 - 발주하겠다

DECODE(rno,3,gubun_vc||'계',1,gubun_vc) as "물품구분" 

SUM(qty_nu)||'EA' as "판매갯수"

단가*수량

SUM(qty_nu*price_nu)||'원' as "판매가격"

SELECT
      DECODE(rno,1,a.indate_vc,2,'총계',3,'소계')
     ,DECODE(rno,3,gubun_vc||'계',1,gubun_vc) as "물품구분" 
     ,SUM(qty_nu)||'EA' as "판매갯수"
     ,SUM(qty_nu*price_nu)||'원' as "판매가격"
  FROM t_orderbasket A
      ,(SELECT rownum rno FROM dept WHERE rownum <4)B      
GROUP BY DECODE(rno,1,a.indate_vc,2,'총계',3,'소계')
        ,DECODE(rno,3,gubun_vc||'계',1,gubun_vc)
ORDER BY DECODE(rno,1,a.indate_vc,2,'총계',3,'소계')  

SELECT
      DECODE(rno,1,'총합',2,a.indate_vc||'계',a.indate_vc)
     ,DECODE(rno,3,gubun_vc||'계',4,gubun_vc) as "물품구분" 
     ,DECODE(rno,4,a.name_vc) as "물품명"
     ,SUM(qty_nu)||'EA' as "판매갯수"
     ,SUM(qty_nu*price_nu)||'원' as "판매가격"
  FROM t_orderbasket A
      ,(SELECT rownum rno FROM dept WHERE rownum <5)B      
GROUP BY DECODE(rno,1,'총합',2,a.indate_vc||'계',a.indate_vc)
        ,DECODE(rno,3,gubun_vc||'계',4,gubun_vc)
        ,DECODE(rno,4,a.name_vc)
ORDER BY DECODE(rno,1,'총합',2,a.indate_vc||'계',a.indate_vc)