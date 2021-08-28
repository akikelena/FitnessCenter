function odjaviSe(){
    localStorage.setItem("rola", 0);
    localStorage.setItem("id", 0);
    window.location.href = "index.html";
}
$(document).ready(function () {

    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);
        window.location.href = "index.html";
    }
    if(rola == 0){
        window.location.href = "index.html";
    }
    if(rola == 2){
        window.location.href = "trener_page.html";
    }
    if(rola == 3){
        window.location.href = "user_page.html";
    }


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/trener/aktivniTreneri/" + rola,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<tr id = 'red" + res[i].id +"'>";
                row += "<td class='celijaZahteva'>" + res[i].id + "</td>";
                row += "<td class='celijaZahteva'>" + res[i].korisnickoIme + "</td>";
                row += "<td class='celijaZahteva'>" + res[i].ime + "</td>";
                row += "<td class='celijaZahteva'>" + res[i].prezime + "</td>";
                row += "<td class='celijaZahteva'>" + res[i].email + "</td>";
                row += "<td class='celijaZahteva'>" + res[i].kontaktTelefon + "</td>";
                row += "<td class='celijaZahteva'>" + res[i].idFC + "</td>";
                let btn = "<button id = 'dugmeObrisi' type = 'submit' data-id=" + res[i].id + ">OBRISI</button>";
                row += "<td class='celijaZahteva'>" + btn + "</td>";
                row += "</tr>";
                $('#tabelaZahteva').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});
$(document).on('click', '#dugmeObrisi', function () {

    let empId = this.dataset.id;
    let brisanje = "#red";
    brisanje += empId;

    let sakrij = $(brisanje);
    sakrij.hide();


    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/trener/obrisiTrenera/" + empId,
        dataType: "json",
        contentType: "application/json",

        success: function () {
            alert("Trener je obrisan!");
        },
        error: function () {
            console.log("ERROR:\n");
        }
    });
});