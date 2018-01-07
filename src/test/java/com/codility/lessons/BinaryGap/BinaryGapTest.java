package com.codility.lessons.BinaryGap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * https://app.codility.com/demo/results/trainingABYQAR-B7W/
 */
@RunWith(SpringRunner.class)
public class BinaryGapTest {
    private static Logger LOG = LoggerFactory.getLogger(BinaryGapTest.class);

    static BinaryGap binaryGap;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @BeforeClass
    public static void setup() {
        binaryGap = new BinaryGap();
    }

    long start, end, diff;

    @Before
    public void start() {
        start = System.currentTimeMillis();
    }

    @After
    public void end() {
        end = System.currentTimeMillis();
        diff = end - start;
        LOG.info("diff-->" + diff);
    }

    @Test
    public void solutionTest() {

        int n = 1041;// 10000010001
        int res = binaryGap.solution(n);
        LOG.info("res-->" + res);

        assertNotNull(res);
        assertEquals(res, 5);

        // LOG.info("diff-->"+diff);

        // example2 example test n=15=1111_2
        res = binaryGap.solution(15);
        LOG.info("15--->" + res);
        assertEquals(res, 0);

        // extremes n=1, n=5=101_2 and n=2147483647=2**31-1
        res = binaryGap.solution(1);
        LOG.info("1--->" + res);
        assertEquals(res, 0);

        res = binaryGap.solution(5);
        LOG.info("5--->" + res);
        assertEquals(res, 1);

        res = binaryGap.solution(2147483647);
        LOG.info("2147483647--->" + res);
        assertEquals(res, 0);

        // trailing_zeroes n=6=110_2 and n=328=101001000_2
        res = binaryGap.solution(6);
        LOG.info("6(110_2)--->" + res);
        assertEquals(res, 0);

        res = binaryGap.solution(328);
        LOG.info("328(101001000_2)--->" + res);
        assertEquals(res, 2);

        res = binaryGap.solution(101001000_2);
        LOG.info("res--->" + res);
        assertEquals(res, 4);

        // power_of_2 n=5=101_2, n=16=2**4 and n=1024=2**10
        res = binaryGap.solution(5);
        LOG.info("5=101_2--->" + res);
        assertEquals(res, 1);

        res = binaryGap.solution(16);
        LOG.info("16=2**4--->" + res);
        assertEquals(res, 0);

        res = binaryGap.solution(1024);
        LOG.info("1024=2**10--->" + res);
        assertEquals(res, 0);

        // simple1 n=9=1001_2 and n=11=1011_2
        res = binaryGap.solution(9);
        LOG.info("9=1001_2--->" + res);
        assertEquals(res, 2);

        res = binaryGap.solution(11);
        LOG.info("11=1011_2--->" + res);
        assertEquals(res, 1);

        // simple2 n=19=10011 and n=42=101010_2
        res = binaryGap.solution(19);
        LOG.info("19=10011--->" + res);
        assertEquals(res, 2);

        res = binaryGap.solution(42);
        LOG.info("42=101010_2--->" + res);
        assertEquals(res, 1);

        // simple3 n=1162=10010001010_2 and n=5=101_2
        res = binaryGap.solution(1162);
        LOG.info("1162=10010001010_2--->" + res);
        assertEquals(res, 3);

        res = binaryGap.solution(5);
        LOG.info("5=101_2--->" + res);
        assertEquals(res, 1);

        // medium1 n=51712=110010100000000_2 and n=20=10100_2
        res = binaryGap.solution(51712);
        LOG.info("51712=110010100000000_2--->" + res);
        assertEquals(res, 2);

        res = binaryGap.solution(20);
        LOG.info("20=10100_2--->" + res);
        assertEquals(res, 1);
    }


    @Test(timeout = 500)
    public void timeTest() {
        // extremes n=1, n=5=101_2 and n=2147483647=2**31-1
        int res = binaryGap.solution(2147483647);
        LOG.info("1--->" + res);

    }
}
