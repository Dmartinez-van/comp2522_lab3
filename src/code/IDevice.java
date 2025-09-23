/**
 * Abstract class representing a generic IDevice with a specific purpose.
 * Has a getter for the purpose and an abstract method to print details.
 *
 * @author David Martinez, Daniel Do
 * @version 1.0
 */
abstract public class IDevice
{

    private String purpose;

    /**
     * Constructs an IDevice with a specific purpose.
     * The purpose describes the intended use or function of the device.
     * For example, a device may have the purpose "communication" or "measurement".
     * The purpose is stored as a String and can be retrieved using getPurpose().
     *
     * @param purpose a String describing the purpose of the device, such as "navigation" or "entertainment"
     */
    public IDevice(final String purpose)
    {
        this.purpose = purpose;
    }

    /**
     * Retrieves the purpose of this device.
     * The purpose is a descriptive String indicating what the device is used for.
     * For example, "navigation", "measurement", or "communication".
     *
     * @return the purpose of the device as a String
     */
    public String getPurpose()
    {
        return purpose;
    }

    /**
     * Prints the details of the device.
     * This method must be implemented by subclasses to display all relevant information about the device,
     * such as its type, model, specifications, and any other distinguishing features.
     * The output should be clear and comprehensive so that another developer or user can understand
     * what makes this device unique and what its intended use is.
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
        return "";
    }
}
