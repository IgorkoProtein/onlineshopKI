CREATE TABLE shop(
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  price DOUBLE NOT NULL,
  manufact_date DATE,
  expiration_date DATE,
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE (name)
)ENGINE innoDB CHARSET utf8;

INSERT INTO shop(name, price, manufact_date, expiration_date) VALUES
  ('tomato', 13.45,'2017-01-22', '2017-07-01'),
  ('chease', 45.5, '2017-03-16', '2017-07-04'),
  ('meat', 120, '2017-02-03', '2017-07-07'),
  ('cucumber', 20.20, '2017-04-21', '2017-07-23'),
  ('egg', 3.20, '2017-06-23', '2017-07-31'),
  ('tea"AHMAD"',100, '2017-06-19', '2017-08-02' ),
  ('coffe"Galka"',10, '2017-05-30', '2017-08-12'),
  ('bread', 10.60, '2017-04-28', '2017-08-24'),
  ('butter', 41.90, '2017-05-06', '2017-12-08'),
  ('carrot', 21, '2017-01-18', '2017-11-25'),
  ('rice', 32, '2017-04-21', '2017-12-23'),
  ('fish"salmon"', 109.90, '2017-01-31', '2017-9-15'),
  ('mushroms', 54, '2017-03-04', '2017-10-13'),
  ('apple', 7.50, '2017-05-16', '2017-07-30'),
  ('banana', 31.25, '2017-05-04', '2017-08-17'),
  ('oranges', 27.70, '2017-05-08', '2017-10-06'),
  ('pineaple', 34.50, '2017-06-05', '2017-10-20');

SELECT* FROM shop;

SELECT name FROM shop WHERE ((DATEDIFF(expiration_date, manufact_date) / 30) = 3);/* Терміну пр 3 місяці*/

SELECT DATEDIFF(expiration_date, manufact_date) FROM shop;

TRUNCATE TABLE shop;

SELECT COUNT(name) AS cheap_products FROM shop WHERE price >= 100;

SELECT name, price FROM shop WHERE price < (SELECT AVG(price) FROM shop);

SELECT AVG(price) FROM shop;

SELECT name FROM shop WHERE (MONTH(expiration_date) - MONTH(updated) = 1); /* Термін пр вийде через місяць*/

SELECT name FROM shop WHERE (MONTH(expiration_date) = MONTH(updated)); /*Свіжий товар*/
