<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:admin-template>
    <jsp:attribute name="marked">listado-paises</jsp:attribute>
    <jsp:attribute name="title">Paises</jsp:attribute>
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
        <h1 class="h3 mb-2 text-gray-800">PAISES</h1>

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
                                <th>NOMBRE</th>
                                <th>C�DIGO</th>
                                <th>ISO 3166A-1</th>
                                <th>ISO 3166A-2</th>
                                <th>ACCI�N</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>C�DIGO</th>
                                <th>ISO 3166A-1</th>
                                <th>ISO 3166A-2</th>
                                <th>ACCI�N</th>
                                

                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>${item.idCountry}</td>
                                    <td>${item.name}</td>

                                    <td>${item.code}</td>
                                    <td>${item.iso3166a1}</td>

                                    <td>${item.iso3166a2}</td>
                                    <td><div class="dropdown">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <em class="fa fa-cog"></em>
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/paises/modificar_paises/${item.idCountry}"><i class="fas fa-edit"></i>   Editar Pa�s</a>
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/deptos/modificar_departamentos/${item.idCountry}"><i class="fas fa-edit"></i>   Editar Estados</a>        
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/municipios/modificar_municipios/${item.idCountry}"><i class="fas fa-edit"></i>   Editar Municipios</a>
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

