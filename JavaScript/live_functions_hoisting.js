//DEMO: try to invoke each of them

// function declaration
function sayHello1(){
	console.log("Hello! (1)");
}

// function expression
var sayHello2 = function (){
	console.log("Hello! (2)");
};

// using arrow 
var sayHello3 = () => console.log("Hello! (3)");