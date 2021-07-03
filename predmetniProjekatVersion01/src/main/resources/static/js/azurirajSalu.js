$(document).on("submit", "#sala-azurirajForm", function (event){
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
});