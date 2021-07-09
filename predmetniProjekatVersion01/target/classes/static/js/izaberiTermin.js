
    var slobodnihMesta = 0;

$(document).ready(function () {

    let id = localStorage.getItem('termin');

    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/termin/izabraniTermini/" + id,

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
                row += "<td>" + "<button class='izborTermina' data-id=" + response.id + ">Prijavi se za termin</button>" + "</td>";
                //let btn = "<button class='izborTermina' data-id=" + response.id + ">Prijavi se za termin</button>";
                //row += "<td>" + btn + "</td>";

                    row += "</tr>";

                slobodnihMesta += response.kapacitet;

                $('#izabranitermini-List').append(row);

        },

        error : function (response){
            console.log("ERROR: \n");
            console.log(response);
        }
    });
});
/*
$(document).on('click', '.izborTermina', function fun(event) {
    event.preventDefault();

    if (slobodnihMesta > 0) {
        console.log(localStorage.getItem("ID"), localStorage.getItem("termin"));

        $.ajax({
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(),
            url : "http://localhost:8080/termin/prijaviTrening/" + localStorage.getItem("ID")+ "/" + localStorage.getItem("termin"),

            success: function (response) {
                console.log("SUCCESS!");
                console.log(response);

                alert("Prijavljen termin!");
            },

            error: function () {
                console.log("ERROR!");
                console.log(response);
            }
        });
    } else {
        alert("Nema slobodnih mesta!");
        window.location.href = "izaberiTermin.html";
    }
});
 */

    $(document).on('click', '.izborTermina', function fun(event) {
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