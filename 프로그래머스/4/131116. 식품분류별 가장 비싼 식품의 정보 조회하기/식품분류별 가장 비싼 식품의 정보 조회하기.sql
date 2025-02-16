SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM
    FOOD_PRODUCT
WHERE
    CATEGORY IN ('과자', '국', '김치', '식용유')
    AND (CATEGORY, PRICE) IN (
        SELECT
            CATEGORY,
            MAX(PRICE) AS PRICE
        FROM
            FOOD_PRODUCT
        GROUP BY
            CATEGORY
    )
ORDER BY
    MAX_PRICE DESC
;