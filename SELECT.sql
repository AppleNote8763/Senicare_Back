SELECT 
    C.custom_number as customerNumber, 
    C.name as name, 
    C.birth as birth, 
    C.location as location, 
    N.name as chargerName, 
    N.user_id as chargerId 
FROM customers C LEFT JOIN nurses N 
ON C.charger = N.user_id 
ORDER BY C.custom_number DESC