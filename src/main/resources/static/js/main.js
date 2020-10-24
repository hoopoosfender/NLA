$( ".showbooks" ).click(function() {
    var id = $(this).attr('id');
    var name = $(this).attr('name');
    var booksTable = document.getElementById("borrow");
    var delay = 1000;
    $.ajax({
        url: "/peoplebooks/"+ id,
        contentType: "application/json",
        dataType: 'json',
        success: function(result){
        //console.log(result);
        setTimeout(function() {
          $(".loader").removeClass('is-active');
        }, delay);
        $("#selected").text(name);
        $("#borrow > tbody").empty();
         var book = JSON.parse(JSON.stringify(result));
         $.each( book, function( index, value ){
                         var row = booksTable.getElementsByTagName("tbody")[0].insertRow(index);
                         var cell0 = row.insertCell(0);
                         var cell1 = row.insertCell(1);
                         var cell2 = row.insertCell(2);
                         cell0.className = "author-style";
                         cell0.innerHTML = value.isbn;
                         cell1.className = "text";
                         cell1.innerHTML = value.title;
                         cell2.className = "text";
                         cell2.innerHTML = value.author;
         });
         $("#borrow").css("display", "block");
        }
    })
});

$(document).ajaxStart(function() {
    $(".loader").addClass('is-active');
    });

