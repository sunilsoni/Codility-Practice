package com.codility.lessons.CountingElements;

import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class PermutationCheckTest {
    private static Logger LOG = LoggerFactory.getLogger(PermutationCheckTest.class);

    static PermutationCheck permutationCheck;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @BeforeClass
    public static void setup() {
        permutationCheck = new PermutationCheck();
    }

    static long start, end;
static double diff;
    @Before
    public void start() {
        start = System.currentTimeMillis();
        LOG.info("start-->" + start);
    }

    @After
    public void end() {
        end = System.currentTimeMillis();
        LOG.info("end-->" + end);

        diff = end - start;
        LOG.info("millis-->" + (diff ) );//millis
        LOG.info("seconds-->" + (diff / 1000) );//seconds
    }

    @Test
    public void permutationCheckTest() {

        int[] A = new int[5];
        for (int i = 0; i < 5 ; i++) {
            A[i]=i+100;
            LOG.info("A-->" + A[i] );
        }

      int res =   permutationCheck.solution(A);
        assertEquals(res, 0);

        A = new int[100];
        for (int i = 99; i >=0 ; i--) {
            A[i]=i;
            //LOG.info("A-->" + A[i] );
        }
        res =   permutationCheck.solution(A);   
        assertEquals(res, 0);
        
        A = new int[100];
        for (int i = 99; i >=0 ; i--) {
            A[i]=i;
            //LOG.info("A-->" + A[i] );
        }

        res =   permutationCheck.solution(A);
        assertEquals(res, 0);
        
        
        A = new int[100];
        for (int i = 0; i <100 ; i++) {
            A[i]=i;
            //LOG.info("A-->" + A[i] );
        }

        res =   permutationCheck.solution(A);
        assertEquals(res, 0);

        A = new int[5];
        for (int i = 0; i <5 ; i++) {
            A[i]=i+1;
            //LOG.info("A-->" + A[i] );
        }

        res =   permutationCheck.solution(A);
        assertEquals(res, 1);
    }
}
