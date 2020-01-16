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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/new_user.css" type="text/css" media="screen">
        <style>


        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>


    </jsp:attribute>
    <jsp:body>
        <div class="container-flex">

            <div>${complaint.user.personalInfo.name}</div>
            <div>${complaint.user.personalInfo.birthDate}</div>
            <div>${complaint.user.personalInfo.gender.name}</div>
            <div>${complaint.user.personalInfo.country.name}</div>
            <div>${complaint.user.personalInfo.municipality.name}</div>
            <div>${complaint.user.personalInfo.address}</div>
            <div>${complaint.user.email}</div>
            <div>${complaint.user.personalInfo.guardianName}</div>
            <div>${complaint.user.personalInfo.guardianContact}</div>
            <div>${complaint.priority}</div>
            <div>${complaint.state.name}</div>
            <div>${complaint.victimName}</div>
            <div>${complaint.victimAge}</div>
            <div>${complaint.grade}</div>
            <div>${complaint.scholarCenter}</div>
            <div>${complaint.misdemeanorDate}</div>
            <div>${complaint.misdemeanorTime}</div>
            <div>${complaint.accusedName}</div>
            <div>${complaint.description}</div>
            <div>${complaint.childContext}</div>
            <div>${complaint.actionTaken}</div>
            <div>${complaint.situationLocation}</div>
            <div>${complaint.isRecurrence}</div>
            <div>${complaint.createdDate}</div>
            <div>${complaint.updatedDate}</div>
            <c:forEach items="${complaintAbuses}" var="item">
                    ${item.abuse.name}
            </c:forEach>
            <c:forEach items="${complaintPrograms}" var="item">
                    ${item.program.name}
            </c:forEach>
            <%--        <div>${complaint.processList}</div>
                    <div>${complaint.complaintProgramsList}</div>
                    <div>${complaint.complaintEvidenceList}</div>
                    <div>${complaint.complaintAbusesList}</div>--%>
            <div>${complaint.accusedType.name}</div>

        </div>
    </jsp:body>
</t:admin-template>