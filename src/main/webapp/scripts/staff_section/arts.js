/* ------------- animation ------------- */

function openUpdate(id, name, desc, artist, length, height) {
    document.getElementById("update-Id").value = id;
    document.getElementById("update-name").value = name;
    document.getElementById("update-desc").value = desc;
    document.getElementById("update-artist").value = artist;
    document.getElementById("update-length").value = length;
    document.getElementById("update-height").value = height;
    document.getElementById("update-panel").style.display = "flex";
}

function closeUpdate() {
    document.getElementById("update-panel").style.display = "none";
}

function openInsert() {
    document.getElementById('insert-entity').textContent = 'Insert Product';
    document.getElementById("insert-panel").style.display = "flex";
}

function closeInsert() {
    document.getElementById("insert-panel").style.display = "none";
}


/* ------------- function ------------- */

function updateTable(json) {
    let table = document.querySelector(".tbody_arts");
    table.innerHTML = " ";
    json.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
                <td>${item.name}</td>
                <td>${item.desc}</td>
                <td>${item.artist}</td>
                <td>${item.length}</td>
                <td>${item.height}</td>
                <td>
                    <button onclick="openUpdate('${item.art_id}', '${item.name}', 
                    '${item.desc}', '${item.artist}', '${item.length}', '${item.height}')">
                        <i class='bx bxs-edit icon'></i>
                    </button>
                    <button onclick="deleteResource('${item.art_id}')">
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
    xhttp.open("POST", "staff-art-servlet?op=delete_art&id=" + id);
    xhttp.send();
}

function updateResource(formData) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            closeUpdate();
            let json = JSON.parse(this.response);
            updateTable(json);
        }
    };
    xhttp.open("POST", "staff-art-servlet?op=update_art");
    xhttp.send(formData);
}

document.getElementById('update-form').onsubmit = function(event) {
    event.preventDefault();
    const formData = new FormData();
    formData.append('id', document.getElementById('update-Id').value);
    formData.append('name', document.getElementById('update-name').value);
    formData.append('desc', document.getElementById('update-desc').value);
    formData.append('artist', document.getElementById('update-artist').value);
    formData.append('length', document.getElementById('update-length').value);
    formData.append('height', document.getElementById('update-height').value);

    const coverFile = document.getElementById('update-cover').files[0];
    if (coverFile) {
        formData.append('cover', coverFile);
    }

    updateResource(formData);
};

function insertResource(formData) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            closeInsert();
            let json = JSON.parse(this.response);
            updateTable(json);
        }
    };
    xhttp.open("POST", "staff-art-servlet?op=insert_art");
    xhttp.send(formData);
}

document.getElementById('insert-form').onsubmit = function(event) {
    event.preventDefault();
    const formData = new FormData();
    formData.append('name', document.getElementById('insert-name').value);
    formData.append('desc', document.getElementById('insert-desc').value);
    formData.append('artist', document.getElementById('insert-artist').value);
    formData.append('length', document.getElementById('insert-length').value);
    formData.append('height', document.getElementById('insert-height').value);

    const coverFile = document.getElementById('insert-cover').files[0];
    if (coverFile) {
        formData.append('cover', coverFile);
    }

    insertResource(formData);
};