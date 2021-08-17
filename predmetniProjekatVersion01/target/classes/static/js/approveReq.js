$(document).ready(function () {
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
});