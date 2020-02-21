<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<t:admin-template>
    <jsp:attribute name="marked">nueva-denuncia</jsp:attribute>
    <jsp:attribute name="title">Denuncias</jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Custom styles for this page -->
        <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/view_complaint.css" type="text/css" media="screen">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/quill/quill.snow.css">

        <style>

            #clasificationComment,#resolution {
                background: white;
                height: 400px;
            }
            #clasificationComment{
                height: 200px;
            }
            #radioBtn .notActive{
                color: #3276b1;
                background-color: #fff;
            }
            .form {
                margin-top: 20px;
                margin-bottom: 20px;
            }
        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/quill/quill.min.js"></script>
        <c:if test="${complaint.state.idState== 1 && user.role.idRole==2 }">
            <script>
                // CUANDO LA CLASIFICACION SE PUEDE ESCRIBIR
                var editor1;
                $(document).ready(function () {
                    editor1 = new Quill('#clasificationComment', {
                        modules: {
                            toolbar: [
                                ['bold', 'italic'],
                                ['link', 'blockquote', 'code-block', 'image'],
                                [{list: 'ordered'}, {list: 'bullet'}]
                            ]
                        },
                        placeholder: 'Comentario',
                        theme: 'snow'
                    });
                });

                var form = document.querySelector('#clasificacion_form');
                form.onsubmit = function () {
                    var hvalue = JSON.stringify(editor1.getContents());
                    //                console.log(JSON.stringify(editor1.getContents()));
                    $(this).append("<textarea name='clasificationComment' style='display:none'>" + hvalue + "</textarea>");

                    //                console.log("Submitted", $(form).serialize(), $(form).serializeArray());
                    //
                    //                // No back end to actually submit to!
                    //                alert('Open the console to see the submit data!')
                    //                return false;
                };
                
                $('#radioBtn a').on('click', function () {
                    var sel = $(this).data('title');
                    var tog = $(this).data('toggle');
                    $('#' + tog).prop('value', sel);

                    $('a[data-toggle="' + tog + '"]').not('[data-title="' + sel + '"]').removeClass('active').addClass('notActive');
                    $('a[data-toggle="' + tog + '"][data-title="' + sel + '"]').removeClass('notActive').addClass('active');
                })
            </script>
        </c:if>
            
        <c:if test="${complaint.state.idState== 2 && user.role.idRole==3 }">
            <script>
                // CUANDO LA RESOLUCION SE PUEDE EDITAR
                var editor2;
                $(document).ready(function () {
                   


                    editor2 = new Quill('#resolution', {
                        modules: {
                            toolbar: [
                                ['bold', 'italic'],
                                ['link', 'blockquote', 'code-block', 'image'],
                                [{list: 'ordered'}, {list: 'bullet'}]
                            ]
                        },
                        placeholder: 'Resolución del caso',
                        theme: 'snow'
                    });
                });

                var form2 = document.querySelector('#resolution_form');
                form2.onsubmit = function () {
                    // Populate hidden form on submit
                    var hvalue = JSON.stringify(editor2.getContents());
                    $(this).append("<textarea name='resolution' style='display:none'>" + hvalue + "</textarea>");
                    //                console.log("Submitted", $(form).serialize(), $(form).serializeArray());
                    //
                    //                // No back end to actually submit to!
                    //                alert('Open the console to see the submit data!')
                    //                return false;
                };               
            </script>
        </c:if>
        <c:if test="${complaint.state.idState> 1 }">

            <script>
                // CUANDO EL CLASIFICAR ESTA EN SOLO LECTURA
                var editor1;
                var ops = ${complaint.clasificationComment};
                $(document).ready(function () {
                    editor1 = new Quill('#clasificationComment', {
                        placeholder: 'Comentario',
                        theme: 'snow',
                        readOnly: true,
                    });
                    editor1.setContents(ops, 'api');

                });
            </script>
        </c:if>
        <c:if test="${complaint.state.idState== 3 }">
            <script>
                // CUANDO LA RESOLUCION ESTA EN SOLO LECTURA
                var editor2;
                var ops2 = ${complaint.resolution};
                $(document).ready(function () {
                    editor2 = new Quill('#resolution', {
                        placeholder: 'Resolución del caso',
                        theme: 'snow',
                        readOnly: true,
                    });
                    editor2.setContents(ops2, 'api');
                });
            </script>
        </c:if>    
    </jsp:attribute>
    <jsp:body>
        <div class="container-flex">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="info-alerta-tab" data-toggle="tab" href="#info-alerta" role="tab" aria-controls="info-alerta" aria-selected="true">Informacion de denuncia</a>
                </li>

                <c:if test="${complaint.state.idState> 1 || user.role.idRole==2}">
                    <li class="nav-item">
                        <a class="nav-link" id="clasif-tab" data-toggle="tab" href="#clasif" role="tab" aria-controls="clasif" aria-selected="false">Clasificación</a>
                    </li>
                </c:if>
                <c:if test="${complaint.state.idState> 2 ||  user.role.idRole==3 && complaint.state.idState==2}">
                    <li class="nav-item">
                        <a class="nav-link" id="result-tab" data-toggle="tab" href="#result" role="tab" aria-controls="result" aria-selected="false">Resolución</a>
                    </li>
                </c:if>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="info-alerta" role="tabpanel" aria-labelledby="info-alerta-tab">
                    AQUI HABRAN VARIOS INPUTS
                    ${complaint.state.idState}
                </div>

                <div class="tab-pane fade" id="clasif" role="tabpanel" aria-labelledby="clasif-tab">
                    <c:if test="${complaint.state.idState== 1 && user.role.idRole==2 }">
                        <form class="form" id="clasificacion_form" action="${pageContext.request.contextPath}/cambiar_clasificacion/${complaint.idComplaint}" method="post">

                            <div class="form-group row">
                                <label for="happy" class="col-sm-4 col-md-4 control-label text-right">Clasificación de la Alerta:</label>
                                <div class="col-sm-7 col-md-7">
                                    <div class="input-group">
                                        <div id="radioBtn" class="btn-group">
                                            <a class="btn btn-primary btn-sm active" data-toggle="happy" data-title="1">LEVE</a>
                                            <a class="btn btn-primary btn-sm notActive" data-toggle="happy" data-title="2">GRAVE</a>
                                        </div>
                                        <input type="hidden" name="priority" id="happy" value="1">
                                    </div>
                                </div>
                            </div>
                            <!--<input name="clasificationComment" type="hidden">-->
                            <div id="clasificationComment"></div>
                            <br>
                            <button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#confirm_clasif_modal">Guardar Clasificación</button>
                        </form>
                    </c:if>
                    <c:if test="${complaint.state.idState> 1 }">
                        <div class="form form-group row">
                            <label for="happy" class="col-sm-4 col-md-4 control-label text-right">Clasificación de la Alerta:</label>
                            <div class="col-sm-7 col-md-7">
                                <div class="input-group">
                                    <div id="radioBtn" class="btn-group">
                                        <a class="btn btn-primary btn-sm ${complaint.priority.idPriority==1?'active':'notActive'}" data-toggle="happy" data-title="1">LEVE</a>
                                        <a class="btn btn-primary btn-sm ${complaint.priority.idPriority==2?'active':'notActive'}" data-toggle="happy" data-title="2">GRAVE</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--<input name="clasificationComment" type="hidden">-->
                        <div id="clasificationComment"></div>
                        <br>
                    </c:if>
                </div>

                <div class="tab-pane fade" id="result" role="tabpanel" aria-labelledby="result-tab">
                    <c:if test="${complaint.state.idState== 2 && user.role.idRole==3 }">
                        <form class="form" id="resolution_form" action="${pageContext.request.contextPath}/setear_resolucion/${complaint.idComplaint}" method="post">
                            <!--<input name="resolution" type="hidden">-->
                            <div id="resolution"></div>
                            <br>
                            <button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#confirm_resolution_modal">Guardar Resolución</button>
                        </form>
                    </c:if>
                    <c:if test="${complaint.state.idState== 3 && user.role.idRole==4 }">
                        <div id="resolution"></div>
                        <br>
                    </c:if>

                </div>
            </div>

        </div>
        <!-- Modal -->
        <div class="modal fade" id="confirm_clasif_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">¿Esta seguro que desea guardar los cambios?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="$('#clasificacion_form').submit()">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="confirm_resolution_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">¿Esta seguro que desea guardar los cambios?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="$('#resolution_form').submit()">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:admin-template>