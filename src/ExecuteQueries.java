import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExecuteQueries {
	private PreparedStatement statement;

	/**
	 * @param user_name name of user
	 * @return list of order by user
	 */
	public List<Order> getUserDetail(String user_name) {
		try {
			statement = Mysqlcon.getConnection().prepareStatement(Queries.getQueryForUserDetail());
			statement.setString(1, user_name);
			ResultSet result = statement.executeQuery();
			List<Order> orderList = new ArrayList<Order>();
			while (result.next()) {
				orderList.add(new Order(result.getInt(1), result.getInt(2), result.getDate(3), result.getDouble(4)));
			}
			statement.clearParameters();
			return orderList;
		} catch (SQLException e) {
			throw new AssertionError("SQl exception in executing query(getUserDetail)");
		}
	}

	/**
	 * @param imageList of images
	 * @param product_id for adding image
	 * @return list of images of product
	 */
	public List<String> insertImagesOfProduct(List<String> imageList, int product_id) {
		try {
			statement = Mysqlcon.getConnection().prepareStatement(Queries.getQueryForInsertImages());
			for (int i = 0; i < imageList.size(); i++) {
				statement.setInt(1, product_id);
				statement.setString(2, imageList.get(i));
				statement.execute();
				statement.clearParameters();
			}
			List<String> imagesList = new ArrayList<String>();
			statement = Mysqlcon.getConnection().prepareStatement(Queries.getQueryForImagesOfProduct());
			statement.setInt(1, product_id);
			ResultSet result = statement.executeQuery();
			while(result.next())
				imagesList.add(result.getString(1));
			return imagesList;
		} catch (SQLException e) {
			throw new AssertionError("SQl exception in executing query(insertImages)"+ e);
		}
	}

	/**
	 * Delete all those products which were not ordered by any Shopper in last 1 year
	 * @return number of products deleted
	 */
	public int deleteProduct() {
		try {
			statement = Mysqlcon.getConnection().prepareStatement(Queries.getQueryForDeleteProduct());
			int  numberOfProductsDeleted =  statement.executeUpdate();
			statement.clearParameters();
			return numberOfProductsDeleted;
		} catch (SQLException e) {
			throw new AssertionError("SQl exception in executing query(deleteProduct)");
		}
	}

	/**
	 * @return list of parent categories
	 */
	public List<Category> getParentCategories() {
		try {
			statement = Mysqlcon.getConnection().prepareStatement(Queries.getQueryForParentCategories());
			ResultSet result = statement.executeQuery();
			List<Category> categoryList = new ArrayList<Category>();
			while (result.next()) {
				categoryList.add(new Category(result.getString(1), result.getInt(2)));
			}
			statement.clearParameters();
			return categoryList;
		} catch (SQLException e) {
			throw new AssertionError("SQl exception in executing query(getParentCategories)");
		}
	}
}
