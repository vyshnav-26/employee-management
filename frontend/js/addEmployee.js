import {API} from "./config.js";
function submitForm() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const role = document.getElementById('role').value;

    fetch(`${API}/employees`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email, role })
    })
        .then(res => res.json())
        .then(data => {
            console.log(data);
            document.getElementById('output').textContent = "Submitted";
    });
    
}

window.submitForm = submitForm;