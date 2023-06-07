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
                <li class="active">
                    <a  onclick="window.location.href = 'dispatchers'">Диспетчеры</a>
                </li>
                <li>
                    <a  onclick="window.location.href = 'drivers'">Водители</a>
                </li>
                <li >
                    <a  onclick="window.location.href = 'routes'">Адреса</a>
                </li>
                <li>
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
        <h1>Изменение диспетчера</h1>

    </div>
</div>

<!-- Content -->
<div class="container">

    <!-- Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Основная информация</h1>

        </div>
    </div>
    <!-- /.row -->

    <!-- Feature Row -->
    <div class="row">
        <div class="col-lg-12">
            <form:form action="saveDispatcher" modelAttribute="dispatcher" cssClass="form">

                <div class="form__field">
                    <form:hidden path="id"/>
                </div>

                <div class="form__field">
                    <form:input maxlength="15"  required="true" path="name" placeholder="Имя"/>
                </div>

                <div class="form__field">
                    <form:input   maxlength="25" required="true" path="surname" placeholder="Фамилия"/>
                </div>
                <div class="form__field">
                    <form:input   maxlength="25" required="true" path="lastname" placeholder="Отчество"/>
                </div>
                <div class="form__field">
                    <form:input type="number" minlength="9" maxlength="9" path="phoneNumber" min="290000000" max="449999999" placeholder="Телефон"/>
                    <span class="form__error">Это поле должно содержать телефон в формате 291111111</span>
                </div>

                <div class="form__field">
                    <form:input maxlength="20" minlength="6"  required="true" path="password" placeholder="Пароль"/>
                </div>

                <input type="submit" value="OK"/>

            </form:form>
        </div>
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


<!-- jQuery -->
<script src="js/jquery-1.11.3.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- IE10 viewport bug workaround -->
<script src="js/ie10-viewport-bug-workaround.js"></script>

<!-- Placeholder Images -->
<script src="js/holder.min.js"></script>

</body>

</html>
