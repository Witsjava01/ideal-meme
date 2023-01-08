package life4fun.service;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import life4fun.entity.Product;
import life4fun.exception.VGBException;

class ProductsDAO {

	private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product ";

	List<Product> selectAllProducts() throws VGBException {
		List<Product> list = new ArrayList<Product>();
		System.out.println("查詢全部商品");
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Product p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					//System.out.println("555555555555555555"+rs.getString("product_name")+" price= "+rs.getDouble("price"));
					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤", e);
		}
		return list;
	}

//	查詢名字
	private static final String SELECT_PRODUCTS_BY_NAME = "SELECT* FROM product   WHERE name LIKE ?";

	List<Product> selectProductsByName(String keyword) throws VGBException {
		List<Product> list = new ArrayList<Product>();
		System.out.println("查詢名字");
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_NAME);) {

			pstmt.setString(1, '%' + keyword + '%');
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Product p = new Product();

					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));

					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤" + keyword, e);
		}
		return list;
	}

//	private static final String SELECT_PRODUCTS_BY_CATEGORY =
//			"SELECT id, name, unit_price, stock, photo_url, category, discount"
//			+ "	FROM products"
//			+ "    WHERE category=?";
	private static final String SELECT_PRODUCTS_BY_CATEGORY = "SELECT *FROM product  WHERE product_catalog=?";

	List<Product> selectProductsByCategory(String category) throws VGBException {
		List<Product> list = new ArrayList<Product>();

		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY);) {

			pstmt.setString(1, category);
			try (ResultSet rs = pstmt.executeQuery(); 
			) {
			
				while (rs.next()) {
					Product p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢分類有誤" + category, e);
		}
		return list;
	}

	private static final String SELECT_NEWEST_PRODUCTS = "SELECT id, name, unit_price, stock, photo_url, category, discount,launch_date "
			+ "	FROM products_list_view " + "    WHERE launch_date<=DATE_ADD(curdate(), INTERVAL 1 DAY)"
			+ "    ORDER BY launch_date DESC, id DESC LIMIT 10";

	List<Product> selectNewestProducts() throws VGBException {
		List<Product> list = new ArrayList<Product>();

		try (Connection connection = MySQLConnection.getConnection(); // 1,2. �����蝺�
				PreparedStatement pstmt = connection.prepareStatement(SELECT_NEWEST_PRODUCTS);) {
			try (ResultSet rs = pstmt.executeQuery(); // 4.�銵�誘
			) {
				
//				while(rs.next()) {
//					Product p;
//					int discount = rs.getInt("discount");
//					if(discount>0) {
//						p = new Outlet();
//						((Outlet)p).setDiscount(discount);
//					}else {
//						p = new Product();
//					}
//					
//					p.setId(rs.getInt("id"));
//					p.setName(rs.getString("name"));
//					p.setUnitPrice(rs.getDouble("unit_price"));
//					p.setStock(rs.getInt("stock"));
//					p.setPhotoUrl(rs.getString("photo_url"));
//					p.setCategory(rs.getString("category"));		
//					p.setLaunchDate(rs.getString("launch_date"));
//					list.add(p);
//				}
			}
		} catch (SQLException e) {
			throw new VGBException("�閰Ｘ�����仃���", e);
		}
		return list;
	}

	
	private static final String SELECTNEWARRIVLSPRODUCTS = "SELECT * FROM life4fun.product order by product_id desc limit 6";

	
	List<Product> selectNewArrProducts() throws VGBException {
		List<Product> list = new ArrayList<Product>();
		System.out.println("查詢最新六件商品 index.js");
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECTNEWARRIVLSPRODUCTS);) {
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Product p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));

					//System.out.println("product_id="+rs.getString("product_id")+"product_name="+rs.getString("product_name"));

					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤", e);
		}
		return list;
	}

	


	private static final String select_Product_By_Id = "SELECT * FROM life4fun.product" + "        WHERE product_Id=?";

	List<Product> selectProductById(String productId) throws VGBException {
		List<Product> list = new ArrayList<Product>();
		Product p = null;
		try (Connection connection = MySQLConnection.getConnection(); 
				PreparedStatement pstmt = connection.prepareStatement(select_Product_By_Id);
		) {
			// 3.1 ��?����
			pstmt.setString(1, productId);

			try (ResultSet rs = pstmt.executeQuery(); // 4.�銵�誘
			) {
			
				while(rs.next()) {
					 p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					System.out.println("測試 id"+"product_name="+rs.getString("product_name")+" id= "+rs.getInt("product_id"));
					
					list.add(p);
					}					
					
				
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤", e);
		}
		return list;
	}

	
	
	private static final String SELECT_PriceHightoLow = "SELECT * FROM life4fun.product order by price desc";

	List<Product> PriceHightoLow() throws VGBException {
		List<Product> list = new ArrayList<Product>();
		System.out.println("查詢價格高低");
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PriceHightoLow);) {
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Product p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					//System.out.println("價格"+"product_name="+rs.getString("product_name")+" price= "+rs.getDouble("price"));
					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤", e);
		}
		return list;
	}
	private static final String SELECT_PriceLowtoHigh = "SELECT * FROM life4fun.product order by price ";

	List<Product> PriceLowtoHigh() throws VGBException {
		List<Product> list = new ArrayList<Product>();
		System.out.println("查詢價格高低");
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PriceLowtoHigh);) {
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Product p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					//System.out.println("價格"+"product_name="+rs.getString("product_name")+" price= "+rs.getDouble("price"));
					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤", e);
		}
		return list;
	}
	private static final String SELECT_newOnshelf = "SELECT * FROM life4fun.product order by product_id desc";

	List<Product> newOnshelf() throws VGBException {
		List<Product> list = new ArrayList<Product>();
		System.out.println("最新上架");
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_newOnshelf);) {
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Product p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					//System.out.println("價格"+"product_name="+rs.getString("product_name")+" price= "+rs.getDouble("price"));
					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤", e);
		}
		return list;
	}
	private static final String SELECT_stock = "SELECT * FROM life4fun.product order by stock desc";

	List<Product> stock() throws VGBException {
		List<Product> list = new ArrayList<Product>();
		System.out.println("最新上架");
		try (Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_stock);) {
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Product p = new Product();


					p.setProductId(rs.getInt("product_id"));
					p.setPhotoUrl1(rs.getString("photo_url_1"));
					p.setProductName(rs.getString("product_name"));
					p.setBrand(rs.getString("brand"));
					p.setPrice(rs.getDouble("price"));
					p.setSize(rs.getString("size"));
					p.setColor(rs.getString("color"));
					p.setStock(rs.getInt("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					//System.out.println("價格"+"product_name="+rs.getString("product_name")+" price= "+rs.getDouble("price"));
					
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("資料庫查詢有誤", e);
		}
		return list;
	}
	
}
