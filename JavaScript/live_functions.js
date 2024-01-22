// DEMO - PART1: BASIC FUNCTION DECLARATION
// 		- with / without arguments
// 		- with / without return
function sumArray(arr){
	let total = 0;
	for (let i = 0; i < arr.length; i++){
		total+= arr[i];
	}
	return total;
}
let arr = [1,2,3,"4" ];
// console.log(`${sumArray(arr)}`);


// DEMO - PART2: FUNCTION EXPRESSIONS
let sayHi = function(name){
	console.log("Hello, " + name);	
}
let a = sayHi;

// console.log(a + 2);
// console.log(sayHi);
// console.log(sayHi("Mark"));
// a("Joanna");

// DEMO - PART3: ARROW FUNCTIONS
// (...) => (expression)
let isEven = n => n % 2 === 0;
let sum = (a, b) => a + b;
let min = (a, b) => {
  	if(a < b) return a;
	else return b;
}

// console.log(min(13, 12))

// DEMO - PART4: CALLBACK FUNCTIONS
let add = (a,b) => a + b;
let multiply = (a,b) => a * b;

function calculate(operation, num1, num2){
	console.log(`Perfoming ${operation}`); 
	return operation(num1, num2);
}

console.log(calculate(multiply, 1 , 2))
console.log(calculate(add, 1 , 2))






