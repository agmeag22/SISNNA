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
        <script>
            $(document).ready(function () {
                var editor1 = new Quill('#clasificationComment', {
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
                var editor2 = new Quill('#resolution', {
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

            var form = document.querySelector('form');
            form.onsubmit = function () {
                // Populate hidden form on submit
                var about = document.querySelector('input[name=about]');
                about.value = JSON.stringify(editor1.getContents());

                console.log("Submitted", $(form).serialize(), $(form).serializeArray());

                // No back end to actually submit to!
                alert('Open the console to see the submit data!')
                return false;
            };
            $('#radioBtn a').on('click', function () {
                var sel = $(this).data('title');
                var tog = $(this).data('toggle');
                $('#' + tog).prop('value', sel);

                $('a[data-toggle="' + tog + '"]').not('[data-title="' + sel + '"]').removeClass('active').addClass('notActive');
                $('a[data-toggle="' + tog + '"][data-title="' + sel + '"]').removeClass('notActive').addClass('active');
            })
        </script>

    </jsp:attribute>
    <jsp:body>
        <div class="container-flex">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="info-alerta-tab" data-toggle="tab" href="#info-alerta" role="tab" aria-controls="info-alerta" aria-selected="true">Informacion de denuncia</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="clasif-tab" data-toggle="tab" href="#clasif" role="tab" aria-controls="clasif" aria-selected="false">Clasificación</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="result-tab" data-toggle="tab" href="#result" role="tab" aria-controls="result" aria-selected="false">Resolución</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="info-alerta" role="tabpanel" aria-labelledby="info-alerta-tab">
                    AQUI HABRAN VARIOS INPUTS
                </div>

                <div class="tab-pane fade" id="clasif" role="tabpanel" aria-labelledby="clasif-tab">
                    <form class="form" action="/denuncias/cambiar_clasificacion/${complaint.idComplaint}">

                        <div class="form-group row">
                            <label for="happy" class="col-sm-4 col-md-4 control-label text-right">Clasificación de la Alerta:</label>
                            <div class="col-sm-7 col-md-7">
                                <div class="input-group">
                                    <div id="radioBtn" class="btn-group">
                                        <a class="btn btn-primary btn-sm active" data-toggle="happy" data-title="1">LEVE</a>
                                        <a class="btn btn-primary btn-sm notActive" data-toggle="happy" data-title="2">GRAVE</a>
                                    </div>
                                    <input type="hidden" name="priority.id_priority" id="happy">
                                </div>
                            </div>
                        </div>
                        <input name="clasificationComment" type="hidden">
                        <div id="clasificationComment"></div>
                        <br>
                        <button type="button" class="btn btn-primary btn-lg btn-block">Guardar Clasificación</button>
                    </form>
                </div>

                <div class="tab-pane fade" id="result" role="tabpanel" aria-labelledby="result-tab">
                    <form class="form" action="/denuncias/setear_resolucion/${complaint.idComplaint}">
                        <input name="resolution" type="hidden">
                        <div id="resolution"></div>
                        <br>
                        <button type="button" class="btn btn-primary btn-lg btn-block">Guardar Resolución</button>
                    </form>
                </div>
            </div>

        </div>


    </jsp:body>
</t:admin-template>