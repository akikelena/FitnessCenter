$(document).on("submit", "#prijava", function (ev) {
    ev.preventDefault();

    let id = $("#id").val();

    let newFitnesCentar = {
        id
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/korisnik/KorisnikList/brisanje/"+id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("Korisnik " + response.id + " je obrisan!");
            window.location.href = "admin_page.html";
        },
        error: function () {
            window.location.href = "admin_page.html";
        }
    });
});