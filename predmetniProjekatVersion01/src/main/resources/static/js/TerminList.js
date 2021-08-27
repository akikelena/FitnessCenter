/*$(document).ready(function () {
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/termin/TerminList",

        success : function (response) {
            console.log("SUCCESS: \n");
            console.log(response);

            for(let termin of response){
                let row = "<tr>";

                row += "<td>" + termin.id + "</td>";
                row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + termin.opis + "</td>";
                row += "<td>" + termin.tipTreninga + "</td>";
                row += "<td>" + termin.oznakaSale + "</td>";
                let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#termini-List').append(row);
            }
        },

        error : function (response){
            console.log("ERROR: \n");
            console.log( response);
        }
});

  $("#submit").on("click", function (event){
        event.preventDefault();

        let naziv = $('#naziv-polje').val();
        let opis = $('#opis-polje').val();
        let tipTreninga = $('#tipTreninga-polje').val();
        let pocetakTermina = $('#pocetakTermina-polje').val();
        let cena = $('#cena-polje').val();

        let sortCena = $('#sortCena').val();
        let sortVreme = $('#sortVreme').val();

        if($('#naziv-polje').val() != "") {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/naziv?naziv="+ $('#naziv-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

                    for(let termin of response){
                            let row = "<tr>";

                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                        row += "<td>" + termin.cena + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + termin.opis + "</td>";
                        row += "<td>" + termin.tipTreninga + "</td>";
                        row += "<td>" + termin.oznakaSale + "</td>";
                        let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                        row += "<td>" + btn + "</td>";
                            row += "</tr>";

                        $('#termini-List').append(row);
                    }
                },
                error: function (response){
                    console.log("ERROR: \n");
                    console.log(response);
                }
            });
        }

        if($('#tipTreninga-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/tipTreninga?tipTreninga="+ $('#tipTreninga-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

                    for(let termin of response){
                            let row = "<tr>";

                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                        row += "<td>" + termin.cena + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + termin.opis + "</td>";
                        row += "<td>" + termin.tipTreninga + "</td>";
                        row += "<td>" + termin.oznakaSale + "</td>";
                        let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                        row += "<td>" + btn + "</td>";

                            row += "</tr>";

                        $('#termini-List').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log( response);
                }
            });
        }


        if($('#opis-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/opis?opis="+ $('#opis-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

                    for(let termin of response){
                            let row = "<tr>";

                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                        row += "<td>" + termin.cena + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + termin.opis + "</td>";
                        row += "<td>" + termin.tipTreninga + "</td>";
                        row += "<td>" + termin.oznakaSale + "</td>";
                        let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                        row += "<td>" + btn + "</td>";

                            row += "</tr>";

                        $('#termini-List').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log( response);
                }
            });
        }


        if($('#pocetakTermina-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/pocetak?pocetakTermina="+ $('#pocetakTermina-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

                    for(let termin of response){
                        let row = "<tr>";

                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                        row += "<td>" + termin.cena + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + termin.opis + "</td>";
                        row += "<td>" + termin.tipTreninga + "</td>";
                        row += "<td>" + termin.oznakaSale + "</td>";
                        let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                        row += "<td>" + btn + "</td>";

                        row += "</tr>";

                        $('#termini-List').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log(response);
                }
            });
        }

        if($('#cena-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/pretraziPoCeni?cena="+ $('#cena-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

                    for(let termin of response){
                        let row = "<tr>";

                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                        row += "<td>" + termin.cena + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + termin.opis + "</td>";
                        row += "<td>" + termin.tipTreninga + "</td>";
                        row += "<td>" + termin.oznakaSale + "</td>";
                        let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                        row += "<td>" + btn + "</td>";

                        row += "</tr>";

                        $('#termini-List').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log(response);
                }
            });
        }

        if($('#sortVreme').val() != "nasumicanRedosled" && $('#sortCena').val() == "nasumicanRedosled"){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/"+ $('#sortVreme').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

                    for(let termin of response){
                            let row = "<tr>";

                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                        row += "<td>" + termin.cena + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + termin.opis + "</td>";
                        row += "<td>" + termin.tipTreninga + "</td>";
                        row += "<td>" + termin.oznakaSale + "</td>";
                        let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                        row += "<td>" + btn + "</td>";

                            row += "</tr>";

                        $('#termini-List').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log(response);
                }
            });
        }


        if($('#sortCena').val() != "nasumicanRedosled" && $('#sortVreme') == "nasumicanRedosled"){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/"+ $('#sortCena').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

                    for(let termin of response){
                        let row = "<tr>";

                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                        row += "<td>" + termin.cena + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + termin.opis + "</td>";
                        row += "<td>" + termin.tipTreninga + "</td>";
                        row += "<td>" + termin.oznakaSale + "</td>";
                        let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                        row += "<td>" + btn + "</td>";

                        row += "</tr>";

                        $('#termini-List').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log(response);
                }
            });
        }

        if($('#sortVreme').val() != "nasumicanRedosled" && $('#sortCena').val() != "nasumicanRedosled"){
            alert("Moguce sortirati samo po 1 parametru!");
        }

        if($('#sortCena').val() == "nasumicanRedosled" && $('#sortVreme').val() == "nasumicanRedosled" &&
            $('#naziv-polje').val() == "" && $('#pocetakTermina-polje').val() == "" && $('#opis-polje').val() == "" &&
            $('#tipTreninga-polje').val() == "" && $('#cena-polje').val() == ""){
            $.ajax({
                type : "GET",
                dataType : "json",
                url : "http://localhost:8080/termin/TerminList",

                    success: function (response){
                        console.log(response);
                            $('#termini-List').html("");

                                for(let termin of response){
                                    let row = "<tr>";

                                    row += "<td>" + termin.id + "</td>";
                                    row += "<td>" + new Date(termin.pocetakTermina).toLocaleString() + "</td>";
                                    row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                                    row += "<td>" + termin.cena + "</td>";
                                    row += "<td>" + termin.naziv + "</td>";
                                    row += "<td>" + termin.opis + "</td>";
                                    row += "<td>" + termin.tipTreninga + "</td>";
                                    row += "<td>" + termin.oznakaSale + "</td>";
                                    let btn = "<button class='odaberiTermin' id=" + termin.id + ">Odaberi termin</button>";
                                    row += "<td>" + btn + "</td>";

                                    row += "</tr>";

                                    $('#termini-List').append(row);
                                }
                    },
                error : function (response){
                    console.log("ERROR!");
                    console.log(response);
                }
            });
        }
  });

    $(document).on('click', '.odaberiTermin', function fun(event) {
        event.preventDefault();

        window.localStorage.setItem('termin', this.id);
        window.location.href = "userTerminiList.html";
    });
});     *///


$(document).ready(function () {
    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);
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
    let maxCena = document.forms['searchBox'].maksimalnaCena.value;
    if(maxCena == "" || isNaN(maxCena)){
        maxCena = 100000;
    }
    let maxTrajanje = document.forms['searchBox'].maksimalnoTrajanje.value;
    if(maxTrajanje == "" || isNaN(maxTrajanje)){
        maxTrajanje = 100000;
    }
    let tipTreninga  = document.forms['searchBox'].tipTreninga.value;

    let naziv  = document.forms['searchBox'].nazivTreninga.value;

    let opis  = document.forms['searchBox'].opisTreninga.value;


    let doDatuma = document.forms['searchBox'].datum.value;
    if(doDatuma == ""){
        doDatuma = "2025-12-31";
    }



    let searchInfo = {
        sve,
        maxCena,
        maxTrajanje,
        tipTreninga,
        naziv,
        opis,
        doDatuma,
    }
    console.log(searchInfo);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/termin/criteria",
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


                let row = "<tr>";
                row += "<td class = \"celijaTabele\">" + res[i].id + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].naziv + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].opis + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].tipTreninga + "</td>";
                row += "<td class = \"celijaTabele\">" + pocetak + "</td>";
                row += "<td class = \"celijaTabele\">" + kraj + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].trajanjeTermina + "min" + "</td>";
                row += "<td class = \"celijaTabele\">" + res[i].cena + "din" + "</td>";

                row += "</tr>";
                $('#sadrzajTabele').append(row);


            }
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

function sortiraj(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("tabelaTermina");
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
    table = document.getElementById("tabelaTermina");
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
                if (Number(prvi) > Number(drugi)/* x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase() */) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (Number(prvi) < Number(drugi)/* x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() */) {
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
    table = document.getElementById("tabelaTermina");
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
                if (Number(prvi) > Number(drugi)/* x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase() */) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (Number(prvi) < Number(drugi)/* x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() */) {
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


