<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">GNotes App</a>
        <button class="btn btn-light" onclick="window.location.href='${pageContext.request.contextPath}/logout'">Logout</button>
    </div>
</nav>
<div class="container mt-5">
    <h1 class="text-center mb-4">Welcome, ${nomUtilisateur}!</h1>
    <p class="text-center text-muted">Choose a feature to manage:</p>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
        <div class="col">
            <div class="card shadow h-100">
                <div class="card-body text-center">
                    <h5 class="card-title">Gestion des Professeurs</h5>
                    <p class="card-text">Manage professors' data and schedules efficiently.</p>
                    <button
                            class="btn btn-primary w-100"
                            onclick="location.href='${pageContext.request.contextPath}/professeurs'">
                        Access
                    </button>
                </div>
            </div>
        </div>_,    </div>

    <div class="col">
            <div class="card shadow h-100">
                <div class="card-body text-center">
                    <h5 class="card-title">Gestion des Modules</h5>
                    <p class="card-text">Manage and organize all modules with ease.</p>
                    <button class="btn btn-primary w-100">Access</button>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow h-100">
                <div class="card-body text-center">
                    <h5 class="card-title">Gestion des Filières</h5>
                    <p class="card-text">Oversee various academic streams effectively.</p>
                    <button class="btn btn-primary w-100">Access</button>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow h-100">
                <div class="card-body text-center">
                    <h5 class="card-title">Gestion des Étudiants</h5>
                    <p class="card-text">Track student information and performance.</p>
                    <button class="btn btn-primary w-100">Access</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
