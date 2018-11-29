<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<html>
<head>
    <title>Demo KT3</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2" style="height: 100%">
            <br><h5 align="center">Filters</h5><br>
            <form action="${pageContext.request.contextPath}/kt3" method="get">
                <label for="pagin">Number of element on one page:</label>
                <input type="text" style="width: 5em" class="form-control" name="pagin" id="pagin"
                       value="${requestScope.pagin}">
                <label for="city">City:</label>
                <select class="form-control" name="city" id="city">
                    <c:forEach var="cityIn" items="${requestScope.cities}">
                        <c:if test="${cityIn eq requestScope.city}">
                            <option selected value="${cityIn}">${cityIn}</option>
                        </c:if>
                        <c:if test="${cityIn != requestScope.city}">
                            <option value="${cityIn}">${cityIn}</option>
                        </c:if>
                    </c:forEach>
                </select><br>
                <label for="place">Place:</label>
                <select class="form-control" name="place" id="place">
                    <c:forEach var="placeIn" items="${requestScope.places}">
                        <c:if test="${placeIn eq requestScope.place}">
                            <option selected value="${placeIn}">${placeIn}</option>
                        </c:if>
                        <c:if test="${placeIn != requestScope.place}">
                            <option value="${placeIn}">${placeIn}</option>
                        </c:if>
                    </c:forEach>
                </select><br>
                <label for="groop">Groop:</label>
                <select class="form-control" name="groop" id="groop">
                    <c:forEach var="groopIn" items="${requestScope.groops}">
                        <c:if test="${groopIn eq requestScope.groop}">
                            <option selected value="${groopIn}">${groopIn}</option>
                        </c:if>
                        <c:if test="${groopIn != requestScope.groop}">
                            <option value="${groopIn}">${groopIn}</option>
                        </c:if>
                    </c:forEach>
                </select><br>
                <button type="submit" class="btn btn-outline-primary">Find by filters</button>
            </form>
        </div>
        <div class="col-md-8" style="height: 100%">
            <br>
            <c:forEach var="concert" items="${requestScope.concerts}">
                <div class="card">
                    <h5 class="card-header">${concert.concertName}</h5>
                    <div class="card-body">
                        <h5 class="card-title">Группа: ${concert.groop.groopname}</h5>
                        <p class="card-text">Место: ${concert.concertPlace.place}</p>
                        <p class="card-text">Город: ${concert.concertPlace.city}</p>
                    </div>
                </div>
                <br>
            </c:forEach>
            <nav aria-label="Page navigation" >
                <ul class="pagination justify-content-center">
                    <c:forEach var="i" begin="1" end="${countPage}" step="1">
                        <li class="page-item"><a class="page-link"
                                                 href="/kt3?numPage=${i}&pagin=${pagin}&city=${city}&place=${place}&groop=${groop}">${i}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
        <div class="col-md-2" style="height: 100%">
        </div>
    </div>
</div>
</body>
</html>
