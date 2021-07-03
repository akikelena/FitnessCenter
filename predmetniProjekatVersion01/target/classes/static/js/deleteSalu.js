$(document).on("submit", "#sala-delete", function (event){
    event.preventDefault();

    let id = $("#id").val();

    let novaSala = {
        id
    }

    console.log(novaSala);

    $.ajax({
        type: "DELETE",
        dataType : "json",
        url : "http://localhost:8080/sala/obrisiSalu"+id,

        success: function (response){
            console.log(response);
                alert("Sala" + response.id + "je obrisana!");
                window.location.href = "admin_page.html";
        },

        error : function (){
            console.log("Error!");
        }
    });
});