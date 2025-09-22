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
import bo.NhaSanXuatBo;
import bo.SanPhamBo;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			NhaSanXuatBo nhaSanXuatBo = new NhaSanXuatBo();
			session.setAttribute("NhaSanXuat", nhaSanXuatBo.getNhaSanXuat());
			SanPhamBo spb = new SanPhamBo();
			ArrayList<SanPhamBean> fp = new ArrayList<SanPhamBean>();
			if (session.getAttribute("featuredProducts") == null) {
				fp = spb.getSanPham();
			}
			session.setAttribute("featuredProducts", fp);
			System.err.println(fp.size());
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
