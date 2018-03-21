package com.homework.cheplic.homework04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DomainTest {
    Unit u;
    Conversion c;
    @Before
    public void setUp(){
        c = new Conversion();
    }

    @Test
    public void get_dimension() throws Exception {
        u = new TimeUnit("s");
        assertEquals("time", u.getDimension());
    }

    @Test
    public void name_changes_conversion_factor() throws Exception{
        u = new TimeUnit("min");
        assertEquals(60.0, u.getConvFact(), 0.001);
    }

    @Test
    public void from_sets_start_unit_name() throws Exception {
        c = Conversion.from("in");
        assertEquals("in", c.getStartUnit().getName());
    }

    @Test
    public void from_sets_start_unit_dimension() throws Exception {
        c = Conversion.from("in");
        assertEquals("length", c.getStartUnit().getDimension());
    }

    @Test
    public void to_sets_end_unit_name() throws Exception {
        c = Conversion.from("in").to("ft");
        assertEquals("ft", c.getEndUnit().getName());
    }

    @Test
    public void to_has_start_unit_name() throws Exception {
        c = Conversion.from("in").to("ft");
        assertEquals("in", c.getStartUnit().getName());
    }

    @Test
    public void to_sets_end_unit_dimension() throws Exception {
        c = Conversion.from("in").to("ft");
        assertEquals("length", c.getEndUnit().getDimension());
    }

    @Test
    public void convert_actually_converts() throws Exception {
        double d = Conversion.from("ft").to("in").convert(9.6);
        assertEquals(115.2, d, 0.001);
    }
}