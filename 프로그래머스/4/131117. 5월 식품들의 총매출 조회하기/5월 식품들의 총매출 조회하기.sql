SELECT
    P.PRODUCT_ID,
    P.PRODUCT_NAME,
    SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES
FROM
    FOOD_ORDER O
JOIN
    FOOD_PRODUCT P
ON
    O.PRODUCT_ID = P.PRODUCT_ID
WHERE
    O.PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY
    P.PRODUCT_ID
ORDER BY
    TOTAL_SALES DESC,
    P.PRODUCT_ID ASC
;