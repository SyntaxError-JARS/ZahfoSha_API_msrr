package Orders;

import com.revature.zahfosha.orders.OrdersDao;
import com.revature.zahfosha.orders.OrdersModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdersDaoViewAllByDateTestSuite {

    OrdersDao sut;

    @BeforeEach
    public void testPrep(){sut = new OrdersDao();}

    @Test
    public void testOrderDaoViewAllByDateTestSuite_returnObjects(){

        OrdersModel actualResult = sut.viewAllByDate("3");

        System.out.println(actualResult);
    }

}
