
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

/* -------------------- utility for authentication -------------------- */

const emailField = document.querySelector(".email-field");

function checkMail() {
    const pattern = /^((?!\.)[\w-_.]*[^.])(@\w+)(\.\w+(\.\w+)?[^.\W])$/gim;
    let email = document.getElementById("email");
    if ( !email.value.match(pattern) ){
        emailField.classList.add("invalid");
        return false;
    } else {
        emailField.classList.remove("invalid");
        return true;
    }
}

/* -------------------- authentication system -------------------- */

const login_form = document.querySelector(".login-form");

login_form.addEventListener("submit", evt => {
    evt.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if ( checkMail() === true )
        checkUser(email, password);

    emailField.addEventListener("keyup", checkMail);
})

async function checkUser(email, password) {
    const body = new URLSearchParams({ email, password });

    try {
        const response = await fetch("login-servlet", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: body.toString()
        });

        if (response.ok) {
            const responseText = await response.text();

            if (responseText.includes("error")) {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Something went wrong!"
                });
            } else {
                // sessionStorage.removeItem('cart');
                window.location.replace(responseText);
            }
        } else {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: `Request failed with status: ${response.status}`
            });
        }
    } catch (error) {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Network error occurred. Please try again later!"
        });
    }
}


