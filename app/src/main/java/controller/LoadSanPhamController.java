package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SanPhamBean;
import bo.NhaSanXuatBo;
import bo.SanPhamBo;

/**
 * Servlet implementation class LoadSanPhamController
 */
@WebServlet("/LoadSanPhamController")
public class LoadSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadSanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		SanPhamBo spb = new SanPhamBo();
		String strPage = request.getParameter("page");
		
		// Load Nha San Xuat
		if (session.getAttribute("NhaSanXuat") == null) {
			NhaSanXuatBo nsxb = new NhaSanXuatBo();
			session.setAttribute("NhaSanXuat", nsxb.getNhaSanXuat());
		}

		// Load San Pham
		String[] dtsd = request.getParameterValues("dtsd");
		String[] price = request.getParameterValues("price");
		String[] type = request.getParameterValues("type");
		String[] nsx = request.getParameterValues("nsx");
		ArrayList<SanPhamBean> fp = new ArrayList<SanPhamBean>();
		if (strPage == null)
			fp = spb.getSanPham(1, dtsd, price, type, nsx);
		else
			fp = spb.getSanPham(Integer.parseInt(strPage), dtsd, price, type, nsx);
		session.setAttribute("numProducts", spb.getNumProducts());
		PrintWriter out = response.getWriter();
		System.out.println("ok");
		for (SanPhamBean x: fp) {    	
	    	out.println("<div class=\"col-sm-6 col-lg-4 mb-4\" data-aos=\"fade-up\">\r\n"
	    			+ "	                <div class=\"block-4 text-center border\">\r\n"
	    			+ "	                  <figure class=\"block-4-image\">\r\n"
	    			+ "	                    <a href=\"shop-single.jsp\"><img src= \"images/" + x.getHinhAnh() + "\" alt=\"Image placeholder\" class=\"img-fluid\"></a>\r\n"
	    			+ "	                  </figure>\r\n"
	    			+ "	                  <div class=\"block-4-text p-4\">\r\n"
	    			+ "	                    <h3><a href=\"shop-single.jsp\">" + x.getTenSanPham() + "</a></h3>\r\n"
	    			+ "	                    <p class=\"mb-0\">Finding perfect t-shirt</p>\r\n"
	    			+ "	                    <p class=\"text-primary font-weight-bold\">" + x.getDonGia() + " VND</p>\r\n"
	    			+ "	                  </div>\r\n"
	    			+ "	                </div>\r\n"
	    			+ "	              </div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
