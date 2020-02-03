<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<t:admin-template>
    <jsp:attribute name="styles">

    </jsp:attribute>
    <jsp:attribute name="title">Crear País</jsp:attribute>
    <jsp:attribute name="marked">nuevo-pais</jsp:attribute>
    <jsp:attribute name="scripts">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/new_user.css" type="text/css" media="screen">
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
    </jsp:attribute>

    <jsp:body>
        ${respuesta}
        <form action="${pageContext.request.contextPath}/paises/guardar" method = "post" class="country">
            <div class="container1">
                <div class="container-grid-flex">
                    
                    <div class="card mb-4 user_info_container">
                        <div class="card-header">
                            INFORMACION DEL PAÍS
                        </div>
                        <div class="card-body card-body2">
                            <div class="form-group">
                                Nombre
                                <input type="text" class="form-control " name="name" id="inputName" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese nombre del país (Ejemplo: El Salvador).</small>
                            </div>
                            <div class="form-group">
                                Codigo de país
                                <input type="text" class="form-control " name="code" id="inputCode" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese el número de código del país (Ejemplo: Para El Salvador "222").</small>
                            </div>
                                                        
                            <div class="form-group">
                                Codigo ISO 3166a-1
                                <input type="text" class="form-control " name="iso3166a1" id="inputIso3166a1" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese ISO 3166a-1 (Ejemplo: Para El Salvador "SV").</small>
                            </div>
                            
                            <div class="form-group">
                                Codigo ISO 3166a-2
                                <input type="text" class="form-control " name="iso3166a2" id="inputIso3166a2" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese ISO 3166a-2 (Ejemplo: Para El Salvador "SLV").</small>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-warning btn-user button">
                    <span class="icon text-white-50">
                        <i class="fas fa-edit"></i>
                    </span>
                    <span class="text">AÑADIR PAÍS</span>

                </button>
            </div>

        </form>
    </jsp:body>
</t:admin-template>