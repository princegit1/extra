package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartBean;
import com.dto.Product;


/**
 * Servlet implementation class S1
 */
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<br>-------------<br>");

		
		
		
		String strAction  = request.getParameter("action");
		if(strAction!=null && !strAction.equals("")) {
			if(strAction.equals("add")) {
				addTocart(request);
			}
			response.sendRedirect("shoppingcart.jsp");        
		}
		 
		
	}

	private void addTocart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Double price = Double.parseDouble(request.getParameter("price"));   
		System.out.println(" -id " + id);
		System.out.println(" -name " + name);
		System.out.println(" -quantity " + quantity);  
		System.out.println(" -price " + price);
		

		CartBean cartBean = null;              
		Object objCartBean = session.getAttribute("cart");
		if(objCartBean!=null) {
			cartBean = (CartBean) objCartBean;
		}
		else   
		{
			cartBean = new CartBean();
			session.setAttribute("cart", cartBean);
			                          
		}
		cartBean.addtoCart(id, name, price, quantity);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
