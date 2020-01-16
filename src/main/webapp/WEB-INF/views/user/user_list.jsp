<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:admin-template>
    <jsp:attribute name="marked">listado-usuarios</jsp:attribute>
    <jsp:attribute name="title">Usuarios</jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Custom styles for this page -->
        <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <script>
            // Call the dataTables jQuery plugin
            $(document).ready(function () {
                $('#dataTable').DataTable();
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">USUARIOS</h1>

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
                                <th>USUARIO</th>
                                <th>FECHA CREACIÓN</th>
                                <th>ULTIMA ACTUALIZACIÓN</th>
                                <th>ESTADO</th>
                                <th>ACCIÓN</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>USUARIO</th>
                                <th>FECHA CREACIÓN</th>
                                <th>ULTIMA ACTUALIZACIÓN</th>
                                <th>ESTADO</th>
                                <th>ACCIÓN</th>
                                

                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>${item.idUser}</td>
                                    <td>${item.email}</td>

                                    <td>${item.createdDate}</td>
                                    <td>${item.updatedDate}</td>
                                    <c:set var="active" value="${item.activeState}" />
                                    <td>
                                    <c:if test="${active>0}">
                                        <a class="btn btn-success btn-sm" href="">Activo</a>
                                    </c:if>
                                    <c:if test="${active<1}">
                                        <a class="btn btn-danger btn-sm" href="">Inactivo</a>
                                    </c:if>
                                    </td>
                                    <td><div class="dropdown">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <em class="fa fa-cog"></em>
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/usuarios/modificar_usuario/${item.idUser}"><i class="fas fa-edit"></i>   Editar</a>

                                                <c:set var="active" value="${item.activeState}" />
                                                <c:if test="${active<1}">
                                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/usuarios/activar_inactivar/${item.idUser}/${item.activeState}"><i class="fas fa-unlock-alt"></i>   Habilitar</a>
                                                </c:if>
                                                <c:if test="${active>0}">
                                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/usuarios/activar_inactivar/${item.idUser}/${item.activeState}"><i class="fas fa-ban"></i>   Inhabilitar</a>
                                                </c:if>
                                            </div>
                                        </div></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</t:admin-template> 
