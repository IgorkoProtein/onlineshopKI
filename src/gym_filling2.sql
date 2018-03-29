INSERT INTO muscle_group (name) VALUES
  ("neck"),
  ("chest"),
  ("shoulders"),
  ("arms"),
  ("press"),
  ("back"),
  ("legs");

INSERT INTO exercises (ex_name) VALUES
  ("squatting"),
  ("bench press");

  INSERT INTO mg_ex (exercis_id, muscle_id) VALUES
  ((SELECT exercis_id
    FROM exercises
    WHERE ex_name LIKE '%squat%'), (SELECT muscle_id
                                      FROM muscle_group
                                      WHERE name LIKE '%legs%')),
  ((SELECT exercis_id
    FROM exercises
    WHERE ex_name LIKE '%squat%'), (SELECT muscle_id
                                      FROM muscle_group
                                      WHERE name LIKE '%bac%')),
    ((SELECT exercis_id
      FROM exercises
      WHERE ex_name LIKE '%squat%'), (SELECT muscle_id
                                      FROM muscle_group
                                      WHERE name LIKE '%pres%'));
SELECT* FROM muscle_group;
SELECT* FROM exercises;
SELECT* FROM mg_ex;

SELECT  ex.ex_name, mg.name FROM exercises AS ex, muscle_group AS mg, mg_ex AS me
WHERE me.exercis_id = ex.exercis_id AND me.muscle_id = mg.muscle_id;

INSERT INTO exercises(ex_name) VALUES
  ('lifting the rod'),
  ("legs press");

INSERT INTO mg_ex (exercis_id, muscle_id) VALUES
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%lifting%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%arms%')),
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%lifting%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%shoulder%'));

INSERT INTO mg_ex (exercis_id, muscle_id) VALUES
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%legs press%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%legs%')),
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%legs press%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%press%'));


EXPLAIN training_day;

ALTER TABLE training_day ADD day_name VARCHAR(20) AFTER training_id;

ALTER TABLE training_day DROP COLUMN day_name;

INSERT INTO training_day (day_name, approaches_number, repetitions_number) VALUES
  ('monday', 4, 12),
  ('wednesday', 4, 15);

SELECT* FROM training_diary;

SELECT* FROM exercises;

SELECT * FROM customers_profiles;
TRUNCATE TABLE customers_profiles;

INSERT INTO customers_profiles (persons_person_id) VALUES
  ((SELECT person_id FROM persons WHERE name LIKE '%Igor%'));

INSERT INTO training_diary (customers_profiles_profile_id) VALUES
  (2);

SELECT* FROM muscle_group; /*complete*/
SELECT* FROM exercises; /*complete*/
SELECT* FROM mg_ex;/*complete*/

SELECT* FROM persons; /*complete*/
SELECT* FROM customers; /*complete*/

INSERT INTO customers (person_id, mobile, email, address) VALUES
  ((SELECT person_id FROM persons WHERE name LIKE '%Bohdan%'), '+380975565147', 'bodya34@gmail.com', 'Solotvyn'),
  ((SELECT person_id FROM persons WHERE name LIKE '%Taras%'), '+380347643167', 'Taras98@gmail.com', 'Milan'),
  ((SELECT person_id FROM persons WHERE name LIKE '%Ivanka%'), '+380375935496', 'Ivanka01@gmail.com', 'Lviv'),
  ((SELECT person_id FROM persons WHERE name LIKE '%Nadya%'), '+380975935487', 'Nadya99@gmail.com', 'Kiev');

INSERT INTO exercises(ex_name) VALUES
  ('pullover');

INSERT INTO mg_ex (exercis_id, muscle_id) VALUES
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%pullover%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%chest%')),
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%pullover%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%shoulders%')),
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%pullover%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%arms%'));


SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table customers_profiles;
SET FOREIGN_KEY_CHECKS = 1;