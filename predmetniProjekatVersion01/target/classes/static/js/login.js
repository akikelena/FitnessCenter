$(document).on("submit", "#log-Form", function (event){
    event.preventDefault();

    let korisnickoIme = $("#korisnickoIme").val();
    let lozinka = $("#lozinka").val();

    let noviLogin = {
        korisnickoIme,
        lozinka
    }

    console.log(noviLogin);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/korisnik/login_page",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviLogin),

        success: function (response){
            window.localStorage.setItem("ID", response.id);
            window.localStorage.setItem("ULOGA", response.uloga);

                if(response.uloga == "ADMINISTRATOR"){
                    window.location.href = "admin_page.html";
                    return;
                }
                    if(response.uloga == "CLAN"){
                        window.location.href = "user_page.html";
                        return;
                    }
                        if(response.uloga == "TRENER"){
                            window.location.href = "trener_page.html";
                        }
            window.location.href = "index.html";
        },

        error: function (){
            alert("Greška prilikom prijave!");
        }
    });
});