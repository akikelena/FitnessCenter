$(document).ready(function (){
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/api/trening/TreningList",

        success : function (response) {
            console.log("SUCCESS: \n", response);
            console.log(response);

            for(let trening of response){
                let row = "<tr>";

                row += "<td>" + treningList.id + "</td>";
                row += "<td>" + treningList.naziv + "</td>";
                row += "<td>" + treningList.tipTreninga + "</td>";
                row += "<td>" + treningList.opis + "</td>";
                row += "<td>" + treningList.trajanje + "</td>";

                row += "</tr>";

                $('#sviKorisnici tbody').append(row);
            }
        },
        error : function (response) {
            console.log("GRESKA: \n", response);
        }
    });
});