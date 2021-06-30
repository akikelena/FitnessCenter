$(document).on("submit", "#sala-addForm", function (event){
    event.preventDefault();

    let oznakaSale = $("#oznakaSale").val();
    let kapacitet = $("#kapacitet").val();


    let novaSala = {
        oznakaSale,
        kapacitet,

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
});