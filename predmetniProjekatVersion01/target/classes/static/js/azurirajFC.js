$(document).on("submit", "#fc-azurirajForm", function (event){
    event.preventDefault();

    let id = $("#id").val();
    let naziv = $("#naziv").val();
    let adresa = $("#adresa").val();
    let brTelCentrale = $("#brTelCentrale").val();
    let email = $("#email").val();

    let noviFC = {
        id,
        naziv,
        adresa,
        brTelCentrale,
        email
    }

    console.log(noviFC);

        $.ajax({
            type : "PUT",
            dataType : "json",
            contentType : "application/json",
            data : JSON.stringify(noviFC),
            url : "http://localhost:8080/fcentar/azurirajFC/" + id,

            success : function (response){
                console.log(response);

                    alert("Fitness centar " + response.id + "je izmenjen!");
                    window.location.href = "azurirajFC.html";
            },

            error : function (){
                    alert("Error!");
            }
        });
});