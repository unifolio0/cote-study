SELECT
    DISTINCT CART_ID
FROM
    CART_PRODUCTS O
WHERE
    (
        SELECT
            COUNT(*)
        FROM
            CART_PRODUCTS I
        WHERE
            O.CART_ID = I.CART_ID
            AND I.NAME = 'Milk'
    ) > 0
    AND (
        SELECT
            COUNT(*)
        FROM
            CART_PRODUCTS I
        WHERE
            O.CART_ID = I.CART_ID
            AND I.NAME = 'Yogurt'
    ) > 0
;