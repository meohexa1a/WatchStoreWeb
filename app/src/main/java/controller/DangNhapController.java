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

import bean.GioHangBean;
import bean.NguoiDungBean;
import bo.GioHangBo;
import bo.NguoiDungBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		NguoiDungBo ndb = new NguoiDungBo();
		String TK = request.getParameter("userName");
		String MK = request.getParameter("passWord");
		int fail = (ss.getAttribute("fail") == null ? 0 : (int)ss.getAttribute("fail"));
		if (TK != null && MK != null) {
			boolean ok = true;
			if (fail > 2) {
				String ccha = request.getParameter("captcha");
				Captcha captcha = (Captcha) ss.getAttribute(Captcha.NAME);
				if (!captcha.isCorrect(ccha)) ok = false;
			}
			NguoiDungBean nguoiDung = ndb.DangNhap(TK, MK);
			if (ok && ndb.DangNhap(TK, MK) != null) {
				ss.setAttribute("nguoiDung", nguoiDung);
				ss.removeAttribute("mess");
				ss.removeAttribute("fail");
				GioHangBo ghb = new GioHangBo();
				ArrayList<GioHangBean> gh = ghb.getCtHoaDon(nguoiDung.getMaNguoiDung());
				ss.setAttribute("giohang", gh);
				if (ss.getAttribute("return") == null)
					response.sendRedirect("ShopController");
				else {
					String msp = (String)ss.getAttribute("return");
					ss.removeAttribute("return");
					response.sendRedirect("ChiTietSanPhamController?msp=" + msp);		
				}
				return;
			} else {
				fail++;
				ss.setAttribute("fail", fail);
				String mess = "Thông tin đăng nhập không hợp lệ";
				ss.setAttribute("mess", mess);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("sign-in.jsp");
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
