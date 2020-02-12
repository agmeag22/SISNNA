<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin-template>
    <jsp:attribute name="styles">

    </jsp:attribute>
    <jsp:attribute name="title">Dashboard</jsp:attribute>
    <jsp:attribute name="marked">dashboard</jsp:attribute>
    <jsp:attribute name="scripts">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dashboard/dashboard.css" type="text/css" media="screen">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </jsp:attribute>
    <jsp:body>
        <div class="container-grid">
            <div class="container-button btn btn-warning" id="complaint_pending_button">
                
                    <a type="button" class="btn-up btn" href="${pageContext.request.contextPath}/denuncias/denuncias_pendientes">Denuncias pendientes</a>
                    <hr>
                    <a type="button" class="btn-down btn " href="${pageContext.request.contextPath}/denuncias/denuncias_pendientes">20</a>
                
            </div>
            <div class="container-button btn btn-warning" id="complaint_processed_button">
                <a type="button" class="btn-up btn " href="${pageContext.request.contextPath}/denuncias/denuncias_procesadas">Denuncias procesadas</a>
                <hr>
                <a type="button" class="btn-down btn" href="${pageContext.request.contextPath}/denuncias/denuncias_procesadas">20</a>
            </div>
            <div class="container-button btn btn-warning" id="user_button">
                <a type="button" class="btn-up btn" href="${pageContext.request.contextPath}/usuarios/inicio_usuarios">Usuarios</a>
                <hr>
                <a type="button" class="btn-down btn" href="${pageContext.request.contextPath}/usuarios/inicio_usuarios">20</a>
            </div>
            <div class="container-button btn btn-warning" id="committee_button">
                <a type="button" class="btn-up btn" href="${pageContext.request.contextPath}/comites/inicio_comites">Comites</a>
                <hr>
                <a type="button" class="btn-down btn" href="${pageContext.request.contextPath}/comites/inicio_comites">20</a>
            </div>
        </div>


    </jsp:body>
</t:admin-template>