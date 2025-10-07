/**
 * Represents an IPhone 16 device with instance variables for whether it has a {@link #highResCamera}
 * and its {@link #memoryGigabytes} ({@value MODEL_256_GB}GB or {@value MODEL_512_GB}GB).
 * This class extends IPhone and provides methods to access and modify IPhone16-specific details.
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
     * Prints the {@link #IPhone16}'s instance variables to the screen
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a String representation of this IPhone16 object, including
     * whether it has a high resolution camera and its memory amount.
     *
     * @return a String describing this IPhone16 instance
     */
    @Override
    public String toString()
    {
        final StringBuilder iphone16String;
        iphone16String = new StringBuilder();

        iphone16String.append(super.toString());
        iphone16String.append("\nHas High Resolution Camera: ");
        iphone16String.append(highResCamera);
        iphone16String.append("\nMemory: ");
        iphone16String.append(memoryGigabytes);
        iphone16String.append("GB");

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
