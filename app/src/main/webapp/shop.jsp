<%@page import="bean.NguoiDungBean"%>
<%@page import="bean.NhaSanXuatBean"%>
<%@page import="bean.DoiTuongSDBean"%>
<%@page import="bean.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shop &mdash; Cua Hang</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
          <div class="col-md-9 order-2">

            <div class="row">
              <div class="col-md-12 mb-5">
                <div class="float-md-left mb-4"><h2 class="text-black h5">Shop All</h2></div>
              </div>
            </div>
            <div class="row mb-5">
						<%
							ArrayList<SanPhamBean> sp = (ArrayList<SanPhamBean>)ss.getAttribute("products");
							if (sp != null) {
								for (SanPhamBean x: sp) {
									if (x.isDaXoa() == true) continue;
						%>
	              <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
	                <div class="block-4 text-center border">
	                  <figure class="block-4-image">
	                    <a href="ChiTietSanPhamController?msp=<%=x.getMaSanPham()%>"><img src= "images/<%=x.getHinhAnh()%>" alt="Image placeholder" class="img-fluid"></a>
	                  </figure>
	                  <div class="block-4-text p-4">
	                    <h3><a href="shop-single.jsp"><%=x.getTenSanPham()%></a></h3>
	                    <p class="text-primary font-weight-bold"><%=x.getDonGia()%> VND</p>
	                  </div>
	                </div>
	              </div>
           	<%	
								}
							}
            %>
            </div>
            <div class="row" data-aos="fade-up">
              <div class="col-md-12 text-center">
                <div class="site-block-27">
                  <ul>
                  	<%
                  		Integer numProducts = (ss.getAttribute("numProducts") == null ? 1 : (int)ss.getAttribute("numProducts"));
                  		Integer numPage = (numProducts + 8) / 9;
                  		Integer curPage = (request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page")));
                 			Integer L = Math.max(curPage - 2, 1);
                 			Integer R = Math.min(curPage + 4 - (curPage - L), numPage);
                 			L = Math.max(1, Math.min(L, curPage - (4 - (R - curPage))));
                  	%>
                  	<% 
                  		if (curPage != 1) { 
                  			out.println("<li><a href=\"ShopController?page=" + String.valueOf(curPage - 1) + "\">&lt;</a></li>");
                  		}
                  		for (int i = L; i <= R; i++) {
												if (i == curPage) {	
										%>
													<li class="active"><a href="ShopController?page=<%=i%>"><%=i%></a></li>
										<%
												} else {
										%>
													<li><a href="ShopController?page=<%=i%>"><%=i%></a></li>
										<% 
												}
                  		}                  	
                  		if (curPage != numPage) {
                  			out.println("<li><a href=\"ShopController?page=" + String.valueOf(curPage + 1) + "\">&gt;</a></li>");
                  		}
                  	%>
                  </ul>
                </div>
              </div>
            </div>
          </div>
					<%
					
					%>
          <div class="col-md-3 order-1 mb-5 mb-md-0">
          <form action="ShopController" method = "get">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Đối tượng sử dụng</h3>
              	<% 
              	ArrayList<String> Check = (ArrayList<String>)ss.getAttribute("DTSD");
              			out.println("<label for =\"dtsd0\" class = \"d-flex\">");
              			if (Check != null && Check.contains("0")) {
              				out.println("<input type=\"checkbox\" checked = checked id=\"dtsd0\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"0\"> <span class=\"text-black\">Nam</span>");
              			} else if (Check == null || !Check.contains("0")) {
              				out.println("<input type=\"checkbox\" id=\"dtsd0\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"0\"> <span class=\"text-black\">Nam</span>");
              			}
										out.println("</label>");
              			out.println("<label for =\"dtsd1\" class = \"d-flex\">");
              			if (Check != null && Check.contains("1")) {
              				out.println("<input type=\"checkbox\" checked = checked id=\"dtsd1\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"1\"> <span class=\"text-black\">Nữ</span>");
              			} else if (Check == null || !Check.contains("1")) {
              				out.println("<input type=\"checkbox\" id=\"dtsd1\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"1\"> <span class=\"text-black\">Nữ</span>");
              			}
										out.println("</label>");
              			out.println("<label for =\"dtsd2\" class = \"d-flex\">");
              			if (Check != null && Check.contains("2")) {
              				out.println("<input type=\"checkbox\" checked = checked id=\"dtsd2\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"2\"> <span class=\"text-black\">Unisex</span>");
              			} else if (Check == null || !Check.contains("2")){
              				out.println("<input type=\"checkbox\" id=\"dtsd2\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"2\"> <span class=\"text-black\">Unisex</span>");
              			}
										out.println("</label>");
              			out.println("<label for =\"dtsd3\" class = \"d-flex\">");
              			if (Check != null && Check.contains("3")) {
              				out.println("<input type=\"checkbox\" checked = checked id=\"dtsd3\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"3\"> <span class=\"text-black\">Trẻ em</span>");
              			} else if (Check == null || !Check.contains("3")) {
              				out.println("<input type=\"checkbox\" id=\"dtsd3\" class=\"mr-2 mt-1\" name = \"dtsd\" value = \"3\"> <span class=\"text-black\">Trẻ em</span>");
              			}
										out.println("</label>");
								%>
            </div>

            <div class="border p-4 rounded mb-4">
              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Khoảng giá</h3>
                 <%
                ArrayList<String> Check2 = (ArrayList<String>)ss.getAttribute("PRICE");
                	out.println("<label for=\"pr1\" class=\"d-flex\">");
                  if (Check2 != null && Check2.contains("1"))
										out.println("<input type=\"checkbox\" checked = checked id=\"pr1\" class=\"mr-2 mt-1\" name = \"price\" value = \"1\"> <span class=\"text-black\">0 - 1.000.000</span>");
                	else if (Check2 == null || !Check2.contains("1"))
                		out.println("<input type=\"checkbox\" id=\"pr1\" class=\"mr-2 mt-1\" name = \"price\" value = \"1\"> <span class=\"text-black\">0 - 1.000.000</span>");
                	out.println("</label>");
                	out.println("<label for=\"pr2\" class=\"d-flex\">");
                  if (Check2 != null && Check2.contains("2"))
										out.println("<input type=\"checkbox\" checked = checked id=\"pr2\" class=\"mr-2 mt-1\" name = \"price\" value = \"2\"> <span class=\"text-black\">1.000.000 - 5.000.000</span>");
                	else if (Check2 == null || !Check2.contains("2"))
                		out.println("<input type=\"checkbox\" id=\"pr2\" class=\"mr-2 mt-1\" name = \"price\" value = \"2\"> <span class=\"text-black\">1.000.000 - 5.000.000</span>");
                	out.println("</label>");
                	out.println("<label for=\"pr3\" class=\"d-flex\">");
                  if (Check2 != null && Check2.contains("3"))
										out.println("<input type=\"checkbox\" checked = checked id=\"pr3\" class=\"mr-2 mt-1\" name = \"price\" value = \"3\"> <span class=\"text-black\">5.000.000 - 20.000.000</span>");
                	else if (Check2 == null || !Check2.contains("3"))
                		out.println("<input type=\"checkbox\" id=\"pr3\" class=\"mr-2 mt-1\" name = \"price\" value = \"3\"> <span class=\"text-black\">5.000.000 - 20.000.000</span>");
                	out.println("</label>");
                %>
              </div>

              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Loại đồng hồ</h3>
                <% 
                ArrayList<String> Check3 = (ArrayList<String>)ss.getAttribute("TYPE");
								out.println("<label for=\"t1\" class=\"d-flex\">");
								if (Check3 != null && Check3.contains("Analog"))
									out.println("<input type=\"checkbox\" id=\"t1\" checked = checked class=\"mr-2 mt-1\" name = \"type\" value = \"Analog\"> <span class=\"text-black\">Analog</span>");
								else if (Check3 == null || !Check3.contains("Analog"))
									out.println("<input type=\"checkbox\" id=\"t1\" class=\"mr-2 mt-1\" name = \"type\" value = \"Analog\"> <span class=\"text-black\">Analog</span>");
								out.println("</label>");
								out.println("<label for=\"t2\" class=\"d-flex\">");
								if (Check3 != null && Check3.contains("Digital"))
									out.println("<input type=\"checkbox\" id=\"t2\" checked = checked class=\"mr-2 mt-1\" name = \"type\" value = \"Digital\"> <span class=\"text-black\">Digital</span>");
								else if (Check3 == null || !Check3.contains("Digital"))
									out.println("<input type=\"checkbox\" id=\"t2\" class=\"mr-2 mt-1\" name = \"type\" value = \"Digital\"> <span class=\"text-black\">Digital</span>");
								out.println("</label>");
								out.println("<label for=\"t3\" class=\"d-flex\">");
								if (Check3 != null && Check3.contains("Ana-Digi"))
									out.println("<input type=\"checkbox\" id=\"t3\" checked = checked class=\"mr-2 mt-1\" name = \"type\" value = \"Ana-Digi\"> <span class=\"text-black\">Ana-Digi</span>");
								else if (Check3 == null || !Check3.contains("Ana-Digi"))
									out.println("<input type=\"checkbox\" id=\"t3\" class=\"mr-2 mt-1\" name = \"type\" value = \"Ana-Digi\"> <span class=\"text-black\">Ana-Digi</span>");
								out.println("</label>");
								%>
              </div>

              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Nhà sản xuất</h3>
                	<% 
                		ArrayList<String> Check4 = (ArrayList<String>)ss.getAttribute("NSX");
                		ArrayList<NhaSanXuatBean> nsx = (ArrayList<NhaSanXuatBean>)ss.getAttribute("NhaSanXuat");
										if (nsx != null) {
	                		for (NhaSanXuatBean x: nsx) {
	                			out.println("<label for=\"" + x.getMaNSX() + "\" class=\"d-flex\">");
	                			if (Check4 != null && Check4.contains(String.valueOf(x.getMaNSX())))
	                				out.println("<input name = \"nsx\" checked = checked value = \"" + x.getMaNSX() + "\" type=\"checkbox\" id=\"" + x.getMaNSX() + "\" class=\"mr-2 mt-1\"> <span class=\"text-black\">"+ x.getTenNSX() + "</span>");
	                			else 
	                				out.println("<input name = \"nsx\" value = \"" + x.getMaNSX() + "\" type=\"checkbox\" id=\"" + x.getMaNSX() + "\" class=\"mr-2 mt-1\"> <span class=\"text-black\">"+ x.getTenNSX() + "</span>");
	                			out.println("</label>");
	                		}
										}
									%>
                
              </div>
							<div class="mb-4">
                <button type="submit" class="btn btn-secondary btn-sm"> Tìm kiếm </button>
              </div>
            </div>
            </form>
          </div>
        </div>
      </div>
    </div>
   
		
		<script>
	    if ( window.history.replaceState ) {
	        window.history.replaceState( null, null, window.location.href );
	    }
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