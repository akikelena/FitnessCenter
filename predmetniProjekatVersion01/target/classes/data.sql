/* FITNES CENTAR */
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email) VALUES ('Pro</G>ym', 'Trg Dositeja Obradovića 6', '022490481', 'progym@gmail.com');
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email) VALUES ('Pro</G>ym01', 'Trg Dositeja Obradovića 7', '022490870', 'progym01@gmail.com');
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email) VALUES ('Pro</G>ym02', 'Trg Dositeja Obradovića 8', '022432456', 'progym01@gmail.com');
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email) VALUES ('Pro</G>ym03', 'Trg Dositeja Obradovića 9', '022490087', 'progym03@gmail.com');

/* SALA */
INSERT INTO SALA (kapacitet, oznaka_sale, fitness_centar_id) VALUES (20, 'S1-1', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fitness_centar_id) VALUES (15, 'S1-2', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fitness_centar_id) VALUES (25, 'S2-1', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fitness_centar_id) VALUES (10, 'S2-2', 1);
INSERT INTO SALA (kapacitet, oznaka_sale, fitness_centar_id) VALUES (25, 'S3-1', 1);


/* KORISNIK */

INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan, fitness_centar_id) VALUES ('akikelena', 'passadmin2', 'Elena', 'Akik', '0634655690', 'elenaakik11@gmail.com', '2000-08-22 15:00:00.000000', 'ADMINISTRATOR', true,1);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan, fitness_centar_id) VALUES ('anapetrovic1', 'anaxyz34', 'Ana', 'Petrovic', '06578900546', 'ana.p@gmail.com', '1998-08-09 19:00:00.000000', 'CLAN', true, 1);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan, fitness_centar_id) VALUES ('petarpetrovic2', 'petarxu45', 'Petar', 'Petrovic', '0615673449', 'petar.petr45@gmail.com', '1995-07-01 19:00:00.000000', 'CLAN', true, 1);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan, fitness_centar_id) VALUES ('marijasavic09', 'werhjmuo890', 'Marija', 'Savic', '0623899071', 'savicmm93@gmail.com', '1993-08-09 20:00:00.000000', 'TRENER', true, 2);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan, fitness_centar_id) VALUES ('markoperic', 'p.marko99', 'Marko', 'Peric', '0627899031', 'pericm909@gmail.com', '1999-11-11 19:00:00.000000', 'TRENER', false, 2);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan, fitness_centar_id) VALUES ('jelenadimitrijevic', 'd_jelena34', 'Jelena', 'Dimitrijevic', '0655546790', 'ana.p8@gmail.com', '1987-10-15 19:00:00.000000', 'CLAN', true, 1);


/* TRENING */
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, treninzi_koje_drzi_id) VALUES ('crossfit', 'napredni nivo treninga', 'CROSSFIT', 60, 1 );
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, treninzi_koje_drzi_id) VALUES ('fitness', 'srednje napredni nivo treninga', 'FITNESS', 45, 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, treninzi_koje_drzi_id) VALUES ('yoga', 'osnovi nivo treninga', 'YOGA', 45, 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, treninzi_koje_drzi_id) VALUES ('skill', 'vezbe tehnike', 'SKILL', 90, 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, treninzi_koje_drzi_id) VALUES ('trx', 'srednje napredni nivo treninga', 'TRX', 60, 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, treninzi_koje_drzi_id) VALUES ('competition', 'takmicarska pripremna grupa', 'COMPETITION', 90, 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, treninzi_koje_drzi_id) VALUES ('mobility', 'srednji nivo treninga', 'MOBILITY', 60, 1);

/* TERMIN  */
INSERT INTO TERMIN(pocetak_termina, broj_prijavljenih_clanova, cena, treninzi_id, sale_id) VALUES ('2020-05-20 08:00:00.000000', 13, 3000,  3, 1);
INSERT INTO TERMIN(pocetak_termina, broj_prijavljenih_clanova, cena, treninzi_id, sale_id) VALUES ('2021-05-14 19:00:00.000000', 15, 3800,  1, 3);
INSERT INTO TERMIN(pocetak_termina, broj_prijavljenih_clanova, cena, treninzi_id, sale_id) VALUES ('2020-05-20 08:00:00.000000', 10, 3400,  4, 2);

/* OCENA */
INSERT INTO OCENA(ocena, trener_id, termini_id) VALUES (9, 1, 1);
INSERT INTO OCENA(ocena, trener_id, termini_id) VALUES (10, 2, 2);

/*  MEDJUTABELE  */

/* ODRADJENI TRENINZI  */
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (2, 1);

/* PRIJAVLJENI TRENINZI  */
INSERT INTO PRIJAVLJENI_TERMINI(korisnik_id, termin_id) VALUES (1,1);
INSERT INTO PRIJAVLJENI_TERMINI(korisnik_id, termin_id) VALUES (2,2);
INSERT INTO PRIJAVLJENI_TERMINI(korisnik_id, termin_id) VALUES (2,1);
