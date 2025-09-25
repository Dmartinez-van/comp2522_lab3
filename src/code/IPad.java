/**
 * @author David Martinez, Daniel Do
 * @version 1.0
 */
public final class IPad extends IDevice
{

    private boolean hasCase;
    private String OSVersion;

    public IPad(final boolean hasCase,
                final String OSVersion)
    {
        super("learning");
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

    void printDetails()
    {
        final StringBuilder details;

        details = new StringBuilder();

        System.out.println(details.toString());
    }

    /**
     * Returns a String representation of this IPad object, including whether it has a case and its OS version.
     * The format is: IPad{hasCase=true, OSVersion='16.4.1'} plus the superclass details.
     *
     * @return a String describing this IPad instance
     */
    @Override
    public String toString()
    {
        final StringBuilder ipadDetails;
        ipadDetails = new StringBuilder();

        ipadDetails.append(super.toString());
        ipadDetails.append("IPad{");
        ipadDetails.append("hasCase=");
        ipadDetails.append(hasCase);
        ipadDetails.append(", OSVersion='");
        ipadDetails.append(OSVersion);
        ipadDetails.append('\'');
        ipadDetails.append("} ");

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
        final IPad that = (IPad) o;
        return this.OSVersion.equals(that.getOSVersion());
//        if (hasCase != iPad.hasCase) return false;
//        return OSVersion != null ? OSVersion.equals(iPad.OSVersion) : iPad.OSVersion == null;
    }
}
