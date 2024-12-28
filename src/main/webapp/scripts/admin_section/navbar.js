
/* ------------- navbar styling ------------- */

const navBar = document.querySelector("nav");
const menuBtns = document.querySelectorAll(".menu-icon");
const overlay = document.querySelector(".overlay");

menuBtns.forEach((menuBtn) => {
    menuBtn.addEventListener("click", () => {
        navBar.classList.toggle("open");
    });
});

overlay.addEventListener("click", () => {
    navBar.classList.remove("open");
});

document.getElementById('logout').addEventListener('click', (evt) => {
    evt.preventDefault();
    Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "logout"
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.replace('auth-servlet?op=logout');
        }
    });
})


