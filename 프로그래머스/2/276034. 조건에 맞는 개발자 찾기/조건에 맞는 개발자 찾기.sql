SELECT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM
    DEVELOPERS
WHERE
    (SELECT
        SKILLCODES.CODE
    FROM
        SKILLCODES
    WHERE
        NAME = 'Python'
    ) & SKILL_CODE > 0
    OR (SELECT
        SKILLCODES.CODE
    FROM
        SKILLCODES
    WHERE
        NAME = 'C#'
    ) & SKILL_CODE > 0
ORDER BY
    ID ASC;