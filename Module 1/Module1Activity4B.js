"use strict";


class Calculator {
	constructor (start) {
	
	}
}

undo() {
	
}

peek(n) {

}

pop() {

}

printMe() {

}

clear() {

}


// make calculator class, constructor has single parameter to which the calculator is initialized
//calc function should now be a method on calculator

//add function to calculator class called 'undo' that akes no parameters and undoes the previous operations
//the value it returns in the new current value of calculator
//if there is no previous operation, set calculator to zero and return zero

//add capability to store and access history of calculator results
//add a property that is a 'stack' that stores the sequence of results from the calculator

//add function to calculator - peek ([optional] n) with no args, peek returns the value at the top of the stack without
//popping stack; with argument n, peek returns nth stack element
//if stack is empty or n > stack.length, return null

//add function - pop - returns top of the stack and removes element from stack. if stack is empty, return null
//add function - printMe - prints the contents of the stack to the console and does not return a value
//clear - resets the calculator to stack==[0]. resets any previous operations (no undo may be applied)