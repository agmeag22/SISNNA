<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:admin-template>
    <jsp:attribute name="styles">
        <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/settings/position_view.css" rel="stylesheet">
    </jsp:attribute>
    <jsp:attribute name="title">Ajustes de cargos</jsp:attribute>
    <jsp:attribute name="marked">ajustes-cargos</jsp:attribute>
    <jsp:attribute name="scripts">
        <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css" type="text/css" media="screen">--%>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/settings_views/position_view.js"></script>
        <script>
            // Call the dataTables jQuery plugin
            $(document).ready(function () {
                $('#dataTable').DataTable();
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div id="container">
            <div class="card mb-4 contact_info_container" id="table-container">
                <div class="card-header">
                    LISTADO DE CARGOS
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-responsive" style="width: auto">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>CARGO</td>
                                <td>FECHA CREACIÓN</td>
                                <td>FECHA MODIFICACIÓN</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${position_list}" var="item">
                                <tr>
                                    <td>${item.idPosition}</td>
                                    <td>${item.name}</td>
                                    <td>${item.createdDate}</td>
                                    <td>${item.updatedDate}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                        <tfoot>
                            <tr>
                                <td>ID</td>
                                <td>CARGO</td>
                                <td>FECHA CREACIÓN</td>
                                <td>FECHA MODIFICACIÓN</td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
            <div class="card mb-4 contact_info_container" id="input-container">
                <div class="card-header">
                    NUEVO CARGO
                </div>
                <div class="card-body">
                    <form class="card-body" action="${pageContext.request.contextPath}/ajustes/cargo/nuevo" method="POST">
                        <input type="text" class="form-control inputs" onkeyup="
                                var start = this.selectionStart;
                                var end = this.selectionEnd;
                                this.value = this.value.toUpperCase();
                                this.setSelectionRange(start, end);
                               " placeholder="Nombre del cargo" required maxlength="50" name="name">
                        <input type="submit" class="btn btn-outline-info btn-sm inputs" value="GUARDAR">
                    </form>
                </div>
            </div>
            <div class="card mb-4 " id="input-update-container">
                <div class="card-header">
                    MODIFICAR CARGO
                </div>
                <div class="card-body">
                    <form class="card-body" action="${pageContext.request.contextPath}/ajustes/cargo/modificar" method="POST">

                        <input type="number" class="form-control inputs" name="id-position" min="1" required placeholder="ID del cargo" id="input-modify">
                        <input type="text" class="form-control inputs" onkeyup="
                                var start = this.selectionStart;
                                var end = this.selectionEnd;
                                this.value = this.value.toUpperCase();
                                this.setSelectionRange(start, end);
                               " placeholder="Nombre del cargo" required maxlength="50" name="name">
                        <input type="submit" class="btn btn-outline-info btn-sm submit-button inputs" value="MODIFICAR" id="submit-button">
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:admin-template>