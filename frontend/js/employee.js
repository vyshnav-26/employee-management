function deleteEmployee(id) {
    fetch(`http://localhost:8080/employees/${id}`, {
        method: 'DELETE'
    })
        .then(data => {
            console.log("deleted employee ", id);
        })
}
function updateEmployee(id, role, name, email) {
    fetch(`http://localhost:8080/employees/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/JSON' },
        body: JSON.stringify({ name, role, email })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data);
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
            row.id = employee.id;
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
        const row = document.createElement("tr");
        const idCell = document.createElement("td");
        const idInput = document.createElement("input");
        idCell.appendChild(idInput);
        row.appendChild(idCell);
        const roleCell = document.createElement("td");
        const roleInput = document.createElement("input");
        roleCell.appendChild(roleInput);
        row.appendChild(roleCell);
        const nameCell = document.createElement("td");
        const nameInput = document.createElement("input");
        nameCell.appendChild(nameInput);
        row.appendChild(nameCell);
        const emailCell = document.createElement("td");
        const emailInput = document.createElement("input");
        emailCell.appendChild(emailInput);
        row.appendChild(emailCell);
        const updateCell = document.createElement("td");
        const updateButton = document.createElement("button");
        updateButton.textContent = "Update";
        updateButton.className = "update";
        updateButton.addEventListener("click", () => {
            updateEmployee(idInput.value, roleInput.value, nameInput.value, emailInput.value);
            document.getElementByID(idInput.value).remove();
        });
        updateCell.appendChild(updateButton);
        row.appendChild(updateCell);
        table.appendChild(row);
    });


