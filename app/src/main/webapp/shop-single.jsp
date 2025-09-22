<%@page import="bean.NguoiDungBean"%>
<%@page import="bean.SanPhamBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shop &mdash; Chi tiet san pham</title>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		HttpSession ss = request.getSession();
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");
		SanPhamBean sp = (SanPhamBean) ss.getAttribute("product");
		long DonGia = sp.getDonGia();
	%>
	<div class="site-wrap">
    <%@include file="head.jsp"%>
		
		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<img src="images/<%=sp.getHinhAnh()%>" alt="Image"
							class="img-fluid">
					</div>
					<div class="col-md-6">
						<h2 class="text-black"><%=sp.getTenSanPham()%></h2>
						<h3>
							Loại đồng hồ:
							<%=sp.getLoaiDongHo()%></h3>
						<div>
							<p>
								<strong class="text-primary h4"> Giá Tiền: </strong> <strong class="text-primary h4" id="Gia"> <%=sp.getDonGia()%></strong>
							</p>
						</div>
						<form action="GioHangController?msp=<%=sp.getMaSanPham()%>&tsp=<%=sp.getTenSanPham()%>&dongia=<%=sp.getDonGia()%>&hinhanh=<%=sp.getHinhAnh()%>" method="post">
							<div class="mb-5">
								<input id="ht" value="<%=sp.getDonGia()%>" type="hidden">
								<p>
									<strong class="text-primary h4" id="Gia"> Số lượng: </strong>
								</p>
								<div class="input-group mb-3" style="max-width: 120px;">
									<input id="soluong"
										onchange="capNhatGia(this.value)"
										class="form-control text-center" value="1" placeholder=""
										aria-label="Example text with button addon"
										aria-describedby="button-addon1" name = "soluong" type = "number">
								</div>
							</div>
							<button type="submit" class="buy-now btn btn-sm btn-primary">
								Add To Cart</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$("#soluong").on(
					"input",
					function() {
						// alert($(this).val()); 
						var dongia = document.getElementById('ht').value;
						// test
						console.log($(this).val());
						console.log(dongia);
						document.getElementById('Gia').innerText = $(this)
								.val()
								* dongia;
					});
		</script>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>

</body>
</html>