DELETE FROM dance_mb;
DELETE FROM man_mb;
DELETE FROM woman_mb;

DBCC CHECKIDENT(man_mb, RESEED, 0);
DBCC CHECKIDENT(woman_mb, RESEED, 0);
DBCC CHECKIDENT(dance_mb, RESEED, 0);

INSERT INTO man_mb(name) VALUES
  ('Petru'),
  ('Sasha'),
  ('Victor'),
  ('Max'),
  ('Serghei'),
  ('Dima'),
  ('Ion');

INSERT INTO woman_mb(name) VALUES
  ('Mila'),
  ('Iuna'),
  ('Linda'),
  ('Iulia'),
  ('Cristina'),
  ('Sveta'),
  ('Oliga');

INSERT INTO dance_mb(man_id, woman_id, style) VALUES
  (1,2,'Samba'),
  (2,1,'Latino'),
  (3,1,'Tango'),
  (4,5,'Salsa'),
  (5,6,'Cha-cha-cha'),
  (6,4,'Rumba'),
  (7,7,'Bachata'),
  (7,7,'Makarena'),
  (7,6,'Lambada');