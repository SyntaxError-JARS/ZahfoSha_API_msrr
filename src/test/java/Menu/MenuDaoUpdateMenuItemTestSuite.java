//package Menu;
//
//import com.revature.zahfosha.menu.MenuDao;
//import com.revature.zahfosha.menu.MenuModel;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//
//public class MenuDaoUpdateMenuItemTestSuite {
//
//    MenuDao sut;
//
//    @BeforeEach
//    public void testPrep() {
//        sut = new MenuDao();
//    }
//
//    @Test
//    public void testMenuDaoUpdateMenuItem_returnUpdatedObject() {
//        MenuModel firstResult = sut.updateMenu(BigDecimal.valueOf(11), "11g", 0, "item2");
//        MenuModel actualReturnedObject = sut.followUPUpdateMenu("item2");
//
//        System.out.println(firstResult);
//        System.out.println(actualReturnedObject);
//    }
//
//}
