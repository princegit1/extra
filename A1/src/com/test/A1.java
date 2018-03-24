package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A1
 */
@WebServlet("/A1")
public class A1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public A1() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		  response.setContentType("image/jpg");
	        ServletOutputStream out = response.getOutputStream();
	 
	        BufferedImage image = new BufferedImage(200, 40, BufferedImage.TYPE_BYTE_INDEXED);
	 
	        Graphics2D graphics = image.createGraphics();
	         
	        // Set back ground of the generated image to white
	        graphics.setColor(Color.WHITE);
	        graphics.fillRect(0, 0, 200, 40);
	 
	        // set gradient font of text to be converted to image
	        GradientPaint gradientPaint = new GradientPaint(10, 5, Color.BLUE, 20, 10, Color.LIGHT_GRAY, true);
	        graphics.setPaint(gradientPaint);
	        Font font = new Font("Comic Sans MS", Font.BOLD, 30);
	        graphics.setFont(font);
	 
	        // write 'Hello World!' string in the image
	        graphics.drawString("Hello World!", 5, 30);
	 
	        // release resources used by graphics context
	        graphics.dispose();
	 
	        // encode the image as a JPEG data stream and write the same to servlet output stream   
	    
	 
	        // close the stream
	        out.close();
	        
	        
	}

}
