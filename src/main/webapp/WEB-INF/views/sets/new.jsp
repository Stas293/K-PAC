<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>New Knowledge Package set</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>Create new knowledge-package set</h1>
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
    <form action="/sets/save" method="post">
        <div class="row">
            <div class="col-12">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="Title" value="${knowledgePackageSet.title}">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="mb-3">
                        <label for="knowledgePackages" class="form-label">Knowledge packages</label>
                        <select class="form-select" id="knowledgePackages" name="knowledgePackages" multiple size="20">
                            <c:forEach items="${knowledgePackages}" var="knowledgePackage">
                                <c:if test="${knowledgePackageSet.knowledgePackages.contains(knowledgePackage.id)}">
                                    <option value="${knowledgePackage.id}" selected>${knowledgePackage.title}</option>
                                </c:if>
                                <c:if test="${not knowledgePackageSet.knowledgePackages.contains(knowledgePackage.id)}">
                                    <option value="${knowledgePackage.id}">${knowledgePackage.title}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
