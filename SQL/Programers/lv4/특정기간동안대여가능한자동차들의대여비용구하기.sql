-- 코드를 입력하세요
SELECT C.CAR_ID, C.CAR_TYPE, FLOOR(30 * C.DAILY_FEE * (100 - D.DISCOUNT_RATE) / 100) FEE
FROM CAR_RENTAL_COMPANY_CAR C
         JOIN (SELECT CAR_ID, COUNT(CASE
                                        WHEN START_DATE > "2022-11-30" OR END_DATE < "2022-11-01" THEN NULL
                                        ELSE 1
    END
                              ) c
               FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
               GROUP BY CAR_ID
               HAVING c = 0) H
              ON C.CAR_ID = H.CAR_ID
         JOIN (SELECT CAR_TYPE, REPLACE(DISCOUNT_RATE, "%", "") DISCOUNT_RATE
               FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
               WHERE CAR_TYPE IN("세단", "SUV") AND DURATION_TYPE LIKE "30%") D
              ON C.CAR_TYPE = D.CAR_TYPE
HAVING FEE >= 500000 AND FEE < 2000000
ORDER BY 3 DESC, 2, 1 DESC
