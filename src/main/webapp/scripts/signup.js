document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("registrationForm");
    const passwordInput = document.getElementById("password");
    const telefonoInput = document.getElementById("telefono");

    form.addEventListener("submit", function (event) {
        let isValid = true;
        let errorMessage = "";

        // Validazione password
        const password = passwordInput.value;
        const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

        if (!passwordRegex.test(password)) {
            isValid = false;
            errorMessage += "La password deve contenere almeno 8 caratteri, una lettera maiuscola, una minuscola, un numero e un carattere speciale.\n";
        }

        // Validazione numero di telefono
        const telefono = telefonoInput.value;
        const telefonoRegex = /^\d{9,15}$/;

        if (!telefonoRegex.test(telefono)) {
            isValid = false;
            errorMessage += "Il numero di telefono deve contenere solo cifre e avere una lunghezza compresa tra 9 e 15 caratteri.\n";
        }

        // Mostra errori se presenti
        if (!isValid) {
            alert(errorMessage);
            event.preventDefault(); // Blocca l'invio del form
        }
    });
});
