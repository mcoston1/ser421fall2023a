"use strict";

class Calculator {
	constructor (total) {
		this.total = total; //initialize calculator to parameter
		this.stack = [];    //initialize stack for calculator results
		this.memory = [];
		this.stack.push(total);  //push first 'memory' value onto stack
	}


//add capability to store and access history of calculator results
//add a property that is a 'stack' that stores the sequence of results from the calculator

	calc (string) {
		var stringObj = JSON.parse(string); //parse the json into useable form

		var operation = stringObj.operation; //operation holder
		var operand = stringObj.operand; //operand holder 
		if (operation === "add" ) { 
			this.total += operand;      //if addition, add
		} else if (operation === "subtract") {
			this.total -= operand;      //if subtraction, subtract
		} else {
			console.log ("Something fishy is happening"); //else hinky things are happenin
		}

		this.stack.push(this.total); //push value onto the stack
		this.memory.push(this.total);//add the value to the memory as well

		return this.total;	//send the total back
	}

	//undoes previous operation, returns new current value of calculator
	undo() {
		if (this.memory.length === 1) {          //no previous operations, just initial value
			this.total = 0;
			return this.total;
		} else if (this.memory.length === 0) {   //all values popped off or other shenaniganery
			return null;
		} else {                             //perform undo operation			 
			this.memory[0] = this.memory[1]; //set mem[0] = mem[1]. That effectively 'undoes' the operation simply. hacky, but it should work.
			this.memory.pop();               //remove the duplicated value to reset calculator 'start' point on stack
			this.total = this.memory[0];     //
			return this.total;
		}
	}

	//add function to calculator - peek ([optional] n) with no args, peek returns the value at the top of the stack without
	//popping stack; with argument n, peek returns nth stack element
	//if stack is empty or n > stack.length, return null
	peek(n) {

	}

	//as long as stack is not empty, returns the top of the stack and removes that element from the stack
	pop() {
		if (this.stack.length === 0) {
			return null;
		} else {
			return this.stack.pop(); //js arrays already have a built in pop method
		}
	}

	//prints the contents of the stack to the console
	printMe() {
		if (this.stack.length == 0) {
			console.log("This b***h is empty. YEET");
		} else {
			for (let i = 0; i < this.stack.length; i++) {
				console.log(this.stack[i]);
			}
		}
	}

	//resets calculator to a stack of length 0
	clear() {
		if (this.stack.length === 0) {
			console.log ("Already clear!");
		} else {
			while (this.stack.length > 0) {
				this.stack.pop();
			}
		}
	}
} //end of class