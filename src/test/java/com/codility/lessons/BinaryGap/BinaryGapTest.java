package com.codility.lessons.BinaryGap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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

    static BinaryGap  binaryGap;

    @BeforeClass
    public static void setup() {
        binaryGap = new BinaryGap();
    }

    long start,end,diff;
    @Before
    public void start() {
        start = System.currentTimeMillis();
    }

    @After
    public void end() {
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("diff-->"+diff);
    }
    @Test
    public void solutionTest() {

        int n = 1041;//10000010001
        int res = binaryGap.solution(n);
        LOG.info("res-->"+res);


        assertNotNull(res);
        assertEquals(res,5);

        //LOG.info("diff-->"+diff);


    }
}
