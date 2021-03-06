<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <style type="text/css">

        </style>


        <title>Sign Up</title>

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
        <!--<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">-->

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
        <script>
            function updateDepartments() {
                var id = document.getElementById("country_list_id").value;

                $.ajax({
                    url: `${pageContext.request.contextPath}/country/${"${id}"}`,
                                type: 'POST',
                                dataType: 'json',
                                success: function (json) {
                                    document.getElementById('country_list_department_id').innerHTML = "";
                                    $.each(json, function (key, value) {
                                        $('<option></option>', {text: value}).attr('value', key).appendTo('#country_list_department_id');
                                    });
                                    updateMuni();
                                }
                            });
                        }

                        function updateMuni() {
                            var id = document.getElementById("country_list_department_id").value;
//                console.log("ENTRO");
                            $.ajax({
                                url: `${pageContext.request.contextPath}/department/${"${id}"}`,
                                            type: 'POST',
                                            dataType: 'json',
                                            success: function (json) {
//                        console.log("ENTRO");
                                                document.getElementById('country_list_department_municipality_id').innerHTML = "";
                                                $.each(json, function (key, value) {
//                            console.log(value);
                                                    $('<option></option>', {text: value}).attr('value', key).appendTo('#country_list_department_municipality_id');
                                                });
                                            }
                                        });
                                    }
                                    function clearMunicipalities() {
                                        document.getElementById('country_list_department_municipality_id').innerHTML = "";
                                    }
                                    function clearDepartments() {
                                        document.getElementById('country_list_department_id').innerHTML = "";
                                    }
                                    $(document).ready(function () {
                                        updateDepartments();
                                        $("#country_list_id").on("change", function () {
                                            clearMunicipalities();
                                            clearDepartments();
                                            updateDepartments();
                                        });
                                        $("#country_list_department_id").on("change", function () {
                                            clearMunicipalities();
                                            updateMuni();
                                        });
                                    });

        </script>
    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-6 col-lg-6 col-md-6">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <!--              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>-->
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h6 text-gray-900 mb-4">Registro de usuario en el sistema</h1>
                                            <h2 class="h6 text-gray-900 mb-4">Inserte sus datos personales</h2>
                                            ${respuesta}
                                        </div>
                                        <form action="${pageContext.request.contextPath}/sign-in">
                                            <div class="form-group">
                                                Nombres y Apellidos
                                                <input type="text" class="form-control form-control-user" name="personalInfo.name" id="inputName">
                                            </div>
                                            <div class="form-group">
                                                E-mail
                                                <input type="email" class="form-control form-control-user" name="email" id="inputEmail">
                                            </div>
                                            <div class="form-group">
                                                Contrase�a
                                                <input type="password" class="form-control form-control-user" name="password" id="inputPassword">
                                            </div>
                                            <div class="form-group">
                                                G�nero
                                                <div class="form-group">
                                                    <select class="form-control" name="personalInfo.gender.idGender">
                                                        <c:forEach items="${genders}" var="gender">
                                                            <option value="${gender.idGender}">${gender.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="country_list">Pa�s</label> 
                                                <select class="custom-select" id="country_list_id" name="country.idCountry" aria-describedby="country_listHelp" required> 
                                                    <c:forEach items="${country_list}" var="country">
                                                        <option value="${country.idCountry}">${country.name}</option>
                                                    </c:forEach>
                                                </select> 
                                            </div>
                                            <div class="form-group">
                                                <label for="country_department_list">Departamento/Estado</label> 
                                                <select class="custom-select" id="country_list_department_id" name="countryDepartment.idCountryDepartment" aria-describedby="country_listHelp" required> 
                                                    <option selected>N/A</option>
                                                </select> 
                                                <small id="nameHelp" class="form-text text-muted">Seleccione el departamento.</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="country_department_list">Municipio</label> 
                                                <select class="custom-select" id="country_list_department_municipality_id" name="municipality.idMunicipality" aria-describedby="country_listHelp" required> 
                                                    <option selected>N/A</option>
                                                </select> 
                                                <small id="nameHelp" class="form-text text-muted">Seleccione el municipio.</small>
                                            </div>
                                            <div class="form-group">
                                                Departamento de Trabajo en Glasswings
                                                <div class="form-group">
                                                    <select class="form-control" name="department.idDepartment">
                                                        <c:forEach items="${departments}" var="department">
                                                            <option value="${department.idDepartment}">${department.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                Cargo de Trabajo en Glasswings
                                                <div class="form-group">
                                                    <select class="form-control" name="position.idPosition">
                                                        <c:forEach items="${positions}" var="position">
                                                            <option value="${position.idPosition}">${position.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>
                                            <button type="submit" class="btn btn-primary btn-user">
                                                Registrarse
                                            </button>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin-2.min.js"></script>

    </body>

</html>

