/*$(document).ready(function () {
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

});     *///


$(document).ready(function () {
    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);
        window.location.href = "index.html";
    }
    if(rola == 0){
        window.location.href = "index.html";
    }
    if(rola == 2){
        window.location.href = "trener_page.html";
        
    }
    if(rola == 1){
        window.location.href = "admin_page.html";
        
    }
    let idClana = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/termin/prijavljeniTermini/" + idClana,
        dataType: "json",
        contentType: "application/json",

        success: function (res) {
            console.log("SUCCESS:\n", res);

            for (i = 0; i < res.length; i++) {
                let pocetak = res[i].pocetakTermina;
                pocetak = setCharAt(pocetak, 10, ' ');
                pocetak = pocetak.substring(0,16);

                let kraj = res[i].krajTermina;
                kraj = setCharAt(kraj, 10, ' ');
                kraj = kraj.substring(0,16);


                let row = "<tr id = 'red" + res[i].id + "'>";
                row += "<td class = \"celijaTabele\">" + res[i].id + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].naziv + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].opis + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].tipTreninga + "</td>";
                row += "<td class = \"celijaTabele\">" + pocetak + "</td>";
                row += "<td class = \"celijaTabele\">" + kraj + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].trajanjeTermina + "min" + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].cena + "din" + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].oznakaSale + "</td>";
                row += "<td class = \"celijaTabele\"><button id = 'dugmeOtkazi' type = 'submit' data-id=" + res[i].id + ">OTKAZI</button></td>"
                row += "</tr>";
                $('#neodradjeni').append(row);


            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }

    });
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/termin/ocenjeniTermini/" + idClana,
        dataType: "json",
        contentType: "application/json",
        //data: JSON.stringify(searchInfo),                                           
        success: function (res) {
            console.log("SUCCESS:\n", res);

            for (i = 0; i < res.length; i++) {
                let pocetak = res[i].pocetakTermina;
                pocetak = setCharAt(pocetak, 10, ' ');
                pocetak = pocetak.substring(0,16);

                let kraj = res[i].krajTermina;
                kraj = setCharAt(kraj, 10, ' ');
                kraj = kraj.substring(0,16);


                let row = "<tr id = 'red" + res[i].id + "'>";
                row += "<td class = \"celijaTabele\">" + res[i].id + "</td>";
                row += "<td class = \"celijaTabele\">" + pocetak + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].trajanjeTermina + "min" + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].cena + "din" + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].userTrener + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].oznakaSale + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].ocena + "</td>";
                row += "</tr>";
                $('#ocenjeni').append(row);


            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }

    });
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/termin/neocenjeniTermini/" + idClana,
        dataType: "json",
        contentType: "application/json",

        success: function (res) {
            console.log("SUCCESS:\n", res);

            for (i = 0; i < res.length; i++) {
                let pocetak = res[i].pocetakTermina;
                pocetak = setCharAt(pocetak, 10, ' ');
                pocetak = pocetak.substring(0,16);

                let kraj = res[i].krajTermina;
                kraj = setCharAt(kraj, 10, ' ');
                kraj = kraj.substring(0,16);


                let row = "<tr id = 'red" + res[i].id + "'>";
                row += "<td class = \"celijaTabele\">" + res[i].id + "</td>";
                row += "<td class = \"celijaTabele\">" + pocetak + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].trajanjeTermina + "min" + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].cena + "din" + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].userTrener + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].oznakaSale + "</td>";
                row += "<td class = \"celijaTabele\"><button id = 'dugmeOceni' type = 'submit' data-id=" + res[i].id + ">OCENI</button></td>"
                row += "</tr>";
                $('#neocenjeni').append(row);


            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }

    });
});

$(document).on('click', '#dugmeOtkazi', function () {

    let idTermina = this.dataset.id;

    let idClana = localStorage.getItem("id");

    let info = {
        idTermina,
        idClana
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/termin/odjaviTermin",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(info),
        success: function (res) {
            console.log("SUCCESS:\n", res);
            window.location.href = "userTerminiList.html";
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

});

$(document).on('click', '#dugmeOceni', function () {

    let idTermina = this.dataset.id;

    localStorage.setItem("TerminZaOceniti", idTermina);

    let idClana = localStorage.getItem("id");

    $('#naslovTabele2').append("ID TERMINA: " + idTermina);

    let sakrij = $("#infoBox");
    sakrij.show();

    let info = {
        idTermina,
        idClana
    }
});
$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let ocena = document.forms['formBox'].ocena.value;
    if(isNaN(ocena) || ocena > 10 || ocena < 0){
        ocena = 10;
    }
    let idClana = localStorage.getItem("id");
    let idTermina = localStorage.getItem("TerminZaOceniti");

    var novaOcena = {
        ocena,
        idClana,
        idTermina
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/ocena/dodajNovuOcenu",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novaOcena),
        success: function (res) {
            console.log(res);
            alert("Termin ocenjen!");
            window.location.href = "userTerminiList.html";
        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});


function zatvoriInfoBox(){

    let sakrij = $("#infoBox");
    sakrij.hide();
}

function setCharAt(str,index,chr) {
    if(index > str.length-1) return str;
    return str.substring(0,index) + chr + str.substring(index+1);
}