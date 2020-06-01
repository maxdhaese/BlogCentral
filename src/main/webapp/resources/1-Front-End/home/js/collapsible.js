// Smoot scroll
window.scrollBy({
    top: -200,
    left: 0,
    behavior: 'smooth'
});


// Collapsible "Sort" menu
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function () {
        this.classList.toggle("active");
        var content = this.nextElementSibling;
        if (content.style.display === "block") {
            content.style.display = "none";
        } else {
            content.style.display = "block";
        }
    });
}

///////////////////
// Button Back to top
///////////////////

mybutton = document.getElementById("myBtn");

// When the user scrolls down 500px from the top of the document, show the button
window.onscroll = function () { scrollFunction() };

function scrollFunction() {
    if (document.body.scrollTop > 500 || document.documentElement.scrollTop > 400) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}

/////////////////////
///// Popups 
/////////////////////

function popUpFunction() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
}

function alertFunction() {
    alert("You need to be logged in to do this");
}
