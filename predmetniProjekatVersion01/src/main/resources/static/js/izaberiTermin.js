
    var slobodnihMesta = 0;

$(document).ready(function () {

    $.ajax({
        type : "GET",
        url : "http://localhost:8080/termin/izabraniTermini/" + localStorage.getItem('termin'),
        dataType : "json",

        success : function (response) {
            console.log("SUCCESS");
            console.log(response);

                    let row = "<tr>";

                row += "<td>" + response.id + "</td>";
                row += "<td>" + new Date(response.pocetakTermina).toLocaleString() + "</td>";
                row += "<td>" + response.brojPrijavljenihClanova + "</td>";
                row += "<td>" + response.cena + "</td>";
                row += "<td>" + response.naziv + "</td>";
                row += "<td>" + response.opis + "</td>";
                row += "<td>" + response.tipTreninga + "</td>";
                row += "<td>" + response.oznakaSale + "</td>";
                let btn = "<button class='prijava' data-id=" + response.id + ">Prijavi se za termin</button>";
                row += "<td>" + btn + "</td>";

                    row += "</tr>";

                slobodnihMesta = response.kapacitet;

                $('#termini-List').append(row);

        },

        error : function (response){
            console.log("ERROR: \n");
            console.log(response);
        }
    });
});

    $(document).on('click', '.prijava', function fun(event) {
        event.preventDefault();

        if(slobodnihMesta <= 0){
            alert("Nema slobodnih mesta!");
            window.location.href = "TerminList.html";
        }
        else {
            console.log(localStorage.getItem("ID"),localStorage.getItem("termin"));

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/termin/prijaviTrening/"+localStorage.getItem("ID")+"/"+ localStorage.getItem("termin"),
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(),

                success: function (response) {
                    console.log(response);
                    alert("Prijavljen termin!");
                },
                error: function(response) {
                    console.log("ERROR: \n", response);
                    alert("Prijavljen termin!");
                }
            });
            window.location.href = "TerminList.html";
        }
    });