CREATE TABLE users(
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    surname VARCHAR(20),
    login VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    born_date DATE,
    created  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY (updated),
    UNIQUE (login)

)ENGINE InnoDB CHARSET utf8;


EXPLAIN users;

INSERT INTO users(login, password) VALUES
    ('Igor', '23kdqwl'),
    ('Nazar','qwerry');



UPDATE users SET name = 'Igorko' WHERE login LIKE 'Igor';

INSERT INTO users(login, password) VALUES
    ('Igor17', '23fhdsl');

DELETE FROM users WHERE name = 'Igor' AND name ='Nazar' AND name ='Igor17';

TRUNCATE TABLE users;

SELECT* FROM users;

INSERT INTO users(login, password, born_date) VALUES
    ('Igor1', '8pj8c1td', '1996-08-25' ),
    ('Valentin','f9vbfq8b', '1998-11-27'),
    ('Vitaliy','ghrhccea', '1996-12-26' ),
    ('Roman','yald1y27', '1998-11-19' ),
    ('Nazar','llwuomp0', '1997-01-05' ),
    ('Roman1', 'gfxxlcd9', '1998-10-21'),
    ('Roman2', 'juhq9owe', '1997-02-02'),
    ('Olexiy','ot23dv6', '1997-01-22'),
    ('Victor','0gshhz0e', '1997-02-13' ),
    ('Bohdan','z8kd254l', '1998-05-19'),
    ('Sasha', '8rj8c12td', '1996-02-05' ),
    ('Olya', 'p1xth3v6', '1998-12-17'),
    ('Andriy','1x89kmfa', '1998-05-05'),
    ('Igor','ypcarsya', '1997-02-13'),
    ('Natalia','xr6p49xk', '1997-05-20'),
    ('Nazik', 'y6iqjkou', '1997-05-21'),
    ('Vova', 'u0cdrz45', '1997-07-05'),
    ('Misha','8q638lea', '1997-07-18'),
    ('Nadya','pz8by8bw', '1998-04-03'),
    ('Sasha2','vtetog08', '1998-05-05');

SELECT* FROM users;

SELECT login FROM users WHERE MONTH(born_date) > 5 AND MONTH(born_date) < 9;

SELECT* FROM users WHERE name IS NULL OR surname IS NULL OR login IS NULL OR password IS NULL OR  born_date IS NULL;

UPDATE users SET name = 'Igor', surname = 'Kupchack' WHERE  login = 'Igor1';

SELECT* FROM users GROUP BY YEAR(born_date);

SELECT GROUP_CONCAT(login SEPARATOR ', ') AS GROUP_LOGIN, YEAR(born_date) AS YEAR, COUNT(*) AS AMOUNT FROM users GROUP BY YEAR(born_date);

SELECT COUNT(*) FROM users WHERE year(born_date) <= 1998 AND year(born_date) >= 1997;

SELECT MIN(MONTH(born_date)), MAX(MONTH(born_date)) FROM users;

SELECT SUM(
    if(MONTH(born_date) <= 3, 2, 1)
)FROM  users;

