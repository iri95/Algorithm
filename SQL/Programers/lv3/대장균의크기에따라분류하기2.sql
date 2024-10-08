SELECT ID, (CASE
                WHEN NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) = 1 THEN "CRITICAL"
                WHEN NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) = 2 THEN "HIGH"
                WHEN NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) = 3 THEN "MEDIUM"
                ELSE "LOW"
    END
    ) COLONY_NAME
FROM ECOLI_DATA
ORDER BY 1