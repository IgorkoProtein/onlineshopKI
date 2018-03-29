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

INSERT INTO persons (name, surname, born_date)VALUES
  ('Igor','Kupchack', '1997-05-25'),
  ('Bohdan', 'Kirichenko','1998-12-30'),
  ('Taras', 'Rashcevuch', '1998-01-17'),
  ('Ivanka', 'Nazarova', '1999-06-25'),
  ('Andriy','Hraboveckuy','1998-03-23'),
  ('Nadya','Pruymak','1999-05-11');

SELECT* FROM persons;

INSERT INTO customers (person_id, mobile, email, address) VALUES
  ((SELECT person_id FROM persons WHERE name LIKE '%Igor%' AND surname LIKE '%Kupchack%'),'+380974454147', 'igor@gmail.com', 'Shevchenka12');

SELECT* FROM customers;

CREATE TABLE customers_profiles(
  profile_id INT(11) UNSIGNED AUTO_INCREMENT,
  person_id INT(11) UNSIGNED NOT NULL,
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(profile_id),
  UNIQUE INDEX unique_id(profile_id),
  CONSTRAINT fk_profile_person FOREIGN KEY (person_id) REFERENCES persons(person_id)
)ENGINE = INNODB DEFAULT CHARSET =UTF8;

EXPLAIN customers_profiles;

CREATE TABLE measurements(
  measurement_id INT(11) UNSIGNED AUTO_INCREMENT,
  profile_id INT(11) UNSIGNED NOT NULL,
  chest DOUBLE NOT NULL,
  biceps DOUBLE NOT NULL,
  waist DOUBLE NOT NULL,
  leg DOUBLE NOT NULL,
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(measurement_id),
  CONSTRAINT fk_measurment_profile FOREIGN KEY (profile_id) REFERENCES customers_profiles(profile_id)
)ENGINE = INNODB DEFAULT CHARSET =UTF8;

INSERT INTO customers_profiles (person_id) VALUES
  ((SELECT person_id FROM persons WHERE name LIKE '%Igor%' AND surname LIKE '%Kupchack%'));

SELECT* FROM customers_profiles;

INSERT INTO measurements(profile_id, chest, biceps, waist, leg) VALUES
  ((SELECT profile_id FROM customers_profiles WHERE person_id = 1), 100, 40, 70, 65);

DROP TABLE measurements;

SELECT* FROM measurements;

CREATE TABLE training_diary(
  entry_id INT(11) UNSIGNED AUTO_INCREMENT,
  profile_id INT(11) UNSIGNED NOT NULL,

  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(entry_id),
  CONSTRAINT fk_diary_profile FOREIGN KEY (profile_id) REFERENCES customers_profiles(profile_id)
)ENGINE = INNODB DEFAULT CHARSET =UTF8;  # ДОробити (додати fk exercises)

CREATE TABLE exercises(
  exercis_id INT(11) UNSIGNED AUTO_INCREMENT,
  muscle_group_id INT(11) UNSIGNED NOT NULL,
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(exercis_id),
  CONSTRAINT fk_muscle_exercises (m)
)ENGINE = INNODB DEFAULT CHARSET =UTF8;  # ДОробити (додати fk muscle_group)

CREATE TABLE muscle_group(
  muscle_id INT(11) UNSIGNED AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(muscle_id)
)ENGINE = INNODB DEFAULT CHARSET =UTF8;