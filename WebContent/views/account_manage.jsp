<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Tra cứu phòng trọ</title>
<link rel="shortcut icon" href="images/page.png" type="image/x-icon">
<link rel="icon" href="images/page.png" type="image/x-icon">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="js/jquery-3.1.0.min.js"></script>

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
						<a href="login.html"><i class="fa fa-sign-in"
							style="padding: 5px;"></i>Đăng nhập</a> <a href="register.html"><i
							class="fa fa-user-plus" style="padding: 5px;"></i>Đăng ký</a> <a
							href="logout.html" id="logout"><i class="fa fa-sign-out"
							style="padding: 5px;"></i>Đăng xuất</a>
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
						<li class="active-item"><a href="home.html"><i
								class="glyphicon glyphicon-home"></i></a></li>
						<li><a href="rent_room.html">Thuê phòng trọ</a></li>
						<li><a href="houses.html">Thuê nhà nguyên căn</a></li>
						<li><a href="find_people.html">Tìm người ở ghép</a></li>
						<li><a href="nap_cash.html">Nạp Cash</a></li>
						<li id="dangtin" style="margin-left: 2%"><a href="post.html"><strong>Đăng
									Tin</strong></a></li>
					</ul>
				</div>
				<div class="col-sm-2">
					<c:forEach var="tk" items="${tentaikhoan}">
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
		<div class="boss-account row">
			<div class="title-account-div col-sm-2">
				<a class="title123" href="chutro.html">
					<ul class="title-account list-group">
						<li class="list-group">
							<p style="padding: 2px">Chung</p>
						</li>
					</ul>
				</a> <a class="title123" href="account_manage.html">
					<ul class="title-account list-group">
						<li class="list-group active_ac">
							<p style="padding: 2px">Quản lí bài đăng</p>
					</ul>
				</a> <a class="title123" href="changepass.html">
					<ul class="title-account list-group">
						<li class="list-group">
							<p style="padding: 2px">Đổi mật khẩu</p>
						</li>
					</ul>
				</a>

			</div>
			<div class="DoiMK col-sm-9">
				<div class="table_manage">
					<h3 id="QL">
						<strong>Quản Lý Tin</strong>
					</h3>
					<div class="table_manage_posts" style="margin-top: -10px;">
							<table class="table table_posts table-striped table-hover">
								<thead>
									<tr class="tr1">
										<th>Mã số</th>
										<th>Tiêu đề</th>
										<th>Ngày đăng</th>
										<th>Ngày hết hạn</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
								<% int i = 1; %>
								<c:forEach var="baidang" items="${baidangs}">
									<tr class="tr1">
										<th scope="row"><%=i++ %></th>
										<td>${baidang.tieude}</td>
										<td>${baidang.ngaydang}</td>
										<td>${baidang.ngayhethan} </td>
										<td><a id="btn2_edit" href="update_post.html?mabd=${baidang.mabd}">
												<button id="btn2" class="btn btn-success">Chỉnh sửa</button> 
											</a>
											<a id="btn2"class="btn btn-warning" onclick="return confirm('Bạn có muốn xóa bài đăng này không?')" 
												href="deletebaidang?mabd=${baidang.mabd}">Xóa
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="footer my-footer ">
		<div class="container">
			<p class="text-muted " style="color: black;">Địa chỉ liên hệ:
				TukPhongTro.com</p>
		</div>
	</footer>
	<%
		String dangtin = (String) request.getAttribute("dangtin");
	%>
	<script type="text/javascript">
			    var dangtin = "<%=dangtin%>";
		if (dangtin == "dang tin thanh cong"){
			alert("Đăng tin thành công");
		}
		if (msg == "chinh sua thanh cong")
			alert("Chỉnh sửa thành công");
		if (msg == "xoa thanh cong")
			alert("Xóa thành công");
		request.setAtrribute("alertMsg","");
	</script>
</body>

</html>