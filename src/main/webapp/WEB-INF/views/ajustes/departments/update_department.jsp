<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:admin-template>
     <jsp:attribute name="styles">

    </jsp:attribute>
    <jsp:attribute name="title">Modificar Usuario</jsp:attribute>
    <jsp:attribute name="scripts">

    </jsp:attribute>
    <jsp:body>


        <form action="${pageContext.request.contextPath}/usuarios/modificado" method = "post" class="user">
            ${respuesta}
                    <div class="form-group">
                        ID
                        <input type="text" class="form-control form-control-user" name="id" id="inputId" value="${user.id}">
                    </div>
                    <div class="form-group">
                        Username
                      <input type="text" class="form-control form-control-user" name="username" id="inputUsername" value="${user.username}">
                    </div>

                     <div class="form-group">
                        Password
                      <input type="password" class="form-control form-control-user" name="password" id="inputPassword" value="${user.password}">
                    </div>
                    <div class="form-group">
                        Name
                      <input type="text" class="form-control form-control-user" name="name" id="inputName" value="${user.name}">
                    </div>
                    <div class="form-group">
                        Last Name
                      <input type="text" class="form-control form-control-user" name="lastname" id="inputLastName" value="${user.lastname}">
                    </div>
                    <div class="form-group">
                        Role
                      <input type="text" class="form-control form-control-user" name="role" id="inputRole" value="${user.role}">
                    </div>
                    <div class="form-group">
                        Department
                      <input type="text" class="form-control form-control-user" name="department" id="inputDepartment" value="${user.department}">
                    </div>

                    <div class="form-group">
                        Committee
                      <input type="text" class="form-control form-control-user" name="committee" id="inputCommittee" value="${user.committee}">
                    </div>
                    <div class="form-group">
                        E-mail
                      <input type="text" class="form-control form-control-user" name="email" id="inputEmail" value="${user.email}">
                    </div>

                    <div class="form-group">
                        Created Alerts
                      <input type="text" class="form-control form-control-user" name="createdAlert" id="inputCreatedAlert" value="${user.createdAlert}">
                    </div>

                    <div class="form-group">
                        Assigned Alerts
                      <input type="text" class="form-control form-control-user" name="assignedAlert" id="inputAssignedAlert" value="${user.assignedAlert}">
                    </div>

                    <div class="form-group">
                        State
                      <input type="text" class="form-control form-control-user" name="state" id="inputState" value="${user.state}">
                    </div>
                    <input type="hidden" id="userNumber" name="userNumber" value="${user.number}">


                    <button type="submit" class="btn btn-primary btn-user">
                      Modificar Usuario
                    </button>
                  </form>
    </jsp:body>
</t:admin-template> 