$(document).ready(function () {
    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);
        window.location.href = "index.html";
    }
    if(rola == 0){
        window.location.href = "index.html";

    }
    if(rola == 1){
        window.location.href = "admin_page.html";

    }
    if(rola == 3){
        window.location.href = "user_page.html";

    }


});


$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let korisnickoIme = document.forms['fc-azurirajForm'].korime.value;
    let lozinka = document.forms['fc-azurirajForm'].Lozinka.value;
    let email = document.forms['fc-azurirajForm'].Email.value;
    let kontaktTelefon = document.forms['fc-azurirajForm'].broj.value;
    let rola = localStorage.getItem("rola");
    let idFC = localStorage.getItem("TrenerZaPromenu");

    var promeniFC = {
        korisnickoIme,
        lozinka,
        kontaktTelefon,
        email,
        rola

    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/trener/azurirajProfil/" + idFC,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(promeniFC),
        success: function (res) {
            console.log(res);
            if(res.rola == 0){
                alert("Podaci su uspesno azurirani!");
                window.location.href = "trener_page.html";
            }
            if(res.rola == 1){
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