/*$(document).on("submit", "#sala-azurirajForm", function (event){
    event.preventDefault();

    let id = $("#id").val();
    let oznakaSale = $("#oznakaSale").val();
    let kapacitet = $("#kapacitet").val();
    let idFC = $("#idFC").val();


    let novaSala = {
        id,
        oznakaSale,
        kapacitet,
        idFC
    }

    console.log(novaSala);

    $.ajax({
        type : "PUT",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(novaSala),
        url : "http://localhost:8080/sala/azurirajSalu/" + id,

        success : function (response){
            console.log(response);

            alert("Sala " + response.id + " je izmenjena!");
            window.location.href = "azurirajSalu.html";
        },

        error : function (){
            alert("Error!");
        }
    });
}); *///

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
        url: "http://localhost:8080/fcentar/centri/regTrenera" ,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<option value='" + res[i].id + "'>" + res[i].naziv + "</option>";
                $('#fitnesCentri').append(row);
            }
        },
        error: function () {
            alert("Greška!");
        }
    });

});


$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let oznakaSale = document.forms['formBox'].oznaka.value;
    let kapacitet = document.forms['formBox'].kapacitetSale.value;
    if(isNaN(kapacitet) || kapacitet == ""){
        kapacitet = -1;
    }
    let idFC = document.forms['formBox'].fitnesCentri.value;
    let idSale = localStorage.getItem("SalaZaPromenu");

    var promeniSalu = {
        oznakaSale,
        kapacitet,
        idFC

    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/sala/azurirajSalu/" + idSale,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(promeniSalu),
        success: function (res) {
            console.log(res);
            if(res.idFC == -1){
                alert("Oznaka za salu je vec u upotrebi!");
            } else {
                alert("Sala je uspesno azurirana!");
                window.location.href = "admin_page.html";
            }
        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});