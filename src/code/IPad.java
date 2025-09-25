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
        this.hasCase = hasCase;
        this.OSVersion = OSVersion;
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
        ipadDetails.append("hasCase=").append(hasCase);
        ipadDetails.append(", OSVersion='").append(OSVersion).append('\'');
        ipadDetails.append("} ");

        return ipadDetails.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof IPad)) return false;
        if (!super.equals(o)) return false;

        IPad iPad = (IPad) o;

        if (hasCase != iPad.hasCase) return false;
        return OSVersion != null ? OSVersion.equals(iPad.OSVersion) : iPad.OSVersion == null;
    }
}
