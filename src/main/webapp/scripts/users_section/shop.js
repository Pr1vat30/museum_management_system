function openShop(p1, p2, p3, p4, p5, p6) {
    document.getElementById("event_id").value = p1;
    document.getElementById("event-name").textContent = p2;
    document.getElementById("ticket_id").value = p3;
    document.getElementById("ticket-type").textContent = p4;
    document.getElementById("ticket-price").textContent = p5;
    document.getElementById("user_id").value = p6;
    document.getElementById("shop-panel").style.display = "flex";
    document.body.style.overflow = "hidden";
}

function closeShop() {
    document.getElementById("shop-panel").style.display = "none";
    document.body.style.overflow = "auto";
}

function insertPurchase(entity) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText.toLowerCase().includes("error")) {
                Swal.fire({
                    icon: "error",
                    title: "Error!",
                    text: "An error occurred during the purchase process.",
                });
            } else {
                closeShop();
                Swal.fire({
                    icon: "success",
                    title: "Good job!",
                    text: "Order placed!",
                }).then(() => {
                    location.reload();
                });
            }
        }
    };
    xhttp.open("POST", "users-shop-servlet?op=insert_purchase");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(entity));
}

document.getElementById('shop-form').onsubmit = function(event) {
    event.preventDefault();
    const entity = {
        event_id: document.getElementById('event_id').value,
        ticket_id: document.getElementById('ticket_id').value,
        user_id: document.getElementById('user_id').value,
        user_password: document.getElementById('user_password').value,
    };
    insertPurchase(entity);
};