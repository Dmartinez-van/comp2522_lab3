/**
 * Abstract class representing a generic IDevice with a specific purpose.
 * Has a getter for the purpose and an abstract method to print details.
 *
 * @author David Martinez, Daniel Do
 * @version 1.0
 */
abstract public class IDevice
{
    private final String purpose;

    /**
     * Constructs an IDevice with a specific purpose.
     * The purpose describes the intended use or function of the device.
     *
     * @param purpose a String describing the purpose of the device
     */
    public IDevice(final String purpose)
    {
        checkPurpose(purpose);

        this.purpose = purpose;
    }

    private void checkPurpose(final String purpose)
    {
        if (purpose == null || purpose.isBlank())
        {
            throw new IllegalArgumentException("Purpose must not be null or blank.");
        }
    }

    /**
     * Retrieves the purpose of this device.
     *
     * @return the purpose of the device as a String
     */
    public String getPurpose()
    {
        return purpose;
    }

    /**
     * Prints the details of the device.
     * This method must be implemented by subclasses to display all relevant information about the device.
     */
    abstract void printDetails();

    /**
     * Returns a String representation of the device.
     * Subclasses should override this method to provide a meaningful summary of the device,
     * including its purpose and any other important attributes.
     *
     * @return a String summarizing the device
     */
    @Override
    public String toString() {

        final StringBuilder device;
        device = new StringBuilder();

        device.append("Device Purpose: ");
        device.append(purpose);

        return device.toString();
    }
}
