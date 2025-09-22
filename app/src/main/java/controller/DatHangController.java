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
import bo.DonDatHangBo;
import bo.GioHangBo;
import dao.GioHangDao;

/**
 * Servlet implementation class DatHangController
 */
@WebServlet("/DatHangController")
public class DatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatHangController() {
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
			ArrayList<GioHangBean> gh = (ArrayList<GioHangBean>)ss.getAttribute("giohang");
			GioHangBo ghb = new GioHangBo();
			if (gh == null || gh.size() == 0) {
				response.sendRedirect("ShopController");
				return;
			}
			String HoVaTen = request.getParameter("c_name");
			String DiaChi = request.getParameter("c_address");
			DiaChi += ", " + request.getParameter("ward");
			DiaChi += ", " + request.getParameter("district");
			DiaChi += ", " + request.getParameter("city");
			String SDT = request.getParameter("c_phone");
			Long TongTien = 0L;
			int MaHoaDon = ghb.getMaHoaDon(nguoiDung.getMaNguoiDung());
			for (GioHangBean x: gh) {
				TongTien += x.getThanhTien();
			}
			if (HoVaTen != null && DiaChi != null && SDT != null) {
				DonDatHangBo dd = new DonDatHangBo();
				GioHangDao ghd = new GioHangDao();
				dd.DatHang(HoVaTen, DiaChi, SDT, TongTien, MaHoaDon);
				ss.removeAttribute("giohang");
				ghd.CapNhatDaMua(nguoiDung.getMaNguoiDung());
				response.sendRedirect("ThankYou");
				return;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
