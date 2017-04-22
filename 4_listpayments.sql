select id_user, SUM(amount) from payments where completed = 1 group by id_user; 
