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


    let naziv = document.forms['formBox'].nazivCentra.value;
    let adresa = document.forms['formBox'].adresaCentra.value;
    let brTelCentrale = document.forms['formBox'].brTelefona.value;
    let email = document.forms['formBox'].emailCentra.value;
    let rola = localStorage.getItem("rola");

    var noviFC = {
        naziv,
        adresa,
        brTelCentrale,
        email,
        rola

    }
    console.log(noviFC);


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/fcentar/dodajFC",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviFC),
        success: function (res) {
            console.log(res);
            if(res.rola == 0){
                alert("Fitnes centar je uspesno kreiran!");
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

/*
$(document).on("submit", "#fc-addForm", function (event){

    event.preventDefault();

        let naziv = $("#naziv").val();
        let adresa = $("#adresa").val();
        let brTelCentrale = $("#brTelCentrale").val();
        let email = $("#email").val();

    let newFitnessCentar = {
        naziv,
        adresa,
        brTelCentrale,
        email
    }
    console.log(newFitnessCentar);

    $.ajax ({
        type: "POST",
        url : "http://localhost:8080/fcentar/dodajFC",
        dataType : "json",
        contentType : "application/json",
        data: JSON.stringify(newFitnessCentar),

        success : function (response) {
            console.log(response);

            alert("Uspešno ste kreirali fitness centar " + response.id + "!");
            window.location.href = "admin_page.html";
        },
        error : function (){
            alert("Greška prilikom pokušaja kreiranja novog fitness centra!");
        }
    });
});

 */