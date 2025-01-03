SELECT
    U.USER_ID,
    U.NICKNAME,
    CONCAT(U.CITY, ' ', U.STREET_ADDRESS1, ' ', U.STREET_ADDRESS2) AS 전체주소,
    CONCAT(LEFT(TLNO, 3), '-', SUBSTRING(TLNO, 4, 4), '-', RIGHT(TLNO, 4)) AS 전화번호
FROM
    USED_GOODS_USER U
WHERE
    (
        SELECT
            COUNT(*)
        FROM
            USED_GOODS_BOARD B
        WHERE
            U.USER_ID = B.WRITER_ID
    ) >= 3
ORDER BY
    U.USER_ID DESC
;