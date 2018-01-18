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
        <div class="container-fluid col-sm-8">
        
        <form method="post" action="post.html?mabd=${baidang.mabd}" enctype="multipart/form-data">
        <div class="shadow">
            <div class="group_fields">
                <h3 class="form_title" style="background-color: #1931a7;padding: 1%;color: #fff; margin-top: 5%">Thông tin chung</h3>
            </div>
            <div class="fields">    
                <p class="bg-success">Các bạn nên điền đầy đủ thông tin vào các mục dưới đây để tin đăng có hiệu quả hơn.</p>
            <div class="group_fields">
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="tieude" class="col-sm-12 control-label">Tiêu đề tin <span class="red_require">(*) </span></label>
                            <input type="text" class="form-control" name="tieude" id="tieude" value="${baidang.tieude}"  maxlength="100" required>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-xs-12">
                            <label for="loaichuyenmuc" class="col-sm-12 control-label">Loại chuyên mục <span class="red_require">(*)</span></label>
                            <select id="loaichuyenmuc" name="loaichuyenmuc" class="form-control" required>
                            	<option value="${baidang.loaitin}" selected>${baidang.loaitin}</option>
                            	<c:if test="${baidang.loaitin != 'Phòng trọ, nhà trọ'}">
						            <option value="Phòng trọ, nhà trọ">Phòng trọ, nhà trọ</option>
						        </c:if>
                                <c:if test="${baidang.loaitin != 'Cho thuê nhà nguyên căn'}">
						             <option value="Cho thuê nhà nguyên căn">Cho thuê nhà nguyên căn</option>
						        </c:if>
						        <c:if test="${baidang.loaitin != 'Tìm người ở ghép'}">
						            <option value="Tìm người ở ghép">Tìm người ở ghép</option>
						        </c:if>
                            </select>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <label for="sodienthoai" class="col-sm-12 control-label">Số điện thoại <span class="red_require">(*)</span></label>
                            <input type="number" class="form-control" name="sodienthoai"  id="sodienthoai" value="${baidang.chutro.getSdt()}" placeholder="Nhập đúng số điện thoại để tiện cho khách liên hệ" required>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="giachothue" class="col-sm-12 control-label">Giá cho thuê <span class="red_require">(*)</span></label>
                            <input type="number" min="1" class="form-control" name="giachothue" id="giachothue" value="${baidang.giaphong }" placeholder="Giá cho thuê (VNĐ)" required>
                        </div>
                        <div class="col-sm-6">
                            <label for="dongvigiachothue" class="col-sm-12 control-label">Số người</label>
                            <input type="number" min="1" class="form-control" name="songuoi" id="songuoi" value="${baidang.songuoi}" placeholder="1" required>
                        </div>
                    </div>
                </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="dientich" class="col-sm-12 control-label">Diện tích <span class="red_require">(*)</span></label>
                            <input type="number" min="1" class="form-control" value="${baidang.dientich}" name="dientich" id="dientich" placeholder="Nhập diện tích (Đơn vị m²)" required>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <label for="doituong" class="col-sm-12 control-label">Đối tượng cho thuê</label>
                            <select id="doituong" name="doituong" class="form-control">
                            	<option value="${baidang.doituong}" selected>${baidang.doituong}</option>
                            	<c:if test="${baidang.loaitin != 'Tất cả'}">
						            <option value="Tất cả">Tất cả</option>
						        </c:if>
						        <c:if test="${baidang.loaitin != 'Nam'}">
						            <option value="Nam">Nam</option>
						        </c:if>
						        <c:if test="${baidang.loaitin != 'Nữ'}">
						            <option value="Nữ">Nữ</option>
						        </c:if>
                            </select>
                        </div>
                    </div>
                </div>
                </div>
            </div>

        <div class="shadow">
            <div class="group_fields">    
                    <h3 class="form_title" style="background-color: #1931a7;padding: 1%;color: #fff;margin-top: 7%">Địa chỉ</h3>
                <div class="fields">
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-xs-12">
                        	<label for="tinhtp" class="col-sm-12 control-label">Tỉnh Thành phố <span class="red_require">(*)</span></label>
                            <select id="select_tinh_tp" class="form-control" name="tinh_tp" required>
                                <option value="${baidang.diachi.getTinh_tp()}" selected>${baidang.diachi.getTinh_tp()}</option>
                                	<c:forEach var="ttp" items="${ttps}">
                                		<c:if test="${ttp.tenTinh_TP != selected}">
								            <option value="${ttp.tenTinh_TP}" >${ttp.tenTinh_TP}</option>
								        </c:if>
                            	</c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <label for="quanhuyen" class="col-sm-12 control-label">Quận huyện <span class="red_require">(*)</span></label>
                             <select id="select_quan_huyen" class="form-control " name="quan_huyen" required>
                                <option value="${baidang.diachi.getQuan_huyen()}" selected data-tinh="${baidang.diachi.getTinh_tp()}" >${baidang.diachi.getQuan_huyen()}</option>
                                	<c:forEach var="qh" items="${qhs}">
                                		<c:if test="${qh.tenQuan_Huyen != selected}">
								            <option value="${qh.tenQuan_Huyen}" data-tinh="${qh.ttp.getTenTinh_TP()}" >${qh.tenQuan_Huyen}</option>
								        </c:if>
                            	</c:forEach>
                             </select>   
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-xs-12">
                            <label for="phuongxa" class="col-sm-12 control-label">Phường/Xã</label>
                            <select id="select_phuong_xa" name="phuong_xa" class="form-control" required>
                            	<option value="${baidang.diachi.getXa_phuong()}" data-huyen="${baidang.diachi.getQuan_huyen()}" selected>${baidang.diachi.getXa_phuong()}</option>
                                	<c:forEach var="px" items="${pxs}">
                                		<c:if test="${px.tenPhuong_Xa != selected}">
								            <option value="${px.tenPhuong_Xa}" data-huyen="${px.qh.getTenQuan_Huyen()}" >${px.tenPhuong_Xa}</option>
								        </c:if>
                            	</c:forEach>
                             </select>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <label for="duong" class="col-sm-12 control-label">Đường</label>
                            <select id="select_duong" name="duong" class="form-control" required>
                                <option value="${baidang.diachi.getDuong()}" data-huyen="${baidang.diachi.getXa_phuong()}" selected>${baidang.diachi.getDuong()}</option>
                                <c:forEach var="d" items="${ds}">
                                	<c:if test="${d.tenDuong != selected}">
								       <option value="${d.tenDuong}" data-phuong="${d.px.getTenPhuong_Xa()}" >${d.tenDuong}</option>
								    </c:if>
                                </c:forEach>
                           	</select>
                        	
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="diachi" class="col-sm-12 control-label">Địa chỉ chính xác <span class="red_require">(*)</span></label>
                            <input id="pac-input" type="text" class="form-control" name="diachi" value="${baidang.diachi.getDiachichinhxac()}" placeholder="Hãy nhập địa chỉ chính xác để khách dễ tìm hơn" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="diachi" class="col-sm-12 control-label">Bản đồ <span class="red_require">(*)</span></label>
                            <p class="bg-success">Để tăng độ tin cậy và tin rao được nhiều người quan tâm hơn, hãy sửa vị trí tin rao của bạn trên bản đồ bằng cách kéo icon tới đúng vị trí của tin rao.</p>
                            <div id="map-canvas" style="width:100%; height:300px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>

		<div class="shadow">
            <div class="group_fields">
                <h3 class="form_title" style="background-color: #1931a7;padding: 1%;color: #fff;margin-top: 7%">Mô tả</h3>
                <div class="fields">
                <p class="bg-success">Mô tả thông tin rỏ ràng, đầu đủ. Hãy viết chữ có dấu để Tin đăng được quan tâm nhiều hơn</p>
                   <textarea style="margin-top: 3%;" name="mota" class="form-control" rows="8"  placeholder="Mô tả thông tin" >${baidang.mota}</textarea>
                </div>
            </div>
        </div>
		

            <div class="shadow">
                <div class="group_fields">
                    <h3 class="form_title" style="background-color: #1931a7;padding: 1%;color: #fff;margin-top: 7%">Hình ảnh</h3>
                    <div class="fields">
                    <p class="bg-success">Tin đăng có hình ảnh rõ ràng sẽ được xem và gọi gấp nhiều lần so với tin rao không có ảnh. Hãy đăng ảnh để được giao dịch nhanh chóng!</p>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-12">
                                <label for="thumbnail-post" class="col-sm-12 control-label">Hình ảnh (Giữ phím Ctrl hoặc Command để chọn nhiều)</label>
                                <p>Định dạng ảnh hỗ trợ: .jpg .png .jpeg .gif - Dung lượng ảnh không quá 2MB</p>
                                <div class="list-input-uploads">
                                    <div class="more-item more-item-1">
                                        <input style="color: red;" type="file" class="dimmy-input-file" name="uploadFile" accept="image/*" value="Upload" multiple="multiple" required/>
                                    </div>
                                </div>
                                
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="btn_dangtin">
            	<input type="submit" class="btn_dangtin btn-warning" style="margin-top: 3%; float: right;padding: 1%;" value="Đăng tin ngay">
            </div>
           
           
           
           </form>
        </div>
        
        <div id="sidebar" class="block-right col-md-4">
            <div class="block_term" style="text-align: justify; font-size: 12px;">
                <img width="85%" src="images/logo.PNG">
                <p style="text-align: center;"></p><p><strong>Trước khi bạn đăng tin lên website. xin vui lòng đọc kỹ các quy định sau đây:</strong></p><p id="p1">1. Không được đăng ký tài khoản và khai báo những thông tin giả mạo, đặt tên tài khoản phản cảm, thô tục</p>
                <p id="p1">2. Không được phép đăng tin liên quan đến các vấn đề mà pháp luật Việt Nam không cho phép.</p>
                <p id="p1">3. Không được đăng những bài viết, thông tin có nội dung vi phạm pháp luật: đả kích, bôi nhọ, chỉ trích hay bàn luận về chính trị, tôn giáo, phản động, kỳ thị văn hóa, dân tộc, cũng như vi phạm khác liên quan đến thuần phong mỹ tục của dân tộc Việt Nam.</p>
                <p id="p1">4. Tiêu đề và nội dung của tin đăng phải dùng tiếng Việt có dấu. Không được sử dụng từ ngữ thô tục, mất văn hoá.</p>
                <p id="p1">5. Tin đăng phải có địa chỉ liên lạc cụ thể không được cho địa chỉ sai. hay dùng thông tin địa chỉ của người khác</p>
                <p id="p1">6. Các bài viết không có nội dung hoặc nội dung không liên quan đến chuyên mục. Những bài viết này sẽ bị xóa mà không cần báo trước.</p>
                <p id="p1">7. Không tạo nhiều tài khoản để đăng tin, nếu chúng tôi phát hiện sẽ xóa và ban toàn bộ nick.</p>
                <p id="p1">8. Không được đăng quá nhiều tin trong ngày và không đăng tin có tiêu đề, nội dung tương tự nhau.</p>
                <p id="p1">9. Khi phát hiện tin đăng không đúng sự thật, hay chỗ cho thuê là dịch vụ hay cò nhà trọ, bạn vui lòng thông báo cho Ban quản trị biết để chúng tôi kịp thời xử lý.</p>
                <p id="p1">10. Những trường hợp cố tình spam, vi phạm nội quy nhiều lần thì chúng tôi sẽ cấm không cho bạn đăng tin và tất cả mọi tin đăng của bạn sẽ không được hiển thị trên <strong>TukPhongTro.com</strong>.</p>
                <p id="p1"><strong>Tất cả các tin đăng sai phạm quy định trên sẽ bị xóa mà không cần thông báo trước.</strong></p>
                <p id="p1"><strong>Chúng tôi không chịu trách nhiệm về nội dung các bài đăng trên website.</strong></p>         
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
        var map = new google.maps.Map(document.getElementById('map-canvas'), {
          center: {lat: 10.823360, lng: 106.636636},  
          zoom: 12,
          mapTypeId: 'roadmap'
        });
       

        // Create the search box and link it to the UI element.
        var input = document.getElementById('pac-input');
        var searchBox = new google.maps.places.SearchBox(input);
        

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
     <% String message = (String)request.getAttribute("alertMsg");%>
			<script type="text/javascript">
			    var msg = "<%=message%>";
			    if(msg == "dang tin that bai" )
			    	alert("Đăng tin thất bại. Xin kiểm tra lại các trường nhập liệu và đăng tin lại...");
	</script>
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