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
  <link href="css/tableStyle.css" rel="stylesheet">


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
    <br>
    <br>
    <button class="section__button section__button1" >Выбрать водителя</button>


  </div>
</div>





<div class="modal modal1">
  <div class="modal__main">
    <h2 class="modal__title">Выберите водителя</h2>

    <div class="row">
      <div class="col-lg-12">
        <c:forEach var="dr" items="${drivers}">


          <c:url var="selectButton" value="/selectDriver">
            <c:param name="driverId" value="${dr.id}"/>
          </c:url>
          <article class="col-md-4 article-intro">
            <h3>
              <a  href="#">${dr.name}</a>
            </h3>
            <p><b>Стаж работы:</b> ${dr.workExperience} years</p>
            <p><a class="btn btn-default " onclick="window.location.href = '${selectButton}'">Выбрать</a></p>
          </article>
        </c:forEach>
      </div>
    </div>

    <button class="modal__close">&#10006;</button>
  </div>
</div>





<!-- Content -->
<div class="container">
  </div>
  <!-- /.row -->



<div class="container">

<c:forEach var="helper" items="${reportHelper}">

<article class="col-md-4 article-intro">

    <p><b>Кол-во рейсов:</b> ${helper.amountOfRoutes}</p>
    <p><b>Кол-во отработанных дней:</b> ${helper.amountOfDaysAll}</p>
  </article>
</c:forEach>
  <!-- Feature Row -->
  <table >
    <thead>
    <tr><th>Номер заказа</th><th>Дата отправки</th><th>Дата доставки</th><th>Водитель</th><th>Машина</th><th>Состояние заказа</th></tr>
    </thead>
    <c:forEach var="order" items="${orders}">
      <tr>
        <td>
          <p>${order.name}</p>
        </td>
        <td>
          <p>${order.dateOfDispatch}</p>
        </td>
        <td>
          <p>${order.dateOfAcceptance}</p>
        </td>
        <td>
          <p>${order.driver.name}</p>
        </td>
        <td>
          <p>${order.driver.driverCar.govermentNumber}</p>
        </td>
        <td>
          <p>${order.orderCondition}</p>
        </td>
      </tr>

    </c:forEach>
  </table>
  <!-- /.row -->





</div>



<script src="js/script.js"></script>

</body>

</html>
