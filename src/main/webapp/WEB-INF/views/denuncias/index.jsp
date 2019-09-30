<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin-template>
    <jsp:attribute name="marked">denuncias</jsp:attribute>
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
        <h1 class="h3 mb-2 text-gray-800">Denuncias</h1>
        <!--<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>-->
          <a href="${pageContext.request.contextPath}/denuncias/nuevo" class="btn btn-success btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-plus"></i>
            </span>
            <span class="text">A&ntildeadir Denuncia</span>
        </a>

        <br><br>
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
                                
                                <th>Tipo de denuncia</th>
                                <th>Estado</th>
                                <th>Fecha de denuncia</th>
                                <th>Accion</th>
                               
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                               
                                <th>Tipo de denuncia</th>
                                <th>Estado</th>
                                 <th>Fecha de denuncia</th>
                                <th>Accion</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <tr>
                                <td>Tiger Nixon</td>
                                <td>System Architect</td>
                          
                                <td>2011/04/25</td>
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
                            <tr>
                                <td>Garrett Winters</td>
                                <td>Accountant</td>
                               
                                <td>2011/07/25</td>
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
                            <tr>
                                <td>Ashton Cox</td>
                                <td>Junior Technical Author</td>
                              
                                <td>2009/01/12</td>
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
                            <tr>
                                <td>Cedric Kelly</td>
                                <td>Senior Javascript Developer</td>

                                <td>2012/03/29</td>
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
                            <tr>
                                <td>Airi Satou</td>
                                <td>Accountant</td>
                                
                                <td>2008/11/28</td>
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
                            <tr>
                                <td>Brielle Williamson</td>
                                <td>Integration Specialist</td>
                               
                                <td>2012/12/02</td>
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
                            <tr>
                                <td>Herrod Chandler</td>
                                <td>Sales Assistant</td>
                                
                                <td>2012/08/06</td>
                                < <td><div class="dropdown">
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
                            <tr>
                                <td>Rhona Davidson</td>
                                <td>Integration Specialist</td>
                               
                                <td>2010/10/14</td>
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
                            <tr>
                                <td>Colleen Hurst</td>
                                <td>Javascript Developer</td>
                               
                                <td>2009/09/15</td>
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
                            <tr>
                                <td>Sonya Frost</td>
                                <td>Software Engineer</td>
                               
                                <td>2008/12/13</td>
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
                            <tr>
                                <td>Jena Gaines</td>
                                <td>Office Manager</td>
                               
                                <td>2008/12/19</td>
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
                            <tr>
                                <td>Quinn Flynn</td>
                                <td>Support Lead</td>
                                
                                <td>2013/03/03</td>
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
                            <tr>
                                <td>Charde Marshall</td>
                                <td>Regional Director</td>
                              
                                <td>2008/10/16</td>
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
                            <tr>
                                <td>Haley Kennedy</td>
                                <td>Senior Marketing Designer</td>
                               
                                <td>2012/12/18</td>
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
                            <tr>
                                <td>Tatyana Fitzpatrick</td>
                                <td>Regional Director</td>
                              
                                <td>2010/03/17</td>
                                <td>$385,750</td>
                            </tr>
                            <tr>
                                <td>Michael Silva</td>
                                <td>Marketing Designer</td>
                             
                                <td>2012/11/27</td>
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
                           
                        </tbody>
                    </table>
                </jsp:body>
            </t:admin-template>