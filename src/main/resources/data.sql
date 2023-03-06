USE `k-pac`;

INSERT INTO `k-pac`.`knowledge_package`
(`title`,
`description`)
VALUES
("Knowledge package 1",
"This is my first knowledge package");

INSERT INTO `k-pac`.`knowledge_package`
(`title`,
`description`)
VALUES
("Second package",
"Second package to test the system");

INSERT INTO `k-pac`.`knowledge_package`
(`title`,
`description`)
VALUES
("Third package",
"Third package to test the system");

INSERT INTO `k-pac`.`knowledge_package`
(`title`,
`description`)
VALUES
("Fourth package",
"Fourth package to test the system");

INSERT INTO `k-pac`.`knowledge_package`
(`title`,
`description`)
VALUES
("Fifth package",
"Fifth package to test the system");

INSERT INTO `k-pac`.`knowledge_package_set`
(`title`)
VALUES
("Knowledge package set 1");

INSERT INTO `k-pac`.`knowledge_package_set`
(`title`)
VALUES
("Knowledge package set 2");

INSERT INTO `k-pac`.`knowledge_package_set`
(`title`)
VALUES
("Knowledge package set 3");

INSERT INTO `k-pac`.`knowledge_package_has_knowledge_package_set`
(`knowledge_package_id`,
`knowledge_package_set_id`)
VALUES
(1,
1);

INSERT INTO `k-pac`.`knowledge_package_has_knowledge_package_set`
(`knowledge_package_id`,
`knowledge_package_set_id`)
VALUES
(2,
1);

INSERT INTO `k-pac`.`knowledge_package_has_knowledge_package_set`
(`knowledge_package_id`,
`knowledge_package_set_id`)
VALUES
(3,
2);

INSERT INTO `k-pac`.`knowledge_package_has_knowledge_package_set`
(`knowledge_package_id`,
`knowledge_package_set_id`)
VALUES
(4,
2);

INSERT INTO `k-pac`.`knowledge_package_has_knowledge_package_set`
(`knowledge_package_id`,
`knowledge_package_set_id`)
VALUES
(5,
3);

INSERT INTO `k-pac`.`knowledge_package_has_knowledge_package_set`
(`knowledge_package_id`,
`knowledge_package_set_id`)
VALUES
(1,
3);

INSERT INTO `k-pac`.`knowledge_package_has_knowledge_package_set`
(`knowledge_package_id`,
`knowledge_package_set_id`)
VALUES
(2,
3);

