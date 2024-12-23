<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
    <meta charset="UTF-8">
    <title>Registrazione Utente</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/signup.css">
    <script src="${pageContext.request.contextPath}/scripts/signup.js" defer></script>
  </head>
  <body>
  <header>
    <jsp:include page="header.jsp"/>
  </header>
  <div class="form-container">
    <h2>Registrazione</h2>
    <form id="registrationForm" action="${pageContext.request.contextPath}//registrazione" method="post">
      <!-- Nome -->
      <label for="nome">Nome</label>
      <input
              type="text"
              id="nome"
              name="nome"
              placeholder="Inserisci il tuo nome"
              required
              title="Il nome è obbligatorio e non può essere vuoto.">

      <!-- Cognome -->
      <label for="cognome">Cognome</label>
      <input
              type="text"
              id="cognome"
              name="cognome"
              placeholder="Inserisci il tuo cognome"
              required
              title="Il cognome è obbligatorio e non può essere vuoto.">

      <!-- Email -->
      <label for="email">Email</label>
      <input
              type="email"
              id="email"
              name="email"
              placeholder="Inserisci la tua email"
              required
              title="Inserisci un'email valida.">

      <!-- Password -->
      <label for="password">Password</label>
      <input
              type="password"
              id="password"
              name="password"
              placeholder="Inserisci la tua password"
              required
              minlength="8"
              title="La password deve contenere almeno 8 caratteri.">

      <!-- Numero di telefono -->
      <label for="telefono">Numero di Telefono</label>
      <input
              type="tel"
              id="telefono"
              name="telefono"
              placeholder="Inserisci il tuo numero di telefono"
              required
              pattern="^\d{9,15}$"
              title="Inserisci un numero di telefono valido con una lunghezza compresa tra 9 e 15 cifre.">

      <!-- Bottone di invio -->
      <button type="submit">Registrati</button>
    </form>
  </div>
  <footer>
    <jsp:include page="footer.jsp"/>
  </footer>
  </body>
  </html>

