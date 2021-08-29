$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let korisnickoIme = document.forms['formBox'].KoriIme.value;
    let ime = document.forms['formBox'].Ime.value;
    let prezime = document.forms['formBox'].prez.value;
    let lozinka = document.forms['formBox'].Lozinka.value;
    let lozinkaProvera = document.forms['formBox'].LozProvera.value;
    let email = document.forms['formBox'].Email.value;
    let datumRodjenja = document.forms['formBox'].DatumRodjenja.value;
    let kontaktTelefon = document.forms['formBox'].BrojTel.value;
    let aktivan = false;
    let idFC = document.forms['formBox'].fitnesCentri.value;
    if(lozinka !== lozinkaProvera) {
        alert("Lozinke se ne poklapaju!");
        return false;
    } else {

        var noviTrener = {
            korisnickoIme,
            ime,
            prezime,
            lozinka,
            email,
            datumRodjenja,
            kontaktTelefon,
            aktivan,
            idFC

        }
        console.log(noviTrener);


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/trener/dodajTrenera",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(noviTrener),
            success: function (res) {
                console.log(res);
                if(res.retVal == 0){
                    alert("Zahtev za registraciju je poslat!");
                    window.location.href = "login_page.html";
                }
                if(res.retVal == 1){
                    alert("Korisnicko ime zauzeto!");
                }
                if(res.retVal == 2){
                    alert("Email zauzet!");
                }
                if(res.retVal == 3){
                    alert("Telefon zauzet!");
                }

            },
            error: function () {
                alert("Greška!");
            }
        });
    }
});

$(document).ready(function () {
    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);
    }
    if(rola == 1){
        window.location.href = "admin_page.html";
        alert("Vec ste prijavljeni!");
    }
    if(rola == 2){
        window.location.href = "trener_page.html";
        alert("Vec ste prijavljeni!");
    }
    if(role == 3){
        window.location.href = "user_page.html";
        alert("Vec ste prijavljeni!");
    }

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/fcentar/centri/regTrenera",
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<option value='" + res[i].id + "'>" + res[i].naziv + "</option>";


                $('#fitnesCentri').append(row);
            }


        },
        error: function () {
            alert("Greška!");
        }
    });


});