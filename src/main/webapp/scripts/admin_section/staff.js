/* ------------- animation ------------- */

function openUpdate(id, name, surname, email, cf, salary, contract, password) {
    document.getElementById("update-Id").value = id;
    document.getElementById("update-name").value = name;
    document.getElementById("update-surname").value = surname;
    document.getElementById("update-email").value = email;
    document.getElementById("update-cf").value = cf;
    document.getElementById("update-salary").value = salary;
    document.getElementById("update-contract").value = contract;
    document.getElementById("update-password").value = password;
    document.getElementById("update-panel").style.display = "flex";
}

function closeUpdate() {
    document.getElementById("update-panel").style.display = "none";
}

function openInsert() {
    document.getElementById("insert-panel").style.display = "flex";
}

function closeInsert() {
    document.getElementById("insert-panel").style.display = "none";
}

/* ------------- function ------------- */

function updateTable(json) {
    let table = document.querySelector(".tbody_staff");
    table.innerHTML = " ";
    json.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
                    <td>${item.name} ${item.surname}</td>
                    <td>${item.email}</td>
                    <td>${item.staff_cf}</td>
                    <td>${item.salary}</td>
                    <td>${item.contract}</td>
                    <td>
                         <button onclick="openUpdate('${item.staff_id}', '${item.name}', '${item.surname}',
                                    '${item.email}', '${item.staff_cf}', '${item.salary}', '${item.contract}', '${item.password}')">
                            <i class='bx bxs-edit icon'></i>
                        </button>
                        <button onclick="deleteResource(${item.staff_id})">
                            <i class='bx bx-trash icon'></i>
                        </button>
                    </td>
                `;
        table.appendChild(row);
    });
}

function deleteResource(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let json = JSON.parse(this.response);
            updateTable(json);
        }
    };
    xhttp.open("GET", "admin-staff-servlet?op=delete_staff" + "&id=" + id);
    xhttp.send();
}

function updateResource(entity) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            closeUpdate();
            let json = JSON.parse(this.response);
            updateTable(json);
        }
    };
    xhttp.open("POST", "admin-staff-servlet?op=update_staff");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(entity));
}

document.getElementById('update-form').onsubmit = function(event) {
    event.preventDefault();
    const entity = {
        staff_id: document.getElementById('update-Id').value,
        name: document.getElementById('update-name').value,
        surname: document.getElementById('update-surname').value,
        email: document.getElementById('update-email').value,
        cf: document.getElementById('update-cf').value,
        password: document.getElementById('update-password').value,
        salary: document.getElementById('update-salary').value,
        contract: document.getElementById('update-contract').value,
    };
    updateResource(entity);
};

function insertResource(entity) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            closeInsert();
            let json = JSON.parse(this.response);
            updateTable(json);
        }
    };
    xhttp.open("POST", "admin-staff-servlet?op=insert_staff");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(entity));
}

document.getElementById('insert-form').onsubmit = function(event) {
    event.preventDefault();
    const entity = {
        name: document.getElementById('insert-name').value,
        surname: document.getElementById('insert-surname').value,
        email: document.getElementById('insert-email').value,
        cf: document.getElementById('insert-cf').value,
        password: document.getElementById('insert-password').value,
        salary: document.getElementById('insert-salary').value,
        contract: document.getElementById('insert-contract').value,
    };
    insertResource(entity);
};