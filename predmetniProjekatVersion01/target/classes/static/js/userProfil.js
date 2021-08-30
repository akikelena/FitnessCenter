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
        window.location.href = "../trenerPG/trenerPG_sr.html";
     
    }
    if(rola == 1){
        window.location.href = "../adminPG/adminPG_sr.html";
     
    }
    let idClana = localStorage.getItem("id");



    $.ajax({
        type: "GET",
        url: "http://localhost:8080/clan/profil/" + idClana,
        dataType: "json",
        success: function (res) {
            let datum = res.datumRodjenja;
            datum = datum.substring(0,10);


            let row = "<tr><td class='profilText rightAlign'> ID: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.id + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Username: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.korisnickoIme + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Ime: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.ime + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Prezime: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.prezime + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Email: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.email + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Datum rodjenja: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + datum + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Telefon: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.kontaktTelefon + "<td></tr>";
            row += "<tr><td class='profilText rightAlign'> Prijavljeni termini: </td><td class='gap20'></td><td class='profilText centerAlign' colspan='2'>" + res.retVal + "<td></tr>";
            row += "<tr><td style='height: 30px;'></td></tr>";
            
            $('#tableFit').append(row);


        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

});






