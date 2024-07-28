# Write your MySQL query statement below
SELECT class from Courses group by class HAVING COUNT(DISTINCT student) >4;