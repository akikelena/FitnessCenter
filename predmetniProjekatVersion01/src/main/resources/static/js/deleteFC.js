$(document).on("submit","#fc-delete", function (event){

    let id = this.dataset.id;

        $.ajax({
            type: "DELETE",
            dataType : "json",
            url : "http://localhost:8080/fcentar/obrisiFC/" + id,

            success: function (response){
                console.log("SUCCESS");
                console.log(response);

                $('[data-id="' + id + '"]').parent().parent().remove();

                alert("Fitness centar" + response.id + "je obrisan!");
                window.location.href = "admin_page.html";
            },

            error : function (response){
                console.log("Error!");
                console.log(response);
            }
        });
});