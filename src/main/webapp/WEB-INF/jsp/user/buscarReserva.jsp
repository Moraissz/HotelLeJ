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
            Buscar Reserva
          </div>
          <div class="card-body col-12">
            <form action="/HotelLeJ/user/reservaBuscada">
              <div class="form-group">
                <label for="idReserva">ID da Reserva:</label>
                <input type="text" class="form-control" id="idReserva" aria-describedby="emailHelp" placeholder="Informe o ID da reserva que deseja buscar">
              </div>
              <input type="submit" class="btn btn-primary btn-block" value="Buscar Reserva">
            </form>
            <a href="/HotelLeJ/user/profile" class="btn btn-outline-dark btn-block mt-2">Back</a>
          </div>

        </div>
      </div>
    </div>
          
    
  <t:footer>

  </t:footer>
</body>

</html>