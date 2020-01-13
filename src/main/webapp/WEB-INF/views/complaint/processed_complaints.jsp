<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin-template>
    <jsp:attribute name="marked">denuncias-procesadas</jsp:attribute>
    <jsp:attribute name="title">Denuncias</jsp:attribute>
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
            $(document).ready(function () {
                $('#dataTable').DataTable();
            });

        </script>
    </jsp:attribute>
    <jsp:body>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">DENUNCIAS PROCESADAS</h1>
       <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">

                <!--<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>-->
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table data-role="table" class="table table-bordered ui-responsive" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>FECHA DE CREACION</th>
                                <th>ESTADO</th>
                                <th>ULTIMA ACTUALIZACION</th>
                                <th>FALTA</th>
                                <th>ACCIÓN</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>FECHA DE CREACION</th>
                                <th>ESTADO</th>
                                <th>ULTIMA ACTUALIZACION</th>
                                <th>FALTA</th>
                                <th>ACCIÓN</th>

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
                                    <td><div class="dropdown">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <em class="fa fa-cog"></em>
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="#">Eliminar</a>
                                                <a class="dropdown-item" href="#">Editar</a>
                                                <a class="dropdown-item" href="#">...</a>
                                            </div>
                                        </div></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </jsp:body>
            </t:admin-template>