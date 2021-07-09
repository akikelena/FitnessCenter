$(document).ready(function () {

    let id = localStorage.getItem("id");

        $.ajax({
            type: "GET",
            dataType: "json",
            url: "http://localhost:8080/termin/TerminList/listaOcenjenihTermina/"+id,

            success: function (response) {

                console.log("SUCCESS!");
                console.log(response);

            for (let termini of response) {

                    let row = "<tr>";

                row += "<td>" + termini.id + "</td>";
                row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                row += "<td>" + termini.cena + "</td>";
                row += "<td>" + termini.naziv + "</td>";
                row += "<td>" + termini.opis + "</td>";
                row += "<td>" + termini.tipTreninga + "</td>";
                row += "<td>" + termini.oznakaSale + "</td>";

                    row += "</tr>";
                $('#o-termini-List').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});