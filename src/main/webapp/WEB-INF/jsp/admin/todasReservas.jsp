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

  <div class="container mt-3">
    <div class="row">
      <div class="card col-12">
        <div class="card-body text-center text-primary Sizeup">
          Todas as Reservas
        </div>
      </div>
    </div>
  </div>
  <div class="container mt-2 px-0">
    <div class="row">
	<c:forEach var="reserva" items="${reservaList}">
      <div class="col-sm-4 mt-4">
        <div class="card">
          <img class="card-img-top" src="/HotelLeJ/images/room_1.jpg" alt="Card image cap">
          <div class="card-header">
            <h4 class="card-title text-center">Nome do Quarto</h4>
          </div>
          <div class="card-body">
            <p class="card-text">idReserva: ${reserva.id_reserva}</p>
            <p class="card-text">Descricao: ${reserva.descricao }</p>
            <p class="card-text">Numero:${reserva.numero_quarto }</p>
            <p class="card-text">Andar: ${reserva.numero_andar }</p>
            <p class="card-text">QtdPessoas: ${reserva.quantidade_pessoas }</p>
           
            
          </div>
        </div>
      </div>
   </c:forEach>
    </div>
  </div>
  <div class="container mt-3">
    <div class="row">
      <a href="/HotelLeJ/admin/profile" class="btn btn-outline-dark btn-block mt-2">Back</a>
    </div>
  </div>

  <t:footer>

  </t:footer>
</body>

</html>