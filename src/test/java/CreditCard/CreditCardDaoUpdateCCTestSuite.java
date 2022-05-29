package CreditCard;

import com.revature.zahfosha.creditcard.CreditCardDao;
import com.revature.zahfosha.creditcard.CreditCardModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditCardDaoUpdateCCTestSuite {

    CreditCardDao sut;

    @BeforeEach
    public void testPrep(){
        sut = new CreditCardDao();
    }

    @Test
    public void testCreditCardDaoUpdateCC_returnUpdatedObject(){
        CreditCardModel firstResult = sut.updateCC("credit card name", "Jacky", "8788");
        CreditCardModel actualReturnedObject = sut.followUPUpdateCC("8788");

        System.out.println(firstResult);
        System.out.println(actualReturnedObject);
    }

}
