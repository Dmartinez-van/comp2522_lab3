import java.util.Objects;

/**
 * Represents an iPad device with instance variables for whether
 * it {@link #hasCase} and the {@link #OSVersion}.
 * This class extends IDevice and provides methods to access and modify iPad-specific details.
 *
 * @author David Martinez, Daniel Do
 * @version 1.0
 */
public final class IPad extends IDevice
{
    public static final String IPAD_PURPOSE = "learning";

    private boolean hasCase;
    private String  OSVersion;

    public IPad(final boolean hasCase,
                final String OSVersion)
    {
        super(IPAD_PURPOSE);
        this.hasCase   = hasCase;
        this.OSVersion = OSVersion;
    }

    /**
     * Returns the operating system version of this iPad.
     *
     * @return the OS version String of this iPad
     */
    public String getOSVersion()
    {
        return OSVersion;
    }

    /**
     * Setter for whether this iPad has a protective case.
     *
     * @param hasCase true if the iPad has a case, false otherwise
     */
    public void setHasCase(final boolean hasCase)
    {
        this.hasCase = hasCase;
    }

    /**
     * Prints the details of this IPad instance to the console.
     */
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a String representation of this IPad object, including whether it has a case and its OS version.
     *
     * @return a String describing this IPad instance
     */
    @Override
    public String toString()
    {
        final StringBuilder ipadDetails;
        ipadDetails = new StringBuilder();

        ipadDetails.append(super.toString());
        ipadDetails.append("\nHas Case: ");
        ipadDetails.append(hasCase);
        ipadDetails.append("\nOS Version: ");
        ipadDetails.append(OSVersion);

        return ipadDetails.toString();
    }

    /**
     * Determines whether this IPad instance is equal to another object.
     *
     * @param o the object to compare with this IPad instance
     * @return true if the specified object is an IPad with the same OS version
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
        final IPad that;
        that = (IPad) o;

        return this.OSVersion.equals(that.getOSVersion());
    }

    /**
     * Returns the hash code value for this IPad instance.
     * The hash code is computed based on the OS version String.
     *
     * @return the hash code value for this IPad instance, based on OS version
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(OSVersion);
    }
}
