package Servlet;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * ÑéÖ¤Âëserlvet
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.CpachaUtil;

public class CpachaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7604377492012901205L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request, response);
	}
	String method;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		 method = request.getParameter("method");
		 if("loginCapcha".equals(method)){
			 generateLoginCpacha(request, response);
			 return;
		 }
		 response.getWriter().write("error method");
	}
	String generatorVCode;
	private void generateLoginCpacha(HttpServletRequest request,HttpServletResponse response) throws IOException{
		CpachaUtil cpachaUtil=new CpachaUtil();
		 generatorVCode = cpachaUtil.generatorVCode();
		 request.getSession().setAttribute("loginCapcha", generatorVCode);
		 BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
		 ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
	}

}
