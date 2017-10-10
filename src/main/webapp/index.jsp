<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="<c:url value="/resources/css/w3.css"/>" rel="stylesheet">
    <style>
        .mySlides {
            display: none;
        }
    </style>

</head>
<body>
<%@ include file="/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="page-header">
                <div class="blog">
                    <h5>
                        <%=
                            new SimpleDateFormat("dd-MMMM-yyyy").format(new Date())
                        %>
                    </h5>
                    <div class="w3-content w3-section" style="max-width: 750px">
                        <img class="mySlides" src="resources/img/slider/3.jpg" style="width:100%">
                        <img class="mySlides" src="resources/img/slider/4.jpg" style="width:100%">
                        <img class="mySlides" src="resources/img/slider/5.jpg" style="width:100%">
                    </div>
                    <script>
                        var myIndex = 0;
                        carousel();

                        function carousel() {
                            var i;
                            var x = document.getElementsByClassName("mySlides");
                            for (i = 0; i < x.length; i++) {
                                x[i].style.display = "none";
                            }
                            myIndex++;
                            if (myIndex > x.length) {
                                myIndex = 1
                            }
                            x[myIndex - 1].style.display = "block";
                            setTimeout(carousel, 3000); // Change image every 3 seconds
                        }
                    </script>
                    <p>Добро пожаловать на внутренний портал "ЗАВОД 410 ЦА".
                        Тут Вы можете оставить заявки для решения ваших технических проболем, которые наши
                        подразделения рассмотрят в самое ближайшее время.
                        ОАСУП желает Вам приятного дня и хорошего настроения!
                    </p>

                    <h3>«ЗАВОД 410 ЦА» - це унікальне підприємство</h3>

                    <p>25 вересня 2017 року об 11 годині на території Державного підприємства «ЗАВОД 410 ЦА»
                        відбулась урочиста передача відремонтованого та модернізованого літака А-32 Народної Республіки
                        Бангладеш
                        представникам Замовника та екіпажу повітряного судна.
                        На церемонії урочистої передачі літака були присутні Заступник генерального директора з
                        авіабудування
                        та виробництва ДК «Укроборонпром» Коробов Володимир Костянтинович, Голова Профспілки
                        авіабудівників України
                        Жугаєвич Ярема Васильович, директор компанії «Flitе Industries Pte Ltd» українського
                        представництва
                        Ярошенко Володимир Євгенович, командир екіпажу літака Махбуб Ахмет, а також представники
                        ВПС Народної Республіки Бангладеш, представники ЗМІ, колектив заводу.
                    </p>

                    <p>Фахівцями заводу в рамках виконання контракту проведено капітальний ремонт та додаткову
                        модернізацію
                        літака Ан-32 згідно вимог Замовника. Випробування пройшли успішно, літак готовий для подальшої
                        служби.
                    </p>


                    <p>Після промов почесних гостей, Генеральний директор Ганькевич В.В. передав командиру екіпажу
                        літака
                        Махбубу Ахмету сертифікат на відновлений літак та модель - точну копію літака Ан-32.
                        Літак Ан-32 розпочав підготовку до відправлення на Батьківщину, на свою авіабазу.
                    </p>

                    <div class="ficon">
                        <a href="" alt="">Детальніше</a>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <nav>
                        <ul class="pagination">
                            <li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <form class="form-search">
                <input class="form-control" type="text" placeholder="Search..">
            </form>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Нове на порталі</strong>
                </div>
                <div class="panel-body">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="img/b.jpg" alt="">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">НОВИНА</h4>
                            <p>Якісь новини з бази данних, Якісь новини з бази данних,
                                Якісь новини з бази данних, Якісь новини з бази данних,
                            </p>
                            <div class="ficon">
                                <a href="" alt="">Детальніше</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="img/a.jpg" alt="">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">НОВИНА</h4>
                            <p>Якісь новини з бази данних, Якісь новини з бази данних,
                                Якісь новини з бази данних, Якісь новини з бази данних,
                            </p>
                            <div class="ficon">
                                <a href="" alt="">Детальніше</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="img/c.jpg" alt="">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">НОВИНА</h4>
                            <p>Якісь новини з бази данних, Якісь новини з бази данних,
                                Якісь новини з бази данних, Якісь новини з бази данних,
                            </p>
                            <div class="ficon">
                                <a href="" alt="">Детальніше</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="img/d.jpg" alt="">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">НОВИНА</h4>
                            <p>Якісь новини з бази данних, Якісь новини з бази данних,
                                Якісь новини з бази данних, Якісь новини з бази данних,
                            </p>
                            <div class="ficon">
                                <a href="" alt="">Детальніше</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>
<%@ include file="footer.jsp" %>
</body>
</html>
