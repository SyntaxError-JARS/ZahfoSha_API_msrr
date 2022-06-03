//package Menu;
//
//import com.revature.zahfosha.menu.MenuDao;
//import com.revature.zahfosha.menu.MenuServices;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//
//public class MenuServicesValidateInputTestSuite {
//
//    MenuServices sut;
//    MenuDao tut;
//
//    @BeforeEach
//    public void testPrep(){
//        sut = new MenuServices(tut);
//    }
//
//    @Test
//    public void testMenuServicesValidateInput_returnTrue(){
//        boolean actualResults = sut.validateInput("test", BigDecimal.valueOf(100), "5g", 1);
//        System.out.println(actualResults);
//    }
//}
