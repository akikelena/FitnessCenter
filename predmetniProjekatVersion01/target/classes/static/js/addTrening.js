$(document).on("submit", "#tr-addForm", function (event) {
    event.preventDefault();


    let naziv = $("#naziv").val();
    let opis = $("#opis").val();
    let tipTreninga = $("#tipTreninga").val();
    let trajanje = $("#trajanje").val();


    let noviTrening = {
        naziv,
        opis,
        tipTreninga,
        trajanje
    }
    console.log(noviTrening);


    $.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8080/trening/dodajTrening",
        contentType: "application/json",
        data: JSON.stringify(noviTrening),

        success: function (response) {
            console.log(response);

            alert("Trening" + response.id + " je kreiran!");
            window.location.href = "TreningList.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja treninga!");
        }
    });
});