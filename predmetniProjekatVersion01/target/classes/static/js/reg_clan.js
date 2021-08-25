$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let korisnickoIme = document.forms['formBox'].KorIme.value;
    let ime = document.forms['formBox'].Ime.value;
    let prezime = document.forms['formBox'].Prezime.value;
    let lozinka = document.forms['formBox'].Loz.value;
    let lozinkaProvera = document.forms['formBox'].LozProvera.value;
    let email = document.forms['formBox'].Email.value;
    let datumRodjenja = document.forms['formBox'].DatumRodjenja.value;
    let kontaktTelefon = document.forms['formBox'].BrojTelefona.value;
    let aktivan = true;
    if(lozinka !== lozinkaProvera) {
        alert("Lozinke se ne poklapaju!");
        return false;
    } else {

        var noviClan = {
            korisnickoIme,
            lozinka,
            ime,
            prezime,
            email,
            datumRodjenja,
            kontaktTelefon,
            aktivan

        }
        console.log(noviClan);


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/clan/dodajClana",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(noviClan),
            success: function (res) {
                console.log(res);

                if(res.retVal == 0){
                    alert("Clan je uspesno kreiran!");
                    window.location.href = "login_page.html";
                }
                if(res.retVal == 1){
                    alert("Korisnicko ime vec postoji!");
                }
                if(res.retVal == 2){
                    alert("Email vec postoji!");
                }
                if(res.retVal == 3){
                    alert("Telefon vec postoji!");
                }
            },
            error: function (res) {
                console.log(res);
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
    if(rola == 3){
        window.location.href = "user_page.html";
        alert("Vec ste prijavljeni!");
    }

});

