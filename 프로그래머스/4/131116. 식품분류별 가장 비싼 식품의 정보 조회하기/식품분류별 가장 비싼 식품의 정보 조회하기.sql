SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM
    FOOD_PRODUCT FP
WHERE
    (CATEGORY, PRICE) = (
        SELECT
            CATEGORY,
            MAX(PRICE) AS MP
        FROM    
            FOOD_PRODUCT
        WHERE
            CATEGORY IN ('과자', '국', '김치', '식용유')
            AND CATEGORY = FP.CATEGORY
        GROUP BY
            CATEGORY
    )
ORDER BY
    MAX_PRICE DESC
;