$(document).ready(function () {
    let rola = localStorage.getItem("rola");
    if(rola == null){
        localStorage.setItem("rola", 0);
        window.location.href = "index.html";
    }
    if(rola == 0){
        window.location.href = "index.html";
    }
    if(rola == 1){
        window.location.href = "admin_page.html";
    }
    if(rola == 3){
        window.location.href = "user_page.html";
    }
    let idTrenera = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/termin/get/" + idTrenera,
        dataType: "json",
        success: function (res) {
            console.log("SUCCESS:\n", res);
            for (i = 0; i < res.length; i++) {

                let pocetak = res[i].pocetakTermina;
                pocetak = setCharAt(pocetak, 10, ' ');
                pocetak = pocetak.substring(0,16);

                let kraj = res[i].krajTermina;
                kraj = setCharAt(kraj, 10, ' ');
                kraj = kraj.substring(0,16);


                let row = "<tr id = 'red" + res[i].id +"'>";
                row += "<td class='celijaTabele'>" + res[i].id + "</td>";
                row += "<td class='celijaTabele'>" + res[i].naziv + "</td>";
                row += "<td class='celijaTabele'>" + res[i].opis + "</td>";
                row += "<td class='celijaTabele'>" + res[i].tipTreninga + "</td>";
                row += "<td class='celijaTabele'>" + pocetak + "</td>";
                row += "<td class='celijaTabele'>" + kraj + "</td>";
                row += "<td class='celijaTabele'>" + res[i].trajanjeTermina + "</td>";
                row += "<td class='celijaTabele'>" + res[i].cena + "</td>";
                row += "<td class='celijaTabele'>" + res[i].oznakaSale + "</td>";
                let btnChange = "<button id = 'dugmeIzmeni' data-id=" + res[i].id + ">IZMENI</button>";
                let btnDelete = "<button id = 'dugmeObrisi' data-id=" + res[i].id + ">OBRISI</button>";
                row += "<td class='celijaTabele'>" + btnChange + "</td>";
                row += "<td class='celijaTabele'>" + btnDelete + "</td>";
                row += "</tr>";
                $('#tabelaTermina').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

});
function setCharAt(str,index,chr) {
    if(index > str.length-1) return str;
    return str.substring(0,index) + chr + str.substring(index+1);
}

$(document).on('click', '#dugmeIzmeni', function () {

    let terminID = this.dataset.id;
    localStorage.setItem("TerminZaPromenu", terminID);
    window.location.href = "azurirajTermin.html";

});
$(document).on('click', '#dugmeObrisi', function () {

    let terminID = this.dataset.id;

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/termin/otkaziTermin/" + terminID,
        dataType: "json",
        contentType: "application/json",
        success: function () {
            alert("Termin je otkazan!");
            window.location.href = "trenerTermini.html";
        },
        error: function () {
            console.log("ERROR:\n");
        }
    });

});

function sortiraj(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("tabelaTermina");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */

            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function sortirajBroj(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("tabelaTermina");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i =1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */
            let prvi = x.innerHTML.toLowerCase();
            let drugi = y.innerHTML.toLowerCase();
            if (dir == "asc") {
                if (Number(prvi) > Number(drugi)/* x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase() */) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (Number(prvi) < Number(drugi)/* x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() */) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function sortirajSaSufiksom(n, suf) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("tabelaTermina");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */
            let prvi = x.innerHTML.toLowerCase();
            let drugi = y.innerHTML.toLowerCase();
            prvi = prvi.substring(0,(prvi.length - suf));
            drugi = drugi.substring(0,(drugi.length - suf));
            /* if(Number(prvi) > Number(drugi)){
                console.log(prvi, " je veci od ", drugi);
            } else {
                console.log(prvi, " nije veci od ", drugi);
            } */
            if (dir == "asc") {
                if (Number(prvi) > Number(drugi)/* x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase() */) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (Number(prvi) < Number(drugi)/* x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() */) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}