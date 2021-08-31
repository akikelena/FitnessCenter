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


});

$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let naziv = document.forms['fc-azurirajForm'].Naziv.value;
    let adresa = document.forms['fc-azurirajForm'].Adresa.value;
    let brTelCentrale = document.forms['fc-azurirajForm'].brTelefona.value;
    let email = document.forms['fc-azurirajForm'].Email.value;
    let rola = localStorage.getItem("rola");
    let idFC = localStorage.getItem("TrenerZaPromenu");

    var promeniFC = {
        naziv,
        adresa,
        brTelCentrale,
        email,
        rola

    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/trener/azuriraj/" + idFC,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(promeniFC),
        success: function (res) {
            console.log(res);
            if(res.rola == 2){
                alert("Podaci su uspesno izmenjeni!");
                window.location.href = "trener_page.html";
            }
            if(res.rola == 0){
                alert("Nemate autoriteta za ovu komandu!");
                window.location.href = "index.html";
            }
            if(res.rola == 2){
                alert("Vec postoji korisnik sa ovim korisnickim imenom!");
            }
            if(res.rola == 3){
                alert("Vec postoji korisnik sa ovom email adresom!");
            }

        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});