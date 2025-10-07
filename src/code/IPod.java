/**
 * Represents an IPod device with instance variables for the {@link #numSongsStored} and
 * its {@link #currentVolumeDB} (must be between {@link #MIN_VOLUME_DB} and {@link #MIN_VOLUME_DB}).
 * This class extends IDevice and provides methods to access and modify IPod-specific details.
 *
 * @author David Martinez,
 *         Daniel Do
 * @version 1.0
 */
public final class IPod extends IDevice
{
    private final double MAX_VOLUME_DB        = 100.0;
    private final double MIN_VOLUME_DB        = 0.0;
    private final int    MIN_NUM_SONGS_STORED = 0;

    private final int numSongsStored;

    private double currentVolumeDB;

    public IPod(final String purpose,
                final double currentVolumeDB,
                final int numSongsStored)
    {
        super(purpose);

        checkCurrentVolumeDB(currentVolumeDB);
        checkNumSongsStored(numSongsStored);

        this.currentVolumeDB = currentVolumeDB;
        this.numSongsStored = numSongsStored;
    }

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

    public double getCurrentVolumeDB()
    {
        return currentVolumeDB;
    }

    public int getNumSongsStored()
    {
        return numSongsStored;
    }

    /**
     * Prints the all details of the IPod.
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a String representation of this IPod object, including its current volume
     * and the number of songs it's storing.
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

    @Override
    public int hashCode()
    {
        return numSongsStored;
    }
}
