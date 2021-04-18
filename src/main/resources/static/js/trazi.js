function trazi(){
    $.get("http://localhost:8080/kupac/all", function(kupci, status){

        if (status !== 'success'){
            alert("error in getting kupci");
            return;
        }
        var table = document.getElementById("table")

        //brisanje prethodnih podataka
        isprazniTabelu();

        //dodavenje elemenata u tabelu
        for (let kupac of kupci) {
            addRow(table,kupac)
        }
    });
}
function akcija(){
    alert('akcija')
}
function isprazniTabelu() {
    let table = document.getElementById("table");
    let rowCount = table.rows.length;

    for(let i=1; i<rowCount; i++) {
        table.deleteRow(i);
        rowCount--;
        i--;
    }

}
function addRow(table,kupac) {
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    //kreiranje polja za NAZIV KUPCA
    var cell_nazivKupca = row.insertCell(0);
    var element_nazivKupca = document.createElement("tr");
    element_nazivKupca.innerText = kupac.naziv;
    cell_nazivKupca.appendChild(element_nazivKupca);

    //kreiranje polja za SIFRU
    var cell_sifra = row.insertCell(1);
    var element_sifra = document.createElement("tr");
    element_sifra.innerText = kupac.id;
    cell_sifra.appendChild(element_sifra);

    //kreiranje polja za GRAD KUPCA
    var cell_grad = row.insertCell(2);
    var element_grad = document.createElement("tr");
    element_grad.innerText = kupac.grad.naziv;
    cell_grad.appendChild(element_grad);

    //kreiranje polja za AKTIVAN
    var cell_aktivan = row.insertCell(3);
    var element_aktivan = document.createElement("tr");
    var checkBox = document.createElement("input");
    checkBox.type = "checkbox";
    checkBox.className = "form-check-input";
    checkBox.onclick = function (){return false;};
    checkBox.checked = kupac.aktivan;
    element_aktivan.appendChild(checkBox);
    cell_aktivan.appendChild(element_aktivan);

    //kreiranje polja za UKUPAN BROJ KARTICA
    var cell_UBK = row.insertCell(4);
    var element_UBK = document.createElement("tr");
    element_UBK.innerText = kupac.kartice.length;
    cell_UBK.appendChild(element_UBK);

    //kreiranje polja za DOZVOLJENE GRADOVE
    var cell_dozvoljeniGradovi = row.insertCell(5);
    var element_dozvoljeniGradovi = document.createElement("tr");
    var dozvoljeniGradovi = izdvojDozvoljeneGradove(kupac);
    var ul_tag = document.createElement("ul");
    ubaciDozvoljeneGradove(ul_tag,dozvoljeniGradovi);
    element_dozvoljeniGradovi.appendChild(ul_tag);
    cell_dozvoljeniGradovi.appendChild(element_dozvoljeniGradovi);
}

function izdvojDozvoljeneGradove(kupac){
    let dozvoljeniGradovi = [];
    kupac.kartice.forEach(kartica => kartica.dozvoljeniGradovi.forEach(grad => dozvoljeniGradovi.push(grad)));

    return [...new Set(dozvoljeniGradovi.map(grad => grad.naziv))];
}
function ubaciDozvoljeneGradove(ul_tag, dozvoljeniGradovi) {
    for (let grad of dozvoljeniGradovi) {
        let li_tag = document.createElement("li");
        li_tag.innerText = grad;
        ul_tag.appendChild(li_tag);
    }
}