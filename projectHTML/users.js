
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
    fetch('http://localhost:8030/user/createUser/' + username + '/' + password + '/' + email + '/ '+ firstName + '/' +surname)
    .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.text().then(function(data) {
        if (data == "User created"){
          sessionStorage.setItem('userName', username);
          console.log(sessionStorage.getItem('userName'));
          window.location.href = ('http://127.0.0.1:5500/homepage.html');
        }
        console.log(data);
        alert(data);
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}

// Logs in user after user presses submit on log in page
function authUser(){
    var username = document.getElementById('inputUsername').value;
    var password = document.getElementById('inputPassword').value;
    console.log(username);
    console.log(password);
    fetch('http://localhost:8030/user/authUser/'+ username + '/' + password)
    .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.text().then(function(data) {
        if (data == "Succesful"){
          sessionStorage.setItem('userName', username);
          console.log(sessionStorage.getItem('userName'));
          window.location.href = ('http://127.0.0.1:5500/homepage.html');
        }
        console.log(data);
        alert(data);
      });
    }
    )
    .catch(function(err) {
        console.log('Fetch Error :-S', err);
    });
}

function updateUser(){
    var email = document.getElementById('inputEmail').value;
    var firstName = document.getElementById('inputFirstName').value;
    var surname = document.getElementById('inputSurname').value;
    fetch('http://localhost:8030/user/updateUser/'+ sessionStorage.getItem('userName') + '/' + email + '/' + firstName + '/' + surname)
    .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
        response.status);
        return;
      }

      // Examine the text in the response
      response.text().then(function(data) {
        console.log(data);
        alert(data);
      });
    }
    )
    .catch(function(err) {
      console.log('Fetch Error :-S', err);
    });
}

function deleteUser(){
    window.location.assign()
}


// Code to call a method in spring boot and get return as response.text() or other format u set
// fetch('http://localhost:8030/user/authUser/username1/password2')
//   .then(
//     function(response) {
//       if (response.status !== 200) {
//         console.log('Looks like there was a problem. Status Code: ' +
//           response.status);
//         return;
//       }

//       // Examine the text in the response
//       response.text().then(function(data) {
//         console.log(data);
//         alert(data);
//       });
//     }
//   )
//   .catch(function(err) {
//     console.log('Fetch Error :-S', err);
//   });