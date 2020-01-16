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
        <!--<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">-->

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

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
                                        </div>

                                <form action="${pageContext.request.contextPath}/signUser" method = "post" class="user">
                                    ${respuesta}
                                    <!--
                                            <div class="form-group">
                                                ID
                                              <input type="text" class="form-control form-control-user" name="id" id="inputId">
                                            </div> -->
                                            <div class="form-group">
                                                Nombre
                                              <input type="text" class="form-control form-control-user" name="name" id="inputName">
                                            </div>
                                            <div class="form-group">
                                                Apellido
                                              <input type="text" class="form-control form-control-user" name="lastname" id="inputLastName">
                                            </div>
                                            <div class="form-group">
                                                Usuario
                                              <input type="text" class="form-control form-control-user" name="username" id="inputUsername">
                                            </div>

                                             <div class="form-group">
                                                Contraseña
                                              <input type="password" class="form-control form-control-user" name="password" id="inputPassword">
                                            </div>
                                            <div class="form-group">
                                                E-mail
                                              <input type="text" class="form-control form-control-user" name="email" id="inputEmail">
                                            </div>
                                            <div class="form-group">
                                                Dirección
                                              <input type="text" class="form-control form-control-user" name="address" id="inputAddress">
                                            </div>
                                            <div class="form-group">
                                                Género
                                                <div class="form-group">
                                                  <select class="form-control" name="gender.idGender">
                                                         <c:forEach items="${genders}" var="gender">
                                                          <option value="${gender.idGender}">${gender.name}</option>
                                                           </c:forEach>
                                                  </select>
                                              </div>
                                              
                                            </div>
                                            <div class="form-group">
                                                Fecha de Nacimiento
                                            <input type="date" class="form-control" id="fechainc" >
                                        
                                            </div>
                                            
                                            <div class="form-group">
                                                Departamento del país
                                              <div class="form-group">

                                                  <select class="form-control" name="countryDepartment.idCountryDepartment">
                                                         <c:forEach items="${countryDepartments}" var="countryD">
                                                          <option value="${countryD.idCountryDepartment}">${countryD.name}</option>
                                                           </c:forEach>
                                                  </select>
                                              </div>
                                            </div>
                                            <div class="form-group">
                                                Municipio
                                            <div class="form-group">
                                                  <select class="form-control" name="municipality.idMunicipality">
                                                         <c:forEach items="${municipalities}" var="municipality">
                                                          <option value="${municipality.idMunicipality}">${municipality.name}</option>
                                                           </c:forEach>
                                                  </select>
                                              </div>
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
                                                Cargo
                                              <input type="text" class="form-control form-control-user" name="position" id="inputPosition">
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

