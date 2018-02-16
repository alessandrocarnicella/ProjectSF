INSERT INTO agenzia(nome)
  VALUES
    ('ESA'),
    ('NASA');


INSERT INTO satellite(nome,datainizio,datafine,nomeagenzia)
  VALUES
    ('Herschel','2009-07-10','2013-06-17','ESA'),
    ('Spitzer','2003-12-18','2009-05-15','NASA');


INSERT INTO banda(lunghezza)
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


INSERT INTO strumento(nome, nomesatellite)
  VALUES
    ('PACS','Herschel'),
    ('SPIRE','Herschel'),
    ('IRAC','Spitzer'),
    ('MIPS','Spitzer');


INSERT INTO utente(nome, cognome, username, password, email, tipoutente)
  VALUES
    ('Franco','Gialli','FrancoG94','francobasi94','FrancoG94@gmail.com','utenteRegitrato'),
    ('Marco','Rossi','MarcoR94','marcobasi94','MarcoR94@gmail.com','Amministratore'),
    ('utente','utente','utente','utente','@email','utenteRegistrato'),
    ('utentea','utentea','utentea','utentea','@emaila','Amministratore');


