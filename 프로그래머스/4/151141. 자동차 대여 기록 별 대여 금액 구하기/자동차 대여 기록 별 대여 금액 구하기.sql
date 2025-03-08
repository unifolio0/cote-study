WITH SALE_FEE AS (
    SELECT
        HISTORY_ID, 
        CAR_TYPE,
        DAILY_FEE,
        DATEDIFF(H.END_DATE, H.START_DATE) + 1 AS DURATION,
        CASE
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN '7일 이상'
            ELSE '할인 없음'
        END AS DURATION_TYPE
    FROM
        CAR_RENTAL_COMPANY_CAR C
    JOIN
        CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    ON
        C.CAR_ID = H.CAR_ID
    WHERE
        C.CAR_TYPE = '트럭'
)
SELECT
    S.HISTORY_ID,
    ROUND(S.DAILY_FEE * ((100 - IFNULL(P.DISCOUNT_RATE, 0)) / 100) * S.DURATION, 0) AS FEE
FROM
    SALE_FEE S
LEFT JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
ON
    S.DURATION_TYPE = P.DURATION_TYPE
    AND S.CAR_TYPE = P.CAR_TYPE
ORDER BY
    FEE DESC,
    S.HISTORY_ID DESC
;