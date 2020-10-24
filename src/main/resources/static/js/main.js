/*

$( document ).ready(function() {
  let endpoint = 'books'

var commentTable = document.getElementById("comments");

    $.ajax({
        url: endpoint,
        contentType: "application/json",
        dataType: 'json',
        success: function(result){
            console.log(result);

                       var book = JSON.parse(JSON.stringify(result));

                       $.each( book, function( index, value ){
                         var row = commentTable.getElementsByTagName("tbody")[0].insertRow(index);
                         var cell0 = row.insertCell(0);
                         var cell1 = row.insertCell(1);

                         cell0.className = "author-style";
                         cell0.innerHTML = value.id;

                         cell1.className = "text";
                         cell1.innerHTML = value.name;

                       });

        }
    })

});
*/

