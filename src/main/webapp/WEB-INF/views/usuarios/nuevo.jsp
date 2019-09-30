<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin-template>
     <jsp:attribute name="styles">

    </jsp:attribute>
    <jsp:attribute name="title">Crear Usuario</jsp:attribute>
    <jsp:attribute name="marked">createUser</jsp:attribute>
    <jsp:attribute name="scripts">

    </jsp:attribute>
    <jsp:body>


        <form action="${pageContext.request.contextPath}/usuarios/nuevo" method = "post" class="user">
            ${respuesta}
                    <div class="form-group">
                        ID
                      <input type="text" class="form-control form-control-user" name="id" id="inputId">
                    </div>
                    <div class="form-group">
                        Username
                      <input type="text" class="form-control form-control-user" name="username" id="inputUsername">
                    </div>

                     <div class="form-group">
                        Password
                      <input type="password" class="form-control form-control-user" name="password" id="inputPassword">
                    </div>
                    <div class="form-group">
                        Name
                      <input type="text" class="form-control form-control-user" name="name" id="inputName">
                    </div>
                    <div class="form-group">
                        Last Name
                      <input type="text" class="form-control form-control-user" name="lastname" id="inputLastName">
                    </div>
                    <div class="form-group">
                        Role
                      <input type="text" class="form-control form-control-user" name="role" id="inputRole">
                    </div>
                    <div class="form-group">
                        Department
                      <input type="text" class="form-control form-control-user" name="department" id="inputDepartment">
                    </div>

                    <div class="form-group">
                        Committee
                      <input type="text" class="form-control form-control-user" name="committee" id="inputCommittee">
                    </div>
                    <div class="form-group">
                        E-mail
                      <input type="text" class="form-control form-control-user" name="email" id="inputEmail">
                    </div>

                    <div class="form-group">
                        Created Alerts
                      <input type="text" class="form-control form-control-user" name="createdAlert" id="inputCreatedAlert">
                    </div>

                    <div class="form-group">
                        Assigned Alerts
                      <input type="text" class="form-control form-control-user" name="assignedAlert" id="inputAssignedAlert">
                    </div>

                    <div class="form-group">
                        State
                      <input type="text" class="form-control form-control-user" name="state" id="inputState">
                    </div>

                    <button type="submit" class="btn btn-primary btn-user">
                      Añadir Usuario
                    </button>
                  </form>
    </jsp:body>
</t:admin-template>
