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

});

$(document).on("submit", "form", function (event) {
    event.preventDefault();
    let isprazni = $("#sadrzajTabele");
    isprazni.empty();

    let test = document.forms['searchBox'].ropcija.value;

    if(test == "sve"){
        var sve = true;
    } else {
        var sve = false;
    }

    let maxCena = 100000;
    let maxTrajanje = document.forms['searchBox'].maksimalnoTrajanje.value;
    if(maxTrajanje == "" || isNaN(maxTrajanje)){
        maxTrajanje = 100000;
    }
    let tipTreninga  = document.forms['searchBox'].tipTreninga.value;
    let naziv  = document.forms['searchBox'].nazivTreninga.value;
    let opis  = document.forms['searchBox'].opisTreninga.value;
    let doDatuma = "2025-12-31";

    
    let searchInfo = {
        sve,
        maxCena,
        maxTrajanje,
        tipTreninga,
        naziv,
        opis,
        doDatuma,
    }
    let idClana = localStorage.getItem("id");
    console.log(searchInfo);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/termin/criteriaPrijava/" + idClana,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(searchInfo),
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
                row += "<td class = \"celijaTabele\">" + res[i].trajanjeTermina + "min" + "</td>";
                row += "<td class = \"celijaTabele\"><button id = 'dugmeInfo' type = 'submit' data-id=" + res[i].id + ">INFO</button></td>"
                row += "</tr>";
                $('#sadrzajTabele').append(row);


            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }

    });
});

$(document).on('click', '#dugmePrijavi', function () {

    let idTermina = this.dataset.id;
    let brisanje = "#red";
    brisanje += idTermina;

    let sakrij = $(brisanje);
    sakrij.hide();

    let idClana = localStorage.getItem("id");

    let info = {
        idTermina,
        idClana
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/termin/prijaviTermin",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(info),
        success: function (res) {
            console.log("SUCCESS:\n", res);
            if(res.retVal == -1){
                alert("Nema mesta na ovom terminu!")
            } else {
                alert("Uspesno ste se prijavili za termin!");
            }
            let isprazni = $("#tableInfo");
            isprazni.empty();
            let sakrij = $("#infoBox");
            sakrij.hide();
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});
$(document).on('click', '#dugmeInfo', function () {

    let isprazni = $("#tableInfo");
    isprazni.empty();
    let idTermina = this.dataset.id;
    let sakrij = $("#infoBox");
    sakrij.show();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/termin/oTerminu/" + idTermina,
        dataType: "json",
        success: function (res) {

            console.log("SUCCESS:\n", res);

            let pocetak = res.pocetakTermina;
            pocetak = setCharAt(pocetak, 10, ' ');
            pocetak = pocetak.substring(0,16);

            let kraj = res.krajTermina;
            kraj = setCharAt(kraj, 10, ' ');
            kraj = kraj.substring(0,16);


            let row = "<tr><td class='infoTextTitle rightAlign'> ID TERMINA: </td><td class='infoText centerAlign'>" + res.id + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> POCETAK TERMINA: </td></td><td class='infoText centerAlign'>" + pocetak + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> TRAJANJE: </td></td><td class='infoText centerAlign'>" + res.trajanjeTermina + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> CENA: </td></td><td class='infoText centerAlign'>" + res.cena + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> NAZIV: </td></td><td class='infoText centerAlign'>" + res.naziv + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> OPIS: </td></td><td class='infoText centerAlign'>" + res.opis + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> TIP: </td></td><td class='infoText centerAlign'>" + res.tipTreninga + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> SALA: </td></td><td class='infoText centerAlign'>" + res.oznakaSale + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> TRENER: </td></td><td class='infoText centerAlign'>" + res.userTrener + "<td></tr>";
            row += "<tr><td class='infoTextTitle rightAlign'> OCENA TRENERA: </td></td><td class='infoText centerAlign'>" + String(res.ocena).substring(0,4) + "<td></tr>";
            row += "<tr><td style='height: 30px;'></td></tr>";
            row += "<tr><td class='centerAlign' colspan='2'><button id = 'dugmePrijavi' type = 'submit' data-id=" + res.id + ">PRIJAVI SE</button></td></tr>";
            row += "<tr><td style='height: 30px;'></td></tr>";

            $('#tableInfo').append(row);


        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

function setCharAt(str,index,chr) {
    if(index > str.length-1) return str;
    return str.substring(0,index) + chr + str.substring(index+1);
}
function zatvoriInfoBox(){
    let isprazni = $("#tableInfo");
    isprazni.empty();
    let sakrij = $("#infoBox");
    sakrij.hide();
}

function sortiraj(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("tabelaTermina2");
    switching = true;

    dir = "asc";

    while (switching) {

        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {

            shouldSwitch = false;

            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;

            switchcount ++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function sortirajBroj(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("tabelaTermina2");
    switching = true;
    dir = "asc";
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i =1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            let prvi = x.innerHTML.toLowerCase();
            let drugi = y.innerHTML.toLowerCase();
            if (dir == "asc") {
                if (Number(prvi) > Number(drugi)) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (Number(prvi) < Number(drugi)) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount ++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function sortirajSaSufiksom(n, suf) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("tabelaTermina2");
    switching = true;
    dir = "asc";
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            let prvi = x.innerHTML.toLowerCase();
            let drugi = y.innerHTML.toLowerCase();
            prvi = prvi.substring(0,(prvi.length - suf));
            drugi = drugi.substring(0,(drugi.length - suf));
            if (dir == "asc") {
                if (Number(prvi) > Number(drugi)) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (Number(prvi) < Number(drugi)) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount ++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}
        