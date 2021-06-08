$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType : "json",
        url : "http://localhost:8080/api/FCsList",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for(let fcentar of response){
                let row = "<tr>";

                row += "<td>" + fcentar.id + "</td>";
                row += "<td>" + fcentar.naziv + "</td>";
                row += "<td>" + fcentar.adresa + "</td>";
                row += "<td>" + fcentar.brTelCentrale + "</td>";
                row += "<td>" + fcentar.email + "</td>";
                row += "</tr>";

                $('#sviKorisnici').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});