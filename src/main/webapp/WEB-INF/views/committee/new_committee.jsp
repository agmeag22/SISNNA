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
            var members = [], PControl = null,puntoControl = false,temp_listado_usuarios = [];
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
                $('#userModal').on('hide.bs.modal', function (event) {
                    if(puntoControl)puntoControl=false;
                });
                $('#userModal').on('shown.bs.modal', function (event) {
                    if(!puntoControl){
                        temp_listado_usuarios = [...members];
                        $(".addUserButton").removeClass("hidden");
                        $(".removeUserButton").addClass("hidden");
                        $(".selectUserButton").addClass("hidden");
                        $("#saveMembers").removeClass("hidden");
                        members.forEach(function(element){
                            var query = '.addUserButton[data-id="'+element.id+'"]';
                            $(query).addClass("hidden");
                            var query = '.removeUserButton[data-id="'+element.id+'"]';
                            $(query).removeClass("hidden");                        
                        });
                    }else{
                        $(".addUserButton").addClass("hidden");
                        $(".removeUserButton").addClass("hidden");
                        $(".selectUserButton").removeClass("hidden");
                        $("#saveMembers").addClass("hidden");
                    }
                    
                  });
                  $('#saveMembers').on("click",function(){
                      members = [...temp_listado_usuarios];
                      var lista = members.map(elemento => elemento.id);
                      
                      $("#miembros").val(JSON.stringify(lista));
                      updateMembersList();
                  });
                });
                function updateMembersList(){
                    var container = document.getElementById("member-list")
                    var list = "<table><tbody>"
                    members.forEach(function(element,index){    
                        list+=`<tr><td>${"${element.name}"}</td><td> ${"${element.email}"}</td><td><input class="hidden" type="text" name="membersList[${"${index}"}].user.idUser" value="${"${element.id}"}"/><input class="hidden" type="text" name="membersList[${"${index}"}].role.idRole" value="3"/><td></tr>`;
                    });
                    list+="<tbody></table>"
                    container.innerHTML = list;
                    $("#pControlInput").attr('name',`membersList[${"${members.length}"}].user.idUser`);
                    $("#pControlInput2").attr('name',`membersList[${"${members.length}"}].user.idUser`);
                }
                
                function openpuntoControl(){
                     puntoControl=true;
                    $("#userModal").modal();
                }
                $('.selectUserButton').on("click",
                function(){
                    var id = $(this).data("id");
                    var name = $(this).data("name");
                    var email = $(this).data("email");
                    PControl = {id:id,name:name,email:email};
                    var container = document.getElementById("pcontrol-list")
                    var list = "<table><tbody>"
                     
                        list+=`<tr><td>${"${PControl.name}"}</td><td> ${"${PControl.email}"}</td></tr>`
                    list+="<tbody></table>"
                    list += `<input type="text" class="hidden" id="pControlInput" name="membersList[${"${members.length}"}].user.idUser" value="${"${id}"}" />`;
                    list += `<input type="text" class="hidden" id="pControlInput2" name="membersList[${"${members.length}"}].role.idRole" value="2" />`;

                    container.innerHTML = list;
                     
                     $("#puntoC").val(id);
                     $("#userModal").modal("hide")
                    
                });
                
                
        </script>
      
    </jsp:attribute>
    
    <jsp:body>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Comites</h1>
        <br><br>
        <form method="POST" action="${pageContext.request.contextPath}/comites/store"
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
                                <select class="form-control" name="country.idCountry">
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
                    <div><a type="button" href="#" class="add_form_field btn btn-success btn-icon-split" onclick="openpuntoControl()" style="margin-bottom: 10px;">
                            <span class="icon text-white-50">
                                <i class="fas fa-edit"></i>
                            </span>
                            <span class="text">Seleccionar</span>
                        </a></div>
                    <div id="pcontrol-list"></div>
                </div>
            </div>
            
            <!--div><input type="text" class="form-control col-sm-4"  name="mytext[]"-->

            <button class="btn btn-warning btn-icon-split" >
                    <span class="icon text-white-50">
                      <i class="far fa-save"></i>
                    </span>
                    <span class="text">Guardar Comite</span>
                  </button>


        </div>
        <input type="hidden" value="" name="miembros" id="miembros"/>
        <input type="hidden" value="" name="puntoC" id="puntoC"/>
        <div id="members-list"></div>
    </form>
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
                                
                                <th>ACCIÓN</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>EMAIL</th>
          
                                <th>ACCIÓN</th>

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
                                                <p style="margin-bottom:0;"><em class="fa fa-plus"></em><span> Añadir</span></p>
                                            </button>
                                             <button  class="btn btn-danger removeUserButton hidden" type="button" data-id="${item.idUser}" data-email="${item.email}" data-name="${item.personalInfo.name}" aria-expanded="false">
                                                <p style="margin-bottom:0;"><em class="fa fa-trash"></em><span> Eliminar</span></p>
                                            </button>
                                            <button class="btn btn-success selectUserButton hidden" type="button" data-id="${item.idUser}" data-email="${item.email}" data-name="${item.personalInfo.name}" aria-expanded="false">
                                                <p style="margin-bottom:0;"><em class="fa fa-plus"></em><span> Seleccionar</span></p>
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