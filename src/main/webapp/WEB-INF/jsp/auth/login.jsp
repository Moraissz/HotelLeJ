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

  <div class="container login-container">
    <div class="row">
      <div class="col-12 login-form-1">
        <h3>Login</h3>
        <form name="loginform" action="" method="post">
            <div class="form-group">
                <input name="username" type="text" class="form-control" placeholder="Your Username *" value="" />
            </div>
            <div class="form-group">
                <input name="password"type="password" class="form-control" placeholder="Your Password *" value="" />
            </div>
            <div class="form-group">
                <input  name="submit" type="submit" class="btnSubmit" value="Login" />
            </div>
            <div class="form-group">
                <a href="/HotelLeJ/auth/cadastrar" class="ForgetPwd">Cadastre-se</a>
            </div>
        </form>
    </div>
    </div>
    
  </div>

  <t:footer>

  </t:footer>
</body>

</html>