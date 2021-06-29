/*
 	Location.html 
*/

function displaymap1() {
    var x1 = document.getElementById("map1");
    var x2 = document.getElementById("map2");
    if (x1.style.display === "block") {
        x1.style.display = "none";
    } else {
        x1.style.display = "block";
        x2.style.display = "none";
    }
}

function displaymap2() {
    var x1 = document.getElementById("map1");
    var x2 = document.getElementById("map2");
    if (x2.style.display === "block") {
        x2.style.display = "none";
    } else {
        x2.style.display = "block";
        x1.style.display = "none";
    }
}