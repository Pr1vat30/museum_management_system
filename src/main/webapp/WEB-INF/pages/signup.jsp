<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/login.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/signup.css">

    <title>Registration Page</title>
</head>
<body>
<section class="container signup-form">
    <div class="form signup">
        <div class="form-content">
            <header>Sign Up</header>
            <form action="#" method="post">
                <div class="section">
                    <label>User Credentials</label>

                    <div class="column">
                        <div class="field input-field">
                            <label>Full Name</label>
                            <input type="text" name="username" placeholder="Enter full name" required>
                        </div>
                        <div class="field input-field">
                            <label>Phone Number</label>
                            <input type="text" name="phone" placeholder="Enter phone number" required>
                        </div>
                    </div>

                    <div class="field email-field">
                        <div class="input-field">
                            <label>Email Address</label>
                            <input type="email" id="email" class="email" name="email" placeholder="Email" required>
                        </div>
                    </div>

                    <div class="field password-field">
                        <div class="input-field">
                            <label>Password</label>
                            <input type="password" id="password" class="password" name="password" placeholder="Enter password" required>
                            <i class='bx bxs-hide eye-icon'></i>
                        </div>
                    </div>

                    <div class="field c_password-field">
                        <div class="input-field">
                            <label>Confirm Password</label>
                            <input type="password" id="c_password" class="password" name="c_password" placeholder="Confirm password" required>
                            <i class='bx bxs-hide eye-icon'></i>
                        </div>
                    </div>
                </div>

                <div class="section">
                    <label>Payment Method</label>

                    <div class="field input-field">
                        <label>Card Number</label>
                        <input type="text" name="card_number" placeholder="Enter card number" required>
                    </div>

                    <div class="column">
                        <div class="field input-field">
                            <label>Card Expiry Date</label>
                            <input type="text" name="card_expiry_date" placeholder="Enter expiry date" required>
                        </div>
                        <div class="field input-field">
                            <label>Card Secret Code</label>
                            <input type="text" name="card_secret_code" placeholder="Enter secret code" required>
                        </div>
                    </div>
                </div>

                <div class="field button-field">
                    <button type="submit">Sign Up</button>
                </div>

                <div class="form-link">
                    <span>Already have an account? <a href="access-servlet?pg=login" class="link login-link">Login</a></span>
                </div>
            </form>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/scripts/signup.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</section>
</body>
</html>

