/**
 * {@link IPhone16}'s purpose is "talking", but with more style.
 *
 * @author David Martinez,
 * Daniel Do
 * @version 1.0
 */
public class IPhone16 extends IPhone
{
    private static final int MODEL_512_GB = 512;
    private static final int MODEL_256_GB = 256;

    private final boolean highResCamera;
    private final int memoryGigabytes;

    /**
     * Constructor for IPhone16
     *
     * @param remainingPlanMinutes the remaining minutes in phone's plan
     * @param planCarrier the phone company name
     * @param highResCamera whether this instance has a high-res camera or not
     * @param memoryGigabytes the amount of memory for the phone, which is
     *                        either {@value MODEL_256_GB}GB or {@value MODEL_512_GB}GB
     */
    IPhone16(final Double remainingPlanMinutes,
             final String planCarrier,
             final boolean highResCamera,
             final int memoryGigabytes)
    {
        super(remainingPlanMinutes, planCarrier);

        // No checker for highResCamera needed.
        checkMemoryGB(memoryGigabytes);

        this.highResCamera = highResCamera;
        this.memoryGigabytes = memoryGigabytes;
    }

    private void checkMemoryGB(int memoryGigabytes)
    {
        if (memoryGigabytes != MODEL_512_GB && memoryGigabytes != MODEL_256_GB)
        {
            throw new IllegalArgumentException("Invalid model of phone");
        }
    }

    /**
     * Gets whether this IPhone16 has a high resolution camera or not.
     *
     * @return a boolean indicating true if phone does have high-res camera, and
     * false if it doesn't.
     */
    public boolean isHighResCamera()
    {
        return highResCamera;
    }

    /**
     * Gets the amount of memory this IPhone16 has.
     *
     * @return an int amount of memory for this IPhone16; units: GB
     */
    public int getMemoryGigabytes()
    {
        return memoryGigabytes;
    }

    /**
     * Returns a String representation of this IPhone16 object, including
     * whether it has a high resolution camera and its memory amount.
     * The format is: IPhone16{hasHighResolutionCamera=true,
     * Memory in Gigabytes=256GB} plus the superclass details.
     *
     * @return a String describing this IPhone16 instance
     */
    @Override
    public String toString()
    {
        final StringBuilder iphone16String;
        iphone16String = new StringBuilder();

        iphone16String.append(super.toString());
        iphone16String.append("IPhone 16{");
        iphone16String.append("hasHighResolutionCamera=");
        iphone16String.append(highResCamera);
        iphone16String.append(", Memory in Gigabytes=");
        iphone16String.append(memoryGigabytes);
        iphone16String.append("GB");
        iphone16String.append("} ");

        return iphone16String.toString();
    }

    /**
     * Determines equality based on 2 factors:
     * 1. remaining plan minutes
     * 2. has high resolution camera
     * Both fields must be the same to be considered equal objects.
     *
     * @param o the object to compare with this {@link #IPhone}
     * @return true if IPhone16s are equal or not.
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (!(o.getClass().equals(this.getClass())))
        {
            return false;
        }
        final IPhone16 that = (IPhone16) o;
        final boolean checkMinutes;
        final boolean checkCamera;

        checkMinutes = this.getRemainingPlanMinutes() == that.getRemainingPlanMinutes();
        checkCamera  = this.isHighResCamera()         == that.isHighResCamera();

        return checkMinutes && checkCamera;
    }

    /**
     * Hashes the remaining minutes to an int for this IPhone16.
     *
     * @return a hashCode int
     */
    @Override
    public int hashCode()
    {
        final int hashFromRPM;
        final double remainingPlanMinutes;
        remainingPlanMinutes = getRemainingPlanMinutes();

        hashFromRPM = Double.hashCode(remainingPlanMinutes);

        return hashFromRPM;
    }
}
