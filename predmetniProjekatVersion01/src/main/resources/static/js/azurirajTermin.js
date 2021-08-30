/*$(document).on("submit", "#termin-azurirajForm", function (event){
    event.preventDefault();

    let id = $("#id").val();
    let pocetakTermina = $("#pocetakTermina").val();
    let cena = $("#cena").val();
    let oznakaSale= $("#oznakaSale").val();
    let tipTreninga = $("#tipTreninga").val();

    let noviTermin = {
        id,
        pocetakTermina,
        cena,
        oznakaSale,
        tip
    }

    console.log(noviTermin);

    $.ajax({
        type : "PUT",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(noviTermin),
        url : "http://localhost:8080/termin/azurirajTermin/" + id,

        success : function (response){
            console.log(response);

            alert("Termin " + response.id + "je izmenjen!");
            window.location.href = "trener_page.html";
        },

        error : function (){
            alert("Error!");
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
        url: "http://localhost:8080/sala/SalaList/aktivneSale/" + idTrenera ,
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

    let cenaTermina = document.forms['formBox'].cena.value;
    if(cenaTermina == ""){
        cenaTermina = -1;
    }
    let idTreninga = document.forms['formBox'].treninzi.value;
    if(idTreninga == ""){
        idTreninga = -1;
    }
    let idSale = document.forms['formBox'].sale.value;
    if(idSale == ""){
        idSale = -1;
    }


    if((pocetakDatum != "" && (pocetakVreme == "" || krajVreme == "")) || (pocetakVreme != "" && (pocetakDatum== "" || krajVreme == "")) || (krajVreme != "" && (pocetakDatum== "" || pocetakVreme == ""))){
        alert("Morate popuniti sva vremenska polja!")
        return false;
    } else {
        if(pocetakDatum == "" || pocetakVreme == ""){
            var pocetakTermina = "2026-12-31";
        } else {
            var pocetakTermina = pocetakDatum;
            pocetakTermina += "T";
            pocetakTermina += pocetakVreme;
            pocetakTermina += ":00"
        }
        if(pocetakDatum == "" || krajVreme == ""){
            var krajTermina = "2026-12-31";
        } else {
            var krajTermina = pocetakDatum;
            krajTermina += "T";
            krajTermina += krajVreme;
            krajTermina += ":00"
        }

    }
    let idTermina = localStorage.getItem("TerminZaPromenu");

    let sati1 = pocetakVreme.substring(0,2);
    let sati2 = krajVreme.substring(0,2);
    let minuti1 = pocetakVreme.substring(3,5);
    let minuti2 = krajVreme.substring(3,5);
    let trajanjeTermina = (Number(sati2)-Number(sati1)) * 60;
    trajanjeTermina += (Number(minuti2)-Number(minuti1));

    console.log(trajanjeTermina);

    var izmeniTermin = {
        pocetakTermina,
        krajTermina,
        trajanjeTermina,
        cenaTermina,
        idTreninga,
        idSale

    }
    console.log(izmeniTermin);


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/termin/izmeniTermin/"+ idTermina,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(izmeniTermin),
        success: function (res) {
            console.log(res);
            if(res.trajanjeTermina == -1){
                alert("Termin nije krerian jer se poklapa sa vec postojecim terminom u datoj sali!");
            } else {
                alert("Termin je uspesno azuriran!");
                window.location.href = "trener_page.html";
            }
        },
        error: function (res) {
            console.log(res);
            alert("Greška!");
        }
    });

});
