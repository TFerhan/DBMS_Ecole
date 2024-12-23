<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/login.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Google-Style-Login-.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Login-Form-Basic-icons.css">
</head>

<body>
<section class="position-relative py-4 py-xl-5"></section>
<div class="login-card"><img class="profile-img-card" src="${pageContext.request.contextPath}/static/img/avatar_2x.bmp">
    <p class="profile-name-card"> </p>
    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <span class="reauth-email"> </span>
        <input class="form-control" type="text" id="nomUtilisateur" name="nomUtilisateur" required="" placeholder="Username" autofocus="">
        <input class="form-control" type="password" id="motDePasse" name="motDePasse" required="" placeholder="Password">
        <div class="checkbox">
            <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Remember me</label></div>
        </div>
        <button class="btn btn-primary btn-lg d-block btn-signin w-100" type="submit">Sign in</button>
    </form>
    <a class="forgot-password" href="#">Forgot your password?</a>
</div>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/login.min.js"></script>
</body>

</html>