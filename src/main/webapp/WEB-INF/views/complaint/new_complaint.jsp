<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin-template>
    <jsp:attribute name="marked">nueva-denuncia</jsp:attribute>
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
        <h1 class="h3 mb-2 text-gray-800">Formulario de Alerta</h1>
        <!--<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>-->

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <!--                <a href="formulario.jsp" class="btn btn-outline-primary">
                                    Nueva Denuncia
                                </a>-->
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <form method="post">
                            <h2>DATOS DEL AFECTADO</h2>
                            <br/>
                            Nombre:
                            <input type="text" class="form-control" id="name">
                            <br/>
                            Representante o guardian:
                            <input type="text" class="form-control" id="rep">
                            <br/>
                            Direccion:
                            <input type="text" class="form-control" id="address">
                            <br/>
                            <br/>
                            <h2>ACERCA DE LA ALERTA</h2>
                            <br/>
                            Tipo de alerta:  
                            <br/>
                            <div class="btn-group">
                                <button type="button" class="btn btn-primary">Abuso de poder</button>
                                <button type="button" class="btn btn-primary">Agresion</button>
                                <button type="button" class="btn btn-primary">Otro</button>
                            </div>
                            <br/>
                            <br/>
                            <br/>
                            <div>
                                Fecha del incidente:                  
                                <input type="date" class="form-control" id="fechainc" 
                                       min="2000-01-01" max="2100-12-31">
                            </div>

                            <div>
                                Hora del incidente:
                                <input type="time" class="form-control" id="horainc" 
                                       min="2000-01-01" max="2100-12-31">
                            </div>
                            <br/>
                            <br/>
                            Lugar donde ocurrio el incidente:
                            <input type="text" class="form-control" id="lugar">
                            <br/>
                            ¿Es de su conocimiento si este incidente se ha presentado en varias ocasiones?
                            <br/>
                            <label class="radio-inline"><input type="radio" name="optradio" checked>Si</label>
                            <label class="radio-inline"><input type="radio" name="optradio">    No</label>
                            <br/>
                            ¿Han sido notificados los padres o responsables de esta situacion?
                            <br/>
                            <label class="radio-inline"><input type="radio" name="optradio" checked>Si</label>
                            <label class="radio-inline"><input type="radio" name="optradio">    No</label>
                            <br/>
                            ¿Está el niño/a fuera del peligro/daño en este momento, o continua en riesgo?
                            <br/>
                            <input type="radio" name="optradio" checked>Fuera de peligro</label>
                            <br/>
                            <input type="radio" name="optradio">    Continua en riesgo</label>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="comment">Observaciones por quien reporta (estado emocional del niño/a, evidencia, entre otros):</label>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="comment">¿Es de su conocimiento si este incidente se ha presentado en varias ocasiones?:</label>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                            <a href="${pageContext.request.contextPath}/denuncias" class="btn btn-warning btn-icon-split" >
                                <span class="icon text-white-50">
                                    <i class="far fa-save"></i>
                                </span>
                                <span class="text">Enviar Denuncia</span>
                            </a>
                        </form>
                    </table>
                </jsp:body>
            </t:admin-template>