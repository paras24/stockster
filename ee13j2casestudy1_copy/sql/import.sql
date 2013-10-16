use ee13j2;
delete from role;
insert into role(roleID,roleName) values('2','Admin');
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (1, NOW(), NOW(), 'bhavneet.bodh@gmail.com', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (2, NOW(), NOW(), 'arpan.bhandari@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (3, NOW(), NOW(), 'apoorva.bhatt@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (4, NOW(), NOW(), 'abhishek.rastogi@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (5, NOW(), NOW(), 'swati.rawat@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO users(userID, created, modified, username, enabled, PASSWORD, roleID) VALUES (6, NOW(), NOW(), 'sapna.yadav@impetus.co.in', 1, '7mL9KnhOCA64a4RvnlY8N5j3UKb1fHCIvWjFQaDS6pCwocTtE9TSpzxpYBQQsHfA', 2);
INSERT INTO locations values(1,'Noida'),(2,'Bangalore'),(3,'Indore');
insert into project (projectID, dateOfprojectAllocation, dateOfprojectDeallocation, groupHeadName, percentAllocation, pointOfContact, projectName, status, subprojectName, supervisorName, subProjectID) values (1, null, null, 'p', 0, 'p', 'p', null, 'p', 'p', null);
INSERT INTO `teammembers` VALUES (1,'g4',NULL,1,'group hd','java','test mem',1,1,1);
insert into opportunity (Id, created, modified, ContactPoint, Work_Duration, People_Required_Count, primary_keyskills, RequestDt, requirementStatus, requirementType, secondary_keyskills, start_Date_Of_Resources, Sub_Project_Name, Loc_Id, Project_Id) values (1, '2013-05-05 12:09:06', '2013-05-05 12:09:06', 'd', 4, 4, 'jj', '2013-05-05 12:09:06', 'jk', 'kj', 'kj', '2013-05-05 12:09:06', 'jk', 1, 1);





