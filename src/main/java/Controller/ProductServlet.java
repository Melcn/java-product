package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.Product;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		ProductDao pDao = new ProductDao();
		String operation = request.getParameter("operation");
		Integer id = Integer.parseInt(request.getParameter("id"));

		//fonction "supprimer" ou "modifier"
		if (operation.equals("supprimer")) {
			pDao.removeProduct(id);
			List<Product> pList = pDao.showList();
			request.setAttribute("list", pList);
			this.getServletContext().getRequestDispatcher("/WEB-INF/viewListProduct.jsp").forward(request, response);
		
		} else {
			request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/viewEditProduct.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		String newName = request.getParameter("newName");
		String newPrice = request.getParameter("newPrice");
		String button = request.getParameter("submit");

		Product product = new Product();
		ProductDao pDao = new ProductDao();

		String error = "";
		
		product.setName(name);
		product.setPrice(price);

		if (button.equals("save") && name.isEmpty() || button.equals("save") && price.isEmpty()) {
			error = "Tous les champs ne sont pas remplis";
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		} else if (button.equals("edit") && !newName.isEmpty()) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			pDao.editProduct(id, newName, newPrice);

		} else {
			
			pDao.addProduct(product);
		
		}
		
		List<Product> pList = pDao.showList();
		request.setAttribute("list", pList);

		this.getServletContext().getRequestDispatcher("/WEB-INF/viewListProduct.jsp").forward(request, response);

		
	}	
	
	

}
