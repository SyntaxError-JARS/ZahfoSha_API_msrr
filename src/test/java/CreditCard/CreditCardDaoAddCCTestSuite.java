package CreditCard;

import com.revature.zahfosha.creditcard.CreditCardDao;
import com.revature.zahfosha.creditcard.CreditCardModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CreditCardDaoAddCCTestSuite {

    CreditCardDao sut;

    @BeforeEach
    public void testPrep(){
        sut = new CreditCardDao();
    }

    @Test
    public void CreditCardDaoAddCreditCard_returnObject(){

        CreditCardModel firstResult = sut.addCC("4444", "me", 333, "20/20/2021", 55555, BigDecimal.valueOf(9000), "test");

        CreditCardModel actualResult = sut.followUpAddCC("4444");

        System.out.println(firstResult);
        System.out.println(actualResult);

    }

}
