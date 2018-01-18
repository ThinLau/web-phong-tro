<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>Tra cứu phòng trọ</title>
    <link rel="shortcut icon" href="images/page.png" type="image/x-icon">
    <link rel="icon" href="images/page.png" type="image/x-icon">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script src="js/paging.js"></script>
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
                        <a href="home.html" id="logout"><i class="fa fa-sign-out" style="padding: 5px;"></i>Đăng xuất</a>
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
    </div>
	<div class="search-info">
		<div class="container">
				<form class="form-search" style=" margin-top: 12px;" method ="post" action ="search" >

					           <div class="row">
                            <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                    <select id="search_room_type" class="form-control" name="loaitin">
                                        <option value="0">--Chọn loại phòng--</option>
                                        <option value="Phòng trọ, nhà trọ" >Phòng trọ, nhà trọ</option>
                                        <option value="Cho thuê nhà nguyên căn" >Nhà thuê nguyên căn</option>
                                        <option value="Tìm người ở ghép" >Tìm người ở ghép</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                    <select class="form-control price" name="giaphong">
                                        <option value="0"  selected='selected'>--Chọn mức giá--</option>
                                        <option value="5" >< 500.000</option>
                                        <option value="10" >500.000 - 1.000.000</option>
                                        <option value="15" >1.000.000 - 1.500.000</option>
                                        <option value="25" >1.500.000 - 2.500.000</option>
                                        <option value="30" >2.500.000 - 3.000.000</option>
                                        <option value="31" > > 3.000.000</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                    <select id="search_doituong" name="doituong" class="form-control">
                                        <option value="0"  selected='selected'>--Chọn đối tượng--</option>
                                        <option value="Tất cả" >Tất cả</option>
                                        <option value="Nam" >Nam</option>
                                        <option value="Nữ" >Nữ</option>
                                    </select>
                                </div>
                            </div>
                             <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                    <select id="search_dientich" name="dientich" class="form-control">
                                        <option value="0"  selected='selected'>--Chọn diện tích--</option>
                                        <option value="20" ><20 m2</option>
                                        <option value="30" >20 m2 - 30 m2</option>
                                        <option value="50" >30 m2 - 50 m2</option>
                                        <option value="51" > >50 m2</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                        <select id="select_tinh_tp" class="form-control tinh-tp" name="tinh">
                                        <option value="0" >--Chọn TP/Tỉnh--</option>
                                        <c:forEach var="ttp" items="${ttps}">
                                        	<option value="${ttp.tenTinh_TP}" >${ttp.tenTinh_TP}</option>
                                        </c:forEach>
                                </select>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                    <select id="select_quan_huyen" class="form-control district" name="quan">
                                        <option value="0" data-flag="0">--Chọn Quận/Huyện--</option>
                                        <c:forEach var="qh" items="${qhs}">
                                        	<option value="${qh.tenQuan_Huyen}" data-tinh="${qh.ttp.getTenTinh_TP()}" >${qh.tenQuan_Huyen}</option>
                                        </c:forEach>
                                    </select>                                                                    
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                    <select id="select_phuong_xa" name="phuong" class="form-control">
                                        <option value="0" data-flag="0">--Chọn Phường/xã--</option>
                                        <c:forEach var="px" items="${pxs}">
                                        	<option value="${px.tenPhuong_Xa}" data-huyen="${px.qh.getTenQuan_Huyen()}" >${px.tenPhuong_Xa}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12 padding5">
                                <div class="form-group">
                                    <select id="select_duong" name="duong" class="form-control">
                                        <option value="0" data-flag="0">--Chọn Đường--</option>
                                        <c:forEach var="d" items="${ds}">
                                        	<option value="${d.tenDuong}" data-phuong="${d.px.getTenPhuong_Xa()}" >${d.tenDuong}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>            
                        </div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12 ">
							<input type="submit"  class="btn btn-warning pull-right" value="Tìm kiếm">
						</div>
					</div>
				</form>
		</div>
	</div>

	<nav class="navbar ">
		<div class="container">
			<h3 class="title-info"> Thông tin phòng trọ mới nhất</h3>
		</div>
	</nav>

	<div class="main-content">
		<div class="container">
			<div class ="row">
				<div class="col-md-8 list-postt">
				<table class = "table" id="results">
					<tr></tr>
					<c:forEach var="baidang" items="${list_bd}">
						<tr>
							<td>
								<div class=" row">
				    				<div class="col-sm-3 col-md-3 ">
				    					<a href="detail_room.html?mabd=${baidang.mabd}">
				    						<img class="image-room" src="images/${baidang.mabd}/${baidang.getAnh()}" alt = "ảnh" />
				    					</a>
				    				</div>
				    				<div class="col-sm-9 col-md-9">
				    					<ul class ="ul-list list-group" style="line-height: 22px;">
				    						<li class="header-info">
				    							<a href="detail_room.html?mabd=${baidang.mabd}" style="font-size: 14px; color: red; font-weight: 300;">${baidang.tieude}</a>
				    						</li>
				    						<li class="info" id ="mota">Mô tả: <span>${baidang.mota}</span></li>
				                            <li>Khu vực: <strong>${baidang.diachi.getQuan_huyen()}, ${baidang.diachi.getTinh_tp()}</strong></li>
				    						<li>Ngày đăng: <strong>${baidang.ngaydang}</strong> </li>
				    						<li class="price">Diện tích: <strong>${baidang.dientich} m²</strong> </li>
				    						<li style="font-size: 17px; color: green;" ><strong>Giá: ${baidang.giaphong} VND</strong></li>
				    					</ul>
				    				</div>
				    			</div>
		    				</td>
		    				</tr>
		    				
					</c:forEach>
				
					</table>
						<hr>
					<div id="pageNavPosition"></div>
                    <script type="text/javascript"><!--
				        var pager = new Pager('results', 5); 
				        pager.init(); 
				        pager.showPageNav('pager', 'pageNavPosition'); 
				        pager.showPage(1);
					</script>
				</div>
				
				
				<div class="col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">TIN MỚI ĐĂNG</h3>
						</div>
						<div class="panel-body">
							<c:forEach var ="item" items="${tinmoidang}">
								<div  style="font-size: 11.5px;">
									<a href="detail_room.html?mabd=${item.mabd}" style="text-decoration: none;">
										<span style="display: block; color: blue;" class="tinmd">${item.mota}</span>
									</a>
									<span style="display: block; color: green; margin-top: 4px; font-size: 15px; font-weight: bold;">${item.giaphong} VNĐ</span>
								</div>
								<hr/>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
   
    <footer class="footer my-footer ">
    	<div class="container ">
    		<p class="text-muted " style="color: black;">Địa chỉ liên hệ: TukPhongTro.com</p>
    	</div>
    </footer>
    <script>
		$("#select_tinh_tp").change(function() {
			  if ($(this).data('options') == undefined) {
			    /*Taking an array of all options-2 and kind of embedding it on the select1*/
			    $(this).data('options', $('#select_quan_huyen option').clone());
			    
			  }
			  var id = $(this).val();
			  var options = $(this).data('options').filter(function(){
				  return $(this).attr("data-flag") === "0" || $(this).attr("data-tinh") == id;
			  });
			  $('#select_quan_huyen').html(options);
			  
			});
		
		$("#select_quan_huyen").change(function() {
			  if ($(this).data('options') == undefined) {
			    /*Taking an array of all options-2 and kind of embedding it on the select1*/
			    $(this).data('options', $('#select_phuong_xa option').clone());
			  }
			  var id = $(this).val();
			  //var options = $(this).data('options').filter('[data-huyen="' + id + '"]');
			   var options = $(this).data('options').filter(function(){
				  return $(this).attr("data-flag") === "0" || $(this).attr("data-huyen") == id;
			  });
			  $('#select_phuong_xa').html(options);
			});
		
		$("#select_phuong_xa").change(function() {
			  if ($(this).data('options') == undefined) {
			    /*Taking an array of all options-2 and kind of embedding it on the select1*/
			    $(this).data('options', $('#select_duong option').clone());
			  }
			  var id = $(this).val();
			 // var options = $(this).data('options').filter('[data-phuong="' + id + '"]');
			  var options = $(this).data('options').filter(function(){
				  return $(this).attr("data-flag") === "0" || $(this).attr("data-phuong") == id;
			  });
			  $('#select_duong').html(options);
			});
  </script>
    
</body>
</html>