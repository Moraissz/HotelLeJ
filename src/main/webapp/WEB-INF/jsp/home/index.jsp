<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
  <link rel="stylesheet" href="/HotelLeJ/css/style.css">
</head>

<body>
	<t:navbar>
	</t:navbar>
	<t:header>
	</t:header>

    <!-- Barra de busca -->
    <div class="container mt-2">
      <div class="row">
        <div class="card mx-auto col-12">
          <div class="card-body">
            <form action="">
              <div class="row">
                <div class="col">
                  <label for="">Data de entrada</label>
                  <input name="dataEntrada" type="date" class="form-control">
                </div>
                <div class="col">
                  <label for="">Data de Saida</label>
                  <input name="dataSaida" type="date" class="form-control">
                </div>
                <div class="col">
                    <label for="">Quantidade Pessoas</label>
                    <input name="qtdPessoas" type="text" class="form-control">
                  </div>
                  
                  <input type="submit" class="btn btn-primary" value="Pesquisar"></input>
              </div>  
            </form>
          </div>
        </div>


      </div>
    </div>
    <!-- Barra de busca -->


   <t:footer></t:footer>
</body>

</html>