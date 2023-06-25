<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<head>

    <title></title>
    <meta charset="UTF-8">


    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body onload="setMinAndMaxDate();">

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
                <li class="active">
                    <a  onclick="window.location.href = 'orders'">Заказы</a>
                </li>
                <li>
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
                <li>
                    <a  onclick="window.location.href = 'reports'">Отчет</a>
                </li>
                <li>
                    <a  download href="https://drive.google.com/file/d/13H1WOectSHRuA8-tJTAPunncAdEqS7Ig/view?usp=sharing">Справка</a>
                </li>
            </ul>


        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="jumbotron feature">
    <div class="container">
        <h1>Заказы</h1>
        <p>На этой странице Вы можете увидеть все данные о Заказах так же легко как и изменить информацию о них..</p>
        <button class="section__button section__button1" >Сформировать новый заказ</button>
    </div>
</div>

<div class="modal modal1">
    <div class="modal__main">
        <h2 class="modal__title">Сформировать заказ</h2>

        <div class="row">
            <div class="col-lg-12">
                <form:form action="addNewOrder" modelAttribute="order" cssClass="form">


                    <div class="form__field">
                        <form:input maxlength="15"  required="true" path="name" placeholder="Номер заказа №"/>
                    </div>
                    <div class="form__field">
                        <h3>Дата отправления</h3>
                        <form:input type="date" id="dateDispatch" path="dateOfDispatch" required="true"  onchange="setRangeToDeliveryDate()" />
                    </div>
                    <div class="form__field">
                        <h3>Дата доставки</h3>
                        <form:input type="date" id="dateDelivery" path="dateOfAcceptance" required="true" />
                    </div>
                    <div class="form__field">
                    </div>


                    <input type="submit" value="OK"/>

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
            <h1 class="page-header">Сформированные Заказы</h1>
            <p>Вы можете изменять или удалять записи в любой момент.</p>
        </div>
    </div>
    <!-- /.row -->


    <div class="row">
        <c:forEach var="order" items="${orders}">


            <c:url var="updateButton" value="/updateOrderCondition">
                <c:param name="orderId" value="${order.id}"/>
            </c:url>



            <c:url var="deleteButton" value="/deleteOrder">
                <c:param name="orderId" value="${order.id}"/>
            </c:url>


            <article class="col-md-4 article-intro">
                <h3>
                    <a>${order.name}</a>
                </h3>
                <p><b>Дата отправки:</b> ${order.dateOfDispatch}</p>
                <p><b>Дата доставки:</b> ${order.dateOfAcceptance}</p>
                <p><b>Состояние заказа:</b> ${order.orderCondition}</p>
                <p><b>Диспетчер:</b> ${order.dispatcher.surname} ${order.dispatcher.name}</p>
                <p><b>Адрес отправки:</b> ул. ${order.departureAdress.adress}</p>
                <p><b>Адрес доставки:</b> ул. ${order.deliveryAdress.adress}</p>
                <p><b>Имя водителя:</b> ${order.driver.surname} ${order.driver.name}</p>


                <p><a class="btn btn-default" onclick="window.location.href = '${updateButton}'">Изменить состояние</a></p>

                <p><a class="btn btn-default" onclick="window.location.href = '${deleteButton}'">Удалить</a></p>
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
                    <h3>Диспетчеры</h3>
                    <p>Нажав на кнопку снизу, Вы попадете на страницу с Диспетчерами, где Вы можете добавлять, изменять и удалять записи.</p>
                    <p><a class="btn btn-default" onclick="window.location.href = 'dispatchers'">К Диспетчерам</a></p>
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


<!-- jQuery -->
<script src="js/jquery-1.11.3.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- IE10 viewport bug workaround -->
<script src="js/ie10-viewport-bug-workaround.js"></script>

<!-- Placeholder Images -->
<script src="js/holder.min.js"></script>
<script src="js/script.js"></script>
<script src="js/orderHelper.js"></script>
<script src="js/saveCurrentDispatcher.js"></script>

</body>

</html>
