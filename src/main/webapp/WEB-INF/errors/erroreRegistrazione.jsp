<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Errore Registrazione</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/erroreRegistrazione.css">
</head>
<body>
<div class="container">
  <div class="error-message">
    <h1>Errore nella registrazione</h1>
    <p>Sembra che ci sia stato un problema con la tua registrazione. Per favore, riprova.</p>
    <p>Se il problema persiste riprova più tardi.</p>
    <a href="${pageContext.request.contextPath}//registrazione" class="retry-button">Riprova</a>
  </div>
</div>
</body>
</html>
