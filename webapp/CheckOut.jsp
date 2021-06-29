<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Outline</title>
  <!--LIBRARY-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css"/>
  <script src="../js/bootstrap.min.js"></script>
  <!--IMPORT CSS-->
  <link rel="stylesheet" href="PerfumeWorld.css"/>
  <!--LIBRARY EXTENDS FOR MORE ICONS-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
  <link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body>
<!--HEADER-->
<header>
  <!--LOGO-->
  <br>
  <div class="row">
    <!--Column 1-->
    <div class="col-sm-4">
    </div>
    <!--Column 2-->
    <div class="col-sm-4">
      <a href="Index.html" id="h1">PERFUME WORLD</a>
      <br>
    </div>
    <!--Column 3-->
    <div class="col-sm-4">
      <ul id="icon-right" class="nav navbar-nav">
        <li><abbr title="Location"><a class="btn" href="Location.html"><span class="glyphicon glyphicon-map-marker"></span></a></abbr></li>
        <!--MODAL NOTIFICATION-->
        <li><abbr title="Notification"><a class="btn" data-toggle="modal" data-target="#modal-notification"><span class="glyphicon glyphicon-bell"></span></a></abbr></li>
        <li><abbr title="Search"><a class="btn" href="Search.html"><span class="glyphicon glyphicon-search"></span></a></abbr></li>
        <li><abbr title="Favorite list"><a class="btn" href="Favorite.html"><span class="glyphicon glyphicon-star"></span></a></abbr></li>
        <li><abbr title="Shopping cart"><a class="btn" href="CheckOut.jsp"><span class="glyphicon glyphicon-shopping-cart"></span></a></abbr></li>
      </ul>
    </div>
  </div>
  <!--NAVIGATION BAR-->
  <div id="menu">
    <ul>
      <li><a class="active" href="Index.html">HOMEPAGE</a></li>
      <li><a href="Category.jsp">CATEGORY</a>
        <ul class="sub-menu">
          <li><a href="Unisex.html">ALL UNISEX</a></li>
          <li><a href="Women.html">ALL WOMEN</a></li>
          <li><a href="Men.html">ALL MEN</a></li>
          <li><a href="Products.html">ALL PRODUCTS</a></li>
        </ul>
      </li>
      <li><a href="Account.html">ACCOUNTS</a>
        <ul class="sub-menu">
          <li><a href="Register.html">REGISTER</a></li>
          <li><a href="Login.html">LOG IN</a></li>
        </ul>
      </li>
      <li><a href="Brand.html">BRAND</a>
        <ul class="sub-menu">
          <li><a href="Chanel.html">CHANEL</a></li>
          <li><a href="Gucci.html">GUCCI</a></li>
          <li><a href="Dior.html">DIOR</a></li>
        </ul>
      </li>
      <li><a href="Sales.html">SALES</a></li>
      <li><a href="Feedback.html">FEEDBACK</a></li>
      <li><a href="Showroom.html">SHOWROOM</a></li>
      <li><a href="Aboutus.html">ABOUT US</a></li>
    </ul>
  </div>
</header>

<!--CONTENT OF HOMEPAGE-->
<div class="parallax"></div> <!--for create scrolling effect-->

<jsp:useBean id="acc" scope="session" class="project.AccountBean"/>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="project.Item" %>

<div id="black-div">
  <div id="categories">
    CHECK OUT
  </div>
  <br><br><br><br><br><br>
  <div id="black-div-description">
<%
    Map inventory = (Map) request.getAttribute("inventory");
    Double total = 0.0;
    if (inventory != null){
        out.println("<table id=\"table\">");
        out.println("<tr><td>PRODUCT NAME</td> <td>PRICE</td> <td>QUANTITY</td> <td>SUBTOTAL</td></tr>");
        for (Object obj : inventory.keySet()){
            Item item = (Item) obj;
            Double subtotal = item.getPrice() * (Integer) inventory.get(item);
            total += subtotal;
            out.println("<form method=\"post\" action=\"Shopping\">");
            out.println("<input type=\"hidden\" name=\"productDelete\" value=\""+item.getProduct()+"\"/>");
            out.println("<tr>");
            out.println("<td>"+item.getProduct()+"</td>");
            out.println("<td>"+item.getPrice()+"</td>");
            out.println("<td>"+inventory.get(item)+"</td>");
            out.println("<td>");
            out.println(subtotal);
            out.println("</td>");
            out.println("<td>");
%>

<input type="submit" name="delete" value="Delete" class="btn btn-default">

<%          out.println("</td>");
            out.println("</tr></form><br>");
        }
        out.println("<tr>");
        out.println("<td></td>");
        out.println("<td></td>");
        out.println("<td></td>");
        out.println("<td><b>TOTAL</b></td>");
        out.println("<td>"+total+"</td>");
        out.println("</tr>");
        out.println("</table>");
    }
%>
  </div>
</div>

<div class="parallax"></div> <!--for create scrolling effect-->

<!--FOOTER-->
<footer>
  <div class="site-footer">
    <div class="row">
      <!--Column 1-->
      <div class="col-sm-6">
        <h6>OUR COMPANY</h6>
        <p class="text-justify">We are Perfume World from Song Song company. Here is the place where you can find your scent. Each of them is unique and characteristic. With us, you will be the artist of your life. To know the story of our foundations or the history of our journey, please <a href="Aboutus.html" id="about-us-footer">click here</a>.</p>
        <br><br>
        <div class="row"> <!-- for logo-->
          <div class="col-sm-4">
            <a href="https://www.chanel.com/us/"><img src="../webapp/image/footer/logo1.JPG" id="footer-logo"></a>
          </div>
          <div class="col-sm-4">
            <a href="https://www.gucci.com/int/en/"><img src="../webapp/image/footer/logo2.JPG" id="footer-logo"></a>
          </div>
          <div class="col-sm-4">
            <a href="https://www.dior.com/en_int"><img src="../webapp/image/footer/logo3.JPG" id="footer-logo"></a>
          </div>
        </div>
      </div>
      <!--Column 2-->
      <div class="col-sm-2">
      </div>
      <!--Column 3-->
      <div class="col-sm-2">
        <h6>DISCOVERY</h6>
        <ul class="footer-links">
          <li><a href="Index.html">Homepage</a></li>
          <li><a href="Category.jsp">Category</a></li>
          <li><a href="Brand.html">Brand</a></li>
          <li><a href="Sales.html">Sales</a></li>
          <li><a href="Login.html">Login</a></li>
          <li><a href="Register.html">Register</a></li>
          <li><a href="Feedback.html">Feedback</a></li>
          <li><a href="Showroom.html">Showroom</a></li>
        </ul>
      </div>
      <!--Column 4-->
      <div class="col-sm-2">
      <h6>&nbsp;OUR CONTACT</h6>
      <ul class="footer-links">
        <li><a class="btn" href="mailto:ntoquyen000@gmail.com"><span class="glyphicon glyphicon-envelope">&nbsp;</span> Email</a></li>
        <!--MODAL PHONE-->
        <li><a class="btn" data-toggle="modal" data-target="#modal-phone"><span class="glyphicon glyphicon-earphone">&nbsp;</span> Phone</a></li>
        <li><a class="btn" href="Location.html"><span class="glyphicon glyphicon-globe">&nbsp;</span> Address</a></li>
        <li><a class="btn" href="https://www.facebook.com/songsong1112/"><span class="fa fa-facebook">&emsp;&ensp;</span> Facebook</a></li>
        <li><a class="btn" href="https://www.instagram.com/songsong.g/"><span class="fa fa-instagram">&emsp;</span> Instagram</a></li>
        <li><a class="btn" href="https://twitter.com/?lang=eng"><span class="fa fa-twitter">&emsp;</span> Twitter</a></li>
        <li><a class="btn" href="https://www.youtube.com/channel/UCAVUjX2Kos263Z8DesC1Plg"><span class="fa fa-youtube">&emsp;</span> Youtube</a></li>
        <li><a class="btn" href="https://www.pinterest.com"><span class="fa fa-pinterest">&emsp;</span> Pinterest</a></li>
        <li><a class="btn" href="https://www.snapchat.com"><span class="fa fa-snapchat">&emsp;</span> Snapchat</a></li>
      </ul>
    </div>
  </div>
</div>
<br>
<p id="footer-last-line">Copyright &copy; 2020 All Rights Reserved by <a href="Aboutus.html" id="about-us-last-line">Song Song</a></p>
<br>
</footer>

<!--MODAL-->
<div class="container">
  <div class="modal" id="modal-notification" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">NOTIFICATION</h2>
        </div>
        <div class="modal-body">
          <p>You have no news.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><h6>CLOSE</h6></button>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container">
  <div class="modal" id="modal-phone" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">PHONE NUMBER</h2>
        </div>
        <div class="modal-body">
          <p>0123 456 789 </p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><h6>CLOSE</h6></button>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>