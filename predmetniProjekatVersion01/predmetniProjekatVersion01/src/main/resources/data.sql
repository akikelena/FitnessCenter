/* FITNES CENTAR */
INSERT INTO FITNESSCENTAR (naziv, adresa, brTelCentrale, email) VALUES ('Pro</G>ym', 'Trg Dositeja Obradovića 6', '022490481', 'progym@gmail.com');

/* SALA */
INSERT INTO SALA (kapacitet, oznakaSale, fcentar_id) VALUES (20, 'S1-1', 1);
INSERT INTO SALA (kapacitet, oznakaSale, fcentar_id) VALUES (15, 'S1-2', 1);
INSERT INTO SALA (kapacitet, oznakaSale, fcentar_id) VALUES (25, 'S2-1', 1);
INSERT INTO SALA (kapacitet, oznakaSale, fcentar_id) VALUES (10, 'S2-2', 1);
INSERT INTO SALA (kapacitet, oznakaSale, fcentar_id) VALUES (25, 'S3-1', 1);


/* KORISNIK */
INSERT INTO KORISNIK (korisnickoIme, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('akikelena', 'passadmin2', 'Elena', 'Akik', '0634655690', 'elenaakik11@gmail.com', 2000-08-22, 0, false);
INSERT INTO KORISNIK (korisnickoIme, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('anapetrovic1', 'anaxyz34', 'Ana', 'Petrovic', '06578900546', 'ana.p@gmail.com', 1998-08-09, 2, false);
INSERT INTO KORISNIK (korisnickoIme, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('petarpetrovic2', 'petarxu45', 'Petar', 'Petrovic', '0615673449', 'petar.petr45@gmail.com', 1995-07-01, 2, false);
INSERT INTO KORISNIK (korisnickoIme, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('marijasavic09', 'werhjmuo890', 'Marija', 'Savic', '0623899071', 'savicmm93@gmail.com', 1993-08-09, 2, false);
INSERT INTO KORISNIK (korisnickoIme, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('markoperic', 'p.marko99', 'Marko', 'Peric', '0627899031', 'pericm909@gmail.com', 1999-11-11, 2, false);
INSERT INTO KORISNIK (korisnickoIme, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('jelenadimitrijevic', 'd_jelena34', 'Jelena', 'Dimitrijevic', '0655546790', 'ana.p@gmail.com', 1987-10-15, 1, false);


/* ADMINISTRATOR */
INSERT INTO ADMINISTRATOR(id) VALUES (0);

/* CLAN */
INSERT INTO CLAN(id) VALUES (2);

/* TRENER */
INSERT INTO TRENER(id, fcentar_id) VALUES (1, 1);

/* TRENING */
INSERT INTO TRENING(naziv, opis, tipTreninga, trajanje) VALUES ('crossfit', 'napredni treninzi', 0, 60 );
INSERT INTO TRENING(naziv, opis, tipTreninga, trajanje) VALUES ('fitness', 'srednje napredni treninzi', 1, 45);
INSERT INTO TRENING(naziv, opis, tipTreninga, trajanje) VALUES ('yoga', 'osnovi nivo treninga', 2, 45);
INSERT INTO TRENING(naziv, opis, tipTreninga, trajanje) VALUES ('skill', 'vezbe tehnike', 2, 120);
INSERT INTO TRENING(naziv, opis, tipTreninga, trajanje) VALUES ('trx', 'srednje napredni treninzi', 3, 60);
INSERT INTO TRENING(naziv, opis, tipTreninga, trajanje) VALUES ('competition', 'takmicarska pripremna grupa', 4, 120);
INSERT INTO TRENING(naziv, opis, tipTreninga, trajanje) VALUES ('mobility', 'srednji nivo treninga', 5, 60);

/* ODRADJENI TRENINZI - MEDJUTABELA */
INSERT INTO ODRADJENI_TRENINZI(clan_id, trening_id) VALUES ();

/* PRIJAVLJENI TRENINZI - MEDJUTABELA */
INSERT INTO PRIJAVLJENI_TRENINZI(clan_id, trening_id) VALUES ();

