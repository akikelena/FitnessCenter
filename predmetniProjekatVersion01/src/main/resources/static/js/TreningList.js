$(document).ready(function () {
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/trening/TreningList",

        success : function (response) {
            console.log("SUCCESS: \n", response);


            for(let trening of response){

                let row = "<tr>";

                row += "<td>" + trening.id + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";


                row += "</tr>";

                $('#trening-List').append(row);
            }
        },
        error : function (response) {
            console.log("GRESKA: \n", response);
        }
    });
});