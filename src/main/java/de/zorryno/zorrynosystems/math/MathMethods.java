package de.zorryno.zorrynosystems.math;

public class MathMethods {
    /**
     * Re-maps a number from one range to another.
     * That is, a value of from_low would get mapped to to_low.
     * A value of from_high to to_high, values in-between to values in-between, etc.
     *
     * @param x the number to map
     * @param from_low the lower bound of the value’s current range
     * @param from_high the upper bound of the value’s current range
     * @param to_low the lower bound of the value’s target range
     * @param to_high the upper bound of the value’s target range
     * @return the mapped value
     */
    public static int map(int x, int from_low, int from_high, int to_low, int to_high) {
        return (x - from_low) * (to_high - to_low) / (from_high - from_low) + to_low;
    }

    /**
     * Re-maps a number from one range to another.
     * That is, a value of from_low would get mapped to to_low.
     * A value of from_high to to_high, values in-between to values in-between, etc.
     *
     * @param x the number to map
     * @param from_low the lower bound of the value’s current range
     * @param from_high the upper bound of the value’s current range
     * @param to_low the lower bound of the value’s target range
     * @param to_high the upper bound of the value’s target range
     * @return the mapped value
     */
    public static long map(long x, long from_low, long from_high, long to_low, long to_high) {
        return (x - from_low) * (to_high - to_low) / (from_high - from_low) + to_low;
    }

    /**
     * Re-maps a number from one range to another.
     * That is, a value of from_low would get mapped to to_low.
     * A value of from_high to to_high, values in-between to values in-between, etc.
     *
     * @param x the number to map
     * @param from_low the lower bound of the value’s current range
     * @param from_high the upper bound of the value’s current range
     * @param to_low the lower bound of the value’s target range
     * @param to_high the upper bound of the value’s target range
     * @return the mapped value
     */
    public static float map(float x, float from_low, float from_high, float to_low, float to_high) {
        return (x - from_low) * (to_high - to_low) / (from_high - from_low) + to_low;
    }

    /**
     * Re-maps a number from one range to another.
     * That is, a value of from_low would get mapped to to_low.
     * A value of from_high to to_high, values in-between to values in-between, etc.
     *
     * @param x the number to map
     * @param from_low the lower bound of the value’s current range
     * @param from_high the upper bound of the value’s current range
     * @param to_low the lower bound of the value’s target range
     * @param to_high the upper bound of the value’s target range
     * @return the mapped value
     */
    public static double map(double x, double from_low, double from_high, double to_low, double to_high) {
        return (x - from_low) * (to_high - to_low) / (from_high - from_low) + to_low;
    }

    /**
     * Constrains a number to be within a range
     *
     * @param x the number to constrain
     * @param min the lower end of the range
     * @param max the upper end of the range
     * @return the constrained value
     */
    public static int constrain(int x, int min, int max) {
        return Math.max(min, Math.min(max, x));
    }

    /**
     * Constrains a number to be within a range
     *
     * @param x the number to constrain
     * @param min the lower end of the range
     * @param max the upper end of the range
     * @return the constrained value
     */
    public static long constrain(long x, long min, long max) {
        return Math.max(min, Math.min(max, x));
    }

    /**
     * Constrains a number to be within a range
     *
     * @param x the number to constrain
     * @param min the lower end of the range
     * @param max the upper end of the range
     * @return the constrained value
     */
    public static float constrain(float x, float min, float max) {
        return Math.max(min, Math.min(max, x));
    }

    /**
     * Constrains a number to be within a range
     *
     * @param x the number to constrain
     * @param min the lower end of the range
     * @param max the upper end of the range
     * @return the constrained value
     */
    public static double constrain(double x, double min, double max) {
        return Math.max(min, Math.min(max, x));
    }

}