import static org.junit.Assert.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ExecuteQueriesTest {

	@Test
	public void getUserDetailTest() {
		ExecuteQueries query= new ExecuteQueries();
		List<Order> orderList = query.getUserDetail("rahul sharma");
		List<Order> expectedList = new ArrayList<Order>();
		expectedList.add(new Order(4, 6, Date.valueOf("2019-07-30"), 50000.0));
		expectedList.add(new Order(4, 2, Date.valueOf("2019-07-28"), 12499.99));
		for(int i=0;i<expectedList.size();i++){
			assertEquals(expectedList.get(i).getShopper_id(), orderList.get(i).getShopper_id());
			assertEquals(expectedList.get(i).getAmount(), orderList.get(i).getAmount(),0.00001);
			assertEquals(expectedList.get(i).getOrder_date(), orderList.get(i).getOrder_date());
			assertEquals(expectedList.get(i).getOrder_id(), orderList.get(i).getOrder_id());
		}
	}
	
	@Test
	public void insertImagesOfProductTest() {
		ExecuteQueries query= new ExecuteQueries();
		List<String> imageList = new ArrayList<String>();
		imageList.add("img1");
		imageList.add("img2");
		imageList.add("img3");
		imageList.add("img4");
		List<String> imagesList = query.insertImagesOfProduct(imageList, 2);
		assertEquals(4, imagesList.size());
	}
	
	@Test
	public void deleteProductTest() {
		ExecuteQueries query= new ExecuteQueries();
		assertEquals(7, query.deleteProduct());
	}
	
	@Test
	public void getParentCategoriesTest() {
		ExecuteQueries query= new ExecuteQueries();
		List<Category> categoryList = query.getParentCategories();
		assertEquals("Accessories", categoryList.get(0).getName());
		assertEquals(3, categoryList.size());
	}
}
