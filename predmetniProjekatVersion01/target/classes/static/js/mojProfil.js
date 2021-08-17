$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/korisnik/"+localStorage.getItem("ID"),

        success: function (response) {
            console.log("SUCCESS:\n");
            console.log(response);

            let row1 = "<tr>";
            row1 += "<td>" + response.id + "</td>";
            row1 += "</tr>";

            $('#moj-Profil').append(row1);

            let row2 = "<tr>";
            row2 += "<td>" + response.korisnickoIme  + "</td>";
            row2 += "</tr>";

            $('#moj-Profil').append(row2);

            let row3 = "<tr>";
            row3 += "<td>" + response.ime + "</td>";
            row3 += "</tr>";

            $('#moj-Profil').append(row3);

            let row4 = "<tr>";
            row4 += "<td>" + response.prezime + "</td>";
            row4 += "</tr>";

            $('#moj-Profil').append(row4);

            let row5 = "<tr>";
            row5 += "<td>" + response.email  + "</td>";
            row5 += "</tr>";

            $('#moj-Profil').append(row5);

            let row6 = "<tr>";
            row6 += "<td>" + response.kontaktTelefon  + "</td>";
            row6 += "</tr>";

            $('#moj-Profil').append(row6);

            let row7 = "<tr>";
            row7 += "<td>" + response.datumRodjenja + "</td>";
            row7 += "</tr>";

            $('#moj-Profil').append(row7);

            let row8 = "<tr>";
            row8 += "<td>" + response.uloga + "</td>";
            row8 += "</tr>";


            $('#moj-Profil').append(row8s);
        },
        error: function (response) {
            console.log("ERROR:\n");
            console.log(response);
        }
    });

});

/*
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
 */