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


    let naziv = document.forms['fc-azurirajForm'].naziv.value;
    let adresa = document.forms['fc-azurirajForm'].adresa.value;
    let brTelCentrale = document.forms['fc-azurirajForm'].brTelefonaCentrale.value;
    let email = document.forms['fc-azurirajForm'].Email.value;
    let rola = localStorage.getItem("rola");
    let idFC = localStorage.getItem("CentarZaPromenu");



    var promeniFC = {
        naziv,
        adresa,
        brTelCentrale,
        email,
        rola

    }



    $.ajax({
        type: "POST",
        url: "http://localhost:8080/fcentar/azurirajFC/" + idFC,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(promeniFC),
        success: function (res) {
            console.log(res);
            if(res.rola == 0){
                alert("Fitnes centar je uspesno azuriran!");
                window.location.href = "admin_page.html";
            }
            if(res.rola == 1){
                alert("Nemate autoriteta za ovu komandu!");
                window.location.href = "index.html";
            }
            if(res.rola == 2){
                alert("Postoji vec fitnes centar sa ovim brojem telefona!");
            }
            if(res.rola == 3){
                alert("Postoji vec fitnes centar sa ovom email adresom!");
            }

        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});