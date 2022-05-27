package Orders;

import com.revature.zahfosha.orders.OrdersDao;
import com.revature.zahfosha.orders.OrdersModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdersDaoCreateCustomOrderTestSuite {

    OrdersDao sut;

    @BeforeEach
    public void testPrep(){
        sut = new OrdersDao();
    }

    @Test
    public void testCreateCustomOrderForOrdersDao_returnObject(){

        OrdersModel actualResult = sut.createCustomOrder(3, "item1", "test", 0, "3", "test");

        System.out.println(actualResult);

    }

}
