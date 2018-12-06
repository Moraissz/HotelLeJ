<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
  <link rel="stylesheet" href="/HotelLeJ/css/style.css">
</head>

<body>
  <t:navbar>
  </t:navbar>
  <t:header>
  </t:header>

  <div class="container">
    <div class="row">
      <div class="card col-12 px-0">
        <div class="card-header text-center Sizeup">
          Bem Vindo, Admin
        </div>
        <div class="card-body col-12">
           <a href="/HotelLeJ/admin/todasReservas" class="btn btn-primary btn-block">Ver todas reservas</a>
           <a href="/HotelLeJ/admin/reservasCheckIn" class="btn btn-primary btn-block">Reservas com check-in realizado</a>
           <a href="/HotelLeJ/admin/buscarReserva" class="btn btn-primary btn-block">Buscar reserva específica</a>
           <a href="/HotelLeJ/admin/reservasSemCheckIn" class="btn btn-primary btn-block">Reservas sem check-in realizado</a>
        </div>
      </div>
    </div>
  </div>

  <t:footer>

  </t:footer>
</body>

</html>