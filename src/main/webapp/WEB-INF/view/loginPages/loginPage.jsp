<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html  "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>

  <title></title>
  <meta charset="UTF-8">


  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">


</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Logo and responsive toggle -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>



    </div>
    <!-- Navbar links -->



    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
</nav>

<div class="jumbotron feature">
  <div class="container">
    <h1>Добро пожаловать</h1>
    <button class="section__button section__button1" >Войти</button>


  </div>
</div>




<div class="modal modal1">
  <div class="modal__main">
    <h2 class="modal__title">Войти в аккаунт диспетчера</h2>

    <div class="row">
      <div class="col-lg-12">
        <form:form action="checkUser" modelAttribute="loginDispatcher" cssClass="form">

          <div class="form__field">
            <form:input maxlength="15" id="currentName" required="true" path="name" placeholder="Имя"/>
          </div>

          <div class="form__field">
            <form:input   maxlength="25" id="currentSurname" required="true" path="surname" placeholder="Фамилия"/>
          </div>
          <div class="form__field">
            <form:password maxlength="20" minlength="6"  required="true" path="password"  placeholder="Пароль"/>
          </div>
          <input class="btn-default" type="submit" onclick="saveCurrentDispatcher()" value="OK"/>

        </form:form>
      </div>
    </div>

    <button class="modal__close">&#10006;</button>
  </div>
</div>









<script src="js/script.js"></script>
<script src="js/saveCurrentDispatcher.js"></script>

</body>

</html>
