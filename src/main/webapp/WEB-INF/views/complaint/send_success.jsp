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
            .hidden{
                display:none;
            }

        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    </jsp:attribute>
    <jsp:body>
        <div class="container1">
            <div class="container-grid-flex">
                <h4 style="color:green;text-align: center">Su alerta ha sido enviada correctamente!</h4>
            </div>
        </div>

    </jsp:body>
</t:admin-template>