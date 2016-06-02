package io;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tushar.mandar on 6/2/16.
 */
public class RetryUtilTest {

    public  static int maxFailures=2;

    @Before
    public void setup() {
    }

    @Test
    public void testWithoutFailure() throws Exception {
        Assert.assertTrue(RetryUtil.<Boolean>retry(3, () -> true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompleteFailure() throws Exception {
      RetryUtil.retry(3, () -> {
          throw new IllegalArgumentException("FAILED");
      });

    }

    @Test
    public void testPartialCompleteFailure() throws Exception {
        Assert.assertTrue(RetryUtil.retry(3, () -> {
            if(maxFailures > 0){
                maxFailures--;
                throw new Exception("FAILED");
            }
            return true;
        }));

    }


}
