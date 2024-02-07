let counter = 1;

function nextOddNumber(){
	let output = counter;
	counter = counter + 2
	return output;
}

function userFunction1(){
	console.log(`userFunction1 ${nextOddNumber()}`)
	console.log(`userFunction1 ${nextOddNumber()}`)
}

function userFunction2(){
	console.log(`userFunction2 ${nextOddNumber()}`)
	console.log(`userFunction2 ${nextOddNumber()}`)
}
userFunction1()
userFunction2()


// DEMO: how to use closures to solve this problem?
// let nextOddNumberGenerator = function (){
// 	let innerCounter = 1;
// 	return () => {
// 		let output = innerCounter;
// 		innerCounter += 2;
// 		return output;
// 	};
// }
// let f1 = nextOddNumberGenerator();
// let f2 = nextOddNumberGenerator();

// console.log(f1())
// console.log(f1())

// console.log(f2())



