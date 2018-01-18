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
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

    <link rel="stylesheet" href="js/liveshow.js">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>

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
        <div class="row col-sm-12">
        <div class="col-sm-9">
            <div class="header-detail">
               <h3>${baidang.tieude}</h3> 
            </div>
    
            <div data-spy="scroll" data-target=".navbar" data-offset="50">

                <nav class="navbar_scroll">
                    <div class="container-fluid nav-scroll">
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li><a href="#section1">THÔNG TIN CHUNG</a></li>
                                <li><a href="#section2">MÔ TẢ CHI TIẾT</a></li>
                                <li><a href="#section3">HÌNH ẢNH</a></li>
                                <li><a href="#section4">BẢN ĐỒ</a></li>
                            </ul>
                    	</div>
                    </div>
                </nav>
			</div>
                <div id="section1" class="container-fluid">
                        <div class="thongtin row" >
                            <div class="header_thongtin col-sm-2">
                                <p style="margin-top: 5px;"><strong>Địa chỉ:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-10" >
                                <p>${baidang.diachi.getDiachichinhxac()}</p> 
                            </div>
                        </div>
                        <div class="thongtin row">
                            <div class="header_thongtin col-sm-2">
                                <p><strong>Loại tin:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.loaitin}</p>
                            </div>
                            <div class="header_thongtin col-sm-2">
                                <p><strong>Ngày đăng tin:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.ngaydang}</p>
                            </div>
                        </div>
                        <div class="thongtin row">
                            <div class="header_thongtin col-sm-2">
                                <p><strong>Người đăng:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.chutro.getHoten()}</p>
                            </div>
                            <div class="header_thongtin col-sm-2">
                                <p><strong>Điện thoại:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.chutro.getSdt()}</p>
                            </div>
                        </div>
                        <div class="thongtin row">
                            <div class="header_thongtin col-sm-2">
                                <p><strong>E-mail:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.chutro.getEmail()}</p>
                            </div>
                            <div class="header_thongtin col-sm-2">
                                <p><strong>Đối tượng:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.doituong}</p>
                            </div>
                        </div>
                        <div class="thongtin row">
                            <div class="header_thongtin col-sm-2">
                                <p><strong>Diện tích:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.dientich}</p>
                            </div>
                            <div class="header_thongtin col-sm-2">
                                <p><strong>Giá thuê:</strong></p>
                            </div>
                            <div class="body_thongtin col-sm-4">
                                <p>${baidang.giaphong}VND</p>
                            </div>
                        </div>
                    </div>
                <div id="section2" class="container-fluid" >
                    <div class="head_section row">
                        <h4 style="padding: 8px;"><strong>THÔNG TIN MÔ TẢ</strong></h4>
                    </div>
                    <div class="row" style="padding: 8px;">
	                    <p style="line-height: 200%;">${baidang.mota}</p>
	                </div>
                </div>
                <div id="section3" class="container-fluid">
                    <div class="head_section row">
                        <h4 style="padding: 8px;"><strong>HÌNH ẢNH</strong></h4>
                    </div>
                    <div  class="container-fluid">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                         

                          <!-- Wrapper for slides -->
                          <div class="carousel-inner" role="listbox">
                          	<div class="item active">
	                              <img style="width: 100%; height: 400px;" width="100" height="100" class="showpic" src="images/${baidang.mabd}/${activeImg}" alt="...">
	                        </div>
                          	<c:forEach var="img" items="${list_img}">
	                            <div class="item" >
	                              <img style="width: 100%; height: 400px;" width="100" height="100" class="showpic" src="images/${baidang.mabd}/${img}" alt="...">
	                            </div>
                           </c:forEach>
                           </div>

                          <!-- Controls -->
                          <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                          </a>
                          <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                          </a>
                        </div>
                    </div>

                </div>
                <div id="section4" class="container-fluid">
                    <div class="head_section row">
                      <h4 style="padding: 8px;"><strong>BẢN ĐỒ</strong></h4>
                    </div>
                    <input style="display: none;" value="${baidang.diachi.getToado()}" id="ip_toado" type="text" class="control" name="diachi" size="40">
                    <div id="map-canvas" style="width:100%; height:400px; margin-top: 1px;"></div>
                </div>
                </div>
                <div class="col-sm-3 " style="margin-top: 60px;">
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
									<span style="display: block; color: green; margin-top: 4px;">${item.giaphong} VNĐ</span>
								</div>
								<hr/>
							</c:forEach>
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
    <script>
      function initAutocomplete() {
    	  var input = document.getElementById('ip_toado').value;
          var latlngStr = input.split(',', 2);
          var latlng = {lat: parseFloat(latlngStr[0]), lng: parseFloat(latlngStr[1])};
          
        var map = new google.maps.Map(document.getElementById('map-canvas'), {
          center: latlng,  
          zoom: 12,
          mapTypeId: 'roadmap'
        });
       var marker = new google.maps.Marker({
            map:map,
            draggable: true,
            position: latlng
          }); 
        
        // Create the search box and link it to the UI element.
        var searchBox = new google.maps.places.SearchBox(input);
        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

        
        // Bias the SearchBox results towards current map's viewport.
        map.addListener('bounds_changed', function() {
          searchBox.setBounds(map.getBounds());
        });

        var markers = [];
        // Listen for the event fired when the user selects a prediction and retrieve
        // more details for that place.
        searchBox.addListener('places_changed', function() {
          var places = searchBox.getPlaces();

          if (places.length == 0) {
            return;
          }

          // Clear out the old markers.
          markers.forEach(function(marker) {
            marker.setMap(null);
          });
          markers = [];

          // For each place, get the icon, name and location.
          var bounds = new google.maps.LatLngBounds();
          places.forEach(function(place) {
            if (!place.geometry) {
              console.log("Returned place contains no geometry");
              return;
            }
            var icon = {
              url: place.icon,
              size: new google.maps.Size(200, 200),
              origin: new google.maps.Point(0, 0),
              anchor: new google.maps.Point(17, 34),
              scaledSize: new google.maps.Size(25, 25)
            };

            // Create a marker for each place.
            markers.push(new google.maps.Marker({
              map: map,
             draggable: true,
              title: place.name,
              position: place.geometry.location
            }));

            if (place.geometry.viewport) {
              // Only geocodes have viewport.
              bounds.union(place.geometry.viewport);
            } else {
              bounds.extend(place.geometry.location);
              
            }
          });
          map.fitBounds(bounds);
          map.setZoom(13);
        });
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQl0XVU1goVsDeqX8z46G8R4grIxd_nSQ&libraries=places&callback=initAutocomplete"
         async defer></script>
</body>

</html>