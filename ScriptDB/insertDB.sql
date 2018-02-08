INSERT INTO "Agenzia"(nome)
  VALUES
    ('ESA'),
    ('NASA');


INSERT INTO "Satellite"(nome,"dataInizio","dataFine","nomeAgenzia")
  VALUES
    ('Herschel','2009-07-10','2013-06-17','ESA'),
    ('Spitzer','2003-12-18','2009-05-15','NASA');


INSERT INTO "Banda"(lunghezza)
  VALUES
  (70),
  (160),
  (250),
  (350),
  (500),
  (3.6),
  (4.5),
  (5.8),
  (8.0),
  (24);


INSERT INTO "Strumento"(nome, "nomeSatellite")
  VALUES
    ('Herschel-PACS','Herschel'),
    ('Herschel-SPIRE','Herschel'),
    ('Spitzer-IRAC','Spitzer'),
    ('Spitzer-MIPS','Spitzer');


INSERT INTO "Utente"(nome, cognome, username, password, email, "tipoUtente")
  VALUES
    ('Franco','Gialli','FrancoG94','francobasi94','FrancoG94@gmail.com','utenteRegitrato'),
    ('Marco','Rossi','MarcoR94','marcobasi94','MarcoR94@gmail.com','Amministartore');