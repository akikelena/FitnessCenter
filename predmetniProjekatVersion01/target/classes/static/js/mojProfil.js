$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/korisnik/"+localStorage.getItem("ID"),

        success: function (response) {
            console.log("SUCCESS:\n");
            console.log(response);

                let row = "<tr>";

            row += "<td>" + response.id + "</td>";
            row += "<td>" + response.korisnickoIme + "</td>";
            row += "<td>" + response.ime + "</td>";
            row += "<td>" + response.prezime + "</td>";
            row += "<td>" + response.email + "</td>";
            row += "<td>" + response.kontaktTelefon + "</td>";
            row += "<td>" + response.datumRodjenja + "</td>";
            row += "<td>" + response.uloga + "</td>";

                row += "</tr>";

            $('#moj-Profil').append(row);
        },
        error: function (response) {
            console.log("ERROR:\n");
            console.log(response);
        }
    });

});