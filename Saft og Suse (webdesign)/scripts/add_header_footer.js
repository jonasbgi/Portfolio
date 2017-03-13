/*
FILE NAME: add_header_footer.js
WRITTEN BY: Zawadi Berg Svela
WHEN: November 2016
PURPOSE: This script creates the HTML for our header and footer.

*/

document.addEventListener("DOMContentLoaded",function(e){
	const header = document.querySelector("header")
	header.innerHTML = "<div id='navbar'>"
		+	"<ul>"
			+	"<li id='header_logo'><a href='index.html'><img src='img/logo_60x34.png' type='image/png'/></a></li>"
			+	"<li><a class='header_text_link' href='om_oss.html'>Om oss</a></li>"
			+	"<li><a class='header_text_link' href='eplesorter.html'>Eplesorter</a></li>"
			+	"<li><a class='header_text_link' href='eplepresser.html'>Eplepresser</a></li>"
			+	"<li><a class='header_text_link' href='pressing.html'>Pressing</a></li>"
			+	"<li><a class='header_text_link' href='cider.html'>Cider</a></li>"
			+	"<li><a class='header_text_link' href='kontakt.html'>Kontakt oss</a></li>"
			+	'<li id="header_fb_logo"><a href="https://www.facebook.com/groups/482042088611960/"><img src="img/fb_logo_g.png" onmouseover=this.src="img/fb_logo_b.png" onmouseout=this.src=src="img/fb_logo_g.png" type="image/png"/></a></li>'
		+	"</ul>"
	+	"</div>"
	+"<img src='img/banner.jpg' type='image/jpg' id='banner'>"
	const footer = document.querySelector("footer")
	footer.innerHTML = "<div><img src='img/logo_footer.png' alt='logo' id='aboutLogo'/></div>"
		+"<div class='footer_text'>"
			+"<h3>Siden er utviklet av:</h3>"
			+"<p>Ine Lofthus Arnesen, Jonas Giske, Zawadi Berg Svela, Astrid Vik og Aslak Hollund</p>"
		+"</div>"
		+"<div class='footer_text'>"
			+"<h3>Kontakt oss</h3>"
			+"<p>For kontakt med webmaster eller Saft & Suse se <a href='kontakt.html'>kontaksskjemaet</a></p>"
		+"</div>"
		+"<div class='footer_text'>"
			+"<h3>Bli med i gruppen</h3>"
			+'<a href="https://www.facebook.com/groups/482042088611960/"><img src="img/fb_logo_g.png" onmouseover=this.src="img/fb_logo_b.png" onmouseout=this.src=src="img/fb_logo_g.png" type="image/png"/></a>'
		+"</div>"
		+"<div class='footer_text'>"
			+"<h3>Sideoversikt</h3>"
			+"<p>Klikk <a href='site_map.html'>her</a> for sideoversikt</p>"
		+"</div>"
})
