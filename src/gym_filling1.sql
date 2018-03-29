CREATE TABLE persons (
  id        INT(11) UNSIGNED     AUTO_INCREMENT,
  name      VARCHAR(11) NOT NULL,
  surname   VARCHAR(11) NOT NULL,
  born_date DATE,
  created   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = innoDB
  DEFAULT CHARSET = utf8;

EXPLAIN persons;

ALTER TABLE persons
  CHANGE id
  person_id INT(11) UNSIGNED AUTO_INCREMENT;

ALTER TABLE persons
  ADD UNIQUE INDEX unique_id(person_id);

CREATE TABLE customers (
  customer_id INT(11) UNSIGNED          AUTO_INCREMENT,
  person_id   INT(11) UNSIGNED NOT NULL,
  mobile      VARCHAR(13),
  email       VARCHAR(50),
  address     VARCHAR(100),
  created     TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated     TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (customer_id),
  UNIQUE INDEX unique_id(customer_id),
  CONSTRAINT FK_CustomerPerson FOREIGN KEY (person_id) REFERENCES persons (person_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

SHOW TABLES;

INSERT INTO persons (name, surname, born_date) VALUES
  ('Igor', 'Kupchack', '1997-05-25'),
  ('Bohdan', 'Kirichenko', '1998-12-30'),
  ('Taras', 'Rashcevuch', '1998-01-17'),
  ('Ivanka', 'Nazarova', '1999-06-25'),
  ('Andriy', 'Hraboveckuy', '1998-03-23'),
  ('Nadya', 'Pruymak', '1999-05-11');

SELECT *
FROM persons;

INSERT INTO customers (person_id, mobile, email, address) VALUES
  ((SELECT person_id
    FROM persons
    WHERE name LIKE '%Igor%' AND surname LIKE '%Kupchack%'), '+380974454147', 'igor@gmail.com', 'Shevchenka12');

SELECT *
FROM customers;

CREATE TABLE customers_profiles (
  profile_id INT(11) UNSIGNED          AUTO_INCREMENT,
  person_id  INT(11) UNSIGNED NOT NULL,
  created    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (profile_id),
  UNIQUE INDEX unique_id(profile_id),
  CONSTRAINT fk_profile_person FOREIGN KEY (person_id) REFERENCES persons (person_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

EXPLAIN customers_profiles;

CREATE TABLE measurements (
  measurement_id INT(11) UNSIGNED          AUTO_INCREMENT,
  profile_id     INT(11) UNSIGNED NOT NULL,
  chest          DOUBLE           NOT NULL,
  biceps         DOUBLE           NOT NULL,
  waist          DOUBLE           NOT NULL,
  leg            DOUBLE           NOT NULL,
  created        TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated        TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (measurement_id),
  CONSTRAINT fk_measurment_profile FOREIGN KEY (profile_id) REFERENCES customers_profiles (profile_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

INSERT INTO customers_profiles (person_id) VALUES
  ((SELECT person_id
    FROM persons
    WHERE name LIKE '%Igor%' AND surname LIKE '%Kupchack%'));

SELECT *
FROM customers_profiles;

INSERT INTO measurements (profile_id, chest, biceps, waist, leg) VALUES
  ((SELECT profile_id
    FROM customers_profiles
    WHERE person_id = 1), 100, 40, 70, 65);

DROP TABLE measurements;

SELECT *
FROM measurements;

CREATE TABLE training_diary (
  entry_id     INT(11) UNSIGNED          AUTO_INCREMENT,
  profile_id   INT(11) UNSIGNED NOT NULL,
  td_id INT(11) UNSIGNED NOT NULL,
  created      TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated      TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (entry_id),
  CONSTRAINT fk_diary_profile FOREIGN KEY (profile_id) REFERENCES customers_profiles (profile_id),
  CONSTRAINT fk_diary_td FOREIGN KEY (td_id) REFERENCES training_day(training_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8; # ДОробити (додати fk exercises)



CREATE TABLE training_day (
  training_id INT(11) UNSIGNED AUTO_INCREMENT,
  approaches_number INT(11) NOT NULL,
  repetitions_number INT(11) NOT NULL,
  created      TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated      TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (training_id)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE td_ex(
  training_id INT(11) UNSIGNED NOT NULL,
  exercis_id  INT(11) UNSIGNED NOT NULL,
  created      TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated      TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (training_id,exercis_id),
  CONSTRAINT fk_tr_day FOREIGN KEY (training_id) REFERENCES training_day(training_id),
  CONSTRAINT fk_exercis FOREIGN KEY (exercis_id) REFERENCES exercises(exercis_id)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;

CREATE TABLE exercises (
  exercis_id  INT(11) UNSIGNED     AUTO_INCREMENT,
  ex_name     VARCHAR(20) NOT NULL,
  description VARCHAR(200),
  pic_url     VARCHAR(100),
  vid_url     VARCHAR(100),
  created     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (exercis_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8; # ДОробити (додати fk muscle_group)

INSERT INTO exercises (ex_name, description) VALUES
  ('Присідання з штангою', 'опис присідання зі штангою');

SELECT *
FROM exercises;


CREATE TABLE muscle_group (
  muscle_id INT(11) UNSIGNED     AUTO_INCREMENT,
  name      VARCHAR(20) NOT NULL,
  created   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (muscle_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

INSERT INTO muscle_group (name) VALUES
  ('chest'),
  ('biceps'),
  ('legs'),
  ('back');

SELECT *
FROM muscle_group;

CREATE TABLE mg_ex (
  exercis_id INT(11) UNSIGNED NOT NULL,
  muscle_id  INT(11) UNSIGNED NOT NULL,
  created    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (exercis_id, muscle_id),
  CONSTRAINT fk_ex FOREIGN KEY (exercis_id) REFERENCES exercises (exercis_id),
  CONSTRAINT fk_mg FOREIGN KEY (muscle_id) REFERENCES muscle_group (muscle_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

DROP TABLE training_diary;
DROP TABLE muscle_group;
DROP TABLE exercises;
DROP TABLE mg_ex;
DROP TABLE td_ex;

INSERT INTO mg_ex (exercis_id, muscle_id) VALUES
  ((SELECT exercis_id
    FROM exercises
    WHERE ex_name LIKE '%сідання%'), (SELECT muscle_id
                                      FROM muscle_group
                                      WHERE name LIKE '%legs%')),
  ((SELECT exercis_id
    FROM exercises
    WHERE ex_name LIKE '%сідання%'), (SELECT muscle_id
                                      FROM muscle_group
                                      WHERE name LIKE '%bac%'));

SELECT* FROM mg_ex;
