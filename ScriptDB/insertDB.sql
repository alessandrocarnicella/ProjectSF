INSERT INTO "Agenzia"(nome)
  VALUES ('ESA');
INSERT INTO "Agenzia"(nome)
  VALUES ('NASA');


INSERT INTO "Satellite"(nome,"dataInizio","dataFine")
  VALUES ('Herschel','2009-07-10','2013-06-17');
INSERT INTO "Satellite"(nome,"dataInizio","dataFine")
  VALUES ('Spitzer','2003-12-18','2009-05-15');


INSERT INTO "Banda"(lunghezza)
  VALUES (70);
INSERT INTO "Banda"(lunghezza)
  VALUES (160);
INSERT INTO "Banda"(lunghezza)
  VALUES (250);
INSERT INTO "Banda"(lunghezza)
  VALUES (350);
INSERT INTO "Banda"(lunghezza)
  VALUES (500);
INSERT INTO "Banda"(lunghezza)
  VALUES (3.6);
INSERT INTO "Banda"(lunghezza)
  VALUES (4.5);
INSERT INTO "Banda"(lunghezza)
  VALUES (5.8);
INSERT INTO "Banda"(lunghezza)
  VALUES (8.0);
INSERT INTO "Banda"(lunghezza)
  VALUES (24);


INSERT INTO "Strumento"(nome, "nomeSatellite")
  VALUES ('Herschel-PACS','Herschel');
INSERT INTO "Strumento"(nome, "nomeSatellite")
  VALUES ('Herschel-SPIRE','Herschel');
INSERT INTO "Strumento"(nome, "nomeSatellite")
  VALUES ('Spitzer-IRAC','Spitzer');
INSERT INTO "Strumento"(nome, "nomeSatellite")
  VALUES ('Spitzer-MIPS','Spitzer');