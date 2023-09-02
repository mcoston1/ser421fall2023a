//mcoston ser421 fall2023
//module 2 activity 1
//
//
"use strict";


//rename the message "Help Spread Duck Duck Go" in the upper right to say Help Spread Love
function spreadLove() {
    document.getElementById("spread").innerText = "Help Spread Love!";
}
spreadLove();

//Output to the console the number of list item tags in the page 
function numLi() {
   var elements = document.getElementsByTagName("li");
   let numb = elements.length;
   console.log(numb);
}
numLi();
//output to the console the value in the search bar (you must get this from the search bar)
function searchVal() {
    var val = document.getElementById("search_form_input").value;
    console.log(val);   
}
searchVal();

//Make the duck in the upper left corner go away
function magicTrick() {
    const elements = document.getElementsByClassName("header__logo js-logo-ddg");
    elements[0].parentNode.removeChild(elements[0]);
}
magicTrick();



