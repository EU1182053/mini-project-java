package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/MenuServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean b;
		
		
		String editAction = request.getParameter("action");
		System.out.println("editAction: " + editAction);
		
		MenuImpl menuImpl = new MenuImpl();
		Menu menu = new Menu();
		HttpSession session = request.getSession();
		
		if(editAction.equalsIgnoreCase("show")) {
			List<Menu> menuList = menuImpl.showFood();
//			System.out.println("editAction show doGet:  "+editAction);
			session.setAttribute("menuList", menuList);
			
			response.sendRedirect("showProduct.jsp");
			
		}
		else if(editAction.equalsIgnoreCase("editById")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			 menu = menuImpl.getFoodById(id);
//			 System.out.println("menu: "+menu);
			 session.setAttribute("menu", menu);
			 
			 response.sendRedirect("editProduct.jsp");
			
			
		}
		else if(editAction.equalsIgnoreCase("deleteById")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			 b = menuImpl.deleteFood(id);
			 
			 if(b)
				 response.sendRedirect("admin.jsp");
			 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String menuAction = request.getParameter("action");

		System.out.println("menuAction doPost: " + menuAction);
		
		HttpSession session = request.getSession();

		MenuImpl menuImpl = new MenuImpl();
		Menu menu = new Menu();

		boolean b;
	
		if (menuAction.equalsIgnoreCase("addProduct")) {
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

			if (b)
				response.sendRedirect("admin.jsp?msg=productAdded");
			else
				response.sendRedirect("admin.jsp?msg=error");

		}

		if (menuAction.equalsIgnoreCase("Update")) {
System.out.println("editById doPost: ");
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String type = request.getParameter("type");
			String available = request.getParameter("available");
			
			
			menu.setId(id);
			menu.setName(name);
			menu.setPrice(price);
			menu.setType(type);
			menu.setAvailable(available);
			
			b = menuImpl.updateFood(menu);
			if(b)
				response.sendRedirect("admin.jsp?msg=edited");
			else
				response.sendRedirect("error.jsp");
			


			

		}
		
		
		

	}

}
