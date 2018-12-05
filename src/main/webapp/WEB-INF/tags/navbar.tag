<%@tag description="Header template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="url" value="${pageContext.request.requestURI}"/>
<c:set var="homeUrl" value="/HotelLeJ/WEB-INF/jsp/home/index.jsp"/>
<c:set var="roomsUrl" value="/HotelLeJ/WEB-INF/jsp/reservas/rooms.jsp"/>
<c:set var="loginUrl" value="/HotelLeJ/WEB-INF/jsp/login/home.jsp"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
  <link rel="stylesheet" href="HotelLeJ/css/style.css">
</head>

<body>
<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark  bg-dark">
      <a class="navbar-brand" href="#">Hotel L&J</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item ${url.equals(homeUrl) ? 'active': ''}">
            <a class="nav-link" href="/HotelLeJ/" >Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item ${url.equals(roomsUrl) ? 'active': ''}">
            <a class="nav-link " href="/HotelLeJ/reservas/rooms">Rooms</a>
          </li>
        </ul>
        <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
            <li class="nav-item ${url.equals(loginUrl) ? 'active': ''}"">
              <a class="nav-link" href="/HotelLeJ/login/home"  > Login<img src="/HotelLeJ/images/avatar.png" alt=""> </a>
            </li>
          </ul>
      </div>
    </nav>
  </header>
  <!-- Fixed navbar -->
</body>
</html>