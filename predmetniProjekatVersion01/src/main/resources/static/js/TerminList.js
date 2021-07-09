$(document).ready(function () {
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/termin/TerminList",

        success : function (response) {
            console.log("SUCCESS: \n");
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
            console.log("ERROR: \n");
            console.log( response);
        }
});
});


  $("#submit").on("click", function (event){
        event.preventDefault();

        let naziv = $('#naziv').val();
        let opis = $('#opis').val();
        let tipTreninga = $('#tipTreninga').val();
        let pocetakTerminaMax = $('#pocetakTermina').val();
        let cenaMax = $('#cena').val();

        let sortCena = $('#sortCena').val();
        let sortVreme = $('#sortVreme').val();

        if($('#naziv').val() != "") {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/naziv?naziv="+ $('#naziv').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

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
                error: function (response){
                    console.log("ERROR: \n");
                    console.log(response);
                }
            });
        }

        if($('#tipTreninga').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/tipTreninga?tipTreninga="+ $('#tipTreninga').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

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
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log( response);
                }
            });
        }


        if($('#opis').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/opis?opis="+ $('#opis').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

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
                error: function (response) {
                    console.log("ERROR: \n");
                    console.log( response);
                }
            });
        }


        if($('#pocetakTermina').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/pocetakTermina?pocetakTermina="+ $('#pocetakTermina').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

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
                error: function (response) {
                    console.log("ERROR: \n");
                    console(response);
                }
            });
        }

        if($('#cena').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/cena?cena="+ $('#cena').val(),

                success : function (response){
                    console.log("SUCCESS: \n");
                    console.log(response);

                    $('#termini-List').html("");

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
            $('#naziv').val() == "" && $('#pocetakTermina').val() == "" && $('#opis').val() == "" &&
            $('#tipTreninga').val() == "" && $('#cena').val() == ""){
            $.ajax({
                type : "GET",
                dataType : "json",
                url : "http://localhost:8080/termin/TerminList",

                    success: function (response){
                        console.log(response);
                            $('#termini-List').html("");

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
                    console.log("ERROR!");
                    console.log(response);
                }
            });
        }
    });
