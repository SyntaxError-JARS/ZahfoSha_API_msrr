package Orders;

import com.revature.zahfosha.orders.OrdersDao;
import com.revature.zahfosha.orders.OrdersModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OrdersDaoViewAllByDateTestSuite {

    OrdersDao sut;

    @BeforeEach
    public void testPrep(){sut = new OrdersDao();}

    @Test
    public void testOrderDaoViewAllByDateTestSuite_returnObjects(){

        OrdersModel[] actualResult = sut.viewAllByDate("10/01/1011");

        System.out.println(Arrays.toString(actualResult));
    }

}
