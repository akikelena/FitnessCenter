$(document).on("submit", "#reg-Form", function (event){
    event.preventDefault();

    let korisnickoIme = $("#korisnickoIme").val();
    let lozinka = $("#loznika").val();
    let ime = $("ime").val();
    let prezime = $("prezime").val();
    let kontaktTelefon = $("kontaktTelefon").val();
    let email = $("email").val();
    let datumRodjenja = $("datumRodjenja").val();
    let uloga = "TRENER";
    let idFC = $("#idFC").val();
    let aktivan = true;

    let noviKorisnik = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        kontaktTelefon,
        email,
        datumRodjenja,
        uloga,
        aktivan: "true",
        idFC
    }

    $.ajax({
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(noviKorisnik),
        url : "http://localhost:8080/korisnik/registracija_trenera",

        success : function (response) {
            console.log(response);
            alert("Korisnik(TRENER) " + response.id + "je kreiran!");
            window.location.href = "login_page.html";
        },
        error: function (){
            alert("Greska pri registraciji!");
        }

    });
});