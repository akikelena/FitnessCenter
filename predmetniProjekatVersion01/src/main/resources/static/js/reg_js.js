$(function () {
    $('input, select').on('focus', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#80bdff');
    });
    $('input, select').on('blur', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#ced4da');
    });
});

// dodavanje novog korisnika
$(document).on("submit", "#regForm", function (event){
    event.preventDefault();

    let korisnickoIme = $("#korisnickoime").val();
    let password = $("#password").val();
    let ime = $("ime").val();
    let prezime = $("prezime").val();
    let brtel = $("brtel").val();
    let email = $("email").val();
    let datum_rodjenja = $("datum_rodjenja").val();
    let uloga = $("uloga").val();

    let noviKorisnik = {
        korisnickoIme,
        password,
        ime,
        prezime,
        brtel,
        email,
        datum_rodjenja,
        ulogaKorsnika: uloga
    }
    $.ajax({
        type: "POST",
        url : "http://localhost:8080/api/register_page",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviKorisnik),
        success: function (response){
            console.log(response);

            alert("Korisnik" + response.id + "je uspešno kreiran!");
            window.location.href = "register_page.html";
        },
        error: function (){
            alert("Greška prilikom kreiranja novog korisnika!");
        }
    });
});
