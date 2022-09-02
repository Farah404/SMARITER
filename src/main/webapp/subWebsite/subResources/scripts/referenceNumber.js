

window.addEventListener('load', function() {
    var today = new Date();
    var date = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear();
    document.getElementById("currentDate").value = date;
    $(document).ready(function() {
        $(".datepicker").datepicker({
            changeMonth: true,
            changeYear: true,
        });
    });

function randomNumber(len) {
  var randomNumber;
  var n = '';

  for (var count = 0; count < len; count++) {
    randomNumber = Math.floor(Math.random() * 10);
    n += randomNumber.toString();
  }
  return n;
}

document.getElementById("Refnunmber").value = randomNumber(9);

})