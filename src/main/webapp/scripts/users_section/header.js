const nav = document.querySelector("header"),
    search = document.querySelector("#search-icon"),
    burger_open = document.querySelector(".burger-open"),
    burger_close = document.querySelector(".burger-close");

search.addEventListener('click', () => {
    nav.classList.toggle('open-search');
    nav.classList.remove("open-nav");
    if ( nav.classList.contains('open-search') )
        return search.classList.replace('bx-search', 'bx-x');
    search.classList.replace('bx-x', 'bx-search');
})

burger_open.addEventListener('click', () => {
    nav.classList.add("open-nav");
    nav.classList.remove("open-search");
    search.classList.replace('bx-x', 'bx-search');
});

burger_close.addEventListener("click", () => {
    nav.classList.remove("open-nav");
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
            sessionStorage.clear();
            window.location.replace('auth-servlet?op=logout');
        }
    });
})
