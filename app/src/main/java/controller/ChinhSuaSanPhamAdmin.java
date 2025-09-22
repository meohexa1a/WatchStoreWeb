package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.NguoiDungBean;
import bo.SanPhamBo;

/**
 * Servlet implementation class ChinhSuaSanPhamAdmin
 */
@WebServlet("/ChinhSuaSanPhamAdmin")
public class ChinhSuaSanPhamAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChinhSuaSanPhamAdmin() {
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
		if (ss.getAttribute("nguoiDung") == null) {
			response.sendRedirect("DangNhapController");
			return;
		} else {
			NguoiDungBean nguoiDung = (NguoiDungBean)ss.getAttribute("nguoiDung");
			if (nguoiDung.getQuyen() == false) {
				response.sendRedirect("IndexController");
				return;
			}
		}
		String msp = request.getParameter("msp");
		String tsp = request.getParameter("TenSanPham");
		String dongia = request.getParameter("DonGia");
		if (msp != null && tsp != null && dongia != null) {
			SanPhamBo spb = new SanPhamBo();
			spb.CapNhatSanPham(tsp, msp, dongia);
		}
		RequestDispatcher rd = request.getRequestDispatcher("HienThiSanPhamAdmin");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
