package tasks;

import org.junit.Assert;
import org.junit.Test;
import tasks.firstTime.Chapter8;
import tasks.secondTime.Chapter8.TripleStep;

import java.util.List;

public class TestChapter8 {

    @Test
    public void getPermsTest() {
        List<String> list = Chapter8.getPerms("1234");
        System.out.println(list);
    }

    @Test
    public void tripleStepTest() {
        Assert.assertEquals(7, TripleStep.count(4));
        Assert.assertEquals(13, TripleStep.count(5));
        Assert.assertEquals(2, TripleStep.count(2));
        Assert.assertEquals(24, TripleStep.count(6));
    }

}
