$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType : "json",
        url : "http://localhost:8080/fcentar/FCList",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for(let fitnessCentar of response){
                let row = "<tr>";
                row += "<td>" + fitnessCentar.id + "</td>";
                row += "<td>" + fitnessCentar.naziv + "</td>";
                row += "<td>" + fitnessCentar.adresa + "</td>";
                row += "<td>" + fitnessCentar.brTelCentrale + "</td>";
                row += "<td>" + fitnessCentar.email + "</td>";
                row += "</tr>";

                $('#fc-List').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});