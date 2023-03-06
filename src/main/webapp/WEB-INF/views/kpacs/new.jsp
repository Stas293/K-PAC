<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>New Knowledge Package</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>New Knowledge Package</h1>
        </div>
    </div>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger" role="alert">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error.defaultMessage}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="post" action="/kpacs/save">
        <div class="mb-3">
            <label for="title" class="form-label">Name</label>
            <input type="text" class="form-control" id="title" aria-describedby="nameHelp" name="title" value="${knowledgePackage.title}">
            <div id="nameHelp" class="form-text">Enter the name of the knowledge package.</div>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" class="form-control" id="description" aria-describedby="descriptionHelp" name="description" value="${knowledgePackage.description}">
            <div id="descriptionHelp" class="form-text">Enter the description of the knowledge package.</div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <a href="/kpacs" class="btn btn-secondary">Back</a>
</div>
</body>
</html>
