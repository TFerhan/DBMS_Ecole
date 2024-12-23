<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Professor List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/admin.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fonts/admin/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Tamplate-SB-Admin-on-BSS.css">
</head>

<body>
<div>
    <nav class="navbar navbar-expand bg-dark sb-topnav navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/static/img/desk.jpg" style="width: 28px;margin-right: 10px;border-width: 3px;border-style: solid;border-radius: 8px;">
                &nbsp;Your Brand
            </a>
            <ul class="navbar-nav d-flex order-3 ms-auto ms-md-0">
                <li class="nav-item d-flex justify-content-center align-items-center">
                    <div class="nav-item dropdown no-arrow">
                        <a class="dropdown-toggle active" aria-expanded="false" data-bs-toggle="dropdown" href="#">
                            &nbsp;<img class="rounded-circle" src="${pageContext.request.contextPath}/static/img/boy.jpg" style="width: 40px;border-width: 2px;border-style: solid;">
                        </a>
                        <div class="dropdown-menu dropdown-menu-end text-start shadow" style="margin-top: 16px;">
                            <a class="dropdown-item" href="#">Settings</a>
                            <a class="dropdown-item" href="#">Activity Log</a>
                            <a class="dropdown-item" href="#">Violations</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Logout</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <div id="sidenavAccordion" class="sb-sidenav accordion sb-sidenav-dark">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading"><span>Management</span></div>
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/professors">
                            <div class="sb-nav-link-icon"><i class="fa fa-users"></i></div>
                            <span>Professors</span>
                        </a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/filieres">
                            <div class="sb-nav-link-icon"><i class="fa fa-building"></i></div>
                            <span>Filieres</span>
                        </a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/modules">
                            <div class="sb-nav-link-icon"><i class="fa fa-book"></i></div>
                            <span>Modules</span>
                        </a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/elements">
                            <div class="sb-nav-link-icon"><i class="fa fa-puzzle-piece"></i></div>
                            <span>Elements</span>
                        </a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/evaluation-modes">
                            <div class="sb-nav-link-icon"><i class="fa fa-tasks"></i></div>
                            <span>Evaluation Modes</span>
                        </a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/user-accounts">
                            <div class="sb-nav-link-icon"><i class="fa fa-user"></i></div>
                            <span>User Accounts</span>
                        </a>
                    </div>
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">
                        <span>Logged in as: ${sessionScope.user.nomUtilisateur}</span>
                    </div>
                </div>
            </div>
        </div>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Professors</h1>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fa fa-table me-1"></i>
                            Professor List
                            <a href="${pageContext.request.contextPath}/admin/professors/add" class="btn btn-primary btn-sm float-end">Add Professor</a>
                        </div>
                        <div class="card-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Speciality</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="professor" items="${professors}">
                                    <tr>
                                        <td>${professor.code}</td>
                                        <td>${professor.nom} ${professor.prenom}</td>
                                        <td>${professor.specialite}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/admin/professors/edit/${professor.code}" class="btn btn-warning btn-sm">Edit</a>
                                            <a href="${pageContext.request.contextPath}/admin/professors/delete/${professor.code}" class="btn btn-danger btn-sm">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/admin.min.js"></script>
</body>

</html>