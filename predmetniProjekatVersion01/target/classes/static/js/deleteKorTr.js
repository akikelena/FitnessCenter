$(document).on("submit", "#kortr-delete", function (event){
    event.preventDefault();

    let ID = $("#id").val();

    let noviKorTr = {
        ID
    }

    console.log(noviKorTr);

    $.ajax({
        type: "DELETE",
        dataType: "json",
        contentType: "application/json",
        data : JSON.stringify(noviKorTr),
        url : "http://localhost:8080/korisnik/obrisi" + ID,

        success: function (response){
            console.log(response);

            alert("Korisnik" + response.ID + "je obrisan!");
            window.location.href = "admin_page.html";
        },

        error : function (){
            console.log("Error!");
        }
    });
});