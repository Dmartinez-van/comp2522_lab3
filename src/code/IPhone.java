/**
 * A class that represents an IPhone device with instance variables for its {@link #planCarrier}
 * and its {@link #remainingPlanMinutes} (must be greater than {@value MIN_MINUTES_REQUIRED}).
 * This class extends IDevice and provides methods to access and modify IPhone-specific details.
 *
 * @author David Martinez,
 *         Daniel Do
 * @version 1.0
 */
public class IPhone extends IDevice
{
    private static final double MIN_MINUTES_REQUIRED = 1.0;
    private static final String IPHONE_PURPOSE       = "Talking";

    private final String planCarrier;
    private final double remainingPlanMinutes;

    /**
     * Constructor for the {@code IPhone} Class.
     *
     * @param remainingPlanMinutes the number of minutes remaining on the plan;
     *                             must be at least {@value MIN_MINUTES_REQUIRED}
     * @param planCarrier          the carrier for the plan; must not be null or blank
     */
    public IPhone(final double remainingPlanMinutes,
                  final String planCarrier)
    {
        super(IPHONE_PURPOSE);

        checkRemainingPlanMinutes(remainingPlanMinutes);
        checkPlanCarrier(planCarrier);

        this.remainingPlanMinutes = remainingPlanMinutes;
        this.planCarrier = planCarrier;
    }

    /*
     * Validator that checks if the remaining plan minutes are not less than
     * {@value MIN_MINUTES_REQUIRED}. Throws IllegalArgumentException if invalid.
     */
    private void checkRemainingPlanMinutes(final double remainingPlanMinutes)
    {
        if (remainingPlanMinutes < MIN_MINUTES_REQUIRED)
        {
            final StringBuilder errMsg;
            errMsg = new StringBuilder();

            errMsg.append("You must have more than ");
            errMsg.append(MIN_MINUTES_REQUIRED);
            errMsg.append(" minutes on your plan");

            throw new IllegalArgumentException(errMsg.toString());
        }
    }

    /*
     * Validator that checks if the plan carrier is not null or blank.
     * Throws IllegalArgumentException if invalid.
     */
    private void checkPlanCarrier(final String planCarrier)
    {
        // In reality planCarrier should be checking some sort of list of valid carriers
        if (planCarrier == null || planCarrier.isBlank())
        {
            throw new IllegalArgumentException("Carrier must not be null or blank");
        }
    }

    /**
     * Prints the {@link #IPhone}'s instance variables to the screen.
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a String representation of this IPhone object,
     * including its remaining plan minutes and its plan carrier.
     *
     * @return a String describing this IPhone instance
     */
    @Override
    public String toString()
    {
        final StringBuilder iphoneString;
        iphoneString = new StringBuilder();

        iphoneString.append(super.toString());
        iphoneString.append("\nRemaining Plan Minutes: ");
        iphoneString.append(remainingPlanMinutes);
        iphoneString.append("\nPlan Carrier: ");
        iphoneString.append(planCarrier);

        return iphoneString.toString();
    }

    /**
     * Getter for an IPhone's remaining plan minutes.
     *
     * @return {@link #remainingPlanMinutes} as double
     */
    public double getRemainingPlanMinutes()
    {
        return remainingPlanMinutes;
    }

    /**
     * equals implementation that considers two {@link IPhone} objects equal
     * if they have the same value for {@link #remainingPlanMinutes}.
     *
     * @param o the object to compare with this {@link #IPhone}
     * @return true if the specified object is an {@link #IPhone} with the same
     *         {@link #remainingPlanMinutes}
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

        final IPhone that;
        that = (IPhone) o;

        return this.getRemainingPlanMinutes() == that.getRemainingPlanMinutes();
    }

    /**
     * Hash code implementation for the {@link #IPhone} class.
     * The hash code is based on the {@link #remainingPlanMinutes} value.
     *
     * @return the hash code value for this {@link #IPhone}
     */
    @Override
    public int hashCode()
    {
        final int hashFromRPM;
        hashFromRPM = Double.hashCode(remainingPlanMinutes);

        return hashFromRPM;
    }
}
