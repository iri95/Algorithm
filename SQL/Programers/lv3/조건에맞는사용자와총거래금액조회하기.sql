SELECT USER_ID, NICKNAME, SUM(PRICE) TOTAL_SALES
FROM USED_GOODS_USER U JOIN USED_GOODS_BOARD B
                            ON U.USER_ID = B.WRITER_ID
WHERE STATUS LIKE "DONE"
GROUP BY U.USER_ID
HAVING SUM(PRICE) >= 700000
ORDER BY TOTAL_SALES;