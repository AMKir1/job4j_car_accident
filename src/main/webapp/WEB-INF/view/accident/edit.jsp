<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
            integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
            integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<div class="container pt-3">

    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Изменение
            </div>
            <div class="card-body">
                <form action="<c:url value='/update'/>" method='POST'>
                    <div class="form-group">

                        <input type="text" class="form-control" name="id" value="${accident.id}" hidden>
                    </div>
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text" class="form-control" name="name" value="${accident.name}" placeholder="${accident.name}">
                    </div>
                    <div class="form-group">
                        <label>Описание</label>
                        <input type="text" class="form-control" name="text" value="${accident.text}" placeholder="${accident.text}">
                    </div>
                    <div class="form-group">
                        <label>Адрес</label>
                        <input type="text" class="form-control" name="address" value="${accident.address}" placeholder="${accident.address}">
                    </div>
                    <div class="form-group mb-3">
                        <label for="type" class="form-label">Тип инцидента: </label>
                        <select class="form-select" id="type" name="type.id">
                            <c:forEach var="type" items="${types}" >
                                <c:if test="${accident.type.id ==  type.id}">
                                <option value="${type.id}" selected>${type.name}</option>
                                </c:if>
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <input name="submit" type="submit" value="Сохранить" />
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>