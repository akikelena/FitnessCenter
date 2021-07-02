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
                row += "<td>" + korisnik.loznika + "</td>";
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.kontaktTelefon + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td>" + korisnik.datumRodjenja + "</td>";
                row += "<td><input type='checkbox' data-id='" + zahtev.id + "' /> </td>";
                row += "</tr>";

                $('#sviKorisnici tbody').append(row);
            }
        },
        error: function (response) {
            console.log("Greska! \n", response);

        }
    });

    $("#approveReq").on("click", function (event) {
        event.preventDefault();

        let listID = []

    $("[type = 'checkbox']").each(function (el){
        console.log(this)
            if($(this).is(":checked")) {
                listID.push($(this).attr("data-id"));
                window.location.href = "approve_request.html";
            }
    })
        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/korisnik/odobri_trenera",
            data : JSON.stringify(listID),
            dataType: "json",
            contentType : "application/json"
        });
    })
});