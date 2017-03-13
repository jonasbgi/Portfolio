/*
FILE NAME: enlarge_image.js
WRITTEN BY: Ine Lofthus Arnesen
WHEN: November 2016
PURPOSE: Display large versions of images when clicked.

This script, and the related html and css, are based on code
from http://alexapps.net/enlarge-thumbnail-image-mouse-click
*/


function showImage(smSrc, lgSrc) {
    var largeImage = document.getElementById('largeImg');
    largeImage.src = lgSrc;
    unselectAll();
    showLargeImagePanel();
    setTimeout(function() {                         /*Delays displaying the large image by 50ms the first time, */
        largeImage.style.display = 'inline-block';  /*in order to give it (some) time to load */               
    }, 10);

}

function showLargeImagePanel() {
    document.getElementById('largeImgPanel').style.display = 'block';
}


/*This function unselects any selected text in the bakground*/
function unselectAll() {     
    if(document.selection)
        document.selection.empty();
    if(window.getSelection)
        window.getSelection().removeAllRanges();
}
