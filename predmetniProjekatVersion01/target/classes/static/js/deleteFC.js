/* $(document).ready(function () {

    $.ajax({
        type: "GET",
        dataType : "json",
        url : "http://localhost:8080/fcentar/FCList",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for(let fitnessCentar of response){

                    let row = "<tr>";

                row += "<td>" + fitnessCentar.id + "</td>";
                row += "<td>" + fitnessCentar.naziv + "</td>";
                row += "<td>" + fitnessCentar.adresa + "</td>";
                row += "<td>" + fitnessCentar.brTelCentrale + "</td>";
                row += "<td>" + fitnessCentar.email + "</td>";
                let btn = "<button class='btnDelete' data-id=" + fitnessCentar.id + ">OBRIŠI FC</button>";
                row += "<td>" + btn + "</td>";

                    row += "</tr>";

                $('#fc-List').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});

$(document).on('click','.btnDelete', function (){

    let fitnessCentarId = this.dataset.id;

        $.ajax({
            type: "DELETE",
            dataType : "json",
            url : "http://localhost:8080/fcentar/FCList/" + fitnessCentarId,

            success: function (){
                console.log("SUCCESS");
                //console.log(response);

                $('[data-id="' + fitnessCentarId + '"]').parent().parent().remove();

                //alert("Fitness centar" + response.id + "je obrisan!");
                //window.location.href = "admin_page.html";
            },

            error : function (){
                alert("Error!");
                //console.log(response);
            }
        });
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
    if(rola == 3){
        window.location.href = "user_page.html";
    }


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/fcentar/FCList/" + rola,
        dataType: "json",
        success: function (res) {
            console.log("SUCCESS:\n", res);
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td class='celijaTabele'>" + res[i].id + "</td>";
                row += "<td class='celijaTabele'>" + res[i].naziv + "</td>";
                row += "<td class='celijaTabele'>" + res[i].adresa + "</td>";
                row += "<td class='celijaTabele'>" + res[i].brTelCentrale + "</td>";
                row += "<td class='celijaTabele'>" + res[i].email + "</td>";
                let btnChange = "<button id = 'dugmeIzmeni' data-id=" + res[i].id + ">IZMENI</button>";
                let btnDelete = "<button id = 'dugmeObrisi' data-id=" + res[i].id + ">OBRISI</button>";
                row += "<td class='celijaTabele'>" + btnChange + "</td>";
                row += "<td class='celijaTabele'>" + btnDelete + "</td>";
                row += "</tr>";


                $('#tabelaCentara').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '#dugmeIzmeni', function () {

    let fitID = this.dataset.id;
    localStorage.setItem("CentarZaPromenu", fitID);
    window.location.href = "azurirajFC.html";

});


$(document).on('click', '#dugmeObrisi', function () {

    let fitID = this.dataset.id;

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/fcentar/FCList/obrisi/" + fitID,
        dataType: "json",
        contentType: "application/json",
        success: function () {
            alert("Fitness centar je obrisan!");
            window.location.href = "admin_page.html";
        },
        error: function () {
            console.log("ERROR:\n");
        }
    });

});

