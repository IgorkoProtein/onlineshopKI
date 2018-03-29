CREATE TABLE persons (
  id INT(11) UNSIGNED AUTO_INCREMENT,
  name VARCHAR(11) NOT NULL,
  surname VARCHAR(11) NOT NULL,
  born_date DATE,
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)ENGINE = innoDB DEFAULT CHARSET = utf8;

EXPLAIN persons;

ALTER TABLE persons
  CHANGE id
  person_id INT(11) UNSIGNED AUTO_INCREMENT;

ALTER TABLE persons ADD UNIQUE INDEX unique_id(person_id);

CREATE TABLE customers (
  customer_id INT(11) UNSIGNED AUTO_INCREMENT,
  person_id INT(11) UNSIGNED NOT NULL,
  mobile VARCHAR(13),
  email VARCHAR(50),
  address VARCHAR(100),
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (customer_id),
  UNIQUE INDEX unique_id(customer_id),
  CONSTRAINT FK_CustomerPerson FOREIGN KEY (person_id) REFERENCES persons(person_id)
)ENGINE = INNODB DEFAULT CHARSET =UTF8;

SHOW TABLES;