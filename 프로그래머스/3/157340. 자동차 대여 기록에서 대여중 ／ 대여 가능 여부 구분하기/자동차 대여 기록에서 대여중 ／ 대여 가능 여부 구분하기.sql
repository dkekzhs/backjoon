-- 코드를 입력하세요
WITH CAR AS (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16'
ORDER BY CAR_ID DESC)

SELECT DISTINCT CAR_ID,'대여중' AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (SELECT * FROM CAR)

UNION ALL 

SELECT DISTINCT CAR_ID,'대여 가능' AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID NOT IN (SELECT * FROM CAR)

ORDER BY CAR_ID DESC;