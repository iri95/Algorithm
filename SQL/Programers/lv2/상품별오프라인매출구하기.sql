SELECT PRODUCT_CODE, SUM(P.PRICE * S.SALES_AMOUNT) SALES
FROM PRODUCT P JOIN OFFLINE_SALE S
                    USING(PRODUCT_ID)
GROUP BY 1
ORDER BY 2 DESC, 1