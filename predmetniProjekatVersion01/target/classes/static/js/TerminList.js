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
});


