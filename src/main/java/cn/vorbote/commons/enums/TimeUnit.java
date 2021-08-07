package cn.vorbote.commons.enums;

/**
 * Unit of time.
 *
 * @author vorbote thills@vorbote.cn
 */
public enum TimeUnit {

    // Millisecond
    MILLIS(1),
    // Second
    SECOND(1000, 1),
    // Minute
    MINUTE(60 * SECOND.Millis(), 60 * SECOND.Second()),
    // Hour
    HOUR(60 * MINUTE.Millis(), 60 * MINUTE.Second()),
    // Day
    DAY(24 * HOUR.Millis(), 24 * HOUR.Second());

    private int millis;
    private int second;

    /**
     * Create a value with millisecond.
     *
     * @param mills The millis equal to this unit.
     */
    TimeUnit(int mills) {
        this.millis = mills;
        this.second = 0;
    }

    /**
     * Create a value with millisecond and second.
     *
     * @param mills The millis equal to this unit.
     * @param second The second equal to this unit.
     */
    TimeUnit(int mills, int second) {
        this.millis = mills;
        this.second = second;
    }

    /**
     * Get the millis equal to this unit.
     *
     * @return The millis equal to this unit.
     */
    public int Millis() {
        return this.millis;
    }

    /**
     * Get the second equal to this unit.
     *
     * @return The second equal to this unit.
     */
    public int Second() {
        return this.second;
    }

}
