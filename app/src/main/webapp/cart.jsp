<%@page import="bean.GioHangBean"%>
<%@page import="bean.ChiTietHoaDonBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.NguoiDungBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
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
        <div class="row mb-5">
          <form class="col-md-12" action = "GioHangController" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th class="product-thumbnail"> Ảnh </th>
                    <th class="product-name"> Sản phẩm </th>
                    <th class="product-price"> Đơn giá </th>
                    <th class="product-quantity"> Số lượng </th>
                    <th class="product-total"> Tổng tiền </th>
                    <th class="product-remove"> Xoá </th>
                  </tr>
                </thead>
                <tbody>
                	<% 
                		ArrayList<GioHangBean> giohang = (ArrayList<GioHangBean>)ss.getAttribute("giohang");
                		Long TongTien = 0L;
                		if (giohang != null) {
                		for (GioHangBean x: giohang) {
                			TongTien += x.getThanhTien();
									%>
										<tr>
	                    <td class="product-thumbnail">
	                      <img src="images/<%=x.getHinhAnh()%>" alt="Image" class="img-fluid">
	                    </td>
	                    <td class="product-name">
	                      <h2 class="h5 text-black"><%=x.getTenSanPham()%></h2>
	                    </td>
	                    <td><%=x.getDonGia()%></td>
	                    <td>
	                      <div class="input-group mb-3" style="max-width: 120px;">
	                        <input type="number" class="form-control text-center" value="<%=x.getSoLuong()%>" name = "<%=x.getMaSanPham()%>" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
	                        <div class="input-group-append">
	                        	<button class = "btn btn-outline-primanry js-btn-plus" type = "submit" name = "suasoluong" value = <%=x.getMaSanPham()%>>+</button>
	                        </div>
	                      </div>
	                    </td>
	                    <td><%=x.getThanhTien()%></td>
	                    <td><a href="GioHangController?xoa=<%=x.getMaSanPham()%>" class="btn btn-primary btn-sm">X</a></td>
                  	</tr>	
									<%               			
                		}
                	}
                	%>
                </tbody>
              </table>
            </div>
          </form>
        </div>

        <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">
              <div class="col-md-6 mb-3 mb-md-0">
              </div>
              <div class="col-md-6">
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
              </div>
              <div class="col-md-8 mb-3 mb-md-0">
              </div>
              <div class="col-md-4">
              </div>
            </div>
          </div>
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                <div class="row">
                  <div class="col-md-12 border-bottom mb-5">
                    <h3 class="text-black h4 text-uppercase">Cart Totals: <%=TongTien%></h3>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                  	<form action="DatHangController" method = "post">
	                    <button class="btn btn-primary btn-lg py-3 btn-block">Đặt hàng</button>
                  	</form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
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