package Customer;

import com.revature.zahfosha.customer.CustomerDao;
import com.revature.zahfosha.customer.CustomerModel;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CustomerDaoUpdateCustomerTestSuite {

    CustomerDao sut;

    @BeforeEach
    public void testPrep(){
        sut = new CustomerDao();
    }

    @Test
    public void testCustomerDaoUpdateMethod_returnsUpdatedCustomerObject(){
        CustomerModel actualResults = sut.updateCustomer("test1", "test1", "test1", BigDecimal.valueOf(0), "test");

        System.out.println(actualResults);
    }

}
