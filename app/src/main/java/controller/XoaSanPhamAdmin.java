package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.NguoiDungBean;
import bo.SanPhamBo;

/**
 * Servlet implementation class XoaSanPhamAdmin
 */
@WebServlet("/XoaSanPhamAdmin")
public class XoaSanPhamAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSanPhamAdmin() {
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
		if (msp != null) {
			SanPhamBo spb = new SanPhamBo();
			spb.xoaSanPham(msp);
		}
		response.sendRedirect("HienThiSanPhamAdmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
