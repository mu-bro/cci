package tasks;

import helpers.Node;
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
        Node n = new Node(1).add(2).add(3).add(4).add(2).add(5);
        Assert.assertEquals("12345",Chapter2.removeDuplicates(n));

        Node n2 = new Node(1).add(1).add(1).add(2).add(2).add(2);
        Assert.assertEquals("12",Chapter2.removeDuplicates(n2));

        Node n3 = new Node(1).add(1).add(1).add(1).add(1).add(1);
        Assert.assertEquals("1",Chapter2.removeDuplicates(n3));
    }

    @Test
    public void findNthElementTest() throws Exception {
        Node n = new Node(1).add(2).add(3).add(4).add(5).add(6).add(7).add(8);
        Assert.assertEquals(8,Chapter2.findNthElement(n, 1));
        Assert.assertEquals(2,Chapter2.findNthElement(n, 7));
        n = new Node(1).add(2);
        Assert.assertEquals(2,Chapter2.findNthElement(n, 1));

        exception.expect(Exception.class);
        Assert.assertEquals(2,Chapter2.findNthElement(n, 3));
    }

    @Test
    public void removeFromMiddleTest() {
        Node n = new Node(1).add(2).add(3).add(4).add(5).add(6).add(7).add(8);
        Node middle = n.next.next.next;
        Chapter2.removeFromMiddle(middle);
        Assert.assertEquals("1235678",n.toString());

        middle = n.next.next.next.next;
        Chapter2.removeFromMiddle(middle);
        Assert.assertEquals("123578",n.toString());
    }

    @Test
    public void findFirstInLoopTest() throws Exception {
        Node loopNode = new Node(8);
        Node n = new Node(1).add(2).add(3).add(4).add(5).add(6).add(7).add(loopNode).add(9).add(10).add(11).add(loopNode);
        Assert.assertEquals(loopNode, Chapter2.findFirstInLoop(n));

        loopNode = new Node(2);
        Node n3 = new Node(1).add(loopNode).add(3).add(4).add(5).add(6).add(7).add(9).add(10).add(11).add(loopNode);
        Assert.assertEquals(loopNode, Chapter2.findFirstInLoop(n3));

        Node n2 = new Node(1).add(2).add(3).add(4).add(5).add(6).add(7).add(8);
        exception.expect(Exception.class);
        Chapter2.findFirstInLoop(n2);
    }

}

