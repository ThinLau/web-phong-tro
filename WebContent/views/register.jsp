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
        <!-- Main content -->
        <div class="page_view_wrapper clearfix">
            <div class="login_custom_wrapper">  
                <div class="login_custom_inner-register" style="background-image: url(images/h1.jpg);">
                    <ul class="login-tabs clearfix" role="tablist">
                        <li role="presentation" class="dangnhap-register col-sm-6 active"><a href="login.html" class="DNDK"><i class="fa fa-sign-in"></i><strong> Đăng Nhập</strong></a></li>
                            <li role="presentation" class="dangky-register col-sm-6"><a href="register.html" class="DNDK"><i class="fa fa-user-plus"></i><strong> Đăng Ký Mới</strong></a></li>
                    </ul>
                    <div class="tab-content-register col-sm-8">
                        <div role="tabpanel" class="tab-pane active" id="register_form">
                            <form name="registerform" id="registerform" action="register.html" method="post" novalidate="novalidate">
                                <p style="font-size: 14px; background: #E74C3C; color: #fff; padding: 5px;">Mỗi thành viên chỉ đăng ký 1 tài khoản duy nhất</p>
                                <div class="col-sm-10"> 
                                	<p>
                                        <label class="lb" for="user_name">Họ Tên</label>
                                        <input type="text" name="name" id="user_name" class="input form-control" value="" size="25">
                                    </p>
                                    <p>
                                        <label class="lb" for="user_login">Tên Tài Khoản</label>
                                        <input type="text" name="username" id="user_login" class="input form-control" value="" size="25">
                                    </p>
                                    <p>
                                        <label class="lb" for="password">Mật khẩu</label>
                                        <input type="password" name="password" id="password" class="input form-control" value="" size="25">
                                    </p>
                                    <p>
                                        <label class="lb" for="re-password">Nhập lại mật khẩu</label>
                                        <input type="password" name="re-password" id="re-password" class="input form-control" value="" size="25">
                                    </p>

                                    <p>
                                        <label class="lb" for="user_email">Email</label>
                                        <input type="email" name="user_email" id="user_email" class="input form-control" value="" size="25">
                                    </p>

                                    <br class="clear">
                                    <input type="hidden" name="redirect_to" value="">
                                    <p class="submit"><input type="submit" name="wp-submit-regiser" id="wp-submit" class="btn btn-warning" value="Đăng ký"></p>
                                    <a class="QMK button-primary button-large button-forgot" href="forgot_pass.html" title="Quên mật khẩu">Quên mật khẩu</a>      
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer my-footer ">
        <div class="container">
            <p class="text-muted " style="color: black;">Địa chỉ liên hệ: TukPhongTro.com</p>
        </div>
    </footer>
     <% String message = (String)request.getAttribute("alertMsg");%>
			<script type="text/javascript">
			    var msg = "<%=message%>";
			    if(msg == "mat khau khong khop" )
			    	alert("Mật khẩu không khớp... Xin nhập lại");
			   
			</script>
</body>

</html>