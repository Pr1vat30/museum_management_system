<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<section class="box-info">
  <ul id = "functions">
    <li>
      <a href="visitors-nav-servlet?pg=art"> <!-- Link per Esposizioni -->
        <i class="icon">🎨</i>
        <div class="text">
          <h3>Esposizioni</h3>
          <p>Scopri le nostre esposizioni permanenti e temporanee.</p>
        </div>
      </a>
    </li>
    <li>
      <a href="visitors-nav-servlet?pg=event"> <!-- Link per Eventi -->
        <i class="icon">📅</i>
        <div class="text">
          <h3>Eventi</h3>
          <p>Partecipa agli eventi culturali organizzati dal museo.</p>
        </div>
      </a>
    </li>
    <li>
      <a href="visitors-nav-servlet?pg=notification"> <!-- Link per Visite Guidate -->
        <i class="icon">📰</i>
        <div class="text">
          <h3>News</h3>
          <p>Rimani aggiornato.</p>
        </div>
      </a>
    </li>
  </ul>
</section>
<!-- Dialog Box per Manutenzione -->
<div id="overlay"></div>
<div id="maintenanceDialog">
  <h2>In Manutenzione</h2>
  <p>Questa sezione è attualmente in manutenzione. Torna presto!</p>
  <button class="close-btn" onclick="closeMaintenanceDialog()">Chiudi</button>
</div>

<script>
  // Funzione per aprire il dialog box
  function showMaintenanceDialog() {
    document.getElementById('overlay').style.display = 'block';
    document.getElementById('maintenanceDialog').style.display = 'block';
  }

  // Funzione per chiudere il dialog box
  function closeMaintenanceDialog() {
    document.getElementById('overlay').style.display = 'none';
    document.getElementById('maintenanceDialog').style.display = 'none';
  }
</script>

