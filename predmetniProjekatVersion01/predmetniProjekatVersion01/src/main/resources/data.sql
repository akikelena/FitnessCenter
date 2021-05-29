/* FITNES CENTAR */
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email) VALUES ('Pro</G>ym', 'Trg Dositeja Obradovića 6', '022490481', 'progym@gmail.com');

/* SALA */
INSERT INTO SALA (kapacitet, oznaka_sale, fcentar_id) VALUES (20, 'S1-1', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fcentar_id) VALUES (15, 'S1-2', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fcentar_id) VALUES (25, 'S2-1', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fcentar_id) VALUES (10, 'S2-2', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fcentar_id) VALUES (25, 'S3-1', 1);

/* TRENING */
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje) VALUES ('crossfit', 'napredni treninzi', 'CROSSFIT', 60 );
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje) VALUES ('fitness', 'srednje napredni treninzi', 'FITNESS', 45);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje) VALUES ('yoga', 'osnovi nivo treninga', 'YOGA', 45);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje) VALUES ('skill', 'vezbe tehnike', 'SKILL', 120);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje) VALUES ('trx', 'srednje napredni treninzi', 'TRX', 60);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje) VALUES ('competition', 'takmicarska pripremna grupa', 'COMPETITION', 120);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje) VALUES ('mobility', 'srednji nivo treninga', 'MOBILITY', 60);


/* KORISNIK */
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('akikelena', 'passadmin2', 'Elena', 'Akik', '0634655690', 'elenaakik11@gmail.com', '2000-08-22 15:00:00.000000', 'ADMINISTRATOR', true);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('anapetrovic1', 'anaxyz34', 'Ana', 'Petrovic', '06578900546', 'ana.p@gmail.com', '1998-08-09 19:00:00.000000', 'CLAN', true);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('petarpetrovic2', 'petarxu45', 'Petar', 'Petrovic', '0615673449', 'petar.petr45@gmail.com', '1995-07-01 19:00:00.000000', 'CLAN', true);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('marijasavic09', 'werhjmuo890', 'Marija', 'Savic', '0623899071', 'savicmm93@gmail.com', '1993-08-09 20:00:00.000000', 'TRENER', true);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('markoperic', 'p.marko99', 'Marko', 'Peric', '0627899031', 'pericm909@gmail.com', '1999-11-11 19:00:00.000000', 'TRENER', false);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) VALUES ('jelenadimitrijevic', 'd_jelena34', 'Jelena', 'Dimitrijevic', '0655546790', 'ana.p@gmail.com', '1987-10-15 19:00:00.000000', 'CLAN', true);

/* ADMINISTRATOR */
INSERT INTO ADMINISTRATOR_KORISNIK(id) VALUES (0);

/* CLAN */
INSERT INTO CLAN_KORISNIK(id) VALUES (1);
INSERT INTO CLAN_KORISNIK(id) VALUES (2);
INSERT INTO CLAN_KORISNIK(id) VALUES (3);

/* TRENER */
INSERT INTO TRENER_KORISNIK(id, fcentar_id) VALUES (1, 1);

/* TERMIN  */
INSERT INTO TERMIN(cena, pocetak_termina, broj_prijavljenih, sala_id, trening_id) VALUES (3000, 2021-05-20 08:00:00.000000, 13,  3, 1);

/* OCENA */
INSERT INTO OCENA(ocena, trener_id, termin_id) VALUES (5, 1, 1);

/*  MEDJUTABELE  */

/* ODRADJENI TRENINZI  */
INSERT INTO ODRADJENI_TRENINZI(clan_id, trening_id) VALUES (2, 1);

/* PRIJAVLJENI TRENINZI  */
INSERT INTO PRIJAVLJENI_TRENINZI(clan_id, trening_id) VALUES (1,1);

/* OCENE TRENINGA */
INSERT INTO OCENE_TRENINGA(clan_id, ocena_id) VALUES (2, 1);
