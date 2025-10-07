/**
 * A class that represents an IPod device with instance variables for the {@link #numSongsStored}
 * and its {@link #currentVolumeDB} (must be between {@link #MIN_VOLUME_DB} and {@link #MIN_VOLUME_DB}).
 * This class extends IDevice and provides methods to access and modify IPod-specific details.
 *
 * @author David Martinez,
 *         Daniel Do
 * @version 1.0
 */
public final class IPod extends IDevice
{
    public static final String IPOD_PURPOSE          = "Listening to Music";
    private static final double MAX_VOLUME_DB        = 100.0;
    private static final double MIN_VOLUME_DB        = 0.0;
    private static final int    MIN_NUM_SONGS_STORED = 0;

    private final int numSongsStored;

    private double currentVolumeDB;

    /**
     * Constructor for the {@code IPod} Class.
     *
     * @param currentVolumeDB the current volume in decibels (dB). must be between
     *                        {@value MAX_VOLUME_DB} and {@value MAX_VOLUME_DB}
     * @param numSongsStored  the number of songs stored on the iPod.
     *                        must be at least {@value MIN_NUM_SONGS_STORED}
     * @throws IllegalArgumentException if currentVolumeDB is out of range or
     *                                  if numSongsStored is below minimum
     */
    public IPod(final double currentVolumeDB,
                final int numSongsStored)
    {
        super(IPOD_PURPOSE);

        checkCurrentVolumeDB(currentVolumeDB);
        checkNumSongsStored(numSongsStored);

        this.currentVolumeDB = currentVolumeDB;
        this.numSongsStored = numSongsStored;
    }

    /*
     * Validator that checks if the number of songs stored is not less than
     * {@value MIN_NUM_SONGS_STORED}. Throws IllegalArgumentException if invalid.
     */
    private void checkNumSongsStored(final int numSongsStored)
    {
        if (numSongsStored < MIN_NUM_SONGS_STORED)
        {
            final StringBuilder errMsg;
            errMsg = new StringBuilder();

            errMsg.append("Number of songs stored cannot be below minimum of ");
            errMsg.append(MIN_NUM_SONGS_STORED);

            throw new IllegalArgumentException(errMsg.toString());
        }
    }

    /*
     * Validator that checks if the current volume in dB is between
     * {@value MIN_VOLUME_DB} and {@value MAX_VOLUME_DB}.
     * Throws IllegalArgumentException if invalid.
     */
    private void checkCurrentVolumeDB(final double currentVolumeDB)
    {
        if (currentVolumeDB < MIN_VOLUME_DB || currentVolumeDB > MAX_VOLUME_DB)
        {
            final StringBuilder errMsg;
            errMsg = new StringBuilder();

            errMsg.append("Current volume DB out of range.");
            errMsg.append(" Must be between ");
            errMsg.append(MIN_VOLUME_DB);
            errMsg.append(" and ");
            errMsg.append(MAX_VOLUME_DB);

            throw new IllegalArgumentException(errMsg.toString());
        }
    }

    /**
     * Getter for the current volume in decibels (dB) of this IPod.
     *
     * @return the current volume for the IPod instance
     */
    public double getCurrentVolumeDB()
    {
        return currentVolumeDB;
    }

    /**
     * Getter for the number of songs stored in the IPod.
     *
     * @return the number of songs for the IPod instance
     */
    public int getNumSongsStored()
    {
        return numSongsStored;
    }

    /**
     * Method that prints all the details of the IPod.
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a String representation of this IPod object, including its
     * current volume and the number of songs it's storing.
     *
     * @return a String describing this IPod instance
     */
    @Override
    public String toString()
    {
        final StringBuilder ipodString;
        ipodString = new StringBuilder();

        ipodString.append(super.toString());
        ipodString.append("\nCurrent Volume (dB): ");
        ipodString.append(currentVolumeDB);
        ipodString.append("\nNumber of Songs Stored: ");
        ipodString.append(numSongsStored);

        return ipodString.toString();
    }

    /**
     * Equals implementation for the IPod class that considers two IPod
     * objects equal if they have the same number of songs stored.
     *
     * @param o the object to compare with this IPod
     * @return true if the IPods are equal
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

        final IPod that;
        that = (IPod) o;

        return this.numSongsStored == that.numSongsStored;
    }

    /**
     * Hash code implementation for the {@link #IPod} class.
     * The hash code is based on the {@link #numSongsStored}.
     *
     * @return the hash code value for this {@link #IPod}
     */
    @Override
    public int hashCode()
    {
        return Integer.hashCode(numSongsStored);
    }
}
