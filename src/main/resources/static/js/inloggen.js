function validateEmail() {
    var x = document.forms["form"]["email"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
}


function checkForm() {
    var x, text;
    x = document.forms["email"].value;
    if (x === "") {
        text = "Vul je e-mailadres in"
    }
    document.forms["email"].innerHTML = text;
    return false;
}

function veldVerplicht() {
    var x, text;
    x = document.getElementById("email").value;

    if (x === "") {
        text = "Vul je e-mailadres in"

    }

    document.getElementById("demo").innerHTML = text;

}

function validateForm() {
    var x = document.forms["form"]["email"].value;
    if (x === "") {
        alert("Name must be filled out");
        return false;
    }
}