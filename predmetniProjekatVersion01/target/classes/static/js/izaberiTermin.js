$(document).ready(function () {
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/termin/TerminList",

        success : function (response) {
            console.log("SUCCESS");
            console.log(response);

            for(let termini of response){
                let row = "<tr>";

                row += "<td>" + termini.id + "</td>";
                row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                row += "<td>" + termini.brojPrijavljenihClanova + "</td>";
                row += "<td>" + termini.cena + "</td>";
                row += "<td>" + termini.naziv + "</td>";
                row += "<td>" + termini.opis + "</td>";
                row += "<td>" + termini.tipTreninga + "</td>";
                row += "<td>" + termini.oznakaSale + "</td>";
                let btn = "<button class='izborTermina' data-id=" + termini.id + ">Izaberi termin</button>";
                row += "<td>" + btn + "</td>";


                row += "</tr>";

                $('#termini-List').append(row);
            }
        },

        error : function (response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '.izborTermina', function myFunction(event) {
    event.preventDefault();

        window.localStorage.setItem('termini', this.id);
        window.location.href = "izabraniTermini.html";

});