/* ------------- animation ------------- */

function openUpdate(id, name, desc, start_date, end_date) {
    document.getElementById("update-Id").value = id;
    document.getElementById("update-name").value = name;
    document.getElementById("update-desc").value = desc;
    document.getElementById("update-start-date").value = start_date;
    document.getElementById("update-end-date").value = end_date;
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
    let table = document.querySelector(".tbody_event");
    table.innerHTML = " ";
    json.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
                <td>${item.event_id}</td>
                <td>${item.name}</td>
                <td>${item.desc}</td>
                <td>${item.start_date}</td>
                <td>${item.end_date}</td>
                <td>${item.n_seats}</td>
                <td>${item.n_seats_available}</td>
                <td>
                    <button onclick="openUpdate('${item.art_id}', '${item.name}', 
                    '${item.desc}', '${item.artist}', '${item.length}', '${item.height}')">
                        <i class='bx bxs-edit icon'></i>
                    </button>
                    <button onclick="deleteResource('${item.event_id}')">
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
    xhttp.open("POST", "staff-event-servlet?op=delete_event&id=" + id);
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
    xhttp.open("POST", "staff-event-servlet?op=update_event");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(entity));
}

document.getElementById('update-form').onsubmit = function(event) {
    event.preventDefault();
    const entity = {
        event_id: document.getElementById('update-Id').value,
        name: document.getElementById('update-name').value,
        desc: document.getElementById('update-desc').value,
        start_date: document.getElementById('update-start-date').value,
        end_date: document.getElementById('update-end-date').value,
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
    xhttp.open("POST", "staff-event-servlet?op=insert_event");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(entity));
}

document.getElementById('insert-form').onsubmit = function(event) {
    event.preventDefault();
    const entity = {
        name: document.getElementById('insert-name').value,
        desc: document.getElementById('insert-desc').value,
        seats: document.getElementById('insert-seats').value,
        start_date: document.getElementById('insert-start-date').value,
        end_date: document.getElementById('insert-end-date').value,
        ticket_type: document.getElementById('insert-ticket-type').value,
        ticket_price: document.getElementById('insert-ticket-price').value,
    };
    insertResource(entity);
};