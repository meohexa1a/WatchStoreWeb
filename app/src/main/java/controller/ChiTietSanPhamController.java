package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SanPhamBean;
import bo.SanPhamBo;

/**
 * Servlet implementation class ChiTietSanPhamController
 */
@WebServlet("/ChiTietSanPhamController")
public class ChiTietSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if (request.getParameter("msp") != null) {
			Integer msp = Integer.valueOf(request.getParameter("msp"));
			SanPhamBo spb = new SanPhamBo();
			ss.setAttribute("product", spb.get1SanPham(msp));
			RequestDispatcher rd = request.getRequestDispatcher("shop-single.jsp");
			rd.forward(request, response);
			return;
		} else {
			response.sendRedirect("ShopController");
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
