package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MenuImpl;
import com.pojo.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/MenuServlet" })
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuAction = request.getParameter("act");
		System.out.println("useraction" + menuAction);
		HttpSession session = request.getSession();
		
		MenuImpl menuImpl = new MenuImpl();
		Menu menu = new Menu();
		
		boolean b;
		
		if(menuAction.equalsIgnoreCase("addProduct")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String type = request.getParameter("type");
			String in_stock = request.getParameter("in_stock");
			
			menu.setAvailable(in_stock);
			menu.setId(id);
			menu.setName(name);
			menu.setPrice(price);
			menu.setType(type);
			
			b = menuImpl.addFood(menu);
			
			if(b)
				response.sendRedirect("admin/admin.jsp?msg=productAdded");
			else
				response.sendRedirect("admin/admin.jsp?msg=error");
			
			
			
		}
		
	}

}
