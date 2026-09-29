function submitForm() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const role = document.getElementById('role').value;

    fetch('http://localhost:8080/employees', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email, role })
    })
        .then(res => res.json())
        .then(data => console.log(data));
    document.getElementById('output').textContent = "Submitted";
}