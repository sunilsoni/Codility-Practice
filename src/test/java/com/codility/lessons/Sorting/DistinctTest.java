package com.codility.lessons.Sorting;

import static org.junit.Assert.assertEquals;

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

import com.codility.lessons.CountingElements.PermutationCheck;
import com.codility.lessons.CountingElements.PermutationCheckTest;

/**
 * https://app.codility.com/demo/results/trainingKSZ5AP-TS8/
 * 
 * @author Sunil
 *
 */
@RunWith(SpringRunner.class)
public class DistinctTest {

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
		LOG.info("millis-->" + (diff));// millis
		LOG.info("seconds-->" + (diff / 1000));// seconds
	}

	@Test
	public void solution1Test() {
		int[] A = new int[5];
		for (int i = 0; i < 5; i++) {
			A[i] = i + 100;
			LOG.info("A-->" + A[i]);
		}

		int res = permutationCheck.solution(A);
		assertEquals(res, 0);
	}

	@Test
	public void solution2Test() {

	}

}
