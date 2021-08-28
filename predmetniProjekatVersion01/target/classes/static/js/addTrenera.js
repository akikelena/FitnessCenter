/*$(document).on("submit", "#trener-addForm", function (event){
    event.preventDefault();

    let idFC = $("#idFC").val();
    let korisnickoIme = $("#korisnickoIme").val();
    let lozinka = $("#lozinka").val();
    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let datumRodjenja = $("#datumRodjenja").val();
    let kontaktTelefon = $("#kontaktTelefon").val();
    let email = $("#email").val();
    let uloga = "TRENER";
    let aktivan = true;

    let noviTrener = {
        idFC,
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        datumRodjenja,
        kontaktTelefon,
        email,
        uloga,
        aktivan: "true"
    }

        $.ajax({
            type : "POST",
            dataType : "json",
            contentType : "application/json",
            data : JSON.stringify(noviTrener),
            url : "http://localhost:8080/korisnik/registracijaTrenera",

            success : function (response){
                console.log(response);

                    alert("Trener " + response.id + " je kreiran!");
                    window.location.href = "admin_page.html";
            },

            error : function (){
                    alert("Error!");
            }
        });
});*///

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

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/fcentar/centri/regTrenera" ,
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

$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let korisnickoIme = document.forms['formBox'].korime.value;
    let ime = document.forms['formBox'].imekor.value;
    let prezime = document.forms['formBox'].prez.value;
    let lozinka = document.forms['formBox'].loz.value;
    let lozinkaProvera = document.forms['formBox'].lozprov.value;
    let email = document.forms['formBox'].emailkor.value;
    let datumRodjenja = document.forms['formBox'].datumr.value;
    let kontaktTelefon = document.forms['formBox'].brtel.value;
    let aktivan = true;
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
                    alert("Trener uspesno registrovan!");
                    window.location.href = "admin_page.html";
                }
                if(res.retVal == 1){
                    alert("Username zauzet!");
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

function odjaviSe(){
    localStorage.setItem("rola", 0);
    localStorage.setItem("id", 0);
    window.location.href = "index.html";
}