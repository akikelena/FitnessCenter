$(document).on("submit", "#fc-addForm", function (event){
    event.preventDefault();

        let naziv = $("#naziv").val();
        let adresa = $("#adresa").val();
        let brTelCentrale = $("#brTelCentrale").val();
        let email = $("#email").val();

    let newFitnessCentar = {
        naziv,
        adresa,
        brTelCentrale,
        email
    }
    console.log(newFitnessCentar);

    $.ajax ({
        type: "POST",
        url : "http://localhost:8080/fcentar/dodaj",
        dataType : "json",
        contentType : "application/json",
        data: JSON.stringify(newFitnessCentar),

        success : function (response) {
            console.log(response);

            alert("Uspešno ste kreirali fitness centar " + response.id + "!");
            window.location.href = "add_FitnessCentar.html";
        },
        error : function (){
            alert("Greška prilikom pokušaja kreiranja novog fitness centra!");
        }
    });
});