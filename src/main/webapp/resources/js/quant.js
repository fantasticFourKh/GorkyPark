function plusAdult() {
		var x = document.getElementById("adultId").value;
		if (x < 9) {
			var y = +x + 1;
			document.getElementById("adultId").value = y;
		}
	}

	function plusChild() {
		var x = document.getElementById("childId").value;
		if (x < 9) {
			var y = +x + 1;
			document.getElementById("childId").value = y;
		}
	}

	function minusAdult() {
		var x = document.getElementById("adultId").value;
		if (x > 0) {
			var y = +x - 1;
			document.getElementById("adultId").value = y;
		}
	}

	function minusChild() {
		var x = document.getElementById("childId").value;
		if (x > 0) {
			var y = +x - 1;
			document.getElementById("childId").value = y;
		}
	}