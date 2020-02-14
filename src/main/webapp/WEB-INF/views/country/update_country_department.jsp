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
                                    rewriteDept();
                                }
                               
                            });
                            
                        }
                        
                        function rewriteDept(){
                            var sel = document.getElementById("country_list_department_id");
                            var text = sel.options[sel.selectedIndex].text;
                                document.getElementById("inputName").value=text;
                        }
                       
    
                                    function clearDepartments() {
                                        document.getElementById('country_list_department_id').innerHTML = "";
                                    }
                                    
                                    $(document).ready(function () {
                                        updateDepartments();
                                        //rewriteDept();
                                        /*$("#country_list_id").on("change", function () {

                                            clearDepartments();
                                            updateDepartments();
                                        });*/
                                        $("#country_list_department_id").on("change", function () {
                                            //clearMunicipalities();
                                            //updateMuni();
                                            
                                            rewriteDept();
                                        });
                                    });

        </script>
    </jsp:attribute>

    <jsp:body>
        ${respuesta}
        <form action="${pageContext.request.contextPath}/deptos/guardar_modificacion_depto/${country.idCountry}" method = "post" class="country">
            <div class="container1">
                <div class="container-grid-flex">
                     
                    <div class="card mb-4 user_info_container">
                        <div class="card-header">
                            MODIFICAR REGIONES/ESTADOS DE ${country.name}
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
                                <label for="country_department_list">Estado a modificar</label> 
                                <select class="custom-select" id="country_list_department_id" name="id_country_department" aria-describedby="country_listHelp"> 
                                    <option selected>N/A</option>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el estado.</small>
                            </div>
                            
                            <!--Añadir estado-->
                            <div class="form-group">
                                Nombre del Estado
                                <input type="text" class="form-control " name="name" id="inputName" >
                                <small id="nameHelp" class="form-text text-muted">Ingrese nombre del estado para el país seleccionado.</small>
                            </div>
                            
                            <button type="submit" class="btn btn-warning btn-user button" id='depto'>
                                <span class="icon text-white-50">
                                    <i class="fas fa-edit"></i>
                                </span>
                                <span class="text">MODIFICAR ESTADO</span>

                            </button>
                            
                            
                        </div>
                    </div>
                    
                </div>
                
            </div>

        </form>
    </jsp:body>
</t:admin-template>
