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
       <!-- <script src="${pageContext.request.contextPath}/resources/js/region/fill-country.js" > </script> -->
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
                        
                        function rewriteMuni(){
                            var sel = document.getElementById("country_list_department_municipality_id");
                            var text = sel.options[sel.selectedIndex].text;
                                document.getElementById("inputName").value=text;
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
                                                rewriteMuni();
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
                                        /*
                                        $("#country_list_id").on("change", function () {
                                            clearMunicipalities();
                                            clearDepartments();
                                            updateDepartments();
                                        });*/
                                        $("#country_list_department_id").on("change", function () {
                                            clearMunicipalities();
                                            updateMuni();
                                            //rewriteMuni();
                                        });
                                        $("#country_list_department_municipality_id").on("change", function () {
                                            //clearMunicipalities();
                                            //updateMuni();
                                            rewriteMuni();
                                        });
                                    });

        </script> 
    </jsp:attribute>

    <jsp:body>
        ${respuesta}
        <form action="${pageContext.request.contextPath}/muni/guardar_modificacion_muni/${country.idCountry}" method = "post" class="country">
            <div class="container1">
                <div class="container-grid-flex">

                    <div class="card mb-4 user_info_container">
                        <div class="card-header">
                            MODIFICAR MUNICIPIOS DEL PAÍS: ${country.name}
                        </div>
                        <div class="card-body card-body2">
                            
                            <!--
                            <div class="form-group">
                                <label for="country_list">País</label> 
                                <select class="custom-select" id="country_list_id" name="id_country" aria-describedby="country_listHelp" required> 
                                    <c:forEach items="${country_list}" var="country">
                                        <option value="${country.idCountry}">${country.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el paÃ­s.</small>
                            </div>-->
                            
                            <input type="hidden" class="form-control " name="countryId" id="country_list_id" value="${country.idCountry}">
                            
                            
                            <div class="form-group">
                                <label for="country_department_list">Estados en el país seleccionado</label> 
                                <select class="custom-select" id="country_list_department_id" name="id_country_department" aria-describedby="country_listHelp"> 
                                    <option selected>N/A</option>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el departamento.</small>
                            </div>
                            
                            <div class="form-group">
                                <label for="country_department_list">Municipios del estado seleccionado</label> 
                                <select class="custom-select" id="country_list_department_municipality_id" name="id_municipality" aria-describedby="country_listHelp" > 
                                    <option selected>N/A</option>
                                </select> 
                                <!-- <small id="nameHelp" class="form-text text-muted">Seleccione el municipio.</small> -->
                            </div>
                            
                            <div class="form-group">
                                Modificar municipio.
                                <input type="text" class="form-control " name="name" id="inputName">
                                <small id="nameHelp" class="form-text text-muted">Ingrese nombre del municipio.</small>
                            </div>
                            
                            
                            <button type="submit" class="btn btn-warning btn-user button" id='mun'>
                                <span class="icon text-white-50">
                                    <i class="fas fa-edit"></i>
                                </span>
                                <span class="text">MODIFICAR MUNICIPIO</span>

                            </button>
                            
                            
                        </div>
                    </div>  
                    <!-- -->
                </div>
                
            </div>

        </form>
    </jsp:body>
</t:admin-template>
