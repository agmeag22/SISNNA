<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<t:admin-template>
    <jsp:attribute name="styles">

    </jsp:attribute>
    <jsp:attribute name="title">Crear Usuario</jsp:attribute>
    <jsp:attribute name="marked">nuevo-usuario</jsp:attribute>
    <jsp:attribute name="scripts">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/new_user.css" type="text/css" media="screen">
        <script>
            function updateDepartments(){
                var id= document.getElementById("country_list_id").value;
                
                $.ajax({
                    url:`${pageContext.request.contextPath}/country/${"${id}"}`,
                    type:'POST',
                    dataType: 'json',
                    success: function( json ) {
                        document.getElementById('country_list_department_id').innerHTML = "";
                        $.each(json, function(key, value) {  
                           $('<option></option>', {text:value}).attr('value', key).appendTo('#country_list_department_id');
                        });
                        updateMuni();
                    }
                  });
            }
            
            function updateMuni(){
                var id= document.getElementById("country_list_department_id").value;
//                console.log("ENTRO");
                $.ajax({
                    url:`${pageContext.request.contextPath}/department/${"${id}"}`,
                    type:'POST',
                    dataType: 'json',
                    success: function( json ) {
//                        console.log("ENTRO");
                        document.getElementById('country_list_department_municipality_id').innerHTML = "";
                        $.each(json, function(key, value) {  
//                            console.log(value);
                           $('<option></option>', {text:value}).attr('value', key).appendTo('#country_list_department_municipality_id');
                        });
                    }
                  });
            }
            function clearMunicipalities(){
                document.getElementById('country_list_department_municipality_id').innerHTML = "";
            }
             function clearDepartments(){
                document.getElementById('country_list_department_id').innerHTML = "";
            }
             $(document).ready(function () {
                 updateDepartments();
                $("#country_list_id").on("change",function(){
                    clearMunicipalities();
                    clearDepartments();
                    updateDepartments();
                });
                $("#country_list_department_id").on("change",function(){
                    clearMunicipalities();
                    updateMuni();
                });
            });
            
        </script>
    </jsp:attribute>

    <jsp:body>
        <form action="${pageContext.request.contextPath}/usuarios/guardar" method = "post" class="user">
            <div class="container1">
                <div class="container-grid-flex">


                    <div class="card mb-4 user_info_container">
                        <div class="card-header">
                            INFORMACION PERSONAL
                        </div>
                        <div class="card-body card-body2">
                            <div class="form-group">
                                Nombres
                                <input type="text" class="form-control " name="name" id="inputName">
                                <small id="nameHelp" class="form-text text-muted">Ingrese nombres.</small>
                            </div>
                            <div class="form-group">
                                Apellidos
                                <input type="text" class="form-control " name="lastname" id="inputLastName">
                                <small id="nameHelp" class="form-text text-muted">Ingrese apellidos.</small>
                            </div>
                            <div class="form-group">
                                Fecha de nacimiento
                                <input type="date" class="form-control " id="fechainc" max="2020-1-13" name="birthDate">

                                <small id="nameHelp" class="form-text text-muted">Ingrese su fecha de nacimiento.</small>
                            </div>  
                                
                            <div class="form-group">
                                <label for="gender_list">Genero</label> 
                                <select class="custom-select" id="gendeid" name="idGender" aria-describedby="idGenderHelp" required> 
                                    <c:forEach items="${gender_list}" var="item">
                                        <option value="${item.idGender}">${item.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione su género.</small>
                            </div>
                            <div class="form-group">
                                <label for="country_list">País</label> 
                                <select class="custom-select" id="country_list_id" name="id_country" aria-describedby="country_listHelp" required> 
                                    <c:forEach items="${country_list}" var="country">
                                        <option value="${country.idCountry}">${country.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el país.</small>
                            </div>
                            <div class="form-group">
                                <label for="country_department_list">Departamento</label> 
                                <select class="custom-select" id="country_list_department_id" name="id_country_department" aria-describedby="country_listHelp"> 

                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el departamento.</small>
                            </div>
                            <div class="form-group">
                                <label for="country_department_list">Municipio</label> 
                                <select class="custom-select" id="country_list_department_municipality_id" name="id_municipality" aria-describedby="country_listHelp"> 

                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el municipio.</small>
                            </div>
                            <div class="form-group">
                                Direccion
                                <input type="text" class="form-control " name="address" id="address">
                                <small id="nameHelp" class="form-text text-muted">Ingrese su dirección.</small>
                            </div>


                        </div>
                    </div>
                    <div class="card mb-4 account_container">
                        <div class="card-header">
                            INFORMACION DE LA CUENTA
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                E-mail
                                <input type="email" class="form-control " name="email" id="inputEmail">
                                <small id="nameHelp" class="form-text text-muted">Ingrese su correo electrónico</small>
                            </div>

                            <div class="form-group">
                                Password
                                <input type="password" class="form-control " name="password" id="inputPassword">
                                <small id="nameHelp" class="form-text text-muted">Ingrese su contraseña.</small>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control " name="password2" id="inputPassword2">
                                <small id="nameHelp" class="form-text text-muted">Ingrese de nuevo su contraseña.</small>
                            </div>
                            <div class="form-group">
                                <label for="role_list">Rol</label> 
                                <select class="custom-select" id="country_list_department_municipality_id" name="role" aria-describedby="id_roleHelp" required> 
                                    <c:forEach items="${role_list}" var="item">
                                        <option value="${item.idRole}">${item.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el rol.</small>
                            </div>
                            <div class="form-group">
                                <label for="department_list">Departamento (Según función)</label> 
                                <select class="custom-select" id="idDepartment" name="department" aria-describedby="id_roleHelp" required> 
                                    <c:forEach items="${department_list}" var="item">
                                        <option value="${item.idDepartment}">${item.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el rol.</small>
                            </div>
<!--                            <div class="form-group">
                                <label for="department_list">Comité</label> 
                                <select class="custom-select" id="idDepartment" name="committee" aria-describedby="id_roleHelp" required> 
                                    <c:forEach items="${committee_list}" var="item">
                                        <option value="${item.committeeList.idCommittee}">${item.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el comité al que pertenece.</small>
                            </div>-->
                        </div>
                    </div>
                    <div class="card mb-4 contact_info_container">
                        <div class="card-header">
                            INFORMACION DE CONTACTO
                        </div>
                        <div class="card-body ">
                            <div class="form-group">
                                Nombre de representante
                                <input type="text" class="form-control " name="guardian_name" id="inputguradian_name">
                                <small id="nameHelp" class="form-text text-muted">Ingrese nombre de representante (Padre,madre o responsable a cargo).</small>
                            </div>

                            <div class="form-group">
                                Numero de telefono
                                <input type="number" max="99999999" class="form-control "  name="guardian_contact" id="inputguradiancontact">
                                <small id="nameHelp" class="form-text text-muted">Ingrese el numero de contacto del representante.</small>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-user">
                    Añadir Usuario
                </button>
            </div>

        </form>
    </jsp:body>
</t:admin-template>
