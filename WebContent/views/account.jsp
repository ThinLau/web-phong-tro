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
					<<c:forEach var="tk" items="${tentaikhoan}">
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
						<li class="list-group active_ac">
							<p style="padding: 2px">Chung</p>
						</li>
					</ul>
				</a> <a class="title123" href="account_manage.html">
					<ul class="title-account list-group">
						<li class="list-group">
							<p style="padding: 2px">Quản lí bài đăng</p>
						</li>
					</ul>
				</a> <a class="title123" href="changepass.html">
					<ul class="title-account list-group">
						<li class="list-group">
							<p style="padding: 2px">Đổi mật khẩu</p>
						</li>
					</ul>
				</a>
			</div>
			<div class="col-sm-9 col-sm-offset-1">
				<div class="table">
						<h3 id="thongtin">
							<strong>Thông tin cá nhân</strong>
						</h3>
						<ul class="title-ul col-sm-8">
							<li class="li1"><label>Họ và tên:</label> <span>${chutro.hoten}</span></li>
							<li class="li1"><label>Số điện thoại:</label> <span>${chutro.sdt}</span></li>
							<li class="li1"><label>E-mail:</label> <span>${chutro.email}</span></li>
							<li class="li1"><label>Địa chỉ:</label> <span>${chutro.diachi}</span></li>
							<li class="li1"><label>Số CMND:</label> <span>${chutro.cmnd}</span></li>
							<li class="btn1_chung">
								<button id="btn1" class="btn btn-warning" data-toggle="modal" data-hoten="${chutro.hoten}"
									data-sdt="${chutro.sdt}"  data-email="${chutro.email}" data-diachi="${chutro.diachi}" 
									data-cmnd="${chutro.cmnd}" data-target="#suathongtin">Chỉnh sửa</button>
							</li>
						</ul>
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

	<!-- Modal -->
	
	<div class="modal fade" id="suathongtin" role="dialog">
		<div class="modal-dialog">
			
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<strong>Chỉnh sửa thông tin </strong>
					</h4>
				</div>
				<div class="modal-body">
					<form action="update_imfor?mact=${chutro.mact}" method="post">
						<ul class="list-group list-group-detail">
							<li class="li2" style="margin-left: 10px;"><label>Họ và tên:</label> <input
								id = "input-hoten" class="form-control" type="text" name="us-name"></li>
							<li class="li2" style="margin-left: 10px;"><label>Số điện thoại:</label> <input
								id = "input-sdt" class="form-control" type="text" name="us-phone"></li>
							<li class="li2" style="margin-left: 10px;"><label>E-mail:</label> <input
								id = "input-email" class="form-control" class="" type="text" name="us-email"></li>
							<li class="li2" style="margin-left: 10px;"><label>Địa chỉ:</label> <input
								id = "input-diachi" class="form-control" type="text" name="us-address"></li>
							<li class="li2" style="margin-left: 10px;"><label>Số CMND:</label> <input
								id = "input-cmnd" class="form-control" type="text" name="us-card"></li>
						</ul>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
							<input  type = "submit" id="btn1" class="btn btn-warning" value ="Lưu">
						</div>
					</form>
				</div>
				
			</div>
			
		</div>
	</div>
	<script>
		$('#suathongtin').on('show.bs.modal', function (event) {
		  var a = $(event.relatedTarget) // Button that triggered the modal
		  var hoten = a.data('hoten') // Extract info from data-* attributes
		  var sdt = a.data('sdt') // Extract info from data-* attributes
		  var email = a.data('email') // Extract info from data-* attributes
		  var diachi = a.data('diachi') // Extract info from data-* attributes
		  var cmnd = a.data('cmnd') // Extract info from data-* attributes
		  
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  $('#input-hoten').val(hoten);
		  $('#input-sdt').val(sdt)
		  $('#input-email').val(email)
		  $('#input-diachi').val(diachi)
		  $('#input-cmnd').val(cmnd)
		})
	</script>
	
	<% String message = (String)request.getAttribute("alertMsg");%>
			<script type="text/javascript">
			    var msg = "<%=message%>";
			    if(msg == "Luu thanh cong" )
			    	alert("Lưu thành công");
			    if(msg == "doi mat khau thanh cong" )
			    	alert("Đổi mật khẩu thành công");
			</script>
</body>

</html>