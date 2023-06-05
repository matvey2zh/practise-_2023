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
    <div class="collapse navbar-collapse" id="navbar">
      <ul class="nav navbar-nav">
        <li>
          <a  onclick="window.location.href = 'orders'">Заказы</a>
        </li>
        <li >
          <a  onclick="window.location.href = 'dispatchers'">Диспетчеры</a>
        </li>
        <li>
          <a  onclick="window.location.href = 'drivers'">Водители</a>
        </li>
        <li>
          <a  onclick="window.location.href = 'routes'">Адреса</a>
        </li>
        <li>
          <a  onclick="window.location.href = 'cars'">Машины</a>
        </li>
        <li class="active">
          <a  onclick="window.location.href = 'reports'">Отчет</a>
        </li>
      </ul>



    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
</nav>

<div class="jumbotron feature">
  <div class="container">
    <h1>Отчеты</h1>
    <p>Выберите отчет</p>
    <button class="section__button " onclick="window.location.href = 'timetable'" >Расписание движения</button>
    <button class="section__button " onclick="window.location.href = 'ordersByOneDriver'" >Кол-во рейсов определенного водителя</button>

  </div>
</div>




<%--<div class="modal modal1">--%>
<%--  <div class="modal__main">--%>
<%--    <h2 class="modal__title">Добавить машину</h2>--%>

<%--    <div class="row">--%>
<%--      <div class="col-lg-12">--%>
<%--        <form:form action="saveCar" modelAttribute="car" cssClass="form">--%>

<%--          <form:hidden path="id"/>--%>
<%--          <div class="form__field">--%>
<%--            <h3><form:input path="govermentNumber" maxlength="8"  required="true" placeholder="Гос номер"/></h3>--%>
<%--          </div>--%>

<%--          <div class="form__field">--%>
<%--          <h3><form:input path="brand" maxlength="15"  required="true" placeholder="Бренд"/></h3>--%>
<%--          </div>--%>

<%--          <div class="form__field">--%>
<%--          <h3>Год выпуска <form:input path="yearOfRelease"  maxlength="4" minlength="4"/></h3>--%>
<%--          </div>--%>

<%--          <div class="form__field">--%>
<%--          <h3><form:input path="model" maxlength="15" required="true" placeholder="Модель"/></h3>--%>
<%--          </div>--%>

<%--          <input class="btn-default" type="submit" value="OK"/>--%>

<%--        </form:form>--%>
<%--      </div>--%>
<%--    </div>--%>

<%--    <button class="modal__close">&#10006;</button>--%>
<%--  </div>--%>
<%--</div>--%>











<script src="js/script.js"></script>

</body>

</html>
