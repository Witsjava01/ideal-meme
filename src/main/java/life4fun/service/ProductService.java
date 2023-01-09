package life4fun.service;

import java.util.List;

import javax.validation.constraints.Size;

import life4fun.entity.Product;
import life4fun.exception.VGBException;

public class ProductService {	
	private ProductsDAO dao = new ProductsDAO();
	
	public List<Product> getAllProducts() throws VGBException{
		List<Product> list = dao.selectAllProducts();		
		return list;
	}
	
	public List<Product> getNewArrProducts() throws VGBException{
		List<Product> list = dao.selectNewArrProducts();
		System.out.println("service->getNewArrProducts");
		return list;
	}
	
	
	public List<Product> getPriceHightoLow() throws VGBException{
		List<Product> list = dao.PriceHightoLow();
		System.out.println("service->PriceHightoLow");
		return list;
	}
	
	public List<Product> PriceLowtoHigh() throws VGBException{
		List<Product> list = dao.PriceLowtoHigh();
		System.out.println("service->PriceLowtoHigh");
		return list;
	}
	
	

	public List<Product> newOnshelf() throws VGBException{
		List<Product> list = dao.newOnshelf();
		System.out.println("service->newOnshelf");
		return list;
	}
	public List<Product> stock() throws VGBException{
		List<Product> list = dao.stock();
		System.out.println("service->stock");
		return list;
	}
	
	public List<Product> getProductsByName(String keyword) throws VGBException{
		if(keyword==null) {
			throw new IllegalArgumentException("用關鍵字查詢產品時必須輸入一個字以上的條件");
		}else if(keyword.length()==0) {
			return dao.selectAllProducts();
		}
		
		List<Product> list = dao.selectProductsByName(keyword);		
		return list;
	}
	
	public List<Product> getProductsByCategory(String category) throws VGBException{
		if(category==null || category.length()==0) {
			throw new IllegalArgumentException("用分類查詢產品時分類條件必須有值");
		}
		
		List<Product> list = dao.selectProductsByCategory(category);		
		return list;
	}
	
	public List<Product> getNewestProducts()throws VGBException{		
		
		List<Product> list = dao.selectNewestProducts();		
		return list;
	}
	
	public Product getProductById(String productId)throws VGBException{		
		Product p = dao.selectProductById(productId);
		System.out.println("service->getProductById");
		return p;
	}
	

}