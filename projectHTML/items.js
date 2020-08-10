function readAll() { 
    console.log(sessionStorage.getItem('userName'));
    fetch('http://localhost:8030/item/readAll/' + sessionStorage.getItem('userName'))
    .then(
        function(response) {
            if (response.status !== 200) {
                console.log('Looks like there was a problem. Status Code: ' +
                response.status);
                return;
            }

        // Examine the text in the response
            response.json().then(function(data) {
            console.log(data);
            for (let i = 0; i < 100; i++) {
                console.log(document.querySelector("#resp").innerHTML = data[i].itemID);
                console.log(document.querySelector("#resp").innerHTML = data[i].title);
                console.log(document.querySelector("#resp").innerHTML = data[i].description);
                console.log(document.querySelector("#resp").innerHTML = data[i].dueBy);
                console.log(document.querySelector("#resp").innerHTML = data[i].complete);
                let para = document.createElement("P"); // Create a <p> element
                para;
                para.className = "alert alert-danger col-md-8";
                para.innerText = `Item ID: ${(document.querySelector("#resp"
                ).innerHTML = data[i].itemID)} \n Title:  ${(document.querySelector(
                "#resp"
                ).innerHTML = data[i].title)} \n  Details : ${(document.querySelector(
                "#resp"
                ).innerHTML = data[i].description)} \n dueBy:  ${(document.querySelector(
                "#resp"
                ).innerHTML = data[i].dueBy)} \n Completed:  ${(document.querySelector(
                "#resp"
                ).innerHTML = data[i].complete)}`; // Insert text
                let myDiv = document.getElementById("todos");
                myDiv.appendChild(para);
            }
            });
        }
    )
    .catch(function(err) {
        console.log('Fetch Error :-S', err);
    });
}

function readAllIncomplete() { 
  console.log(sessionStorage.getItem('userName'));
  fetch('http://localhost:8030/item/readByIncompled/' + sessionStorage.getItem('userName'))
  .then(
      function(response) {
          if (response.status !== 200) {
              console.log('Looks like there was a problem. Status Code: ' +
              response.status);
              return;
          }

      // Examine the text in the response
          response.json().then(function(data) {
          console.log(data);
          for (let i = 0; i < 100; i++) {
              console.log(document.querySelector("#resp").innerHTML = data[i].itemID);
              console.log(document.querySelector("#resp").innerHTML = data[i].title);
              console.log(document.querySelector("#resp").innerHTML = data[i].description);
              console.log(document.querySelector("#resp").innerHTML = data[i].dueBy);
              console.log(document.querySelector("#resp").innerHTML = data[i].complete);
              let para = document.createElement("P"); // Create a <p> element
              para;
              para.className = "alert alert-danger col-md-8";
              para.innerText = `Item ID: ${(document.querySelector("#resp"
              ).innerHTML = data[i].itemID)} \n Title:  ${(document.querySelector(
              "#resp"
              ).innerHTML = data[i].title)} \n  Details : ${(document.querySelector(
              "#resp"
              ).innerHTML = data[i].description)} \n dueBy:  ${(document.querySelector(
              "#resp"
              ).innerHTML = data[i].dueBy)} \n Completed:  ${(document.querySelector(
              "#resp"
              ).innerHTML = data[i].complete)}`; // Insert text
              let myDiv = document.getElementById("todos");
              myDiv.appendChild(para);
          }
          });
      }
  )
  .catch(function(err) {
      console.log('Fetch Error :-S', err);
  });
}

function completeItem(){
  var itemID = document.getElementById('input1').value
    fetch('http://localhost:8030/item//markCompleted/'+ sessionStorage.getItem('userName') +'/' + itemID)
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
        window.location.href = ('http://127.0.0.1:5500/homepage2.html');
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}

function deleteItem() {
    var itemID = document.getElementById('input1').value
    fetch('http://localhost:8030/item/delete/'+ sessionStorage.getItem('userName') +'/' + itemID)
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
        window.location.href = ('http://127.0.0.1:5500/homepage.html');
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}

function addItem() {
    var title = document.getElementById('inputTitle').value
    var description = document.getElementById('inputDescription').value
    var dueBy = document.getElementById('inputDueDate').value
    console.log(title);
    console.log(description);
    console.log(dueBy);
    fetch('http://localhost:8030/item/addItem/'+ sessionStorage.getItem('userName') +'/' + title +'/' + description + '/' + dueBy + '/' + false)
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
        window.location.href = ('http://127.0.0.1:5500/homepage.html');
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
    alert('Fetch Error :-S', err);
  });
}