package Customer;

import com.revature.zahfosha.customer.CustomerDao;
import com.revature.zahfosha.customer.CustomerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CustomerDaoCreateTestSuite {

    CustomerDao sut;

    @BeforeEach
    private void testPrep(){
        sut = new CustomerDao();
    }

    @Test
    public void testCustomerDaoCreateCustomerMethod_returnsCreatedCustomerObject(){

        CustomerModel actualResults = sut.createCustomer("thethe", "thethe", "thethe", "thethe", BigDecimal.valueOf(100), 1);

        System.out.println(actualResults);
    }

}
