package tasks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static helpers.Helper.createMatrix;

public class TestChapter2 {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void removeDuplicatesTest() {
        Chapter2.Node n = new Chapter2.Node(1).add(2).add(3).add(4).add(2).add(5);
        Assert.assertEquals("12345",Chapter2.removeDuplicates(n));

        Chapter2.Node n2 = new Chapter2.Node(1).add(1).add(1).add(2).add(2).add(2);
        Assert.assertEquals("12",Chapter2.removeDuplicates(n2));

        Chapter2.Node n3 = new Chapter2.Node(1).add(1).add(1).add(1).add(1).add(1);
        Assert.assertEquals("1",Chapter2.removeDuplicates(n3));
    }

    @Test
    public void findNthElementTest() throws Exception {
        Chapter2.Node n = new Chapter2.Node(1).add(2).add(3).add(4).add(5).add(6).add(7).add(8);
        Assert.assertEquals(8,Chapter2.findNthElement(n, 1));
        Assert.assertEquals(2,Chapter2.findNthElement(n, 7));
        n = new Chapter2.Node(1).add(2);
        Assert.assertEquals(2,Chapter2.findNthElement(n, 1));

        exception.expect(Exception.class);
        Assert.assertEquals(2,Chapter2.findNthElement(n, 3));
    }
}

