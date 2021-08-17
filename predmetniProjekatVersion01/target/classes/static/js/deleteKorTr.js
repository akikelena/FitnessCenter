$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType : "json",
        url : "http://localhost:8080/korisnik/KorisnikList",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for(let korisnik of response){

                let row = "<tr>";

                row += "<td>" + korisnik.id + "</td>";
                row += "<td>" + korisnik.korisnickoIme + "</td>";
                row += "<td>" + korisnik.lozinka + "</td>";
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.kontaktTelefon + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td>" + korisnik.datumRodjenja + "</td>";
                row += "<td>" + korisnik.uloga + "</td>";
                row += "<td>" + korisnik.aktivan + "</td>";

                row += "</tr>";

                $('#fc-List').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});
