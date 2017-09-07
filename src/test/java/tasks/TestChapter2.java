package tasks;

import org.junit.Assert;
import org.junit.Test;

import static helpers.Helper.createMatrix;

public class TestChapter2 {

    @Test
    public void removeDuplicatesTest() {
        Chapter2.Node n = new Chapter2.Node(1).add(2).add(3).add(4).add(2).add(5);
        System.out.println(n.print());
        Chapter2.removeDuplicates(n);
        System.out.println(n.print());
        Assert.assertEquals("12345",n.print());


    }

}

