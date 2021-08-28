/*$(document).on("submit", "#sala-addForm", function (event){
    event.preventDefault();

    let oznakaSale = $("#oznakaSale").val();
    let kapacitet = $("#kapacitet").val();
    let idFC = $("#idFC").val();


    let novaSala = {
        oznakaSale,
        kapacitet,
        idFC

    }
    console.log(novaSala);

    $.ajax ({
        type: "POST",
        url : "http://localhost:8080/sala/dodajSalu",
        dataType : "json",
        contentType : "application/json",
        data: JSON.stringify(novaSala),

        success : function (response) {
            console.log(response);

            alert("Uspešno ste kreirali salu " + response.id + "!");
            window.location.href = "admin_page.html";
        },
        error : function (){
            alert("Greška prilikom pokušaja kreiranja nove sale!");
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

function odjaviSe(){
    localStorage.setItem("rola", 0);
    localStorage.setItem("id", 0);
    window.location.href = "index.html";
}

$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let oznakaSale = document.forms['formBox'].oznaka.value;
    let kapacitet = document.forms['formBox'].kapacitetSale.value;
    if(isNaN(kapacitet) || kapacitet == ""){
        kapacitet = 0;
    }
    let idFC= document.forms['formBox'].fitnesCentri.value;

    var novaSala = {
        oznakaSale,
        kapacitet,
        idFC
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/sala/dodajSalu",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novaSala),
        success: function (res) {
            console.log(res);
            if(res.idFitnesCentra == -1){
                alert("Oznaka za salu je vec u upotrebi!");
            } else {
                alert("Sala je uspesno dodata!");
                window.location.href = "admin_page.html";
            }
        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});