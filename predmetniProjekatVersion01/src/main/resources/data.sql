/* FITNES CENTAR */
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email, uklonjen) VALUES ('ProGym', 'Trg Dositeja Obradovića 6', '022490481', 'progym@gmail.com', '0');
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email, uklonjen) VALUES ('ProGym01', 'Trg Dositeja Obradovića 7', '022490870', 'progym01@gmail.com', '0');
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email, uklonjen) VALUES ('ProGym02', 'Trg Dositeja Obradovića 8', '022432456', 'progym01@gmail.com', '0');
INSERT INTO FITNESS_CENTAR (naziv, adresa, br_tel_centrale, email, uklonjen) VALUES ('ProGym03', 'Trg Dositeja Obradovića 9', '022490087', 'progym03@gmail.com', '0');

/* SALA */
INSERT INTO SALA (kapacitet, oznaka_sale, sala_se_koristi, fitness_centar_id) VALUES (20, 'S1-1', 1, 1);
INSERT INTO SALA (kapacitet, oznaka_sale, sala_se_koristi,fitness_centar_id) VALUES (15, 'S1-2', 1, 2);
INSERT INTO SALA (kapacitet, oznaka_sale, sala_se_koristi,fitness_centar_id) VALUES (25, 'S2-1', 0, 1);
INSERT INTO SALA (kapacitet, oznaka_sale, sala_se_koristi,fitness_centar_id) VALUES (10, 'S2-2', 1, 2);
INSERT INTO SALA (kapacitet, oznaka_sale, sala_se_koristi,fitness_centar_id) VALUES (25, 'S3-1', 1, 1);


/* KORISNIK */

INSERT INTO ADMIN (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, aktivan) VALUES ('akikelena', 'passadmin2', 'Elena', 'Akik', '0634655690', 'elenaakik11@gmail.com', '2000-08-22 15:00:00.000000', true);

INSERT INTO CLAN (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, aktivan) VALUES ('anapetrovic1', 'anaxyz34', 'Ana', 'Petrovic', '06578900546', 'ana.p@gmail.com', '1998-08-09 19:00:00.000000', true);
INSERT INTO CLAN (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, aktivan) VALUES ('petarpetrovic2', 'petarxu45', 'Petar', 'Petrovic', '0615673449', 'petar.petr45@gmail.com', '1995-07-01 19:00:00.000000', true);
INSERT INTO CLAN (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, aktivan) VALUES ('jelenadimitrijevic', 'd_jelena34', 'Jelena', 'Dimitrijevic', '0655546790', 'ana.p8@gmail.com', '1987-10-15 19:00:00.000000', true);

INSERT INTO TRENER (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, aktivan, uklonjen, prosecna_ocena, fitness_centar_id) VALUES ('marijasavic09', 'werhjmuo890', 'Marija', 'Savic', '0623899071', 'savicmm93@gmail.com', '1993-08-09 20:00:00.000000', true, false, '8.00', 1);
INSERT INTO TRENER (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja,aktivan, uklonjen,  prosecna_ocena,fitness_centar_id) VALUES ('markoperic', 'p.marko99', 'Marko', 'Peric', '0627899031', 'pericm909@gmail.com', '1999-11-11 19:00:00.000000', false, false , '9.00', 2);
INSERT INTO TRENER (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, aktivan, uklonjen, prosecna_ocena, fitness_centar_id) VALUES ('m.bojana', 'bojananovi0708', 'Bojana', 'Milic', '0656768987', 'bojanamilicntr07@gmail.com', '1980-10-02 19:00:00.000000', true, false , '8.45', 1);
INSERT INTO TRENER (korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, aktivan, uklonjen, prosecna_ocena, fitness_centar_id) VALUES ('mitrovicj13', 'mitrovictr567', 'Jovan', 'Mitrovic', '06144768987', 'jovanmitrovic236@gmail.com', '1984-11-02 20:00:00.000000', false , false , '9.35', 2);

/* TRENING */
INSERT INTO TRENING(naziv, opis, tip_treninga) VALUES ('intense', 'napredni', 'CROSSFIT');
INSERT INTO TRENING(naziv, opis, tip_treninga) VALUES ('medium', 'srednji', 'FITNESS');
INSERT INTO TRENING(naziv, opis, tip_treninga) VALUES ('easy', 'osnovni', 'YOGA');
INSERT INTO TRENING(naziv, opis, tip_treninga) VALUES ('medium', 'tehnika', 'SKILL');
INSERT INTO TRENING(naziv, opis, tip_treninga) VALUES ('medium', 'srednji', 'TRX');
INSERT INTO TRENING(naziv, opis, tip_treninga) VALUES ('intense', 'takmicarski', 'COMPETITION');
INSERT INTO TRENING(naziv, opis, tip_treninga) VALUES ('easy', 'srednji', 'MOBILITY');

/* TERMIN  */
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena, otkazan, trening_id, trener_id, sale_id) VALUES ('2021-05-04 11:30:00', '2021-05-04 12:30:00', '60', '550', 0, 1, 1, 2);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena,otkazan, trening_id, trener_id, sale_id) VALUES ('2021-11-07 18:30:00', '2021-11-07 19:30:00', '60', '500', 0, 4, 1, 4);
INSERT INTO TERMIN(pocetak_termina,kraj_termina, trajanje_termina, cena, otkazan,trening_id, trener_id,sale_id) VALUES ('2021-11-05 15:45:00', '2021-11-05 17:15:00', '90', '750', 0, 2, 2, 2);
INSERT INTO TERMIN(pocetak_termina,kraj_termina, trajanje_termina, cena, otkazan,trening_id, trener_id,sale_id) VALUES ('2021-11-04 15:15:00', '2021-11-04 16:00:00', '45', '330', 0, 1, 2, 4);
INSERT INTO TERMIN(pocetak_termina,kraj_termina, trajanje_termina, cena, otkazan,trening_id, trener_id,sale_id) VALUES ('2021-11-07 15:30:00', '2021-11-07 17:30:00', '120', '630', 0, 5, 2, 1);
INSERT INTO TERMIN(pocetak_termina,kraj_termina, trajanje_termina, cena, otkazan,trening_id, trener_id,sale_id) VALUES ('2021-11-06 12:45:00', '2021-11-06 15:15:00', '150', '1200', 0, 6, 1, 5);
INSERT INTO TERMIN(pocetak_termina,kraj_termina, trajanje_termina, cena, otkazan,trening_id, trener_id,sale_id) VALUES ('2018-11-08 11:15:00', '2018-11-08 12:30:00', '75', '400', 0, 1, 2, 2);

/* OCENA */
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('8.20', 1, 1);
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('7.50', 2, 3);
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('8.90', 2, 1);
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('9.60', 3, 2);
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('8.90', 2, 2);
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('8.45', 2, 1);
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('7.60', 2, 3);
INSERT INTO OCENA(ocena, korisnik_id, termin_id) VALUES ('9.00', 2, 5);


/*  MEDJUTABELE  */

/* ODRADJENI TRENINZI */
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (2, 1);
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (1, 1);
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (1, 2);
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (1, 4);
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (1, 5);
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (2, 2);
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (3, 1);
INSERT INTO ODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (3, 2);

/* PRIJAVLJENI TRENINZI  */
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (1,3);
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (1,6);
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (1,7);
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (2,2);
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (2,5);
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (2,6);
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (3,3);
INSERT INTO NEODRADJENI_TERMINI(korisnik_id, termin_id) VALUES (3,1);