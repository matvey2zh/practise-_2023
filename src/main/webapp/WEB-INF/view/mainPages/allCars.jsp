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
        <li >
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
        <li class="active">
          <a  onclick="window.location.href = 'cars'">Машины</a>
        </li>

      </ul>




    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
</nav>

<div class="jumbotron feature">
  <div class="container">
    <h1>Машины</h1>
    <p>На этой странице Вы можете увидеть все данные Машинах так же легко, как и изменить информацию о них..</p>
    <button class="section__button section__button1" >Добавить новую машину</button>


  </div>
</div>




<div class="modal modal1">
  <div class="modal__main">
    <h2 class="modal__title">Добавить машину</h2>

    <div class="row">
      <div class="col-lg-12">
        <form:form action="saveCar" modelAttribute="car" cssClass="form">

          <form:hidden path="id"/>
          <div class="form__field">
            <h3><form:input path="govermentNumber" minlength="8" maxlength="8"  required="true" placeholder="Гос номер"/></h3>
          </div>

          <div class="form__field">
          <h3><form:input path="brand" maxlength="15"  required="true" placeholder="Бренд"/></h3>
          </div>

          <div class="form__field">
          <h3>Год выпуска <form:input path="yearOfRelease"  type="number" min="1985" max="2023" /></h3>
          </div>

          <div class="form__field">
          <h3><form:input path="model" maxlength="15" required="true" placeholder="Модель"/></h3>
          </div>

          <input class="btn-default" type="submit" value="OK"/>

        </form:form>
      </div>
    </div>

    <button class="modal__close">&#10006;</button>
  </div>
</div>





<!-- Content -->
<div class="container">

  <!-- Heading -->
  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Существующие машины</h1>
      <form:form action="searchInfoInCars" modelAttribute="searchInfo">
        <form:input path="info"></form:input>
        <input class="btn-default" type="submit" value="OK"/>
      </form:form>

      <p>Вы можете изменять или удалять записи в любой момент.</p>
      <button class="btn btn-default" onclick="window.location.href = 'carsSortByYearUp'">Cортировать по дате ↑</button>
      <button class="btn btn-default" onclick="window.location.href = 'carsSortByYearDown'">Cортировать по дате ↓</button>
      <button class="btn btn-default" onclick="window.location.href = 'carsSortByModelUp'">Cортировать по модели ↑</button>
      <button class="btn btn-default" onclick="window.location.href = 'carsSortByModelDown'">Cортировать по модели ↓</button>
    </div>
  </div>
  <!-- /.row -->



  <!-- Feature Row -->
  <div class="row">
    <c:forEach var="car" items="${cars}">

        <c:url var="updateButton" value="/updateCar">
            <c:param name="carId" value="${car.id}"/>
        </c:url>

      <c:url var="deleteCarButton" value="/deleteCar">
        <c:param name="carId" value="${car.id}"/>
      </c:url>

      <article class="col-md-4 article-intro">
        <h3>
          <a>${car.govermentNumber}</a>
        </h3>
        <p><b>Бренд:</b> ${car.brand}</p>
        <p><b>Модель:</b> ${car.model}</p>
        <p><b>Год выпуска:</b> ${car.yearOfRelease} year</p>

        <p><a class="btn btn-default "  onclick="window.location.href = '${updateButton}'">Изменить</a></p>
        <p><a class="btn btn-default" onclick="window.location.href = '${deleteCarButton}'">Удалить</a></p>

      </article>
    </c:forEach>
  </div>
  <!-- /.row -->

</div>
<!-- /.container -->

<footer>
  <div class="footer-blurb">
    <div class="container">
      <div class="row">
        <div class="col-sm-4 footer-blurb-item">
          <h3>Заказы</h3>
          <p>Нажав на кнопку снизу, Вы попадете на страницу с Заказами, где Вы можете добавлять, изменять и удалять записи.</p>
          <p><a class="btn btn-default" onclick="window.location.href = 'orders'">К Заказам</a></p>
        </div>
        <div class="col-sm-4 footer-blurb-item">
          <h3>Водители</h3>
          <p>Нажав на кнопку снизу, Вы попадете на страницу с Водителями, где Вы можете добавлять, изменять и удалять записи. </p>
          <p><a class="btn btn-default" onclick="window.location.href = 'drivers'">К Водителям</a></p>
        </div>
        <div class="col-sm-4 footer-blurb-item">
          <h3>Адреса</h3>
          <p>Нажав на кнопку снизу, Вы попадете на страницу с Адресами, где Вы можете добавлять, изменять и удалять записи.</p>
          <p><a class="btn btn-default" onclick="window.location.href = 'routes'">К Адресам</a></p>
        </div>

      </div>
      <!-- /.row -->
    </div>
  </div>

  <div class="small-print">
    <div class="container">
      <p><a href="#">Terms &amp; Conditions</a> | <a href="#">Privacy Policy</a> | <a href="#">Contact</a></p>
    </div>
  </div>
</footer>





<script src="js/script.js"></script>

</body>

</html>
