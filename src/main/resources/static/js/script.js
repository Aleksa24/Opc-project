function trazi(){
    $.get("http://localhost:8080/kupac/all", function(kupci, status){
        if (status !== 'success'){
            alert("error in getting kupci");
            return;
        }

        let body = document.getElementById("body");
        removeAllChildNodes(body);

        for (let kupac of kupci) {
            addRow(document.getElementById("table"),kupac)
        }



        console.log(body)
    });
}
function akcija(){
    alert('akcija')
}
function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}
function addRow(table,kupac) {
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var cell_nazivKupca = row.insertCell(0);
    var element_nazivKupca = document.createElement("tr");
    element_nazivKupca.innerText = kupac.naziv;
    cell_nazivKupca.appendChild(element_nazivKupca);

    var cell_sifra = row.insertCell(1);
    var element_sifra = document.createElement("tr");
    element_sifra.innerText = kupac.id;
    cell_sifra.appendChild(element_sifra);

    var cell_grad = row.insertCell(2);
    var element_grad = document.createElement("tr");
    element_grad.innerText = kupac.grad.naziv;
    cell_grad.appendChild(element_grad);

    var cell_aktivan = row.insertCell(3);
    var element_aktivan = document.createElement("tr");
    var checkBox = document.createElement("input");
    checkBox.type = "checkbox";
    checkBox.className = "form-check-input";
    checkBox.onclick = function (){return false;};
    checkBox.checked = kupac.aktivan;
    element_aktivan.appendChild(checkBox);
    cell_aktivan.appendChild(element_aktivan);

    var cell_UBK = row.insertCell(4);
    var element_UBK = document.createElement("tr");
    element_UBK.innerText = kupac.kartice.length;
    cell_UBK.appendChild(element_UBK);

    var cell_dozvoljeniGradovi = row.insertCell(5);
    var element_dozvoljeniGradovi = document.createElement("tr");
    element_dozvoljeniGradovi.name=kupac.id;
    cell_dozvoljeniGradovi.appendChild(element_dozvoljeniGradovi);
}