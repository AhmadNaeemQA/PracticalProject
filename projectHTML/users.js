
// Adds a user to the database after user presses submit on registration page
function addUser(){
    var username = document.getElementById('inputUsername').value;
    var password = document.getElementById('inputPassword').value;
    var email = document.getElementById('inputEmail').value;
    var firstName = document.getElementById('inputFirstName').value;
    var surname = document.getElementById('inputSurname').value;
    console.log(username);
    console.log(password);
    console.log(email);
    console.log(firstName);
    console.log(surname);
    window.location = ('homepage.html')
    //window.location = ('http://localhost:8003/createUser/'+ username + '/' + password + '/' + email + '/' + firstName + '/' + surname);
}

// Logs in user after user presses submit on log in page
function authUser(){
    var username = document.getElementById('inputUsername').value;
    var password = document.getElementById('inputPassword').value;
    console.log(username);
    console.log(password);
    //window.location = ('http://localhost:8003/authUser/'+ username + '/' + password)
}

function updateUser(){
    var email = document.getElementById('inputEmail').value;
    var firstName = document.getElementById('inputFirstName').value;
    var surname = document.getElementById('inputSurname').value;
    window.location = ('http://localhost:8003/updateUser/'+ userID + '/' + email + '/' + firstName + '/' + surname);
}