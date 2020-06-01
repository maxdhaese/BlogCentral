var password = document.getElementById("password"),
  confirm_password = document.getElementById("confirm_password");


var isValid = false

function validatePassword() {
  console.log("ok")
  if (password.value != confirm_password.value) {
    console.log("in if")
    confirm_password.setCustomValidity("Passwords Don't Match");
    isValid = false;
  } else {
    console.log("in else")
    confirm_password.setCustomValidity('');
    isValid = true;
  }
}

var removeChars = () => {
  // Extract the validity parameter
  var userNameValid = document.getElementById("username").validity.valid
  var firstNameValid = document.getElementById("firstname").validity.valid
  var lastNameValid = document.getElementById("lastname").validity.valid
  var emailValid = document.getElementById("email").validity.valid
  var passwordValid = document.getElementById("password").validity.valid
  var confirm_passwordValid = document.getElementById("confirm_password").validity.valid

  if (userNameValid && firstNameValid && lastNameValid && emailValid && passwordValid && confirm_passwordValid) {
    // all good
  } else {
    confirm_password.value = "";
    password.value = "";
  }

}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;