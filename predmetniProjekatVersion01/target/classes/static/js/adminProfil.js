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
        window.location.href = "admin_page.html";
    }
    let idClana = localStorage.getItem("id");


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/profil/" + idClana,
        dataType: "json",
        success: function (res) {
            let datum = res.datumRodjenja;
            datum = datum.substring(0,10);

            let row = "<tr><td class='profilText rightAlign'> ID: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.id + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Korisnicko ime: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.korisnickoIme + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Lozinka: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.lozinka + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Ime: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.ime + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Prezime: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.prezime + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Email: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.email + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Datum rodjenja: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + datum + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Kontakt telefon: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.kontaktTelefon + "<td></tr>";
            let btnChange = "<button id = 'dugmeIzmeni' data-id=" + res[i].id + ">IZMENI</button>";
            row += "<td class='celijaTabele'>" + btnChange + "</td>";
            row += "<tr><td style='height: 30px;'></td></tr>";

            $('#tableFit').append(row);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

});

$(document).on('click', '#dugmeIzmeni', function () {

    let fitID = this.dataset.id;
    localStorage.setItem("CentarZaPromenu", fitID);
    window.location.href = "izmeniProfilAdmin.html";

});