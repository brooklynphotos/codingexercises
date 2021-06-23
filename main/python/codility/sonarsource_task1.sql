insert into candidates values (25, 'Taylor', 30);
insert into candidates values (113, 'Paul', 21);
insert into candidates values (10, 'Lara', 19);
insert into reports values (1, 'Codility', 10, 20);
insert into reports values (36, 'Soft', 113, 60);
insert into reports values (137, 'Codility', 10, 30);
insert into reports values (2, 'ITCompany', 10, 99);

-- write your code in PostgreSQL 9.4
select c.id, c.name, coalesce(ct.company_count, 0) from candidates c left join (
SELECT c.id as candidate_id, c.name as candidate_name, count(distinct r.company) as company_count
from candidates c join reports r on c.id=r.candidate_id
group by c.id, c.name
) ct on c.id=ct.candidate_id
order by c.id
