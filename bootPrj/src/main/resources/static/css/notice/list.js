window.onload = function (){

    var asideTitle = window.document.getElementById("aside-title");
    var a1 = document.getElementById("a1");

    asideTitle.onclick = printSum;
    
    function printSum(){
        var x = prompt('x:');
        var y = prompt('y:');
        x = parseInt(x);
        y = parseInt(y);
        asideTitle.innerText = x+y;
        a1.value = x+y;
    }
};

