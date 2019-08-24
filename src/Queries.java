public class Queries {

	public static String getQueryForUserDetail() {
		return "SELECT o.shopper_id, o.order_id, o.order_date, o.amount FROM orders o, shopper "
				+ "WHERE shopper.shopper_id = o.shopper_id AND shopper.shopper_name = ? "
				+ "ORDER BY o.order_date DESC";
	}

	public static String getQueryForInsertImages(){
		return "INSERT INTO images(product_id, image) VALUES(?,?) ";
	}
	
	public static String getQueryForImagesOfProduct(){
		return "SELECT image FROM images WHERE product_id = ? ";
	}
	
	public static String getQueryForDeleteProduct() {
		return "DELETE FROM product WHERE product_id NOT IN "
				+ "(SELECT DISTINCT product_id FROM items_ordered i INNER JOIN orders o ON o.order_id=i.order_id "
				+ " WHERE DATEDIFF(CURDATE(), o.order_date) < 365)";
	}

	public static String getQueryForParentCategories() {
		return "SELECT DISTINCT c.name , "
				+ "(SELECT COUNT(category_id) FROM category cc WHERE cc.parent_category=c.category_id GROUP BY cc.parent_category)"
				+ " AS children_categories FROM category c WHERE c.parent_category IS NULL ORDER BY c.name;";
	}
}
