package firstTime.tasks;

import firstTime.helpers.Stack3Array;
import firstTime.helpers.StackArray;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import secondTime.helpers.Stack;

public class TestChapter3 {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void stackArrayTest() {
        StackArray<Integer> stack = new StackArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Assert.assertEquals(4, (int) stack.pull());
        Assert.assertEquals(3, (int) stack.pull());
        Assert.assertEquals(2, (int) stack.peek());
        Assert.assertEquals(2, (int) stack.pull());
        Assert.assertEquals(1, (int) stack.pull());
        Assert.assertEquals(null, stack.pull());
    }


    @Test
    public void Stack3ArrayTest() {
        Stack3Array<Integer> stack = new Stack3Array();
        stack.push(1, 0);
        stack.push(1, 1);
        stack.push(1, 2);
        stack.push(2, 0);
        stack.push(2, 1);
        stack.push(3, 0);
        stack.push(4, 0);
        stack.push(4, 1);

        Assert.assertEquals(4, (int) stack.pull(0));
        Assert.assertEquals(4, (int) stack.pull(1));
        Assert.assertEquals(3, (int) stack.pull(0));
        Assert.assertEquals(2, (int) stack.pull(1));
        Assert.assertEquals(1, (int) stack.pull(1));
        Assert.assertEquals(null, stack.pull(1));
        Assert.assertEquals(2, (int) stack.peek(0));
        Assert.assertEquals(2, (int) stack.pull(0));
        Assert.assertEquals(1, (int) stack.pull(0));
        Assert.assertEquals(1, (int) stack.pull(2));
        Assert.assertEquals(null, stack.pull(0));

        stack.push(10, 2);
        Assert.assertEquals(10, (int) stack.pull(2));
    }

    @Test
    public void stackWithMin2Test() {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(6);
        stack.push(4);
        stack.push(5);
        stack.pop();
        Assert.assertEquals(6, stack.peek());
        stack.pop();
        Assert.assertEquals(4, stack.peek());

    }





}

