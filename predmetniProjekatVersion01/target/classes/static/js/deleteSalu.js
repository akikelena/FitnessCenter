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
                let btn = "<button class='btnDelete' data-id=" + sala.id + ">OBRIŠI SALU</button>";
                row += "<td>" + btn + "</td>";

                row += "</tr>";

                $('#sala-List').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});

$(document).on('click','.btnDelete', function (){

    let salaId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        dataType : "json",
        url : "http://localhost:8080/sala/SalaList/" + salaId,

        success: function (){
            console.log("SUCCESS");

            $('[data-id="' + salaId + '"]').parent().parent().remove();
        },

        error : function (){
            alert("Error!");
        }
    });
});