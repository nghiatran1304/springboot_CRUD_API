const API_URL = "http://localhost:8080/api/customers";

function createCustomer() {
    const fullname = document.getElementById("fullname").value;
    const address = document.getElementById("address").value;
    const salary = document.getElementById("salary").value;

    const newCustomer = {
        fullname,
        address,
        salary
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(newCustomer),
    })
        .then(response => response.json())
        .then(data => {
            alert("Customer added!");
            location.reload();
        })
        .catch(error => console.error("Error:", error));
}

function searchCustomer() {
    const searchName = document.getElementById("searchName").value;
    fetch(`${API_URL}?name=${searchName}`)
        .then(response => response.json())
        .then(data => {
            displayCustomers(data);
        })
        .catch(error => console.error("Error:", error));
}

function displayCustomers(customers) {
    const table = document.getElementById("customersTable");
    table.innerHTML = "";
    customers.forEach(customer => {
        const row = table.insertRow();
        const nameCell = row.insertCell(0);
        nameCell.textContent = customer.fullname;

        const addressCell = row.insertCell(1);
        addressCell.textContent = customer.address;

        const actionsCell = row.insertCell(-1);
        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.onclick = function () {
            deleteCustomer(customer.id);
        };
        actionsCell.appendChild(deleteButton);

        const editButton = document.createElement("button");
        editButton.textContent = "Edit";
        editButton.onclick = function () {
            editCustomer(customer);
        };
        actionsCell.appendChild(editButton);
    });
}

function deleteCustomer(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE",
    })
        .then(response => {
            alert("Customer deleted!");
            location.reload();
        })
        .catch(error => console.error("Error:", error));
}

function editCustomer(customer) {
    alert(customer.id);
    document.getElementById("fullname").value = customer.fullname;
    document.getElementById("address").value = customer.address;
    document.getElementById("salary").value = customer.salary;

    const addButton = document.querySelector("button");
    addButton.textContent = "Update";
    addButton.onclick = function () {
        updateCustomer(customer.id);
    };
}

function updateCustomer(id) {
    const fullname = document.getElementById("fullname").value;
    const address = document.getElementById("address").value;
    const salary = document.getElementById("salary").value;

    const updatedCustomer = {
        id,
        fullname,
        address,
        salary
    };

    fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedCustomer),
    })
        .then(response => response.json())
        .then(data => {
            alert("Customer updated!");
            location.reload();
        })
        .catch(error => console.error("Error:", error));
}

// Khi trang tải xong, lấy danh sách khách hàng
window.onload = function () {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            displayCustomers(data);
        })
        .catch(error => console.error("Error:", error));
};