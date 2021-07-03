$(document).on("submit", "#trener-addForm", function (event){
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
        aktivan
    }

        $.ajax({
            type : "POST",
            dataType : "json",
            contentType : "application/json",
            data : JSON.stringify(noviTrener),
            url : "http://localhost:8080/korisnik/registracijaTrenera",

            success : function (response){
                console.log(response);

                    alert("Trener" + response.id + "je kreiran!");
                    window.location.href = "addTrenera.html";
            },

            error : function (){
                    alert("Error!");
            }
        });
});