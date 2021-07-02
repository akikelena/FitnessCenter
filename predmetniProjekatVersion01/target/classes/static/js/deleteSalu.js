$(document).on('click', '.btnDeleteSalu', function (){
    let salaId = this.dataset.id;

    $.ajax({
        type : "DELETE",
        url : "http://localhost:8080/sala/" + salaId,
        dataType : "json",

        success: function () {
            console.log("SUCCESS");

            $('[data-id="' + salaId + '"]').parent().parent().remove();
        },

        error: function (){
            alert("Greska prilikom brisanja sale!");
        }
    });
});