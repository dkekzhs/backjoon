-- 코드를 작성해주세요

SELECT D.ID
FROM ECOLI_DATA D
INNER JOIN (
        SELECT A.ID
        FROM ECOLI_DATA A
        INNER JOIN (
                SELECT ID
                FROM ECOLI_DATA
                WHERE PARENT_ID IS NULL
        ) AS B ON A.PARENT_ID = B.ID
    ) AS C ON D.PARENT_ID = C.ID
ORDER BY D.ID ASC;