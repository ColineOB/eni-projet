function disableElementsVente() {
	document.getElementById("encheresOuvertes").disabled = false;
	document.getElementById("encheresEnCours").disabled = false;
	document.getElementById("encheresGagnees").disabled = false;
	document.getElementById("ventesEnCours").disabled = true;
	document.getElementById("ventesEnCours").checked = false;
	document.getElementById("ventesNonDebutees").disabled = true;
	document.getElementById("ventesNonDebutees").checked = false;
	document.getElementById("ventesTerminees").disabled = true;
	document.getElementById("ventesTerminees").checked = false;
}

function disableElementsAchat() {
	document.getElementById("encheresOuvertes").disabled = true;
	document.getElementById("encheresOuvertes").checked = false;
	document.getElementById("encheresEnCours").disabled = true;
	document.getElementById("encheresEnCours").checked = false;
	document.getElementById("encheresGagnees").disabled = true;
	document.getElementById("encheresGagnees").checked = false;
	document.getElementById("ventesEnCours").disabled = false;
	document.getElementById("ventesNonDebutees").disabled = false;
	document.getElementById("ventesTerminees").disabled = false;
}