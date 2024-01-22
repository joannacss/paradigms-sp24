<!-- Demonstrates prompts -->
<!DOCTYPE HTML>
<html>
	<head>

	</head>
	<body>
		<script type="text/javascript">
		let age = prompt('How old are you?', 100);
		alert(age); 

		let exitNow = confirm("Would you like to exit?")
		if(exitNow) // true if ok is pressed
			alert("User want to exit");
		else 
			alert("User do not want to exit");
		</script>
	</body>
</html>