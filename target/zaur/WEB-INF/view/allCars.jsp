<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>

  <title></title>
  <meta charset="UTF-8">


  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <script src="script.js" defer></script>
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
    <p>На этой странице Вы можете увидеть все данные Машинах так же легко как и изменить информацию о них..</p>
    <p><a class="btn btn-default" onclick="window.location.href = 'addNewCar'">Добавить новую машину</a></p>

  </div>
</div>

<section class="section">
  <h1 class="section__title">Модальное окно</h1>
  <button class="section__button section__button1">Открыть</button>
</section>

<section class="section">
  <h1 class="section__title">Модальное окно</h1>
  <button class="section__button section__button2">Открыть 2</button>
</section>

<div class="modal modal1">
  <div class="modal__main">
    <h2 class="modal__title">Модальное окно</h2>

    <div class="modal__container">
      <p>Сделаем правильно</p>
      <p>HTML CSS JavaScript</p>
    </div>

    <button class="modal__btn">Смотреть видео</button>
    <button class="modal__close">&#10006;</button>
  </div>
</div>

<div class="modal modal2">
  <div class="modal__main">
    <h2 class="modal__title">Модальное окно 2</h2>

    <div class="modal__container">
      <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Laborum doloremque unde perferendis.</p>
      <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ea accusantium aperiam, quis commodi incidunt amet quidem vero ut possimus sed veniam aliquam eum, in porro consequuntur impedit deserunt sequi velit quisquam quod suscipit. Consequuntur, facere earum, iusto sit odit aperiam ipsam illo architecto autem esse eos eius maiores quam magnam?</p>
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
      <p>Вы можете изменять или удалять записи в любой момент.</p>
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
          <a>${car.id}</a>
        </h3>
        <p><b>Бренд:</b> ${car.brand}</p>
        <p><b>Модель:</b> ${car.model}</p>
        <p><b>Год выпуска:</b> ${car.yearOfRelease} year</p>

        <p><a class="btn btn-default" onclick="window.location.href = '${updateButton}'">Изменить</a></p>
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
      <p>Copyright &copy; Example.com 2015 </p>
    </div>
  </div>
</footer>






</body>

</html>
