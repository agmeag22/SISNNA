<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<t:admin-template>
    <jsp:attribute name="marked">comites</jsp:attribute>
    <jsp:attribute name="title">Comites</jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Custom styles for this page -->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
        <script src="resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <script>
            // Call the dataTables jQuery plugin
//            $(document).ready(function () {
//                $('#dataTable').DataTable();
//            });

        </script>
    </jsp:attribute>
    <jsp:body>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Comites</h1>
        <p class="mb-4">Listado de Comites</p>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                
                <!--<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>-->
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Ultima actualizacion</th>
                                <th>Creación</th>

                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Ultima actualizacion</th>
                                <th>Creación</th>

                            </tr>
                        </tfoot>
                        <tbody>
                            <%--<c:out value="${lista}" />--%>
                            <c:forEach items="${lista}" var="item">
                                <%--    <c:out value="${item.idCommittee}" />--%>
                                <tr>
                                    <td>${item.idCommittee}</td>
                                    <td>${item.name}</td>
                                   
                                    <td>${item.updatedUp}</td>
                                     <td>${item.createdUp}"</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </jsp:body>
            </t:admin-template>