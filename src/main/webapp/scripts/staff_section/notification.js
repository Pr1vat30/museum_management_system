function openDetails(id, title, content){
    document.getElementById('details-Id').value = id;
    document.getElementById('details-content').innerHTML = generateDetailsHTML(title, content)
    document.getElementById('details-panel').style.display = 'flex';
}

function closeDetails() {
    document.getElementById('details-panel').style.display = 'none';
}

function generateDetailsHTML(title, content) {
    return `
        <p><strong>Title: </strong>${title}</p><br>
        <p><strong>Content: </strong>${content}</p><br>
    `;
}