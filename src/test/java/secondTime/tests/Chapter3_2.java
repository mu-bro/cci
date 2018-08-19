package secondTime.tests;

import org.junit.Assert;
import org.junit.Test;
import secondTime.helpers.Stack3Array;

public class Chapter3_2 {

    @Test
    public void Stack3ArrayTest() {
        Stack3Array stack = new Stack3Array();
        stack.push(1, 1);
        stack.push(1, 2);
        stack.push(1, 3);
        stack.push(2, 1);
        stack.push(2, 2);
        stack.push(3, 1);
        stack.push(4, 1);
        stack.push(4, 2);

        Assert.assertEquals(4, (int) stack.pop(1));
        Assert.assertEquals(4, (int) stack.pop(2));
        Assert.assertEquals(3, (int) stack.pop(1));
        Assert.assertEquals(2, (int) stack.pop(2));
        Assert.assertEquals(1, (int) stack.pop(2));
        Assert.assertEquals(null, stack.pop(2));
        Assert.assertEquals(2, (int) stack.peek(1));
        Assert.assertEquals(2, (int) stack.pop(1));
        Assert.assertEquals(1, (int) stack.pop(1));
        Assert.assertEquals(1, (int) stack.pop(3));
        Assert.assertEquals(null, stack.pop(1));

        stack.push(10, 3);
        Assert.assertEquals(10, (int) stack.pop(3));
    }
}
