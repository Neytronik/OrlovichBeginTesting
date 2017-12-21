package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {

        Point a = new Point(1, 3);
        Point b = new Point(3, 3);
        Point c = new Point(6, 7);

        Assert.assertEquals(a.distance(b), 2.0);
        Assert.assertEquals(b.distance(c), 5.0);
    }

}
