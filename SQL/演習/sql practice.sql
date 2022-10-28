課題に沿ったSQL文記述練習

/* 1 */
  SELECT A.EMPLOYEE_ID , A.EMPLOYEE_NM , B.ENTERING_DATE
    FROM employee_mst A INNER JOIN employee_enrollment B
                        ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
ORDER BY A.EMPLOYEE_ID ;

/* 2 */
  SELECT A.EMPLOYEE_ID , A.EMPLOYEE_NM , A.SEX
    FROM employee_mst A INNER JOIN employee_enrollment B
                        ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
   WHERE B.RETIRED_FLG = 0
     AND A.SEX         = 1
ORDER BY A.EMPLOYEE_ID ;

/* 3 */
  SELECT A.EMPLOYEE_ID , A.EMPLOYEE_NM , A.BIRTH_DATE
    FROM employee_mst A INNER JOIN employee_enrollment B
                        ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
   WHERE B.RETIRED_FLG = 0
     AND TIMESTAMPDIFF(YEAR, A.BIRTH_DATE, '2017/4/1') <= 40
ORDER BY A.BIRTH_DATE DESC , A.EMPLOYEE_ID ;

/* 4 */
  SELECT A.EMPLOYEE_ID , A.EMPLOYEE_NM , A.BIRTH_DATE 
    FROM employee_mst A INNER JOIN  employee_enrollment B
                        ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
   WHERE B.RETIRED_FLG = 0
     AND (TIMESTAMPDIFF(YEAR, A.BIRTH_DATE, '2017/4/1') BETWEEN '20' AND '29'
      OR TIMESTAMPDIFF(YEAR, A.BIRTH_DATE, '2017/4/1')BETWEEN '50' AND '59')
ORDER BY A.BIRTH_DATE , A.EMPLOYEE_ID ;

/* 5 */
  SELECT A.EMPLOYEE_ID , A.EMPLOYEE_NM
    FROM employee_mst A INNER JOIN employee_enrollment B
                        ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
   WHERE EMPLOYEE_NM LIKE '%“c%'
ORDER BY A.EMPLOYEE_ID ;

/* 6 */
  SELECT A.EMPLOYEE_ID ,
         A.EMPLOYEE_NM ,
         CONCAT (TIMESTAMPDIFF(MONTH , B.ENTERING_DATE , '2017/4/1') DIV 12 , '”N' ,
                 TIMESTAMPDIFF(MONTH , B.ENTERING_DATE , '2017/4/1') MOD 12 , 'ƒ–ŒŽ' ) AS ENROLLMENT_PERIOD_YM
    FROM employee_mst A INNER JOIN employee_enrollment B
                        ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
   WHERE B.RETIRED_FLG = 0
ORDER BY TIMESTAMPDIFF(MONTH , B.ENTERING_DATE , '2017/4/1'), A.EMPLOYEE_ID ;

/* 7 */
  SELECT a.EMPLOYEE_ID , a.EMPLOYEE_NM , d.DIVISION_NM
    FROM employee_mst a INNER JOIN employee_enrollment b
                                ON a.EMPLOYEE_ID = b.EMPLOYEE_ID
                        INNER JOIN employee_career_hst c
                                ON b.EMPLOYEE_ID = c.EMPLOYEE_ID
                        INNER JOIN division_mst d
                                ON c.DIVISION_CD = d.DIVISION_CD
   WHERE b.RETIRED_FLG = 0
     AND c.START_DATE  <= '2017/4/1'
     AND c.FINISH_DATE >= '2017/4/1'
ORDER BY a.EMPLOYEE_ID ;

/* 8 */
  SELECT a.EMPLOYEE_ID , a.EMPLOYEE_NM , CASE WHEN c.MANAGER_ID IS NOT NULL THEN 1 ELSE 0 END AS MANAGER_FLAG
    FROM employee_enrollment b INNER JOIN employee_mst a ON a.EMPLOYEE_ID = b.EMPLOYEE_ID
                               LEFT OUTER JOIN division_mst c ON a.EMPLOYEE_ID = c.MANAGER_ID
   WHERE b.RETIRED_FLG = 0
ORDER BY a.EMPLOYEE_ID ;

/* 9 */
  SELECT COUNT(A.EMPLOYEE_ID) AS COUNT_EMPLOYEE , 
         MIN(A.BIRTH_DATE)    AS BIRTH_DATE_OLDEST , 
         MAX(A.BIRTH_DATE)    AS BIRTH_DATE_YNGEST , 
         ROUND(AVG(TIMESTAMPDIFF(YEAR , A.BIRTH_DATE , '2017/4/1')) , 1) AS AVERAGE_AGE
    FROM employee_mst A INNER JOIN employee_enrollment B 
                                ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
   WHERE B.RETIRED_FLG = 0 ;
   
/* 10 */
  SELECT A.SEX , 
         COUNT(A.EMPLOYEE_ID) AS COUNT_EMPLOYEE , 
         MIN(A.BIRTH_DATE)    AS BIRTH_DATE_OLDEST , 
         MAX(A.BIRTH_DATE)    AS BIRTH_DATE_YNGEST , 
         ROUND(AVG(TIMESTAMPDIFF(YEAR , A.BIRTH_DATE , '2017/4/1')) , 1) AS AVERAGE_AGE
    FROM employee_mst A INNER JOIN employee_enrollment B 
                                ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
   WHERE B.RETIRED_FLG = 0
   GROUP BY A.SEX
   ORDER BY A.SEX ;

/* 11 */
  SELECT MAX(D.DIVISION_CD) ,
         MAX(D.DIVISION_NM) ,
         COUNT(A.EMPLOYEE_ID) AS COUNT_MEMBER
    FROM employee_mst A INNER JOIN employee_enrollment B 
                                ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
                        INNER JOIN employee_career_hst C
                                ON B.EMPLOYEE_ID = C.EMPLOYEE_ID
                        INNER JOIN division_mst D
                                ON C.DIVISION_CD = D.DIVISION_CD
   WHERE B.RETIRED_FLG = 0
     AND C.START_DATE  <= '2017/4/1'
     AND C.FINISH_DATE >= '2017/4/1'
GROUP BY D.DIVISION_CD
ORDER BY D.DIVISION_CD ;

/* 12 */
  SELECT MAX(D.DIVISION_CD) ,
         MAX(D.DIVISION_NM) ,
         ROUND(AVG(TIMESTAMPDIFF(YEAR , A.BIRTH_DATE , '2017/4/1')) , 1) AS AVERAGE_AGE
    FROM employee_mst A INNER JOIN employee_enrollment B 
                                ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
                        INNER JOIN employee_career_hst C
                                ON B.EMPLOYEE_ID = C.EMPLOYEE_ID
                        INNER JOIN division_mst D
                                ON C.DIVISION_CD = D.DIVISION_CD
   WHERE B.RETIRED_FLG = 0
     AND C.START_DATE  <= '2017/4/1'
     AND C.FINISH_DATE >= '2017/4/1'
GROUP BY D.DIVISION_CD
  HAVING AVERAGE_AGE < 37
ORDER BY D.DIVISION_CD ;

/* 13 */
  SELECT A.EMPLOYEE_ID      AS EMPLOYEE_ID ,
         MAX(A.EMPLOYEE_NM) AS EMPLOYEE_NM ,
         D.DIVISION_CD      AS DIVISION_CD ,
         MAX(D.DIVISION_NM) AS DIVISION_NM ,
         SUM(CASE WHEN ('2017/4/1' BETWEEN C.START_DATE AND C.FINISH_DATE)
                  THEN TIMESTAMPDIFF(MONTH , C.START_DATE , '2017/4/1')
                  ELSE TIMESTAMPDIFF(MONTH , C.START_DATE , C.FINISH_DATE) END ) AS ENROLLMENT_PERIOD_M
    FROM employee_mst A INNER JOIN employee_career_hst C
                                ON A.EMPLOYEE_ID = C.EMPLOYEE_ID
                        INNER JOIN division_mst D
                                ON C.DIVISION_CD = D.DIVISION_CD
GROUP BY A.EMPLOYEE_ID , D.DIVISION_CD
ORDER BY A.EMPLOYEE_ID , D.DIVISION_CD ;
