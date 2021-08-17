$(document).on("submit", "#fc-azurirajForm", function (event){
    event.preventDefault();

    let id = $("#id").val();
    let korisnickoIme = $("#korisnickoIme").val();
    let lozinka = $("#lozinka").val();
    let kontaktTelefon = $("#kontaktTelefon").val();
    let email = $("#email").val();

    let noviFC = {
        id,
        korisnickoIme,
        lozinka,
        kontaktTelefon,
        email
    }

    console.log(noviFC);

    $.ajax({
        type : "PUT",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(noviFC),
        url : "http://localhost:8080/korisnik/azurirajKorisnika/" + id,

        success : function (response){
            console.log(response);

            alert("Podaci korisnika  " + response.id + " je izmenjen!");
            window.location.href = "azurirajKorisnika.html";
        },

        error : function (){
            alert("Error!");
        }
    });
});