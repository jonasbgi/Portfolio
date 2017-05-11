/*
FILE NAME: presses_click.js
WRITTEN BY: Jonas Bjøralt Giske
WHEN: November 2016
PURPOSE: Power the interactive applepress at eplepresser.html.

This makes elements of the same class invisible (visibility hidden) and keeps one element visible, or hides an element.
All variables and constants are based upon HTML-fed-arguments; this code may be reused for a different HTML.
*/
function testMap(showText){
	newBox = document.getElementById(showText);
	newBox.style.visibility="visible";
}

//Hides all elements in class 'className' except for the item 'showItem'
function hideAllBut(showItem, className){
	textboxes = document.getElementsByClassName(className);
	for(i=0; i < textboxes.length; i++){
		var elmntID = textboxes[i].id;	document.getElementById(elmntID).style.visibility="hidden";
	}
	visibleBox = document.getElementById(showItem);
	visibleBox.style.visibility="visible";

}
function hideItem(elmntID){
	document.getElementById(elmntID).style.visibility="hidden";
}
