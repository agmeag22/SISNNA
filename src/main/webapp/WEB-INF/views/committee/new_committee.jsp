<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<t:admin-template>
    <jsp:attribute name="marked">nuevo-comite</jsp:attribute>
    <jsp:attribute name="title">Comites</jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Custom styles for this page -->
        <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <style>
            .hidden{
                display:none
            } 
        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
       <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <script>
            var members = [];
             var temp_listado_usuarios = [];
             $(document).ready(function () {
                $('#dataTable').DataTable({
                    select: true
                });
                
                $(".addUserButton").on( "click",function(){
                    var id = $(this).data("id");
                    var name = $(this).data("name");
                    var email = $(this).data("email");
                    var item = {id:id,name:name,email:email};
                    console.log("Esta agregando el id" +id);
                    var query = '.removeUserButton[data-id="'+id+'"]';
                    console.log(query);
                    $(query).removeClass("hidden");
                    $(this).addClass("hidden");
                    temp_listado_usuarios.push(item);
                });
                $(".removeUserButton").on( "click",function(){
                    var id = $(this).data("id");
                    var name = $(this).data("name");
                    var email = $(this).data("email");
                    var item = {id:id,name:name,email:email};
                    console.log("Esta borrando el id" +id);
                    var query = '.addUserButton[data-id="'+id+'"]';
                    console.log(query);
                    $(this).addClass("hidden");
                    $(query).removeClass("hidden");
                    temp_listado_usuarios.splice( temp_listado_usuarios.indexOf(item), 1 );
                });
                $('#userModal').on('shown.bs.modal', function (event) {
                    temp_listado_usuarios = [...members];
                    $(".addUserButton").removeClass("hidden");
                    $(".removeUserButton").addClass("hidden");
                    members.forEach(function(element){
                        var query = '.addUserButton[data-id="'+element.id+'"]';
                        $(query).addClass("hidden");
                        var query = '.removeUserButton[data-id="'+element.id+'"]';
                        $(query).removeClass("hidden");                        
                    });
                        
                  });
                  $('#saveMembers').on("click",function(){
                      members = [...temp_listado_usuarios];
                      updateMembersList();
                  });
                });
                function updateMembersList(){
                    var container = document.getElementById("member-list")
                    var list = "<table><tbody>"
                    members.forEach(function(element){    
                        list+=`<tr><td>${"${element.name}"}</td><td> ${"${element.email}"}</td></tr>`
                    });
                    list+="<tbody></table>"
                    container.innerHTML = list;
                }
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
                    <div><input type="text" class="form-control" name="name"></div>
                     <div class="form-group">
                                <label>Pais</label>
                                <select class="form-control">
                                       <c:forEach items="${countries}" var="country">
                                        <option value="${country.idCountry}">${country.name}</option>
                                         </c:forEach>
                                </select>
                            </div>
                  
                    
                </div>
            </div>

            <div class="card mb-4">
                <div class="card-header">
                    MIEMBROS DEL COMITE
                </div>
                <div class="card-body card-body2">
                    <div><a href="#userModal" class="add_form_field btn btn-warning btn-icon-split" style="margin-bottom: 10px;" data-toggle="modal" >
                            <span class="icon text-white-50">
                                <i class="fas fa-edit"></i>
                            </span>
                            <span class="text">Editar Miembros</span>
                          
                        </a></div>
                <div id="member-list"></div>
                </div>
            </div>
            
             <div class="card mb-4">
                <div class="card-header">
                    PUNTO DE CONTROL
                </div>
                <div class="card-body card-body2">
                    <div><a href="#" class="add_form_field btn btn-success btn-icon-split" style="margin-bottom: 10px;">
                            <span class="icon text-white-50">
                                <i class="fas fa-edit"></i>
                            </span>
                            <span class="text">Seleccionar</span>
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

    
    <div class="modal" id="userModal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Busqueda de Usuarios</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times; </span>
              </button>
            </div>
            <div class="modal-body">
             <div class="">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>EMAIL</th>
                                
                                <th>ACCI�N</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>EMAIL</th>
          
                                <th>ACCI�N</th>

                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${usuarios}" var="item">
                                <tr>
                                    <td>${item.idUser}</td>
                                    <td>${item.personalInfo.name}</td>
                                    <td>${item.email}</td>
                                    <td>
                                            <button class="btn btn-success addUserButton" type="button" data-id="${item.idUser}" data-email="${item.email}" data-name="${item.personalInfo.name}" aria-expanded="false">
                                                <p style="margin-bottom:0;"><em class="fa fa-plus"></em><span> A�adir</span></p>
                                            </button>
                                             <button  class="btn btn-danger removeUserButton hidden" type="button" data-id="${item.idUser}" data-email="${item.email}" data-name="${item.personalInfo.name}" aria-expanded="false">
                                                <p style="margin-bottom:0;"><em class="fa fa-trash"></em><span> Eliminar</span></p>
                                            </button>
                                        </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </div>
            <div class="modal-footer">
              <button type="button" id="saveMembers" data-dismiss="modal" class="btn btn-primary">Guardar</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div>
          </div>
      </div>
</jsp:body>
</t:admin-template>