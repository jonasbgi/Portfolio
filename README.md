# Portfolio
Samples of code uploaded to be viewed by potential employers. Feel free to download and view, but please the following about the samples: 

-- SaftogSuse -- 
This was a webtechnology project with 4 other students. Therefore, some code was not done by me, but is needed to make the page function properly. The work by me is: eplepresser.html, presses-click.js and some parts of the css-file. 

-- Java -- 
All this code is done by me as homework. Some code may not run properly on your computer as it may be used by a framework made by our professor. The purpose is, however, to show how I write and structure the code (i.e. comments, loops and if-statements). 

-Card-
This was 2 separate pieces of homework. 
Card.Java is a class containing fields for suite and face, and some get-methods (including toString). Later, a compareTo-method was added as part of a framework-excercise. 
CardDeck.Java is a class containg an even number of Card-objects. It has methods to get the card at index n (getCard), and to shuffle the deck (shufflePerfectly). 
CardComparator.Java implements the Comparator-interface with Card-objects. It compares two Card-objects, and returns 1, 0, or -1 based on comparison. The constructor takes arguments to determine trumf and if ace is highest or lowest. 

-Person-
The Person-objects are designed to link to other Person-objects trough variables. It has fields for gender, mom, dad, and children, where the last three are of the Person-type. It has methods for setFather/setMother, addChild, and likewise removeChild.
When designing this class, I needed to make sure method-calls did not recurse infinitely. This is because calling any method calls the corresponding method in the other class in question. That is, for example, setFather calls addChild, and addChild calls setFather. 
This was solved by implementing get-methods, and calling these before calling set/add-methods. 
