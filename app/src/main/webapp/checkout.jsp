<%@page import="bean.GioHangBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.NguoiDungBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shoppers &mdash; Colorlib e-Commerce Template</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">


<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<%
	HttpSession ss = request.getSession();
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	%>
	<div class="site-wrap">
		<%@include file="head.jsp"%>
		<div class="site-section">
			<div class="container">
				<form action="DatHangController" method="get">
					<div class="row">
						<div class="col">
					    <h2 class="h3 mb-3 text-black">Địa chỉ nhận hàng</h2>
					    <div class="p-3 p-lg-5 border">
					        <div class="mb-3">
					            <label for="c_name" class="form-label text-black">Họ và tên <span class="text-danger">*</span></label>
					            <input type="text" class="form-control" id="c_name" name="c_name" required minlength="5" maxlength="20">
					        </div>
					        <div class="row mb-3">
					            <div class="col-md-4">
					                <label for="city" class="form-label text-black">Tỉnh thành <span class="text-danger">*</span></label>
					                <select class="form-select" id="city" aria-label="Chọn tỉnh thành" name = "city">
					                    <option value="" selected disabled>Chọn tỉnh thành</option>
					                </select>
					            </div>
					            
					            <div class="col-md-4">
					                <label for="district" class="form-label text-black">Quận huyện <span class="text-danger">*</span></label>
					                <select class="form-select" id="district" aria-label="Chọn quận huyện" name = "district">
					                    <option value="" selected disabled>Chọn quận huyện</option>
					                </select>
					            </div>
					            
					            <div class="col-md-4">
					                <label for="ward" class="form-label text-black">Phường xã <span class="text-danger">*</span></label>
					                <select class="form-select" id="ward" aria-label="Chọn phường xã" name = "ward">
					                    <option value="" selected disabled>Chọn phường xã</option>
					                </select>
					            </div>
					        </div>
					
					        <div class="mb-3">
					            <label for="c_address" class="form-label text-black">Địa chỉ cụ thể <span class="text-danger">*</span></label>
					            <input type="text" class="form-control" id="c_address" name="c_address" placeholder="Địa chỉ" required minlength="5" maxlength="50">
					        </div>
					
					        <div class="mb-3">
					            <label for="c_phone" class="form-label text-black">Số điện thoại <span class="text-danger">*</span></label>
					            <input type="text" class="form-control" id="c_phone" name="c_phone" placeholder="Số điện thoại" required pattern="[0-9]{10}">
					        </div>
					    </div>
					</div>

						<div class="col">
							<h2 class="h3 mb-3 text-black">Your Order</h2>
							<div class="p-3 p-lg-5 border">
								<table class="table site-block-order-table mb-5">
									<thead>
										<th>Product</th>
										<th>Total</th>
									</thead>
									<tbody>
										<%
										ArrayList<GioHangBean> gh = (ArrayList<GioHangBean>) ss.getAttribute("giohang");
										Long tt = 0L;
										if (gh != null) {
											for (GioHangBean x : gh) {
												out.println("<tr>");
												out.println("<td>" + x.getTenSanPham() + "<strong class=\"mx-2\">x</strong>" + x.getSoLuong() + "</td>");
												out.println("<td>" + x.getThanhTien() + "</td>");
												out.println("</tr>");
												tt += x.getThanhTien();
											}
										}
										%>
										<tr>
											<td class="text-black font-weight-bold"><strong>Order
													Total</strong></td>
											<td class="text-black font-weight-bold"><strong><%=tt%></strong></td>
										</tr>
									</tbody>
								</table>
								<div class="form-group">
									<%
									if (tt != 0)
									%>
									<button type="submit"
										class="btn btn-primary btn-lg py-3 btn-block">Place
										Order</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- </form> -->
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
	<script>
    var cities = document.getElementById("city");
    var districts = document.getElementById("district");
    var wards = document.getElementById("ward");

    var Parameter = {
        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
        method: "GET",
        responseType: "application/json",
    };

    var promise = axios(Parameter);

    promise.then(function (result) {
        renderCity(result.data);
    }).catch(function (error) {
        console.error("Error fetching data:", error);
    });

    function renderCity(data) {
        for (const city of data) {
            cities.options[cities.options.length] = new Option(city.Name, city.Name);
        }

        cities.onchange = function () {
            districts.length = 1;
            wards.length = 1;

            if (this.value !== "") {
                const selectedCity = data.find(city => city.Name === this.value);

                for (const district of selectedCity.Districts) {
                    districts.options[districts.options.length] = new Option(district.Name, district.Name);
                }
            }
        };

        districts.onchange = function () {
            wards.length = 1;

            if (this.value !== "") {
                const selectedCity = data.find(city => city.Name === cities.value);
                const selectedDistrict = selectedCity.Districts.find(district => district.Name === this.value);

                for (const ward of selectedDistrict.Wards) {
                    wards.options[wards.options.length] = new Option(ward.Name, ward.Name);
                }
            }
        };
    }
</script>

</body>
</html>