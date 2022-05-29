package Orders;

import com.revature.zahfosha.orders.OrdersDao;
import com.revature.zahfosha.orders.OrdersModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ViewAllOrdersTestSuite {

    OrdersDao sut;

    @BeforeEach
    public void testPrep(){sut = new OrdersDao();}

    @Test
    public void testOrdersDaoViewAllOrders_returnObjects(){

        OrdersModel[] actualResult = sut.viewAllOrders();

        System.out.println(Arrays.toString(actualResult));

    }

}
