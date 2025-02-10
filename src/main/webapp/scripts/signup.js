
/* -------------------- icons animation system -------------------- */

const hide_eye = document.querySelectorAll(".eye-icon");

hide_eye.forEach(eyeIcon => {
    eyeIcon.addEventListener("click", () => {
        let password = eyeIcon.parentElement.querySelectorAll(".password");

        password.forEach(password => {
            if(password.type === "password"){
                password.type = "text";
                eyeIcon.classList.replace("bxs-hide", "bxs-show");
            } else {
                password.type = "password";
                eyeIcon.classList.replace("bxs-show", "bxs-hide");
            }
        })
    })
})

/* -------------------- utility -------------------- */

function validateForm(data) {
    if ( !data.email.match(/^((?!\.)[\w-_.]*[^.])(@\w+)(\.\w+(\.\w+)?[^.\W])$/gim) ){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Invalid email, try again!",
        });
        return false;
    }

    if ( !data.phone.match(/(?:([+]\d{1,4})[-.\s]?)?(?:[(](\d{1,3})[)][-.\s]?)?(\d{1,4})[-.\s]?(\d{1,4})[-.\s]?(\d{1,9})/g) ){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Invalid phone number, try again!",
        });
        return false;
    }

    if ( !data.password.match(/^((?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9]).{6,})\S$/) ){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Invalid password, try again!",
        });
        return false;
    }

    if ( data.password !== data.c_password ) {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Password don't match, try again!",
        });
        return false;
    }

    if ( !data.card_number.match(/^\d{16}$/) ) {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Invalid card number, try again!",
        });
        return false;
    }

    if ( !data.card_expiry_date.match(/^(0[1-9]|1[0-2])\/(0[1-9]|[12][0-9]|3[01])$/) ){
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Invalid expiry date, try again!",
        });
        return false;
    }

    if ( !data.card_secret_code.match(/^\d{3}$/) ) {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Invalid secret code, try again!",
        });
        return false;
    }

    return true
}

/* -------------------- validation system signup -------------------- */

const signup_form = document.querySelector(".signup-form");

signup_form.addEventListener('submit', evt => {
    evt.preventDefault();

    const formData = new FormData(evt.target);
    const data = {};

    formData.forEach((value, key) => {
        data[key] = value;
    });

    if (validateForm(data)) {
        addUser(data);
    }
});

async function addUser(data) {
    try {
        const response = await fetch("signup-servlet", {
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=UTF-8",
            },
            body: JSON.stringify(data),
        });

        if (response.ok) {
            const responseText = await response.text();
            if (responseText.includes("error")) {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Account already exists, try again!",
                });
            } else {
                window.location.replace(responseText);
            }
        } else {
            Swal.fire({
                icon: "error",
                title: "Server Error",
                text: "Unable to create the account. Please try again later.",
            });
        }
    } catch (error) {
        Swal.fire({
            icon: "error",
            title: "Network Error",
            text: "Unable to connect to the server. Please check your internet connection.",
        });
    }
}
