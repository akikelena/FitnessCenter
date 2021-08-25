$(document).ready(function () {

    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);

    }
    if(rola == 3){
        window.location.href = "user_page.html";
        alert("Vec ste prijavljeni!");
    }
    if(rola== 1){
        window.location.href = "admin_page.html";
        alert("Vec ste prijavljeni!");
    }
    if(rola == 2){
        window.location.href = "trener_page.html";
        alert("Vec ste prijavljeni!");
    }

});

$(document).on("submit", "form", function (event) {
    event.preventDefault();

    let korisnickoIme = document.forms['loginBox'].usname.value;
    let lozinka = document.forms['loginBox'].passwd.value;
    let uloga = document.forms['loginBox'].class.value;
    if(uloga === "admin") {
        var rola = 1;
    }
    if(uloga === "trener") {
        var rola = 2;
    }
    if(uloga === "clan") {
        var rola = 3;
    }
    console.log(korisnickoIme);
    console.log(lozinka);
    console.log(rola);


    let prijava = {
        korisnickoIme,
        lozinka,
        rola
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/prijava/" + uloga,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(prijava),
        success: function (res) {
            console.log(res);
            if(res.korimeprovera == false){
                alert("Korisnicko ime nije pronandjeno u bazi!");
            } else {
                if(res.lozinkaprovera == false){
                    alert("Korisnicko ime i lozinka se ne poklapaju");
                } else {
                    if(res.rola == 1){
                        localStorage.setItem("rola", 1);
                        localStorage.setItem("id", res.id);
                        window.location.href = "admin_page.html";
                    } else if(res.rola == 2){
                        localStorage.setItem("rola", 2);
                        localStorage.setItem("id", res.id);
                        window.location.href = "trener_page.html";
                    } else if(res.rola == 3){
                        localStorage.setItem("rola", 3);
                        localStorage.setItem("id", res.id);
                        window.location.href = "user_page.html";
                    }
                }
            }


        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});