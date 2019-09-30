<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:admin-template>
    <jsp:attribute name="marked">usuarios</jsp:attribute>
    <jsp:attribute name="title">Usuarios</jsp:attribute>
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
        <h1 class="h3 mb-2 text-gray-800">Usuarios</h1>
      <!--  <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p> -->
          <a href="${pageContext.request.contextPath}/comites/nuevo" class="btn btn-success btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-plus"></i>
            </span>
            <span class="text">A&ntildeadir Usuario</span>
        </a>

        <br><br>
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Usuarios en el sistema</h6>
            </div>
            <div class="card-body">
<!--                <div class="table-responsive">
                    <a href="${pageContext.request.contextPath}/usuarios/nuevo" class="btn btn-secondary btn-user">
                      Crear Nuevo Usuario
                    </a>                      -->
                    <!--<hr>-->
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre de Usuario</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Rol</th>
                                <th>Departamento</th>
                                <th>Comite</th>
                                <th>email</th>
                                <th>Alertas hechas</th>
                                <th>Alertas Asignadas</th>
                                <th>Estado</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Id</th>
                                <th>Nombre de Usuario</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Rol</th>
                                <th>Departamento</th>
                                <th>Comite</th>
                                <th>email</th>
                                <th>Alertas hechas</th>
                                <th>Alertas Asignadas</th>
                                <th>Estado</th>
                                <th>Accion</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach var="user" items="${allUsers}">
                            <tr> 
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>${user.name}</td>
                                <td>${user.lastname}</td>
                                <td>${user.role}</td>
                                <td>${user.department}</td>
                                <td>${user.committee}</td>
                                <td>${user.email}</td>
                                <td>${user.createdAlert}</td>
                                <td>${user.assignedAlert}</td>
                                <td>${user.state}</td>
                                 <td><div class="dropdown">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <em class="fa fa-cog"></em>
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="#"><form  action="${pageContext.request.contextPath}/usuarios/eliminar" method="post">
                                        <input type="hidden" name="userNumber" id="userNumberInput"  value="${user.number}">
                                        <input type="submit" class="dropdown-item" value="Eliminar" /><br>
                                  </form></a>
                                                <a class="dropdown-item" href="#">  <form  action="${pageContext.request.contextPath}/usuarios/modificar" method="post">
                                            <input type="hidden" id="userNumber" name="userNumber" value="${user.number}">
                                              <input type="submit" class="dropdown-item" value="Editar" />
                                    </form></a>
                                                <a class="dropdown-item" href="#">...</a>
                                            </div>
                                        </div></td>
                                <td>
                                        /
                                      </td>                                
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
                </jsp:body>
            </t:admin-template> 