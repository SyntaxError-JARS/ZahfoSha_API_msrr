package Orders;

import com.revature.zahfosha.orders.OrdersDao;
import com.revature.zahfosha.orders.OrdersModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdersDaoCreateCustomOrder {

    OrdersDao sut;

    @BeforeEach
    public void testPrep(){
        sut = new OrdersDao();
    }

    @Test
    public void testCreateCustomOrderForOrdersDao_returnObject(){

        OrdersModel actualResult = sut.createCustomOrder(1, "1", "1", 1, "1", "1");

        System.out.println(actualResult);

    }

}
