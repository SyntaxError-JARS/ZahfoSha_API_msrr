package Menu;

import com.revature.zahfosha.menu.MenuDao;
import com.revature.zahfosha.menu.MenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MenuDaoCreateMenuTestSuite {

    MenuDao sut;

    @BeforeEach
    public void testPrep(){
        sut = new MenuDao();
    }

    @Test
    public void testCreateNewMenuItemForMenuDao_returnsNewMenuObject(){

        MenuModel firstResult = sut.createMenu("newItem", BigDecimal.valueOf(100), "3g", 1);
        MenuModel actualResult = sut.followUpCreateMenu("newItem");

        System.out.println(firstResult);
        System.out.println(actualResult);
    }

}
