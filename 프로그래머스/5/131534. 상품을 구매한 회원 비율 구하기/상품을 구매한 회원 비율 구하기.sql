-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH , COUNT(DISTINCT USER_ID) AS PURCHASED_USERS ,ROUND(COUNT(DISTINCT USER_ID) / (SELECT COUNT(USER_ID)
                        FROM USER_INFO
                        WHERE JOINED BETWEEN '2020-12-31' AND '2022-01-01'),1) AS PUCHASED_RATIO
FROM ONLINE_SALE
WHERE USER_ID IN (SELECT USER_ID 
FROM USER_INFO
WHERE JOINED BETWEEN '2020-12-31' AND '2022-01-01')
GROUP BY YEAR, MONTH
ORDER BY YEAR ASC, MONTH ASC
;