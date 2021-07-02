$(document).on("submit", "#fc-delete", function (event){
    event.preventDefault();

    let ID = $("#id").val();

        $.ajax({
            type: "DELETE",
            url : "http://localhost:8080/fcentar/obrisi" + ID,

            success: function (response){
                console.log(response);

                alert("Fitness centar" + response.ID + "je obrisan!");
                window.location.href = "admin_page.html";
            },

            error : function (){
                console.log("Error!");
            }
        });
});