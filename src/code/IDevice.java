/**
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
