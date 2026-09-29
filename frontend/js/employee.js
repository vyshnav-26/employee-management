function deleteEmployee(id) {
    fetch(`http://localhost:8080/employees/${id}`, {
        method: 'DELETE'
    })
        .then(data => {
            console.log("deleted employee ", id);
        })
}

fetch('http://localhost:8080/employees', {
    method: 'GET'
})
    .then(res => res.json())
    .then(data => {
        console.log(data);
        const table = document.getElementById("Employees");
        data.forEach(employee => {
            const row = document.createElement("tr");
            const idCell = document.createElement("td");
            idCell.textContent = employee.id;
            row.appendChild(idCell);
            const roleCell = document.createElement("td");
            roleCell.textContent = employee.role;
            row.appendChild(roleCell);
            const nameCell = document.createElement("td");
            nameCell.textContent = employee.name;
            row.appendChild(nameCell);
            const emailCell = document.createElement("td");
            emailCell.textContent = employee.email;
            row.appendChild(emailCell);
            const buttonCell = document.createElement("td");
            const button = document.createElement("button");
            button.textContent = "Delete";
            button.className = "button";
            button.addEventListener("click", () => {
                deleteEmployee(employee.id);
                row.remove();
            });
            buttonCell.appendChild(button);
            row.appendChild(buttonCell);

            table.appendChild(row);
        });
    });

