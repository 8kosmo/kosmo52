SELECT A.cdate,
       A.amt*B.crate
  FROM test02 A, test02 B
 WHERE A.rownum -1 = B.rownum
 
SELECT rownum rno, cdate, crate, amt
 FROM test02 
 
SELECT A.cdate, B.crate
     , TO_CHAR(A.amt*B.crate,'999,999,999')||'원' as "한화금액"
  FROM (
        SELECT rownum rno, cdate, crate, amt
         FROM test02   
       )A,
       (
        SELECT rownum rno, cdate, crate, amt
         FROM test02         
       )B
 WHERE A.rno-1 = B.rno       
 