<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file = "/header.jsp"%>

<div class="container">
    <div class="col-lg-6">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Тема</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Тема">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Remember me
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Запит</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="8"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Відправити</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col-lg-6">
        <div class="map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3023.7075541908544!2d30.438596814591058!3d50.410828871158955!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xee9e3723e79832ad!2z0JfQkNCS0J7QlCAjNDEwINCT0KDQkNCW0JTQkNCd0KHQmtCe0Jkg0JDQktCY0JDQptCY0Jgg0JPQnw!5e0!3m2!1sen!2sru!4v1506661903460" width="400" height="300" frameborder="0" style="border:0" allowfullscreen>

            </iframe>
        </div>
    </div>
</div>

<address>
    <strong>
        Київ, Повітрофлотський проспект, 94<br>
        Україна<br>
    </strong>
</address>

<hr>
<%@ include file="/footer.jsp" %>
</body>
</html>