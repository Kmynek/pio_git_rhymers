package edu.kis.vh.nursery;

public class HanoiRhymer extends defaultCountingOutRhymer {
    /**
     * counting out class
     */
    int totalRejected = 0;
    /**
     * return total rejected int
     */
    public int reportRejected() {
        return totalRejected;
    }
    /**
     * counting total rejected
     * @param in input number to count in
     */
    @Override
    public void countIn(final int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
