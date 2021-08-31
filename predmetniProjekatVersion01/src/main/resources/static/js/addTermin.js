/*$(document).on("submit", "#termin-addForm", function (event){
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
}); *///


$(document).ready(function () {
    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);
        window.location.href = "index.html";
    }
    if(rola == 0){
        window.location.href = "index.html";
    }
    if(rola == 1){
        window.location.href = "admin_page.html";
    }
    if(rola == 3){
        window.location.href = "user_page.html";
    }

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/trening/TreningList" ,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<option value='" + res[i].id + "'>" + res[i].naziv + "|" + res[i].opis + "|" + res[i].tipTreninga + "</option>";


                $('#treninzi').append(row);
            }


        },
        error: function () {
            alert("Greška!");
        }
    });
    let idTrenera = localStorage.getItem("id");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sala/SalaList/aktivneSale/"+idTrenera ,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<option value='" + res[i].id + "'>" + res[i].oznakaSale + "</option>";

                $('#sale').append(row);
            }


        },
        error: function () {
            alert("Greška!");
        }
    });


});

$(document).on("submit", "form", function (event) {
    event.preventDefault();


    let pocetakDatum = document.forms['formBox'].pocetakDatum.value;
    let pocetakVreme = document.forms['formBox'].pocetakVreme.value;
    let krajVreme = document.forms['formBox'].krajVreme.value;
    let cena = document.forms['formBox'].cena.value;
    let idTreninga = document.forms['formBox'].treninzi.value;
    let idSale = document.forms['formBox'].sale.value;
    let idTrenera = localStorage.getItem("id");

    let pocetakTermina = pocetakDatum;
    pocetakTermina += "T";
    pocetakTermina += pocetakVreme;
    pocetakTermina += ":00"

    let krajTermina = pocetakDatum;
    krajTermina += "T";
    krajTermina += krajVreme;
    krajTermina += ":00"

    let sati1 = pocetakVreme.substring(0,2);
    let sati2 = krajVreme.substring(0,2);
    let minuti1 = pocetakVreme.substring(3,5);
    let minuti2 = krajVreme.substring(3,5);
    let trajanjeTermina = (Number(sati2)-Number(sati1)) * 60;
    trajanjeTermina += (Number(minuti2)-Number(minuti1));
    console.log(trajanjeTermina);


    var noviTermin = {
        pocetakTermina,
        krajTermina,
        trajanjeTermina,
        cena,
        idTreninga,
        idSale,
        idTrenera

    }
    console.log(noviTermin);


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/termin/dodaj",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviTermin),
        success: function (res) {
            console.log(res);
            if(res.trajanjeTermina == -1){
                alert("Termin nije kreiran jer se poklapa sa vec postojecim terminom u datoj sali!");
            } else {
                alert("Termin je uspesno kreiran!");
                window.location.href = "trener_page.html";
            }
        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});
