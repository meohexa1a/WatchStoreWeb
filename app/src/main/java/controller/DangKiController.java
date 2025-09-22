package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.NguoiDungBo;

/**
 * Servlet implementation class DangKiController
 */
@WebServlet("/DangKiController")
public class DangKiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKiController() {
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
		NguoiDungBo ndb = new NguoiDungBo();
		String tenNguoiDung = request.getParameter("tenNguoiDung");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String mess = "";
		if (tenNguoiDung != null && tenDangNhap != null && matKhau != null) {
			if (ndb.KiemTraTonTai(tenDangNhap) == true) {
				mess = "Tên đăng nhập đã tồn tại";
				ss.setAttribute("mess", mess);
			} else {
				if (ndb.DangKi(tenNguoiDung, tenDangNhap, matKhau)) {
					ss.removeAttribute("mess");
					response.sendRedirect("DangNhapController");
					return;
				} else {
					mess = "Tên đăng nhập đã tồn tại";
					ss.setAttribute("mess", mess);
				}
			}
		} else {
			ss.removeAttribute("mess");
		}
		System.out.println("quay lai dang nhap");
		RequestDispatcher rd = request.getRequestDispatcher("sign-up.jsp");
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
