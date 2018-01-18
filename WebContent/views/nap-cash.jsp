<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Tra cứu phòng trọ</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

    <script src="js/jquery-3.1.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
    <header>
        <div class="container">
            <div class="row">
                <div class="logo col-sm-5">
                    <a href="home.html"><img src="images/logo.PNG"></a>
                </div>
                <div class="col-sm-7">
                    <nav class="login-nav">
                        <a href="login.html"><i class="fa fa-sign-in" style="padding: 5px;"></i>Đăng nhập</a>
                        <a href="register.html"><i class="fa fa-user-plus" style="padding: 5px;"></i>Đăng ký</a>
                        <a href="logout.html" id="logout"><i class="fa fa-sign-out" style="padding: 5px;"></i>Đăng xuất</a>
                    </nav>
                </div>
                
            </div>
        </div>
    </header>
    <div class="container-fluid  menu-bar">
        <div class="container">
            <div class="row">
                <div class="col-xs-10 col-sm-10 col-md-10 menu-bar">
                    <ul class="nav navbar-nav navbar-listmenu col-sm-12">
                        <li class="active-item"><a href="home.html"><i class="glyphicon glyphicon-home"></i></a></li>
                        <li><a href="rent_room.html">Thuê phòng trọ</a></li>
                        <li><a href="houses.html">Thuê nhà nguyên căn</a></li>
                        <li><a href="find_people.html">Tìm người ở ghép</a></li>
                        <li><a href="nap_cash.html">Nạp Cash</a></li>
                    	<li id="dangtin" style="margin-left: 2%"><a  href="post.html" ><strong>Đăng Tin</strong></a></li>
                    </ul>
                </div>
                <div class="col-sm-2">
                	<c:forEach var="tk" items="${tentaikhoan}">
						<c:if test="${tentaikhoan=='admin'}">
		                     <ul class="nav navbar-nav navbar-listmenu" style="cursor: pointer;">
		                         <li class="dropdown-toggle" data-toggle="dropdown"><a style="font-size: 12px"><span>Hi, </span> <span>${tk}</span> <span class="caret"></span></a></li>
		                         <ul class="dropdown-menu" style="padding-left: 5px; padding-right: 5px;">
		                              <li><a style="color: #000" href="admin.html">Quản lý</a></li>
		                              <li><a style="color: #000" href="changepass.html">Đổi mật khẩu</a></li>
		                              <li><a style="color: #000" href="logout.html">Đăng xuất</a></li>
		                         </ul>
		                    </ul>
		                </c:if>
	                	<c:if test="${tk!='admin'}">
		                     <ul class="nav navbar-nav navbar-listmenu" style="cursor: pointer;">
		                         <li class="dropdown-toggle" data-toggle="dropdown"><a style="font-size: 12px"><span>Hi, </span> <span>${tk}</span> <span class="caret"></span></a></li>
		                         <ul class="dropdown-menu" style="padding-left: 5px; padding-right: 5px;">
		                              <li><a style="color: #000" href="chutro.html">Quản lý</a></li>
		                              <li><a style="color: #000" href="changepass.html">Đổi mật khẩu</a></li>
		                              <li><a style="color: #000" href="logout.html">Đăng xuất</a></li>
		                         </ul>
		                    </ul>
		                </c:if>
	               	</c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="method method_napcard" >
            <div class=" napcash container">
                <div class="method_napcard_inner">
                    <div class="col-sm-7">
                        <h3 class="method_title"><strong>THANH TOÁN BẰNG THẺ CÀO ĐIỆN THOẠI</strong></h3>
                        <p>1 GOLD = 1.000 VNĐ các bạn nhé</p>
                        <div class="row">
                            <form action="NapCash.html" id="frm-nap-card" method="POST">
                                <div class="form-group clearfix">
                                    <label for="nha_mang" class="col-xs-12 control-label">Nhà mạng</label>
                                    <div class="col-sm-7 col-xs-12">
                                        <select id="nha_mang" name="type_card" class="form-control">
                                            <option value="VIETTEL">Viettel</option>
                                            <option value="VMS">Mobifone</option>
                                            <option value="VNP">Vinaphone</option>
                                            <option value="VCOIN">Thẻ cào VTC Coin</option>
                                            <option value="GATE">Thẻ cào FPT Gate</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group clearfix">
                                    <label for="ma_the_cao" class="col-xs-12 control-label">Mã thẻ cào</label>
                                    <div class="col-sm-7 col-xs-12">
                                        <input type="text" class="form-control" id="ma_the_cao" name="ma_the_cao">
                                    </div>
                                </div>
                                <div class="form-group clearfix">
                                    <label for="so_seri" class="col-xs-12 control-label">Số seri thẻ</label>
                                    <div class="col-sm-7 col-xs-12">
                                        <input type="text" class="form-control" id="so_seri" name="so_seri">
                                    </div>
                                </div>

                                <div class="form-group clearfix">
                                    <label for="so_seri" class="col-xs-12 control-label"></label>
                                    <div class="col-xs-12">
                                        <button type="submit" class="btn btn-warning btn_napcash">Nạp Gold</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="thecao col-sm-5">
                    <img width="300px" src="images/thecao.png">
                </div>
            </div>
        </div>
    </div>

    <footer class="footer my-footer ">
        <div class="container">
            <p class="text-muted " style="color: black;">Địa chỉ liên hệ: TukPhongTro.com</p>
        </div>
    </footer>
</body>

</html>