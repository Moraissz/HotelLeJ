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
            Alterar Usuario
          </div>
          <div class="card-body col-12">
            <form action="/HotelLeJ/user/sucesso">
              <div class="form-group">
                <label for="nomePessoa">Nome:</label>
                <input type="email" class="form-control" id="nomePessoa" aria-describedby="emailHelp" placeholder="Lucas Morais">
              </div>
              <div class="form-group">
                <label for="documentoPessoa">Documento:</label>
                <input type="text" class="form-control" id="documentoPessoa" placeholder="111-111-111.23">
              </div>
              <input type="submit" class="btn btn-primary btn-block" value="Alterar Perfil">
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