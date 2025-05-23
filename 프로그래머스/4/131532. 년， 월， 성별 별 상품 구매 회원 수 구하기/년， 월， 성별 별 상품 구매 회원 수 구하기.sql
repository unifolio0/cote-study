SELECT
    YEAR(O.SALES_DATE) AS YEAR,
    MONTH(O.SALES_DATE) AS MONTH,
    U.GENDER,
    COUNT(DISTINCT U.USER_ID) AS USERS
FROM
    USER_INFO U
JOIN
    ONLINE_SALE O
ON
    U.USER_ID = O.USER_ID
WHERE
    U.GENDER IS NOT NULL
GROUP BY
    YEAR,
    MONTH,
    U.GENDER
ORDER BY
    YEAR ASC,
    MONTH ASC,
    U.GENDER ASC
;