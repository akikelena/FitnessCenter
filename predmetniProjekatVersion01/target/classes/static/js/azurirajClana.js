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

function odjaviSe(){
    localStorage.setItem("rola", 0);
    localStorage.setItem("id", 0);
    window.location.href = "index.html";
}

$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let korisnickoIme = document.forms['fc-azurirajForm'].korisnickoIme.value;
    let lozinka = document.forms['fc-azurirajForm'].lozinka.value;
    let ime = document.forms['fc-azurirajForm'].ime.value;
    let prezime = document.forms['fc-azurirajForm'].prezime.value;
    let email = document.forms['fc-azurirajForm'].email.value;
    let kontaktTelefon = document.forms['fc-azurirajForm'].kontaktTelefon.value;
    let rola = localStorage.getItem("rola");

    var promeniFC = {
        korisnickoIme,
        ime,
        prezime,
        lozinka,
        kontaktTelefon,
        email,
        rola

    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/clan/azurirajProfil/" + idFC,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(promeniFC),
        success: function (res) {
            console.log(res);
            if(res.rola == 0){
                alert("Podaci su uspesno azurirani!");
                window.location.href = "user_page.html";
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