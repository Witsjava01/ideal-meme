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

	private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";

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
					p.setStock(rs.getString("stock"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl2(rs.getString("photo_url_2"));
					p.setPhotoUrl3(rs.getString("photo_url_3"));
					p.setPhotoUrl4(rs.getString("photo_url_4"));
					p.setOnshelf(rs.getString("Onshelf"));
					p.setProductCatalog(rs.getString("product_catalog"));


					System.out.println("product_name="+rs.getString("product_name")+" price= "+rs.getDouble("price"));
					
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
					p.setStock(rs.getString("stock"));
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
					p.setStock(rs.getString("stock"));
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

//	private static final String select_Product_By_Id = "SELECT id, name, unit_price, stock, photo_url,"
//			+ "		description, launch_date, category, discount"
//			+ " FROM products" 
//			+ "    WHERE id=?";

//	private static final String select_Product_By_Id = 
//			"SELECT id,product_id, color_name,"
//			+ "		name, unit_price, products.stock, products.photo_url,"
//			+ "		description, launch_date, category, discount,"
//			+ "        product_colors.photo_url color_photo,"
//			+ "        IFNULL(icon_url,product_colors.photo_url) icon_url,"
//			+ "        product_colors.stock AS color_stock"
//			+ "	FROM products"
//			+ "		LEFT JOIN product_colors ON products.id=product_colors.product_id"
//			+ "        WHERE products.id =?";

	private static final String select_Product_By_Id = "SELECT id, product_id, name, color_name, size_color,"
			+ "     size_count, unit_price,"
			+ "		stock, color_stock, photo_url, description, launch_date, category, discount,"
			+ "		color_photo, icon_url FROM product_detail_view" + "        WHERE id=?";

	Product selectProductById(String productId) throws VGBException {
		Product p = null;
		try (Connection connection = MySQLConnection.getConnection(); // 1,2. �����蝺�
				PreparedStatement pstmt = connection.prepareStatement(select_Product_By_Id);// 3.皞��誘
		) {
			// 3.1 ��?����
			pstmt.setString(1, productId);

			try (ResultSet rs = pstmt.executeQuery(); // 4.�銵�誘
			) {
				// 5.���s
//				while(rs.next()) {
//					if(p==null) {
//						int discount = rs.getInt("discount");
//						if(discount>0) {
//							p = new Outlet();
//							((Outlet)p).setDiscount(discount);
//						}else p = new Product();					
//						
//						p.setId(rs.getInt("id"));
//						p.setName(rs.getString("name"));
//						p.setUnitPrice(rs.getDouble("unit_price"));
//						p.setStock(rs.getInt("stock"));
//						p.setPhotoUrl(rs.getString("photo_url"));
//						p.setDescription(rs.getString("description"));
//						p.setLaunchDate(rs.getString("launch_date"));
//						p.setCategory(rs.getString("category"));		
//						p.setLaunchDate(rs.getString("launch_date"));
//						p.setSizeCount(rs.getInt("size_count"));
//						//Logger.getLogger("憿舐內霈�������").log(Level.INFO, String.valueOf(p)); //for test
//					}					
//					
				// 霈����
				String colorName = rs.getString("color_name");
//					if(colorName!=null) {
//						Color color = new Color();
//						color.setColorName(colorName);
//						color.setStock(rs.getInt("color_stock"));
//						color.setPhotoUrl(rs.getString("color_photo"));
//						color.setIconUrl(rs.getString("icon_url"));
//						
//						p.addColor(color);
//					}
//				}
			}
		} catch (SQLException e) {
			throw new VGBException("�隞���閰Ｙ��仃���", e);
		}
		return p;
	}

	private static final String SELECT_SIZE_LIST = "SELECT product_id, color_name, size_name, "
			+ "	product_color_sizes.stock, " + "    product_color_sizes.unit_price AS list_price,"
			+ "    product_color_sizes.unit_price * (100-discount)/100 AS price," + "    ordinal, discount"
			+ "	FROM product_color_sizes" + "		INNER JOIN products ON product_color_sizes.product_id = products.id"
			+ "    WHERE product_id=? AND color_name=? ORDER BY ordinal";

	List<Size> selectSizeList(String productId, String colorName) throws VGBException {
		List<Size> sizeList = new ArrayList<>();
		try (Connection connection = MySQLConnection.getConnection(); // 1,2. �����蝺�
				PreparedStatement pstmt = connection.prepareStatement(SELECT_SIZE_LIST); // 3.皞��誘
		) {
			// 3.1 ��?����
			pstmt.setString(1, productId);
			pstmt.setString(2, colorName);
			try (ResultSet rs = pstmt.executeQuery(); // 4.�銵�誘
			) {
				// 5.���s
//				while(rs.next()) {
//					Size size = new Size();					
//					size.setColorName(rs.getString("color_name"));
//					size.setSizeName(rs.getString("size_name"));
//					size.setStock(rs.getInt("stock"));
//					size.setListPrice(rs.getDouble("list_price"));
//					size.setUnitPrice(rs.getDouble("price"));
//					size.setOrdinal(rs.getInt("ordinal"));
//					
//					sizeList.add(size);
//				}				
			}
		} catch (SQLException e) {
			throw new VGBException("�閰┬izeList憭望��", e);
		}
		return sizeList;
	}
}
