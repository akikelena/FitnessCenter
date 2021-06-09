$(document).on("submit", "#tr-addForm", function (event) {
    event.preventDefault();


    let naziv = $("#naziv").val();
    let opis = $("#opis").val();
    let tip = $("#tip").val();
    let trajanje = $("#trajanje").val();


    let noviTrening = {
        naziv,
        opis,
        tip,
        trajanje
    }
    console.log(noviTrening);


    $.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8080/api/trening/dodajTr",
        contentType: "application/json",
        data: JSON.stringify(noviTrening),
        success: function (response) {
            console.log(response);

            alert("Trening" + response.id + " je kreiran!");
            window.location.href = "TreningList.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});