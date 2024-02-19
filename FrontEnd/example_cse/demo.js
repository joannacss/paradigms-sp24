// Q1
let h1 = document.getElementsByTagName("h1");
h1[0].innerText = "Computer Science and Engineering Faculty";


// Q2
let h2 = document.getElementsByTagName('h2');

for(let i = 0 ; i < h2.length ; i++){
	let el = h2[i];
	let name = el.children[0].innerText;
	let parts = name.split(" ");
	let lastName = parts[parts.length - 1];
	el.innerText = `Prof. ${lastName}`
}


// Q3

let anchor = document.getElementById("post-1033-link");
anchor.href = "https://sarec.nd.edu";
console.log(anchor);