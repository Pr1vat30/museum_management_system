<%--
  Created by IntelliJ IDEA.
  User: salvatorenocera
  Date: 22/12/24
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href=./Styles/login.css>
    <title>Access Page</title>
</head>
<body>
<section class="container login-form">
    <div class="form login">
        <div class="form-content">
            <header>Login</header>
            <form action="#" method="post">
                <div class="field email-field">
                    <div class="input-field">
                        <input type="email" id="email" class="email" name="email" placeholder="Email" required>
                    </div>
                    <span class="error e-mail">
                        <i class='bx bx-error-circle error-icon'></i>
                        <p class="error-text">Please enter a valid email</p>
                    </span>
                </div>

                <div class="field password-field">
                    <div class="input-field">
                        <input type="password" id="password" class="password" name="password" placeholder="Password" required>
                        <i class='bx bxs-hide eye-icon'></i>
                    </div>
                </div>

                <div class="form-link">
                    <a href="#" class="forgot-pass">Forgot password?</a>
                </div>

                <div class="field button-field">
                    <button type="submit">Login</button>
                </div>

                <div class="form-link">
                    <span>Don't have an account? <a href="#" class="link signup-link">Sign Up</a></span>
                </div>
            </form>
        </div>
    </div>
</section>
<script src="./Scripts/login.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>