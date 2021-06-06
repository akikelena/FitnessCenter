$(document).on("submit", "#logForm", function (event){
    event.preventDefault();

    let korisnickoime = $("#korisnickoime").val();
    let password = $("#password").val();

    let noviLogin = {
        korisnickoime,
        password
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/login_page",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviLogin),
        success: function (response){
            console.log(response);

            alert("Uspešno logovanje korisnika " + response.id);
            window.location.href = "login_page.html";
        },

        error: function (){
            alert("Greška prilikom logovanja!");
        }
    });
});