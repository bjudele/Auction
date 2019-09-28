<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link rel="stylesheet" href="/vendors/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/vendors/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="/vendors/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="/vendors/nice-select/nice-select.css">
    <link rel="stylesheet" href="/vendors/owl-carousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="/vendors/owl-carousel/owl.carousel.min.css">

    <link rel="stylesheet" href="/vendors/style.css">
</head>
<body>

<!-- ================ trending product section start ================= -->
<section class="section-margin calc-60px">
    <div class="container">
        <div class="section-intro pb-60px">
            <p>All the items available</p>
            <h2>Auction <span class="section-intro__style">Items</span></h2>
        </div>

        <div class="row">
            <c:forEach var="item" items="${itemList}">
            <div class="col-md-6 col-lg-4 col-xl-3">
                <div class="card text-center card-product">
                    <div class="card-product__img">
                        <img class="card-img" src="/images/product/product1.png" alt="">
                        <ul class="card-product__imgOverlay">
                            <li>
                                <button><i class="ti-search"></i></button>
                            </li>
                            <li>
                                <button><i class="ti-shopping-cart"></i></button>
                            </li>
                            <li>
                                <button><i class="ti-heart"></i></button>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <p>${item.category}</p>
                        <h4 class="card-product__title"><a href="/account/item/${item.id}">${item.name}</a></h4>
                        <p class="card-product__price">Started at $${item.startingPrice}</p>
                        <p class="card-product__price">Currently at $${item.startingPrice+4}</p>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>

    </div>
</section>
<!-- ================ trending product section end ================= -->
<script src="/vendors/jquery/jquery-3.2.1.min.js"></script>
<script src="/vendors/bootstrap/bootstrap.bundle.min.js"></script>
<script src="/vendors/skrollr.min.js"></script>
<script src="/vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="/vendors/nice-select/jquery.nice-select.min.js"></script>
<script src="/vendors/jquery.ajaxchimp.min.js"></script>
<script src="/vendors/mail-script.js"></script>
<script src="/vendors/main.js"></script>
</body>

</html>
