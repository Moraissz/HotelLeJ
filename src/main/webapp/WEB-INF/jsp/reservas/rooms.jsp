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
  <div class="container mt-2">
    <div class="row">
      <div class="card mx-auto col-12">
        <div class="card-body">
          <form>
            <div class="row">
              <div class="col">
                <label for="">Data de entrada</label>
                <input type="date" class="form-control">
              </div>
              <div class="col">
                <label for="">Data de Saida</label>
                <input type="date" class="form-control">
              </div>
              <div class="col">
                <label for="">Quantidade Pessoas</label>
                <input type="text" class="form-control">
              </div>

              <input type="submit" class="btn btn-primary" value="Pesquisar"></input>
            </div>
          </form>
        </div>
      </div>


    </div>
  </div>

  <div class="container mt-3">
    <div class="row">
      <div class="card col-12">
        <div class="card-body text-center text-primary Sizeup">
          Venha conhecer nossos quartos
        </div>
      </div>
    </div>
  </div>

  <div class="container mt-2 px-0">
    <div class="row">
        <c:forEach var="quarto" items="${quartoList}">
        <form class="col-12 form-inline px-0" action="/HotelLeJ/reserva/finalizar">
          <div class="col-sm-4 mt-4">
            <div class="card">
              <img class="card-img-top" src="/HotelLeJ/images/room_1.jpg" alt="Card image cap">
              <div class="card-header">
                <h4 class="card-title text-center">${quarto.nome}</h4>
              </div>
              <div class="card-body">
                <p class="card-text">Descricao: ${quarto.descricao}</p>
                <p class="card-text">Numero: ${quarto.numero}</p>
                <p class="card-text">Andar: ${quarto.andar}</p>
                <p class="card-text">QtdPessoas: ${quarto.qtdPessoas}</p>
                <p class="card-text">NroBanheiros:${quarto.nroBanheiros}</p>
                <input type="hidden" value="${quarto.id}">
              </div>
              <div class="card-footer text-center">
                <input  type="submit" class="btn btn-primary" value="Reservar">
              </div>
            </div>
          </div>
          </form>
        </c:forEach>
    </div>
  </div>

  <t:footer>

  </t:footer>
</body>

</html>