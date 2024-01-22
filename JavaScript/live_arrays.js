// EXAMPLE 1: imperative-style
// function returns true if all elements are below a given threshold
function isBelowThreshold(array, threshold){
	for(let i = 0; i < array.length ; i++){
		if(array[i] > threshold)
			return false;
	}
	return true;
}
const array1 = [1, 30, 39, 29, 10, 13];
let output1 = isBelowThreshold(array1, 40);
console.log(`DEMO1: ${output1}`);	// true


// DEMO 1: Array.every(callback[,thisArg]) 
// The every() method tests whether all elements in the array 
// pass the test implemented by the provided function. 
// It returns a Boolean value.
function isBelow(x){
	return x < 40;
}
// array1.every(x => x < 40 );
 let outputDemo = array1.every(x => x < 40 ); //array1.every(isBelow);
console.log("DEMO1 OUT " + outputDemo);


// -------------------------------------------------------------------------
// EXAMPLE 2: imperative-style
// function returns all words whose size are higher than a given wordLength
function getAllWords(words, wordLength){
	let result = [];
	for(let i = 0; i < words.length ; i++){
		if(words[i].length > wordLength)
			result.push(words[i]);
	}
	return result;
}
const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];
// console.log(`DEMO2: ${getAllWords(words,6)}`) // ["exuberant", "destruction", "present"]

// DEMO2: Array.filter(callback[,thisArg]) 
// The filter() method creates a new array with all elements that 
// pass the test implemented by the provided function.
// It returns a new array with all the filtered elements.
console.log(`DEMO2 :${words.filter((word) => word.length > 6)}`)


// -------------------------------------------------------------------------
// EXAMPLE 3: imperative-style
// computes a new array in which each element is multiplied by 2
function multiplyByTwo(array){
	let result = [];
	for(let i = 0; i < array.length ; i++){
		result.push(array[i] * 2);
	}
	return result;
}
const demo3Arr = [1, 4, 9, 16];
// console.log(`DEMO3: ${multiplyByTwo(demo3Arr)}`) // [2, 8, 18, 32]

// DEMO3: Array.map(callback[,thisArg])
// The map() method creates a new array populated with the results of calling a 
// provided function on every element in the calling array.
console.log("DEMO3: " + demo3Arr.map(x => x * 2));

// -------------------------------------------------------------------------
// EXAMPLE 4: imperative-style
// Given an array of objects, create a new array with only IDs
function extractIds(array){
	let result = [];
	for(let i = 0; i < array.length ; i++){
		result.push(array[i].id);
	}
	return result;
}
let people = [
  { id: 20, name: 'Peter' },
  { id: 24, name: 'Jane' },
  { id: 56, name: 'Joe' },
  { id: 88, name: 'Jennifer' }
];
// console.log(`DEMO4: ${extractIds(people)}`) // [20, 24, 56, 88]

// DEMO4: Using map to achieve this goal
console.log("DEMO 4: " + people.map( x => x.id))
// -------------------------------------------------------------------------
// EXAMPLE 5: imperative-style
// Sum all numbers in the array
function computeSum(array){
	let result = 0;
	for(let i = 0; i < array.length ; i++){
		result += array[i];
	}
	return result;
}
let demo5Arr = [1, 2, 3, 4];
// console.log(`DEMO5: ${computeSum(demo5Arr)}`) // 10


// DEMO5: Array.reduce(callback[,initialValue])
// executes a user-supplied "reducer" callback function on each element of the array, 
// passing in the return value from the calculation on the preceding element. 
// It returns a single value. 
let reducer = (accumulator, currentValue) => accumulator + currentValue;
console.log("DEMO5: " +  demo5Arr.reduce(reducer));




//Example6: Sum of even squares
function sumOfEvenSquares(array){
	let sum = 0;
	for(let i = 0; i < array.length ; i++){
		if(array[i] % 2 == 0)
			sum += array[i] * array[i];
	}
	return sum;
}

let demo6Arr = [4, 11, 25, 23, 8];
// console.log(`DEMO6: ${sumOfEvenSquares(demo6Arr)}`); // 80

// DEMO6: combining filter, map, reduce!
console.log("DEMO6" + demo6Arr.filter(x => x % 2 === 0).map(x => x*x).reduce((accumulator, x) => accumulator + x))

