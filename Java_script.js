Java script:
1. how to call rest 
Ans.
		The API includes a lot more, but start with the fetch() method. It takes two arguments:

		A URL or an object representing the request.
		Optional init object containing the method, headers, body etc.
		I) 
		const userAction = async () => {
		  const response = await fetch('http://example.com/movies.json');
		  const myJson = await response.json(); //extract JSON from the http response
		  // do something with myJson
		}

		II)
		Recreating the previous top answer, a POST:

		const userAction = async () => {
		  const response = await fetch('http://example.com/movies.json', {
			method: 'POST',
			body: myBody, // string or object
			headers: {
			  'Content-Type': 'application/json'
			}
		  });
		  const myJson = await response.json(); //extract JSON from the http response
		  // do something with myJson
		}
		
		III)
		function loadDoc() {
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
				  document.getElementById("demo").innerHTML = this.responseText;
				}
			  };
			  xhttp.open("GET", "demo_get2.asp?fname=Henry&lname=Ford", true);
			  xhttp.send();
		}

2. 