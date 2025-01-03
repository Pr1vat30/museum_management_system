/* ------------- animation ------------- */

function openUpdate(id, title, object, content, entity) {
    document.getElementById('update-entity').textContent = 'Update ' + entity;
    document.getElementById("update-Id").value = id;
    document.getElementById("update-title").value = title;
    document.getElementById("update-object").value = object;
    document.getElementById("update-content").value = content;
    document.getElementById("update-panel").style.display = "flex";
}

function closeUpdate() {
    document.getElementById("update-panel").style.display = "none";
}

function openInsert(entity) {
    document.getElementById('insert-entity').textContent = 'Insert ' + entity;
    document.getElementById("insert-panel").style.display = "flex";
}

function closeInsert() {
    document.getElementById("insert-panel").style.display = "none";
}

/* ------------- function ------------- */

function updateTable(json, type) {
    let table = document.querySelector(".tbody_" + type);
    table.innerHTML = " ";
    json.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
                    <td>${item.title}</td>
                    <td>${item.object}</td>
                    <td>${item.send_date}</td>
                    <td>
                        <button onclick="openUpdate('${item.message_id}', '${item.title}', '${item.object}', '${item.content}', '${type}')">
                            <i class='bx bxs-edit icon'></i>
                        </button>
                        <button onclick="deleteResource('${type}', ${item.message_id})">
                            <i class='bx bx-trash icon'></i>
                        </button>
                    </td>
                `;
        table.appendChild(row);
    });
}

function deleteResource(type, id) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let json = JSON.parse(this.response);
            updateTable(json, type);
        }
    };
    xhttp.open("GET", "admin-message-servlet?op=delete_message" + "&id=" + id);
    xhttp.send();
}

function updateResource(entity) {
    let array = document.getElementById('update-entity').textContent.split(" ");
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            closeUpdate();
            let json = JSON.parse(this.response);
            updateTable(json, array[1].toLowerCase());
        }
    };
    xhttp.open("POST", "admin-message-servlet?op=update_message");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(entity));
}

document.getElementById('update-form').onsubmit = function(event) {
    event.preventDefault();
    let array = document.getElementById('update-entity').textContent.split(" ");
    const entity = {
        message_id: document.getElementById('update-Id').value,
        title: document.getElementById('update-title').value,
        object: document.getElementById('update-object').value,
        content: document.getElementById('update-content').value,
    };
    updateResource(entity);
};

function insertResource(entity) {
    let array = document.getElementById('insert-entity').textContent.split(" ");
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            closeInsert();
            let json = JSON.parse(this.response);
            updateTable(json, array[1].toLowerCase());
        }
    };
    xhttp.open("POST", "admin-message-servlet?op=insert_message");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(entity));
}

document.getElementById('insert-form').onsubmit = function(event) {
    event.preventDefault();
    let array = document.getElementById('insert-entity').textContent.split(" ");
    const entity = {
        title: document.getElementById('insert-title').value,
        object: document.getElementById('insert-object').value,
        content: document.getElementById('insert-content').value,
    };
    insertResource(entity);
};








