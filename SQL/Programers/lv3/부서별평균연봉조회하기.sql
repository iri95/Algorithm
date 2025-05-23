SELECT D.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(E.SAL)) AVG_SAL
FROM HR_DEPARTMENT D JOIN HR_EMPLOYEES E
                          USING(DEPT_ID)
GROUP BY DEPT_ID
ORDER BY 3 DESC