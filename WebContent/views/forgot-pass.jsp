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
    <div class=" container" >
        <div class="row-forget" style="background-image: url(images/forget.jpg);">
            <div class="col-sm-6 col-sm-offset-3" >
                <div id="primary" class="content-area " >
                    <div id="content" class="site-content" role="main">
                        <div id="post-57602"  class="post-57602 page type-page status-publish hentry">
                            <h1 class="entry-title1"><strong>QUÊN MẬT KHẨU</strong></h1>
                            <div class="entry-content">
                                <div class="tml tml-lostpassword" id="theme-my-login">
                                    <p class="message">Vui lòng nhập tên đăng nhập hay địa chỉ email. Bạn sẽ nhận được link tạo mật khẩu mới.</p>   
                                    <form role="form">
                                      <div class="form-group">
                                        <label id="lab" for="">Email address</label>
                                        <input type="email" class="form-control" id="" placeholder="Enter email">
                                      </div>
                                      <button type="submit" class="btn btn-info">Submit</button>

                                      <div class="form-group" style="margin: 10px; font-size: 12px; ">
                                          <a style="padding-right: 10px; border-right: 1px solid #000;" class="" href="login.html" rel="nofollow">Đăng nhập</a>
                                          <a style=" " class=""  href="register.html" rel="nofollow">Đăng ký tài khoản</a>
                                      </div>
                                    </form>
                                </div>
                            </div><!-- .entry-content -->
                        </div> <!-- #post-## -->                    
                    </div><!-- #content -->
                </div><!-- #primary -->
            </div><!-- #wrapper -->
            <footer class="footer  ">
    <div class="container col-sm-12">
        <p style="text-align: center; color: white; margin-top: 3%;">Địa chỉ liên hệ: TukPhongTro.com</p>
    </div>
</footer>
        </div>
    </div>

<% String message = (String)request.getAttribute("alertMsg");%>
			<script type="text/javascript">
			    var msg = "<%=message%>";
			    if(msg == "xin check mail" )
			    	alert("Xin vui lòng check mail!");
	</script>


</body>

</html>