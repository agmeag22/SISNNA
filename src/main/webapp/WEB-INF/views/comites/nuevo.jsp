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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>
        <script>
            $(document).ready(function () {
                var max_fields = 100;
                var wrapper = $(".card-body2");
                var add_button = $(".add_form_field");
                var x = 1;
                $(add_button).click(function (e) {
                    e.preventDefault();
                    if (x < max_fields) {
                        x++;
                        $(wrapper).append('<div class="input-group">\n\
                        <select class="custom-select" id="inputGroupSelect04" aria-label="Example select with button addon">\n\
                        <option selected>Elija un nuevo miembro</option><option value="1">Tiger Nixonz</option><option value="2">Garrett Winters</option>\n\
                        <option value="3">Ashton Cox</option><option value="3">Cedric Kelly</option><option value="3">Airi Satou</option>\n\
                        <option value="3">Brielle Williamson</option><option value="3">Herrod Chandler</option></select><div class="input-group-append">\n\
                        <a href="#" class="btn btn-danger btn-icon-split delete"><span class="icon text-white-50">\n\
                        <i class="fas fa-trash"></i></span><span class="text">Eliminar</span></a></div></div><br>'); //add input box
                    } else {
                        alert('You Reached the limits')
                    }
                });

                $(wrapper).on("click", ".delete", function (e) {
                    e.preventDefault();
                    $(this).parent('div').parent('div').remove();
                    x--;
                })
            });
        </script>

    </jsp:attribute>
    
    <jsp:body>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Comites</h1>
        <br><br>
        <div class="container1">
            <div class="card mb-4">
                <div class="card-header">
                    INFORMACION GENERAL DEL COMITE
                </div>
                <div class="card-body">
                    <div><label>Nombre del Comite</label></div>
                    <div><input type="text" class="form-control" name="ComitteeName"></div>
                    <div><label>Descripción</label></div>
                    <div><input type="text" class="form-control" name="ComitteeName"></div>
                    <div><label>Función</label></div>
                    <div><input type="text" class="form-control" name="ComitteeName"></div>
                </div>
            </div>

            <div class="card mb-4">
                <div class="card-header">
                    MIEMBROS DEL COMITE
                </div>
                <div class="card-body card-body2">
                    <div><label>Añadir Miembros</label></div>
                    <div><a href="#" class="add_form_field btn btn-success btn-icon-split" style="margin-bottom: 10px;">
                            <span class="icon text-white-50">
                                <i class="fas fa-plus"></i>
                            </span>
                            <span class="text">A&ntildeadir Miembro</span>
                        </a></div>
                </div>
            </div>

            <!--div><input type="text" class="form-control col-sm-4"  name="mytext[]"-->

            <a href="${pageContext.request.contextPath}/comites" class="btn btn-warning btn-icon-split" >
                    <span class="icon text-white-50">
                      <i class="far fa-save"></i>
                    </span>
                    <span class="text">Guardar Comite</span>
                  </a>



        </div>
    </tbody>
</jsp:body>
</t:admin-template>