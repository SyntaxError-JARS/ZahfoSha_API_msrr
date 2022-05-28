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
        CreditCardModel firstResult = sut.updateCC("limits", "1200", "1111");
        CreditCardModel actualReturnedObject = sut.followUPUpdateCC("1111");

        System.out.println(firstResult);
        System.out.println(actualReturnedObject);
    }

}
