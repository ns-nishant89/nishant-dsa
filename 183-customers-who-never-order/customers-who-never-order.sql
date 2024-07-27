# Write your MySQL query statement below
SELECT name as Customers
From Customers 
WHERE ID NOT IN (
    SELECT customerId from Orders
)