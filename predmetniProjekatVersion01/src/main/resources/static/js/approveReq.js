// prikaz svih zahteva za trenera

$(document).ready(function () {
    $.ajax({
        type : "GET",
        url : "http://localhost:8080/api/approve_request",
        dataType : "json",
        success : function (response) {
            console.log("SUCCESS: \n", response);

            for (let zahtev of response) {
                let row = "<tr>";
                row += "<td>" + zahtev.ime + "</td>";
                row += "<td>" + zahtev.prz + "</td>";
                row += "<td>" + zahtev.email + "</td>";
                row += "<td><input type='checkbox' data-id='" + zahtev.id + "' /> </td>";
                row += "</tr>";

                $('#sviKorisnici').append(row);
            }
        },
        error: function (response) {
            console.log("Greska! \n", response);

        }
    });

    $("#approveSelected").on("click", function (event) {
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
            url: "http://localhost:8080/api/approveRequest",
            data : JSON.stringify(listID),
            dataType: "json",
            contentType : "application/json"
        });
    })
});