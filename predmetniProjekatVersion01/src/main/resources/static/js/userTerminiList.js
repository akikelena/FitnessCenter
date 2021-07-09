$(document).ready(function () {
    //let idKorisnika = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/termin/terminiKorisnika/"+localStorage.getItem("ID"),
        dataType: "json",
        success: function (response) {
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
                let btn =  "<button class='odjavi' id=" + response.id + ">Odjavi</button>";
                row += "<td>" + btn + "</td>";

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

$(document).on('click', '.odjavi', function myFunction(event) {
    event.preventDefault();

    console.log(localStorage.getItem("ID"),localStorage.getItem("termin"));

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/termin/odjaviTrening/"+localStorage.getItem("ID")+"/"+ localStorage.getItem("termin"),
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(),

        success: function (response) {
            console.log(response);
            alert("Odjavljeno!");
        },

        error: function(response) {
            console.log("ERROR: \n", response);
            alert("Odjavljeno!");
        }
    });
    window.location.href = "userTerminiList.html";

});