import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void test001() {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(2);

        boolean isEqualto3 = list.size() == 2;
        Assert.assertTrue(isEqualto3);

    }
}