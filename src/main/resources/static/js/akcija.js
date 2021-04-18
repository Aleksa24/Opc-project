function akcija(){
    // try {
        var table = document.getElementById("table");
        var rowCount = table.rows.length;

        for(var i=1; i<rowCount; i++) {
            var row = table.rows[i];
            var tr = row.cells[3].childNodes[0]
            var checkbox = tr.childNodes[0];

            console.log(typeof tr)
            console.log(typeof checkbox)

            if (checkbox.checked === false){
                table.deleteRow(i);
                rowCount--;
                i--;
            }
        }
    // }catch(e) {
    //     alert(e);
    // }
}