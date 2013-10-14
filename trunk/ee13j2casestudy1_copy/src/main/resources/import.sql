use ee13j2;
delete from role;
insert into role(roleID,roleName) values('2','Admin');
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (1, NOW(), NOW(), 'bhavneet.bodh@gmail.com', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (2, NOW(), NOW(), 'arpan.bhandari@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (3, NOW(), NOW(), 'apoorva.bhatt@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (4, NOW(), NOW(), 'abhishek.rastogi@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (5, NOW(), NOW(), 'swati.rawat@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (6, NOW(), NOW(), 'sapna.yadav@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (6, NOW(), NOW(), 'manoj@gmail.com', 2, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);




