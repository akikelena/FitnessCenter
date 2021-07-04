$(document).ready(function () {
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/termin/TerminList",

        success : function (response) {
            console.log("SUCCESS: \n", response);
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

                row += "</tr>";

                $('#termini-List').append(row);
            }
        },

        error : function (response){
            console.log("ERROR: \n", response);
        }
});

    $("#trazi-submit").on("click", function (event){
        event.preventDefault();

        let naziv = $('#naziv-polje').val();
        let tipTreninga = $('#tip-polje').val();
        let opis = $('#opis-polje').val();
        let pocetak = $('#pocetakTermina-polje').val();
        let cena = $('#cena-polje').val();

        let sortCena = $('#sortCena').val();
        let sortVreme = $('#sortVreme').val();

        if($('#naziv-polje').val() != "") {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/naziv?naziv="+ $('#naziv-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n", response);
                    console.log(response);

                    $('#sviKorisnici tbody').html("");

                    for(let termini of response){
                        let row = "<tr>";

                        row += "<td>" + termini.id + "</td>";
                        row += "<td>" + termini.naziv + "</td>";
                        row += "<td>" + termini.tipTreninga + "</td>";
                        row += "<td>" + termini.oznakaSale + "</td>";
                        row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termini.cena + "</td>";
                        row += "</tr>";

                        $('#sviKorisnici tbody').append(row);
                    }
                },
                error: function (response){
                    console.log("ERROR: \n", response);
                }
            });
        }

        if($('#tip-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/tip?tip="+ $('#tip-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n", response);
                    console.log(response);

                    $('#sviKorisnici tbody').html("");

                    for(let termini of response){
                        let row = "<tr>";

                        row += "<td>" + termini.id + "</td>";
                        row += "<td>" + termini.naziv + "</td>";
                        row += "<td>" + termini.tipTreninga + "</td>";
                        row += "<td>" + termini.oznakaSale + "</td>";
                        row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termini.cena + "</td>";
                        row += "</tr>";

                        $('#sviKorisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n", response);
                }
            });
        }


        if($('#opis-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/opis?opis="+ $('#opis-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n", response);
                    console.log(response);

                    $('#sviKorisnici tbody').html("");

                    for(let termini of response){
                        let row = "<tr>";

                        row += "<td>" + termini.id + "</td>";
                        row += "<td>" + termini.naziv + "</td>";
                        row += "<td>" + termini.tipTreninga + "</td>";
                        row += "<td>" + termini.oznakaSale + "</td>";
                        row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termini.cena + "</td>";
                        row += "</tr>";

                        $('#sviKorisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n", response);
                }
            });
        }


        if($('#pocetakTermina-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/pocetakTermina/pocetakTermina?pocetakTermina="+ $('#pocetakTermina-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n", response);
                    console.log(response);

                    $('#sviKorisnici tbody').html("");

                    for(let termini of response){
                        let row = "<tr>";

                        row += "<td>" + termini.id + "</td>";
                        row += "<td>" + termini.naziv + "</td>";
                        row += "<td>" + termini.tipTreninga + "</td>";
                        row += "<td>" + termini.oznakaSale + "</td>";
                        row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termini.cena + "</td>";
                        row += "</tr>";

                        $('#sviKorisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n", response);
                }
            });
        }

        if($('#cena-polje').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/cena?cena="+ $('#cena-polje').val(),

                success : function (response){
                    console.log("SUCCESS: \n", response);
                    console.log(response);

                    $('#sviKorisnici tbody').html("");

                    for(let termini of response){
                        let row = "<tr>";

                        row += "<td>" + termini.id + "</td>";
                        row += "<td>" + termini.naziv + "</td>";
                        row += "<td>" + termini.tipTreninga + "</td>";
                        row += "<td>" + termini.oznakaSale + "</td>";
                        row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termini.cena + "</td>";
                        row += "</tr>";

                        $('#sviKorisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n", response);
                }
            });
        }

        if($('#sortVreme').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/sort?vreme="+ $('#sortVreme').val(),

                success : function (response){
                    console.log("SUCCESS: \n", response);
                    console.log(response);

                    $('#sviKorisnici tbody').html("");

                    for(let termini of response){
                        let row = "<tr>";

                        row += "<td>" + termini.id + "</td>";
                        row += "<td>" + termini.naziv + "</td>";
                        row += "<td>" + termini.tipTreninga + "</td>";
                        row += "<td>" + termini.oznakaSale + "</td>";
                        row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termini.cena + "</td>";
                        row += "</tr>";

                        $('#sviKorisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n", response);
                }
            });
        }


        if($('#sortCena').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/sort?cena="+ $('#sortCena').val(),

                success : function (response){
                    console.log("SUCCESS: \n", response);
                    console.log(response);

                    $('#sviKorisnici tbody').html("");

                    for(let termini of response){
                        let row = "<tr>";

                        row += "<td>" + termini.id + "</td>";
                        row += "<td>" + termini.naziv + "</td>";
                        row += "<td>" + termini.tipTreninga + "</td>";
                        row += "<td>" + termini.oznakaSale + "</td>";
                        row += "<td>" + new Date(termini.pocetakTermina).toLocaleString() + "</td>";
                        row += "<td>" + termini.cena + "</td>";
                        row += "</tr>";

                        $('#sviKorisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR: \n", response);
                }
            });
        }
    });
});