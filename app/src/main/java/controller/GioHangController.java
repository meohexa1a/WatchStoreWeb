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

/**
 * Servlet implementation class CartController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GioHangBo ghb = new GioHangBo();
		if (ss.getAttribute("nguoiDung") == null) {
			String s = request.getParameter("msp");
			ss.setAttribute("return", s);
			response.sendRedirect("DangNhapController");
			return;
		}
		NguoiDungBean ndb = (NguoiDungBean)ss.getAttribute("nguoiDung");
		if (request.getParameter("suasoluong") != null) {
			ArrayList<GioHangBean> gh = new ArrayList<GioHangBean>();
			if (ss.getAttribute("giohang") == null) {
				ss.setAttribute("giohang", gh);
			}
			String msp = request.getParameter("suasoluong");
			gh = (ArrayList<GioHangBean>)ss.getAttribute("giohang");
			Integer sl = Integer.valueOf(request.getParameter(msp));
			Integer ms = Integer.valueOf(msp);
			if (gh != null && sl > 0)
			for (GioHangBean x: gh) {
				if (x.getMaSanPham() == ms) {
					x.setSoLuong(sl);
					ghb.CapNhatGioHang(ndb.getMaNguoiDung(), x.getMaSanPham(), Long.valueOf(sl));
					break;
				}
			}
			ss.setAttribute("giohang", gh);
		}
		
		if (request.getParameter("msp") != null) {
			int msp = Integer.valueOf(request.getParameter("msp"));
			String tsp = request.getParameter("tsp");
			String ha = request.getParameter("hinhanh");
			Long dongia = Long.valueOf(request.getParameter("dongia"));
			int soluong = Integer.valueOf(request.getParameter("soluong"));
			ArrayList<GioHangBean> gh = new ArrayList<GioHangBean>();
			if (ss.getAttribute("giohang") == null) {
				ss.setAttribute("giohang", gh);
			}
			gh = (ArrayList<GioHangBean>)ss.getAttribute("giohang");
			Boolean tonTai = false;
			if (gh != null) {
				for (GioHangBean x: gh) {
					if (x.getMaSanPham() == msp) {
						x.setSoLuong(x.getSoLuong() + soluong);
						ghb.CapNhatGioHang(ndb.getMaNguoiDung(), x.getMaSanPham(), Long.valueOf(x.getSoLuong()));
						tonTai = true;
						break;
					}
				}
			}
			if (tonTai == false) {
				System.out.println("da them san pham");
				gh.add(new GioHangBean(msp, tsp, ha, dongia, soluong, soluong * dongia));
				ghb.CapNhatGioHang(ndb.getMaNguoiDung(), msp, Long.valueOf(soluong));
			}
			ss.setAttribute("giohang", gh);
			response.sendRedirect("GioHangController");
			return;
		}
		if (request.getParameter("xoa") != null) {
			int ma = Integer.valueOf(request.getParameter("xoa"));
			ArrayList<GioHangBean> gh = new ArrayList<GioHangBean>();
			if (ss.getAttribute("giohang") == null) {
				ss.setAttribute("giohang", gh);
			}
			gh = (ArrayList<GioHangBean>)ss.getAttribute("giohang");
			if (gh != null) {
				for (int i = 0; i < gh.size(); i++) {
					if (gh.get(i).getMaSanPham() == ma) {
						gh.remove(i);
						ghb.XoaCtHoaDon(ndb.getMaNguoiDung(), ma);
						break;
					}
				}
			}
			ss.setAttribute("giohang", gh);
			response.sendRedirect("GioHangController");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
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
