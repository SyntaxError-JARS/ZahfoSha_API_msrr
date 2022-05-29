package Menu;

import com.revature.zahfosha.menu.MenuDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuDaoDeleteByMenuItemTestSuite {

    MenuDao sut;

    @BeforeEach
    public void testPrep(){
        sut = new MenuDao();
    }

    @Test
    public void testMenuDaoDeleteItemByMenuItemName_returnsTrue(){
        boolean actualResult = sut.deleteByMenuItem("newItem");

        System.out.println(actualResult);
    }

}
