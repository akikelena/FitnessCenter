$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType : "json",
        url : "http://localhost:8080/fcentar/FCList",

        success : function (response) {
            console.log("SUCCESS: \n", response);

            for(let fitnessCentar of response){

                    let row = "<tr>";

                row += "<td>" + fitnessCentar.id + "</td>";
                row += "<td>" + fitnessCentar.naziv + "</td>";
                row += "<td>" + fitnessCentar.adresa + "</td>";
                row += "<td>" + fitnessCentar.brTelCentrale + "</td>";
                row += "<td>" + fitnessCentar.email + "</td>";
                let btn = "<button class='btnDelete' data-id=" + fitnessCentar.id + ">OBRIŠI FC</button>";
                row += "<td>" + btn + "</td>";

                    row += "</tr>";

                $('#fc-List').append(row);
            }
        },
        error: function (response){
            console.log("GRESKA! \n", response);
        }
    });
});

$(document).on('click','.btnDelete', function (){

    let fitnessCentarId = this.dataset.id;

        $.ajax({
            type: "DELETE",
            dataType : "json",
            url : "http://localhost:8080/fcentar/FCList/" + fitnessCentarId,

            success: function (){
                console.log("SUCCESS");
                //console.log(response);

                $('[data-id="' + fitnessCentarId + '"]').parent().parent().remove();

                //alert("Fitness centar" + response.id + "je obrisan!");
                //window.location.href = "admin_page.html";
            },

            error : function (){
                alert("Error!");
                //console.log(response);
            }
        });
});