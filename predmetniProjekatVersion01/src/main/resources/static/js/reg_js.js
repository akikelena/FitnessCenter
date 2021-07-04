// dodavanje novog korisnika
$(document).on("submit", "#reg-Form", function (event){
    event.preventDefault();

    let korisnickoIme = $("#korisnickoIme").val();
    let lozinka = $("#lozinka").val();
    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let kontaktTelefon = $("#kontaktTelefon").val();
    let email = $("#email").val();
    let datumRodjenja = $("#datumRodjenja").val();
    let uloga = $("#uloga").is(":checked")?"TRENER":"CLAN";

    let noviKorisnik = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        kontaktTelefon,
        email,
        datumRodjenja,
        uloga
    }
    $.ajax({
        type: "POST",
        url : "http://localhost:8080/korisnik/register_page",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviKorisnik),
        success: function (response){

            console.log(response);
            alert("Korisnik" + response.id + "je kreiran!");
            window.location.href = "login_page.html";
        },
        error: function (){
            alert("Greška prilikom kreiranja novog korisnika!");
        }
    });
});

$("#btn-login").on("click", function (event) {
    console.log("test");
    window.location.href = "login_page.html";
});
