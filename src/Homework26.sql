
SHOW TABLES;

ALTER TABLE physicalData
  ADD created  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE physicalData
  ADD updated TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP;

INSERT INTO physicalData( weight, legVolume, handVolume, waistVolume, shouldersVolume) VALUES
  (78.2, 56, 38, 71, 128),
  (81, 61, 41.2, 76, 145);

INSERT INTO physicalData( weight, legVolume, handVolume, waistVolume, shouldersVolume) VALUES
  (88.2, 66, 45, 81, 150),
  (120, 81, 56.2, 80, 178);


ALTER TABLE physicalData
  ADD breastVokume DOUBLE NOT NULL AFTER waistVolume;

UPDATE physicalData SET weight = 95 WHERE handVolume = 41.2;

UPDATE physicalData SET breastVokume = 100 LIMIT 2;

UPDATE physicalData SET breastVokume = 111 WHERE legVolume = 66;

DELETE FROM physicalData WHERE breastVokume = 110;

SELECT *FROM physicalData;




CREATE TABLE myPower(
  id INT(11) AUTO_INCREMENT,
  brenchPress DOUBLE NOT NULL,
  squatting DOUBLE NOT NULL,
  traction DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE myPower
  ADD created  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE myPower
  ADD updated TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP;

INSERT INTO myPower(brenchPress, squatting, traction) VALUES
  (140, 200, 240),
  (100, 160, 200),
  (90, 110, 111);

ALTER TABLE myPower
    ADD bicepsdouble DOUBLE NOT NULL;

SELECT *FROM physicalData;


