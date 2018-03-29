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

SELECT* FROM persons; /*complete*/
SELECT* FROM customers; /*complete*/

SELECT* FROM muscle_group; /*complete*/
SELECT* FROM exercises; /*complete*/
SELECT* FROM mg_ex;/*complete*/
SELECT * FROM training_day;/*complete*/
SELECT * FROM customers_profiles;/*complete*/
SELECT * FROM measurements;/*complete*/
SELECT * FROM training_diary;/*complete*/
SELECT * FROM exercise_sessions;

  INSERT INTO mg_ex (exercis_id, muscle_id) VALUES
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%pullover%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%chest%')),
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%pullover%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%shoulders%')),
  ((SELECT exercis_id FROM exercises WHERE ex_name LIKE '%pullover%'), (SELECT muscle_id FROM muscle_group WHERE name LIKE '%arms%'));

EXPLAIN exercise_sessions;

INSERT INTO training_day(day_name) VALUES
  ('monday'),
  ('tuesday'),
  ('wednesday'),
  ('thursday'),
  ('friday'),
  ('saturday');

TRUNCATE TABLE customers_profiles; /*Cannot truncate a table referenced in a foreign key constraint (`online_shop`.`measurements`, CO */

INSERT INTO customers_profiles (persons_person_id) VALUES
  ((SELECT person_id FROM persons WHERE name LIKE '%Taras%')),
  ((SELECT person_id FROM persons WHERE name LIKE '%Ivanka%')),
  ((SELECT person_id FROM persons WHERE name LIKE '%Andriy%')),
  ((SELECT person_id FROM persons WHERE name LIKE '%Nadya%'));

TRUNCATE TABLE measurements;

INSERT INTO measurements(profile_id, chest, biceps, waist, leg) VALUES/*Чи можна тут селектити з customers_profiles*/
  (1,95, 40.5, 70, 54 ),
  (2, 100, 42.4, 68, 60),
  (3, 92, 35, 60, 48 ),
  (4, 108, 45, 78, 67),
  (5, 120, 50.9, 85, 74);

INSERT INTO training_diary(customers_profiles_profile_id) VALUES
  (1),
  (2),
  (3),
  (4),
  (5);

INSERT INTO exercise_sessions (approaches,repetitions,rest_time, total_time,exercises_exercis_id,training_day_training_id,training_diary_entry_id) VALUES
  (5, 12, 1, 20, (SELECT exercis_id FROM exercises WHERE ex_name LIKE '%legs press%'), (SELECT training_id FROM training_day WHERE day_name LIKE '%monday%'),1);




INSERT INTO exercise_sessions (approaches,repetitions,rest_time, total_time,exercises_exercis_id,training_day_training_id,training_diary_entry_id) VALUES
  (5, 12, 1, 20, (SELECT exercis_id FROM exercises WHERE ex_name LIKE '%squatting%'), (SELECT training_id FROM training_day WHERE day_name LIKE '%monday%'),1),
  (5, 12, 1, 20, (SELECT exercis_id FROM exercises WHERE ex_name LIKE '%squatting%'), (SELECT training_id FROM training_day WHERE day_name LIKE '%monday%'),1),
  (5, 12, 1, 20, (SELECT exercis_id FROM exercises WHERE ex_name LIKE '%squatting%'), (SELECT training_id FROM training_day WHERE day_name LIKE '%monday%'),1),
  (5, 12, 1, 20, (SELECT exercis_id FROM exercises WHERE ex_name LIKE '%squatting%'), (SELECT training_id FROM training_day WHERE day_name LIKE '%monday%'),1);
DELETE FROM training_day WHERE training_id  = 3;


