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

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table persons;
SET FOREIGN_KEY_CHECKS = 1;


