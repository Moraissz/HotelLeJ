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

<div class="container mt-2">
      <div class="row">
        <div class="card col-12">
          <div class="card-body text-center text-primary Sizeup">
            Preencha o formulario para finalizar sua reserva!
          </div>
        </div>
      </div>
    </div>
    <div class="container mt-2 px-0">
      <div class="row">
        <div class="col-6">
          <div class="card">
            <img class="card-img-top" src="/HotelLeJ/images/room_1.jpg" alt="Card image cap">
            <div class="card-header">
              <h4 class="card-title text-center">Quarto</h4>
            </div>
            <div class="card-body">
                <p class="card-text">Descricao: ${quarto.descricao}</p>
                <p class="card-text">Numero quarto: ${quarto.numero_quarto}</p>
                <p class="card-text">Andar: ${quarto.numero_andar}</p>
                <p class="card-text">Quantidade de pessoas: ${quarto.quantidade_pessoas}</p>
                <p class="card-text">Número de banheiros:${quarto.numero_banheiro}</p>
            </div>
          </div>
        </div>
        <div class="col-6">
          <form action="/HotelLeJ/reservas/sucesso">
            <div class="card">
              <div class="card-header">Dados do alugador responsável
                <div class="card-body">
                  <div class="form-group">
                    <label for="nomePessoa">Nome:</label>
                    <input name="pessoa_nome" type="text" class="form-control" id="nomePessoa" aria-describedby="emailHelp" placeholder="Informe seu nome">
                  </div>
                  <div class="form-group">
                    <label for="documentoPessoa">Documento:</label>
                    <input name="pessoa_documento" type="text" class="form-control" id="documentoPessoa" placeholder="Informe seu Documento">
                  </div>
                  <div class="form-group">
                    <label for="pessoas">Quantidade de Pessoas:</label>
                    <input name="pessoas" type="text" class="form-control" id="pessoas" placeholder="Informe a quantidade de pessoas">
                  </div>
                  <div class="form-group">
                    <label for="Telefone">Telefone:</label>
                    <input name="Telefone" type="text" class="form-control"  placeholder="Informe seu Telefone">
                  </div>
                  <div class="form-group">
                    <label for="Consideracao">Alguma consideracao:</label>
                    <input name="Consideracao" type="text" class="form-control"  placeholder="Alguma consideracao">
                  </div>
                </div>

              </div>
            </div>
        </div>
      </div>
    </div>


    <div class="container mt-2">
      <div class="row">
        <div class="card col-12 px-0">
          <div class="card-footer col-12 text-center">
            <input type="submit" class="btn btn-primary" value="Finalizar Reservar">
          </div>
          </form>
        </div>
      </div>
    </div>
      

  <t:footer>

  </t:footer>
</body>

</html>