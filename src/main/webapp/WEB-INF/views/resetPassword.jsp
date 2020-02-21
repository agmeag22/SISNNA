<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login</title>

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
                                            <h1 class="h6 text-gray-900 mb-4">BIENVENIDO A SISTEMA DE ALERTAS</h1>
                                            <h2 class="h6 text-gray-900 mb-4">Reiniciar contraseña</h2>
                                            <h2 class="h6 text-gray-900 mb-4">${respuesta}</h2>
                                        </div>
                                        <form action="${pageContext.request.contextPath}/reset" method = "post" class="user">
                                            
                                            <!--
                                            <div class="form-group">
                                                <input type="email" class="form-control form-control-user" name="email" id="idEmail" aria-describedby="emailHelp" placeholder="Ingrese su email">
                                            </div>
                                            -->
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user" name="passwordNew" id="inputPassword" placeholder="Contraseña nueva" oninput="check(this)">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user" name="passwordConfirm" id="inputPasswordConfirm" placeholder="Confirme contraseña nueva" oninput="check(this)">
                                            </div>
                                            <script language='javascript' type='text/javascript'>
                                                function check(input) {                                                                                                        
                                                    if((document.getElementById('inputPasswordConfirm').value === '') || (document.getElementById('inputPassword').value === '')){
                                                        //input.setCustomValidity('La contraseña no puede estar vacia');
                                                        //document.getElementByName("validacion").value("La contraseña no puede ir vacia");
                                                        document.getElementById("resetButton").setAttribute("disabled","disabled");
                                                    }else{
                                                        input.setCustomValidity('');
                                                        //document.getElementByName("validacion").value("");
                                                        document.getElementById("resetButton").removeAttribute("disabled");
                                                    }
                                                }
                                            </script>
                                            
                                            <input type="hidden" class="form-control form-control-user" name="tokenId" id="theToken" value="${resetToken}">
                                            
                                            <output name="validacion"></output>
                                           
                                            
                                            <button type="submit" class="btn btn-primary btn-user btn-block" id="resetButton" disabled="true">
                                                Reiniciar Contraseña
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

