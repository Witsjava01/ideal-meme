package life4fun.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import life4fun.dto.RequestResult;
import life4fun.entity.Product;
import life4fun.exception.VGBException;
import life4fun.service.MemberService;
import life4fun.service.ProductService;
import life4fun.service.StreetNameService;
import life4fun.service.impl.MemberServiceImpl;
import life4fun.service.impl.StreetNameServiceImpl;
import life4fun.utils.ApplicationUtils;
import life4fun.utils.ConstantUtils;
import life4fun.utils.JsonUtils;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	public static final String JSP_SOURCE = "/jsp/product/";
	public static final String JS_SOURCE = "/js/product/";
	public static final String STATIC_SOURCE = "static";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(ApplicationUtils.JS_SOURCE_KEY, JS_SOURCE);
		request.setAttribute(ApplicationUtils.STATIC_SOURCE_KEY, STATIC_SOURCE);
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method") == null ? "getAllProducts" : request.getParameter("method");
		System.out.println("method -> " + method);
		switch (method) {
		case "getAllProducts":
			try {
				getAllProducts(request, response);
			} catch (ServletException | IOException | VGBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "getNewArrProducts":
			try {
				getNewArrProducts(request, response);
			} catch (ServletException | IOException | VGBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "getPriceHightoLow":
			try {
				getPriceHightoLow(request, response);
			} catch (ServletException | IOException | VGBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "getPriceLowtoHigh":
			try {
				getPriceLowtoHigh(request, response);
			} catch (ServletException | IOException | VGBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "getnewOnshelf":
			try {
				getnewOnshelf(request, response);
			} catch (ServletException | IOException | VGBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		case "getStock":
			try {
				getStock(request, response);
			} catch (ServletException | IOException | VGBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, VGBException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		ProductService service = new ProductService();
		List<Product> list = null;
		
			list = service.getAllProducts();

		request.setAttribute("product",list);
		response.getWriter().append(JsonUtils.getGson().toJson(list));

}
	public void getNewArrProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, VGBException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		System.out.println("servlet->getNewArrProducts");

		ProductService service = new ProductService();
		List<Product> listArr = null;
		
			listArr = service.getNewArrProducts();

		request.setAttribute("product",listArr);
		response.getWriter().append(JsonUtils.getGson().toJson(listArr));

}
	public void getPriceHightoLow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, VGBException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		System.out.println("servlet->getPriceHightoLow");

		ProductService service = new ProductService();
		List<Product> listPriceHightoLow = null;
		
			listPriceHightoLow = service.getPriceHightoLow();

		request.setAttribute("product",listPriceHightoLow);
		response.getWriter().append(JsonUtils.getGson().toJson(listPriceHightoLow));

}
	public void getPriceLowtoHigh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, VGBException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		System.out.println("servlet->getPriceLowtoHigh");

		ProductService service = new ProductService();
		List<Product> listPriceLowtoHigh = null;
		
		listPriceLowtoHigh = service.PriceLowtoHigh();

		request.setAttribute("product",listPriceLowtoHigh);
		response.getWriter().append(JsonUtils.getGson().toJson(listPriceLowtoHigh));

}
	
	public void getnewOnshelf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, VGBException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		System.out.println("servlet->getnewOnshelf");

		ProductService service = new ProductService();
		List<Product> listnewOnshelf = null;
		
		listnewOnshelf = service.newOnshelf();

		request.setAttribute("product",listnewOnshelf);
		response.getWriter().append(JsonUtils.getGson().toJson(listnewOnshelf));

}
	
	public void getStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, VGBException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		System.out.println("servlet->getnewOnshelf");

		ProductService service = new ProductService();
		List<Product> listStock = null;
		
		listStock = service.stock();

		request.setAttribute("product",listStock);
		response.getWriter().append(JsonUtils.getGson().toJson(listStock));

}



}
