

fetch('http://localhost:8080/employees', {
    method: 'GET',
})
    .then(res => res.json())
    .then(data => {
        console.log(data),
            document.getElementById("output").textContent = data[0].name
    });

