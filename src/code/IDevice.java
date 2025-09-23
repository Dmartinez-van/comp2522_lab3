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

    public IDevice(final String purpose)
    {

        this.purpose = purpose;
    }

    public String getPurpose()
    {
        return purpose;
    }

    abstract void printDetails();
}
