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

        OrdersModel actualResult = sut.createCustomOrder(4, "item1", "test", 0, "10/01/1011", "test");
        OrdersModel extraResult = sut.followUpCreateCustomOrder(4, "item1", "test", 0, "10/01/1011", "test");

        System.out.println(actualResult);
        System.out.println(extraResult);

    }

}
