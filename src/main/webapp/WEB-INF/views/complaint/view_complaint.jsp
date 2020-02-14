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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/view_complaint.css" type="text/css" media="screen">
        <style>


        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>


    </jsp:attribute>
    <jsp:body>
        <div class="container-flex">
            <div class="victim-container">
                <div class="card mb-4 user_info_container">
                    <div class="card-header">
                        Informacion de la victima
                    </div>
                    <div class="card-body card-body2">
                        <div class="div-box">Nombre de la victima: ${complaint.victimName}</div>
                        <div class="div-box">Edad: ${complaint.victimAge}</div>
                        <div class="div-box">Grado que cursa: ${complaint.grade}</div>
                        <div class="div-box">Centro escolar: ${complaint.scholarCenter}</div>
                        <div class="div-box">Contexto de la victima: ${complaint.childContext}</div>
                        <div class="div-box">                           
                            <table class="table table-option" id="dataTable" width="100%" cellspacing="0">
                                <thead><tr><th>Programas al que pertenece la victima</th></tr></thead>
                                <tbody>
                                    <c:forEach items="${complaintPrograms}" var="item">
                                        <tr><td>${item.program.name}</td></tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="user-container">
                <div class="card mb-4 user_info_container">
                    <div class="card-header">
                        Informacion del usuario que realizó la denuncia
                    </div>
                    <div class="card-body card-body2">
                        <div class="div-box">Nombre del usuario: ${complaint.user.personalInfo.name}</div>
                        <div class="div-box">Fecha de nacimiento: ${complaint.user.personalInfo.birthDate}</div>
                        <div class="div-box">Genero: ${complaint.user.personalInfo.gender.name}</div>
                        <div class="div-box">País: ${complaint.user.personalInfo.country.name}</div>
                        <div class="div-box">Municipio: ${complaint.user.personalInfo.municipality.name}</div>
                        <div class="div-box">Dirección: ${complaint.user.personalInfo.address}</div>
                        <div class="div-box">Email: ${complaint.user.email}</div>
                        <div class="flex-cont-second">
                            <div class="div-box">Nombre de responsable:</div>
                            <div>ssssssssssssssssssssssssssssss ${complaint.user.personalInfo.guardianName}</div>
                        </div>
                        <div class="flex-cont-second">
                            <div class="div-box">Contacto de responsable:</div>
                            <div>ssssssssssss ${complaint.user.personalInfo.guardianContact}</div> 
                        </div>

                    </div>
                </div>
            </div>
            <div class="complaint-container">
                <div class="card mb-4 user_info_container">
                    <div class="card-header">
                        Informacion de la denuncia
                    </div>
                    <div class="card-body card-body2">
                        <div class="flex-cont">
                            <div>Prioridad: ${complaint.priority}</div>
                            <div>Estado de la denuncia: ${complaint.state.name}</div>
                        </div>
                        <div class="flex-cont">
                            <div class="div-box">Fecha de la falta: ${complaint.misdemeanorDate}</div>
                            <div class="div-box">Hora de la falta: ${complaint.misdemeanorTime}</div>
                        </div>
                        <div class="div-box">
                            Descripcion de la denuncia: 
                            <text>${complaint.description}<text>
                        </div>
                        <div class="div-box">Acción inmediata tomada: ${complaint.actionTaken}</div>
                        <div class="div-box">Lugar de la falta o faltas: ${complaint.situationLocation}</div>
                        <div class="div-box">Nombre del acusado: ${complaint.accusedName}</div>
                        <div class="div-box">Recurrencia: ${complaint.isRecurrence}</div>
                        <div class="div-box">

                            <table class="table table-option" id="dataTable" width="100%" cellspacing="0">
                                <thead><tr><th>Abusos o faltas que se le hicieron a la victima</th></tr></thead>
                                <tbody>
                                    <c:forEach items="${complaintAbuses}" var="item">
                                        <tr><td>${item.abuse.name}</td></tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="div-box">Fecha en la que se generó la denuncia: ${complaint.createdDate}</div>
                        <div class="div-box">Fecha y hora de última modificación: ${complaint.updatedDate}</div>
                    </div>
                </div>
            </div>
        </div>


    </jsp:body>
</t:admin-template>