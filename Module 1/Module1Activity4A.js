"use strict";

var total = 0; //result total holder

function calc(string) {
	var stringObj = JSON.parse(string); //parse the json into useable form

	var operation = stringObj.operation; //operation holder
	var operand = stringObj.operand; //operand holder 
	if (operation === "add" ) { 
		total += operand;      //if addition, add
	} else if (operation === "subtract") {
		total -= operand;      //if subtraction, subtract
	} else {
		console.log ("Something fishy is happening"); //else hink
	}
	return total;	//send the total back
}