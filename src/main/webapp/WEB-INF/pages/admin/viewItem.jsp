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
<!--================Single Product Area =================-->
<div class="product_image_area">
    <div class="container">
        <div class="row s_product_inner">
            <div class="col-lg-6">
                <div class="owl-carousel owl-theme s_Product_carousel">
                    <div class="single-prd-item">
                        <img class="img-fluid" src="/images/category/s-p1.jpg" alt="">
                    </div>
                    <!-- <div class="single-prd-item">
                        <img class="img-fluid" src="/images/category/s-p1.jpg" alt="">
                    </div>
                    <div class="single-prd-item">
                        <img class="img-fluid" src="/images/category/s-p1.jpg" alt="">
                    </div> -->
                </div>
            </div>
            <div class="col-lg-5 offset-lg-1">
                <div class="s_product_text">
                    <h3>${itemForm.name}</h3>
                    <h2>Current price is $${itemForm.currentPrice}</h2>
                    <ul class="list">
                        <li><a class="active" href="#"><span>Category</span>: ${itemForm.category}
                        </a></li>
                        <li><a><span>Started at</span>: $${itemForm.startingPrice}</a></li>
                        <li><a><span>Started on</span>: ${itemForm.startDate}</a></li>
                        <li><a><span>Expires on</span>: ${itemForm.endDate}</a></li>
                        <li><a><span>Owned by</span>: ${itemForm.ownerName}</a></li>
                    </ul>
                    <p>${itemForm.description}</p>
                </div>
                <br><br><br><br>
                <div class="card_area d-flex align-items-center">
                    <form method="get" action="/admin/home/">

                        <button class="button button-header" type="submit">Back to main page
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--================End Single Product Area =================-->
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
