/*
FILE NAME: kontakt.js
WRITTEN BY: Astrid Vik
WHEN: October 2015
PURPOSE: javascript that autofills email with name, subject and message
*/

// function autofills name, subject, and message into email

function autofillEmail() {
          var name = document.getElementById("name").value;
          var subject = document.getElementById("subject").value;
          var message = document.getElementById("message").value;
          var webmasterChoice = document.getElementById("webmaster");
          if (webmasterChoice.checked){
            var receiver = "webmaster@saftogsuse.no";
          } else{
            var receiver = "kontakt@saftogsuse.no";
          }
		
          var body = encodeURI(message)+"%0D%0A"+"%0D%0A"+encodeURI(name);
          window.location.href='mailto:'+receiver+'?subject='+encodeURI(subject)+'&body='+body;
        return false;
        }