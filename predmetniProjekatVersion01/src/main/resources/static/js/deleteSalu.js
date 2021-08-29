/* $(document).ready(function () {

    $.ajax({
        type: "GET",
        dataType : "json",
        url : "http://localhost:8080/sala/SalaList",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for(let sala of response){

                let row = "<tr>";

                row += "<td>" + sala.id + "</td>";
                row += "<td>" + sala.oznakaSale + "</td>";
                row += "<td>" + sala.kapacitet + "</td>";
                row += "<td>" + sala.idFC + "</td>";
                let btn = "<button class='btnDelete' data-id=" + sala.id + ">OBRIŠI SALU</button>";
                row += "<td>" + btn + "</td>";

                row += "</tr>";

                $('#sala-List').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});

$(document).on('click','.btnDelete', function (){

    let salaId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        dataType : "json",
        url : "http://localhost:8080/sala/SalaList/" + salaId,

        success: function (){
            console.log("SUCCESS");

            $('[data-id="' + salaId + '"]').parent().parent().remove();
        },

        error : function (){
            alert("Error!");
        }
    });
}) *///

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
        url: "http://localhost:8080/sala/SalaList",
        dataType: "json",
        success: function (res) {
            console.log("SUCCESS:\n", res);
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td class='celijaTabele'>" + res[i].id + "</td>";
                row += "<td class='celijaTabele'>" + res[i].kapacitet + "</td>";
                row += "<td class='celijaTabele'>" + res[i].oznakaSale + "</td>";
                row += "<td class='celijaTabele'>" + res[i].idFC + "</td>";

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

    let salaID = this.dataset.id;
    localStorage.setItem("SalaZaPromenu", salaID);
    window.location.href = "azurirajSalu.html";

});
$(document).on('click', '#dugmeObrisi', function () {

    let fitID = this.dataset.id;

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/sala/SalaList/obrisi/" + fitID,
        dataType: "json",
        contentType: "application/json",
        success: function () {
            alert("Sala je obrisana!");
            window.location.href = "admin_page.html";
        },
        error: function () {
            console.log("ERROR:\n");
        }
    });

});
function odjaviSe(){
    localStorage.setItem("rola", 0);
    localStorage.setItem("id", 0);
    window.location.href = "index.html";
}