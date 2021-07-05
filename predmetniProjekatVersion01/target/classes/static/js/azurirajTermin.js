$(document).on("submit", "#termin-azurirajForm", function (event){
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
});