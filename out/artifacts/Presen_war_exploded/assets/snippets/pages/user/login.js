function validForm() {
    var username = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var validUsername = document.getElementById("email-error");
    var validPassword = document.getElementById("password-error");

    var check = true;

    if(username.length === 0){
        validUsername.innerText = "This field is required.";
        if(password.length === 0)
            validPassword.innerText = "This field is required";
        if(password.length < 3 && password.length > 0)
            validPassword.innerText = "Password character require between 6-20 character";
        if(password.length >3)
            validPassword.innerText ="";
        check = false;
    }

    if(password.length === 0){
        validPassword.innerText = "This field is required.";
        if(username.length >0)
            validUsername.innerText ="";
        check = false;
    }
    if(password.length < 3 && password.length >0){
        validPassword.innerText = "Password character require between 6-20 character";
        if(username.length >0)
            validUsername.innerText ="";
        check = false;
    }

    return check;
}

