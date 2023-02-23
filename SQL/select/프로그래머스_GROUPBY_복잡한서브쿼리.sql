-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (SELECT CAR_ID 
               FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
               WHERE MONTH(START_DATE) IN ('08','09','10')
               GROUP BY CAR_ID
               HAVING COUNT(*) >= 5)
    AND MONTH(START_DATE) IN ('08','09','10') # 이거 꼭 넣어줘야함!!
GROUP BY MONTH(START_DATE),CAR_ID
HAVING RECORDS > 0
ORDER BY 1,2 DESC;
