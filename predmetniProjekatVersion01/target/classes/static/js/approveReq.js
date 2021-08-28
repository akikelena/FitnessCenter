/*$(document).ready(function () {
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "http://localhost:8080/korisnik/lista_trenera",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for (let korisnik of response) {
                let row = "<tr>";
                row += "<td>" + korisnik.id + "</td>";
                row += "<td>" + korisnik.korisnickoIme + "</td>";
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td><input type='checkbox' data-id='" + korisnik.id + "' /> </td>";
                row += "</tr>";

                $('#zahtevi').append(row);
            }
        },
        error: function (response) {
            console.log("Greska! \n", response);

        }
    });

    $("#btn-approveReq").on("click", function (event) {
        event.preventDefault();

        let idList = []

    $("[type = 'checkbox']").each(function (elem){
        console.log(this)

            if($(this).is(":checked")) {
                idList.push($(this).attr("data-id"));
                window.location.href = "approve_request.html";
            }
    })
        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/korisnik/odobriZahtevTrenera",
            data : JSON.stringify(idList),
            dataType: "json",
            contentType : "application/json"
        });
    })
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
    if(rola == 2){
        window.location.href = "trener_page.html";
    }
    if(rola == 3){
        window.location.href = "user_page.html";
    }


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/trener/zahteviZaTrenera/" + rola,
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
                let btn = "<button id = 'dugmeOdobri' type = 'submit' data-id=" + res[i].id + ">ODOBRI</button>"
                    + "<button id = 'dugmeOdbij' type = 'submit' data-id=" + res[i].id + ">ODBIJ</button>";
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
$(document).on('click', '#dugmeOdobri', function () {


    let empId = this.dataset.id;
    let brisanje = "#red";
    brisanje += empId;

    let sakrij = $(brisanje);
    sakrij.hide();


    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/trener/aktivirajTrenera/" + empId,
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            alert(res.korisnickoIme + " je prihvacen!");
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '#dugmeOdbij', function () {


    let empId = this.dataset.id;
    let brisanje = "#red";
    brisanje += empId;

    let sakrij = $(brisanje);
    sakrij.hide();


    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/trener/odbijZahtevTrenera/" + empId,
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            alert("Zahtev je odbijen!");
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});