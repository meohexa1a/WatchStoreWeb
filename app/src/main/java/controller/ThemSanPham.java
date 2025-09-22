package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.NguoiDungBean;
import bo.SanPhamBo;

/**
 * Servlet implementation class ThemSanPham
 */
@WebServlet("/ThemSanPham")
public class ThemSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public String getNameImage() {
    	SanPhamBo spb = new SanPhamBo();
    	int id = spb.getMaSanPhamMax() + 1;
    	return String.valueOf(id);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String TenSanPham = "";
		 Long DonGia = 0L;
		 String LoaiDongHo = "";
		 int MaNSX = 0; 
		 int MaDoiTuongSD = 0;
		 String anh = getNameImage();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 try {
			List<FileItem> fileItems = upload.parseRequest(request);
			if (fileItems != null)
			for (FileItem fileItem : fileItems) {
				if (fileItem.getContentType() != null && !fileItem.isFormField()) {
					if (!fileItem.getContentType().equals("image/png")) continue;
					System.err.println(fileItem.getContentType());
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "images";
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}
				        String fileImg = dirUrl + File.separator + nameimg;
				        File file = new File(fileImg);
				        try {
				        	fileItem.write(file);
				        	Path source = Paths.get(fileImg);
				        	Files.move(source, source.resolveSibling(anh + ".png"));
				        	System.out.println("UPLOAD THÀNH CÔNG...!");
				            System.out.println("Đường dẫn lưu file là: " + dirUrl);
				        } catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else { //Neu la control
						String name =fileItem.getFieldName();
						if (name.equals("TenSanPham")) {
							TenSanPham = fileItem.getString("UTF-8");
							System.out.println("ten san pham = " + TenSanPham);
						}
						if (name.equals("DonGia")) {
							DonGia = Long.valueOf(fileItem.getString());
						}
						if (name.equals("LoaiDongHo")) {
							LoaiDongHo = fileItem.getString();
						}
						if (name.equals("DTSuDung")) {
							MaDoiTuongSD = Integer.valueOf(fileItem.getString());
						}
						if (name.equals("NSX")) {
							MaNSX = Integer.valueOf(fileItem.getString());
						}
						System.out.println(TenSanPham + "\n" + DonGia + "LoaiDongHo" + "\n" + MaDoiTuongSD + "\n" + MaNSX);
					}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		SanPhamBo spb = new SanPhamBo();
		spb.ThemSanPham(TenSanPham, DonGia, anh + ".png", LoaiDongHo, MaNSX, MaDoiTuongSD);
		response.sendRedirect("HienThiSanPhamAdmin");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
