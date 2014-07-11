package com.voyanta.data.utils.utils;

import static java.lang.System.currentTimeMillis;

public class ProcessTimer {

    private Long timeoutInMilliseconds = 0L;

    public Long startTime() {
        return startTimeInMilliseconds;
    }

    private Long startTimeInMilliseconds;
    private Long executionTimeInMilliseconds;
    private String executionTime;

    private ProcessTimer() {
        this.startTimeInMilliseconds = currentTimeMillis();
    }

    private ProcessTimer(Long startTimeInMilliseconds) {
        this.startTimeInMilliseconds = startTimeInMilliseconds;
    }

//    public static com.venkyold.org.adv.utils.ProcessTimer start(Long startTimeInMilliseconds) {
//        return new com.venkyold.org.adv.utils.ProcessTimer(startTimeInMilliseconds);
//    }
//
//    public static com.venkyold.org.adv.utils.ProcessTimer start() {
//        return new com.venkyold.org.adv.utils.ProcessTimer();
//    }
//
//    public com.venkyold.org.adv.utils.ProcessTimer withTimeout(Long timeout) {
//        this.timeoutInMilliseconds = timeout;
//        return this;
//    }
//
//    public boolean timedOut() {
//        return executionTimeInMilliseconds() > timeoutInMilliseconds;
//    }
//
//    public boolean notTimedOut() {
//        return !timedOut();
//    }
//
//    public Long executionTimeInMilliseconds(Long endTimeInMilliseconds) {
//        updateTimings(endTimeInMilliseconds);
//        return executionTimeInMilliseconds;
//    }
//
//    public Long executionTimeInMilliseconds() {
//        updateTimings(currentTimeMillis());
//        return executionTimeInMilliseconds;
//    }
//
//    public String executionTime() {
//        updateTimings(currentTimeMillis());
//        return executionTime;
//    }
//
//    public String executionTime(Long endTimeInMilliseconds) {
//        updateTimings(endTimeInMilliseconds);
//        return executionTime;
//    }
//
//    private void updateTimings(Long endTimeMilliseconds) {
//        executionTimeInMilliseconds = endTimeMilliseconds - startTimeInMilliseconds;
//        executionTime = executionTimeInMilliseconds + " ms";
//    }
//
//    public String remainingTime() {
//        executionTime();
//        long remainingTime = timeoutInMilliseconds - executionTimeInMilliseconds;
//        return (remainingTime < 0 ? 0 : remainingTime) + " ms";
//    }
}
