package com.voyanta.data.utils.utils;

//import com.venkyold.org.adv.utils.ProcessTimer;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: dev
 * Date: 05/04/13
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
public class Poller {
//    private static final Logger LOGGER = Logger.getLogger(com.venkyold.org.adv.utils.Poller.class);
//
//    private long timeoutInMilliseconds = 10000;
//    private com.venkyold.org.adv.utils.ProcessTimer processTimer = ProcessTimer.start();
//    private int pollingEveryMs = 500;
//
//    private Poller() {
//    }
//
//    public static com.venkyold.org.adv.utils.Poller start() {
//        return new com.venkyold.org.adv.utils.Poller();
//    }
//
//    public com.venkyold.org.adv.utils.Poller withTimeout(int timeoutInMilliseconds) {
//        this.timeoutInMilliseconds = timeoutInMilliseconds;
//        return this;
//    }
//
//
//    public com.venkyold.org.adv.utils.Poller pollingEvery(int pollingEveryMs) {
//        this.pollingEveryMs = pollingEveryMs;
//        return this;
//    }
//
//    public boolean pollUntilConditionIsSatisfied(Condition condition) {
//        int i = 0;
//        while (System.currentTimeMillis() < processTimer.startTime() + timeoutInMilliseconds) {
//            i++;
//            if (condition.isSatisfied()) {
//                LOGGER.info("Condition passed - condition [" + condition.describe() + "] is satisfied after " + processTimer.executionTime());//, true);
//                return true;
//            } else {
//                LOGGER.info("Waiting on condition [" + condition.describe() + "] for " + pollingEveryMs + " ms. Attempt [" + i + "]");//, true);
//                CommonUtil.waitFor(pollingEveryMs);
//            }
//        }
//
//        LOGGER.error("Condition failed after waiting for " + timeoutInMilliseconds + " ms");//, true);
//        LOGGER.error("Condition failed is [" + condition.describe() + "]");//, true);
//        return false;
//
//    }
}
