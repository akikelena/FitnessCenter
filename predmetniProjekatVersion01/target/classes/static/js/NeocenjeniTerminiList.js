$(document).ready(function () {

    let id = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/termin/listaNeocenjenihTermina/"+id,

            success: function (response) {

                console.log("SUCCESS!");
                console.log(response);

            for (let termin of response) {

                    let row = "<tr>";

                row += "<td>" + termin.id + "</td>";
                row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + termin.opis + "</td>";
                row += "<td>" + termin.tipTreninga + "</td>";
                row += "<td>" + termin.oznakaSale + "</td>";

                    row += "</tr>";

                $('#termini-List').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n");
            console.log(response);
        }
    });
});