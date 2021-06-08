$(document).on("submit", "#fc-addForm", function (event){
    event.preventDefault();

        let naziv = $("#naziv_fc").val();
        let adresa = $("#adresa_fc").val();
        let brTelCentrale = $("#br_tel").val();
        let email = $("#email_fc").val();

    let newFC = {
        naziv,
        adresa,
        brTelCentrale,
        email
    }
    console.log(newFC);

    $.ajax({
        type: "POST",
        url : "http://localhost:8080/api/add_fitcentar",
        dataType: JSON.stringify(newFC),
        success : function (response) {
            console.log(response);

            alert("Uspešno ste kreirali fitness centar " + response.id + "!");
            window.location.href = "login_page.html";
        },
        error : function (){
            alert("Greška prilikom pokušaja kreiranja novog fitness centra!");
        }
    });
});