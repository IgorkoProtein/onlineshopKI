CREATE TABLE smartphones (
  id INT(11) AUTO_INCREMENT,
  vendor VARCHAR(10) NOT NULL ,
  model VARCHAR(20) NOT NULL,
  price DOUBLE NOT NULL,
  procesor VARCHAR(50),
  ram INT(11),
  storage INT(11),
  PRIMARY KEY (id)
)ENGINE InnoDB CHARACTER SET utf8;



SHOW DATABASES ;
USE smart_db;

SHOW TABLES;


EXPLAIN smartphones;

ALTER TABLE smartphones
  CHANGE id
  id  BIGINT(20) UNSIGNED NOT NULL  AUTO_INCREMENT;

ALTER TABLE  smartphones
  ADD user VARCHAR(30)
  AFTER ram;

ALTER TABLE smartphones
  DROP user;

ALTER TABLE smartphones
  ADD created  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE smartphones
  ADD updated TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP;

INSERT INTO smartphones VALUES
  (NULL, 'LG', 'v30', 700, 'snep 835',4, 64,  NOW(), CURRENT_TIMESTAMP);

INSERT INTO smartphones(vendor, model, price,ram, storage) VALUES
  ('samsun', 's8', 700, 4, 128),
  ('oneplus', '3t', 400,6,64);

UPDATE smartphones SET procesor = 'SNAP 821' WHERE id = 4;

UPDATE  smartphones SET created = NOW();

UPDATE smartphones SET procesor = 'EXYNOS' WHERE vendor LIKE 'sams%';

UPDATE smartphones set ram = 8 WHERE ram <= 4 LIMIT 2;

DELETE FROM smartphones WHERE model LIKE 's%';

DELETE FROM smartphones WHERE vendor = 'oneplus';

TRUNCATE TABLE smartphones;

SELECT *FROM smartphones;