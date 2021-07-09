$(document).ready(function () {
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

        let naziv = $('#naziv').val();
        let opis = $('#opis').val();
        let tipTreninga = $('#tipTreninga').val();
        let pocetakTermina = $('#pocetakTermina').val();
        let cena = $('#cena').val();

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

        if($('#tipTreninga').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/tipTreninga?tipTreninga="+ $('#tipTreninga').val(),

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


        if($('#opis').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/opis?opis="+ $('#opis').val(),

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


        if($('#pocetakTermina').val() != ""){
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/termin/TerminList/pocetakTermina?pocetakTermina="+ $('#pocetakTermina').val(),

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
            $('#naziv').val() == "" && $('#pocetakTermina').val() == "" && $('#opis').val() == "" &&
            $('#tipTreninga').val() == "" && $('#cena').val() == ""){
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
});


