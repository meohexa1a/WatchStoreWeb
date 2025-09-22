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

import bean.DoiTuongSDBean;
import bean.SanPhamBean;
import bo.NhaSanXuatBo;
import bo.SanPhamBo;

/**
 * Servlet implementation class ShopController
 */
@WebServlet("/ShopController")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void DEBUG(String[] str) {
    	if (str == null) return;
    	for (int i = 0; i < str.length; i++) {
    		System.err.println(str[i]);
    	}
    }
    public void DEBUG(ArrayList<String> str) {
    	if (str != null) 
			for (String x: str) {
				System.err.println(x);
			}
    }
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
		
		if (request.getParameter("search") != null) {
			String pt = request.getParameter("search");
			session.setAttribute("products", spb.getSanPham(pt));
		} else {
			
			// Load San Pham
			String[] dtsd = request.getParameterValues("dtsd");
			String[] price = request.getParameterValues("price");
			String[] type = request.getParameterValues("type");
			String[] nsx = request.getParameterValues("nsx");
			DEBUG(dtsd);
			DEBUG(price);
			DEBUG(type);
			DEBUG(nsx);
			ArrayList<String> DTSD = new ArrayList<String>();
			ArrayList<String> PRICE = new ArrayList<String>();
			ArrayList<String> TYPE = new ArrayList<String>();
			ArrayList<String> NSX = new ArrayList<String>();
			ArrayList<SanPhamBean> fp = new ArrayList<SanPhamBean>();
			if (strPage != null) {
				DTSD = (ArrayList<String>)session.getAttribute("DTSD");
				TYPE = (ArrayList<String>)session.getAttribute("TYPE");
				PRICE = (ArrayList<String>)session.getAttribute("PRICE");
				NSX = (ArrayList<String>)session.getAttribute("NSX");
				fp = spb.getSanPham(Integer.parseInt(strPage), DTSD, PRICE, TYPE, NSX);
			} else {
				
				if (dtsd != null) {
					for (int i = 0; i < dtsd.length; i++) {
							DTSD.add(dtsd[i]);
					}
				}
				if (price != null) {
					for (int i = 0; i < price.length; i++) {
							PRICE.add(price[i]);
					}
				}
				if (type != null) {
					for (int i = 0; i < type.length; i++) {
						if (!type[i].equals("")) {
							TYPE.add(type[i]);
						}
					}
				}
				if (nsx != null) {
					for (int i = 0; i < nsx.length; i++) {
						if (!nsx[i].equals("")) {
							NSX.add(nsx[i]);
						}
					}
				}
				DEBUG(DTSD);
				DEBUG(PRICE);
				DEBUG(TYPE);
				DEBUG(NSX);
				session.setAttribute("DTSD", DTSD);
				session.setAttribute("TYPE", TYPE);
				session.setAttribute("NSX", NSX);
				session.setAttribute("PRICE", PRICE);
				fp = spb.getSanPham(1, DTSD, PRICE, TYPE, NSX);
			}
			session.setAttribute("numProducts", spb.getNumProducts());
			session.setAttribute("products", fp); 	
		}
		String web = "shop.jsp";
		if (strPage != null) {
			web += "?page=" + Integer.parseInt(strPage);
		}	
		RequestDispatcher rd = request.getRequestDispatcher(web);
		rd.forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

	