$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType : "json",
        url : "http://localhost:8080/sala/SalaList",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for(let sala of response){

                let row = "<tr>";

                row += "<td>" + sala.id + "</td>";
                row += "<td>" + sala.oznakaSale + "</td>";
                row += "<td>" + sala.kapacitet + "</td>";
                row += "<td>" + sala.idFC + "</td>";

                row += "</tr>";

                $('#sala-List').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});