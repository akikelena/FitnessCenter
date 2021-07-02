$(document).on('click', '.btnDeleteFC', function (){
    let fcId = this.dataset.id;

    $.ajax({
        type : "DELETE",
        url : "http://localhost:8080/fcentar/" + fcId,
        dataType : "json",

        success: function () {
            console.log("SUCCESS");

            $('[data-id="' + fcId + '"]').parent().parent().remove();
        },

        error: function (){
            alert("Greska prilikom brisanja FC-a!");
        }
    });
});