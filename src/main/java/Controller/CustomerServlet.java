package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dao.ProductDao;
import model.Customer;
import model.Product;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String nameCustomer = request.getParameter("nameCustomer");
		String firstName = request.getParameter("firstName");
		String mail = request.getParameter("mail");
		String adress = request.getParameter("adress");

		String newMail = request.getParameter("newMail");
		String newAdress = request.getParameter("newAdress");
		String button = request.getParameter("submit");

		Customer customer = new Customer();
		CustomerDao cDao = new CustomerDao();

		String error = "";

		customer.setNameCustomer(nameCustomer);
		customer.setFirstName(firstName);
		customer.setMail(mail);
		customer.setAdress(adress);

		if (button.equals("save") && nameCustomer.isEmpty() || button.equals("save") && firstName.isEmpty()
				|| button.equals("save") && adress.isEmpty()) {
			error = "Tous les champs ne sont pas remplis";
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/indexCustomer.jsp").forward(request, response);

		} else if (button.equals("edit") && !newMail.isEmpty()) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			cDao.editCustomer(id, newMail, newAdress);

		} else {

			cDao.addCustomer(customer);

		}

		List<Customer> customerList = cDao.showCustomerList();
		request.setAttribute("list", customerList);

		this.getServletContext().getRequestDispatcher("/WEB-INF/viewListCustomer.jsp").forward(request, response);

	}

}
