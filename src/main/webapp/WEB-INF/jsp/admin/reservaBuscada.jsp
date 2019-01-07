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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
            Reserva Buscada
          </div>
          <div class="card-body px-0 col-12">

            <img class="card-img-top" src="/HotelLeJ/images/room_1.jpg" alt="Card image cap">
            <div class="card-header">
              <h4 class="card-title text-center">Quarto</h4>
            </div>
            <div class="card-body">
            <p  class="card-text">ID Reserva: ${reserva.id_reserva}</p>
            <p  class="card-text">Usuario: ${reserva.usuario}</p>
            <p class="card-text">Descricao: ${reserva.descricao }</p>
            <p class="card-text">Numero quarto:${reserva.numero_quarto }</p>
            <p class="card-text">Andar: ${reserva.numero_andar }</p>
            <p class="card-text">Quantidade de pessoas: ${reserva.quantidade_pessoas }</p>
            <p class="card-text">Data Entrada: ${reserva.data_entrada} </p>
            <p class="card-text">Data Saida: ${reserva.data_saida} </p>
            <p class="card-text">Checkin: ${reserva.data_checkin} </p>
            <p class="card-text">Valor: ${reserva.valor} </p>
            <p class="card-text">Status: ${reserva.status} </p>
            </div>
            <div class="card-footer">
                <form action="/HotelLeJ/admin/reservaDeletada">
                  <button type="submit"  class="btn btn-primary btn-block" ${reserva.status.equals('Finalizado') || reserva.status.equals('Confirmado') ? 'disabled="disabled"' : ''}
                  ${checkInDay  ? '' : 'disabled="disabled"'}
                  >Deletar Reserva</button>
                </form>
               
                <form action="/HotelLeJ/admin/alterarReserva" class="my-2">
                <button type="submit"  class="btn btn-primary btn-block" ${reserva.status.equals('Finalizado') || reserva.status.equals('Confirmado') ? 'disabled="disabled"' : ''}
                 ${checkInDay2  ? '' : 'disabled="disabled"'}
                >Alterar Reserva</button>
                </form>
                
                <form action="/HotelLeJ/admin/reservaFinalizada">
                  <button type="submit"  class="btn btn-primary btn-block" ${reserva.status.equals('Finalizado') ? 'disabled="disabled"' : ''}
                   ${checkInDay3  ? '' : 'disabled="disabled"'}
                  >Finalizar Reserva</button>
                </form>
            </div>
            <a href="/HotelLeJ/admin/profile" class="btn btn-outline-dark btn-block mt-2">Back</a>
          </div>

        </div>
      </div>
    </div>
          
    
  <t:footer>

  </t:footer>
</body>

</html>