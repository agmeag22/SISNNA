<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<t:admin-template>
    <jsp:attribute name="marked">nueva-denuncia</jsp:attribute>
    <jsp:attribute name="title">Denuncias</jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Custom styles for this page -->
        <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/new_user.css" type="text/css" media="screen">
        <style>
            
            
        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
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
            
            function createAbuses(){
                 var container= document.getElementById("complaintAbusesList_container");
                    container.innerHTML = "";
                    var list = ""
                    var element = "";
                    $('.complaintAbusesList:checkbox:checked').each(function(index){
                         element = $(this).val();
                        console.log($(this).val());
                          list+=`<input class="hidden" type="text" name="complaintAbusesList[${"${index}"}].abuse.idAbuse" value="${"${element}"}"/>`;
                    });                  
                    container.innerHTML = list;
            }
            function createPrograms(){
             var container= document.getElementById("complaintProgramsList_container");
                    container.innerHTML = "";
                    var list = ""
                    var element = "";
                    $('.complaintProgramsList:checkbox:checked').each(function(index){
                         element = $(this).val();
                        console.log($(this).val());
                          list+=`<input class="hidden" type="text" name="complaintProgramsList[${"${index}"}].program.idProgram" value="${"${element}"}"/>`;
                    });                  
                    container.innerHTML = list;
            }
            $(document).ready(function () {
                updateDepartments();
                createAbuses();
                createPrograms();
                $("#country_list_id").on("change",function(){
                    clearMunicipalities();
                    clearDepartments();
                    updateDepartments();
                });
                $("#country_list_department_id").on("change",function(){
                    clearMunicipalities();
                    updateMuni();
                });
                $("#country_list_department_id").on("change",function(){
                    clearMunicipalities();
                    updateMuni();
                });
                $(".complaintAbusesList").on("click",function(){
                    console.log($(this).val());
                   createAbuses();
                });
                 $(".complaintProgramsList").on("click",function(){
                    console.log($(this).val());
                   createPrograms();
                });
                
            });
            
        </script>
            
    </jsp:attribute>
    <jsp:body>
        <div class="container1">
            <div class="container-grid-flex">
                <form method="POST" action="${pageContext.request.contextPath}/denuncias/store">
                    
                    <div class="card mb-4 user_info_container">
                        <div class="card-header">
                            Informacion del niño, niña o adolescente afectado
                        </div>
                        <div class="card-body card-body2">
                            <div class="form-group">
                                Nombre: <span style="color:red">*</span>
                                <input type="text" class="form-control " name="victimName" id="address" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese el nombre.</small>
                            </div>
                            <div class="form-group">
                                <label for="gender_list">Genero:  <span style="color:red">*</span></label> 
                                <select class="custom-select" id="gendeid" name="gender.idGender" aria-describedby="idGenderHelp" required> 
                                    <c:forEach items="${genderList}" var="item">
                                        <option value="${item.idGender}">${item.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione su género.</small>
                            </div>
                            <div class="form-group">
                                Edad: <span style="color:red">*</span>
                                <input type="number" class="form-control " name="victimAge" id="address" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese la edad en años.</small>
                            </div>
                            <div class="form-group">
                                Centro escolar al que pertenece: <span style="color:red">*</span>
                                <input type="text" class="form-control " name="scholarCenter" id="address" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese el nombre del centro escolar.</small>
                            </div>
                            <div class="form-group">
                                Grado: <span style="color:red">*</span>
                                <input type="text" class="form-control " name="grade" id="address" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese el grado.</small>
                            </div>
                                
                                
                            <div class="form-group">
                                <label>¿Pertenece a alguno de los programas de Glasswing?</label>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="isGlasswing" id="optionsRadios1" value="1" checked=""> Si
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="isGlasswing" id="optionsRadios2" value="0"> No
                                    </label>
                                </div>
                                    
                            </div>
                            <div class="form-group">
                                <p style="margin:0">¿A qué programa pertenece?:</p>
                                <c:forEach items="${programList}" var="item" varStatus="loop">
                                    <div class="checkbox">
                                        <label class="" for="options[${item.idProgram}]">
                                            <input type="checkbox"  class="complaintProgramsList" value="${item.idProgram}"/>
                                            ${item.name}</label>
                                    </div>
                                </c:forEach>
                                <div id="complaintProgramsList_container"></div>
                            </div>
                            <div class="form-group">
                                <label for="country_list">País</label> 
                                <select class="custom-select" id="country_list_id" name="country.idCountry" aria-describedby="country_listHelp" required> 
                                    <c:forEach items="${countryList}" var="country">
                                        <option value="${country.idCountry}">${country.name}</option>
                                    </c:forEach>
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el país.</small>
                            </div>
                            <div class="form-group">
                                <label for="country_department_list">Departamento</label> 
                                <select class="custom-select" id="country_list_department_id" name="countryDepartment.idCountryDepartment" aria-describedby="country_listHelp" required> 
                                    
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el departamento.</small>
                            </div>
                            <div class="form-group">
                                <label for="country_department_list">Municipio</label> 
                                <select class="custom-select" id="country_list_department_municipality_id" name="municipality.idMunicipality" aria-describedby="country_listHelp" required> 
                                    
                                </select> 
                                <small id="nameHelp" class="form-text text-muted">Seleccione el municipio.</small>
                            </div>
                            <!--                        <div class="form-group">
                                                        Direccion
                                                        <input type="text" class="form-control " name="address" id="address" required>
                                                        <small id="nameHelp" class="form-text text-muted">Ingrese su dirección.</small>
                                                    </div>-->
                                                        
                                                        
                        </div>        
                    </div>
                    <div class="card mb-4 account_container">
                        <div class="card-header">
                            Informacion del incidente
                        </div>
                        <div class="card-body card-body2">
                            <div class="form-group">
                                <p style="margin:0">Situación o acción de vulneración:</p>
                                <c:forEach items="${abuseList}" var="item" varStatus="loop">
                                    <div class="checkbox">
                                        <label class="" for="options[${item.idAbuse}]">
                                            <input type="checkbox"  class="complaintAbusesList" value="${item.idAbuse}"/>
                                            ${item.name}</label>
                                    </div>
                                </c:forEach>
                                <div id="complaintAbusesList_container"></div>  
                            </div>
                            <div class="form-group">
                                <label>¿Quién cometió la falta? *</label>
                                <c:forEach items="${accusedList}" var="item" varStatus="loop">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="accusedType.idAccusedType"  value="${item.idAccusedType}" required=""> ${item.name} 
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>
                                
                            <div class="form-group">
                                Nombre del agresor (Sí lo sabe): <span style="color:red">*</span>
                                <input type="text" class="form-control " name="accusedName" id="address" required>
                                <small id="nameHelp" class="form-text text-muted">Ingrese el nombre del agresor.</small>
                            </div>
                            <div class="form-group">
                                Fecha en la que se cometió la falta: <span style="color:red">*</span>
                                <input type="date" class="form-control " id="fechainc"  name="misdemeanorDate" required>
                                    
                                <small id="nameHelp" class="form-text text-muted">Ingrese la fecha aproximada.</small>
                            </div>  
                            <div class="form-group">
                                Hora en la que se cometió la falta: <span style="color:red">*</span>
                                <input type="date" class="form-control " id="fechainc"  name="misdemeanorTime" required>
                                    
                                <small id="nameHelp" class="form-text text-muted">Ingrese la hora aproximada.</small>
                            </div>  
                            <div class="form-group">
                                Lugar en que se cometió la falta: <span style="color:red">*</span>
                                <input type="text" class="form-control " name="situationLocation" id="address" required>
                                <small id="nameHelp" class="form-text text-muted">(Centro escolar, parque, aula, lugar de residencia, comunidad, en salida educativa Glasswing) </small>
                            </div>    
                                
                                
                            <div class="form-group">
                                Descripción de los hechos: <span style="color:red">*</span>
                                <textarea class="form-control " name="description" id="address" required></textarea>
                                <small id="nameHelp" class="form-text text-muted">Favor escribir los hechos sucedidos lo más objetivamente posible. Lo más importante es retomar las causas principales de la situación, consecuencias y preocupaciones de quien reporta. </small>
                            </div> 
                                
                            <div class="form-group">
                                Situación actual de la niña, niño o adolescente: <span style="color:red">*</span>
                                <textarea class="form-control " name="childContext" id="address" required></textarea>
                                <small id="nameHelp" class="form-text text-muted">Se refiere al contexto, situación física, psicológica y familiar del niño, niña o adolescente afectado. </small>
                            </div> 
                            <div class="form-group">
                                Acciones inmediatas (Sí se hicieron) : <span style="color:red">*</span>
                                <textarea class="form-control " name="actionTaken" id="address" required></textarea>
                                <small id="nameHelp" class="form-text text-muted">Se refiere al contexto, situación física, psicológica y familiar del niño, niña o adolescente afectado. </small>
                            </div> 
                                
                        </div>
                    </div>
                    <button class="btn btn-warning btn-icon-split" >
                        <span class="icon text-white-50">
                            <i class="far fa-save"></i>
                        </span>
                        <span class="text">Guardar Comite</span>
                    </button>
                </form>
            </div>
                
        </div>
            
    </jsp:body>
</t:admin-template>