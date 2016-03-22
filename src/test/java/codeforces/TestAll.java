package codeforces;

import codeforces.problem1.BSpreadSheet;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Test all
 * Created by Sam on 2016/3/22.
 */
public class TestAll {

    @Test
    public void test1To26() {
        Assert.assertEquals("A1", BSpreadSheet.convertFromRC(1, 1));
//        System.out.println(BSpreadSheet.convertFromRC(1, 1));
    }

    @Test
    public void test26To26() {
        Assert.assertEquals("Z1", BSpreadSheet.convertFromRC(1, 26));
    }

    @Test
    public void test27To26() {
        Assert.assertEquals("AA1", BSpreadSheet.convertFromRC(1, 27));
    }

    @Test
    public void test55To26() {
        Assert.assertEquals("BC1", BSpreadSheet.convertFromRC(1, 55));
    }
}
