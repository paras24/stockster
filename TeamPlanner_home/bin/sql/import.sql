use ee13j2;
delete from role;
insert into role(roleID,roleName) values('1','Admin');
insert into role(roleID,roleName) values('2','GroupHead');
insert into role(roleID,roleName) values('3','GroupGuest');
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (1, NOW(), NOW(), 'bhavneet.bodh@gmail.com', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (2, NOW(), NOW(), 'bhavneet.bodh@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 3);




