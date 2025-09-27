/**
 * The {@code IPhone}'s purpose is "talking"
 * Extends the IDevice class.
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
     * Constructs an {@code IPhone} object with the specified purpose,
     * remaining plan minutes, and plan carrier.
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

    /**
     * Validates the remaining plan minutes for the {@link #IPhone}.
     * <p>
     * This method checks if the provided value is greater than or equal to
     * {@value MIN_MINUTES_REQUIRED}.
     * <p>
     *
     * @param remainingPlanMinutes the number of minutes remaining on the plan;
     *                             must be at least {@value MIN_MINUTES_REQUIRED}
     * @throws IllegalArgumentException if {@code remainingPlanMinutes} is less than
     *                                  {@value MIN_MINUTES_REQUIRED}
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

    private void checkPlanCarrier(final String planCarrier)
    {
        // In reality planCarrier should be checking some sort of list of valid carriers
        if (planCarrier == null || planCarrier.isBlank())
        {
            throw new IllegalArgumentException("Carrier must not be null or blank");
        }
    }

    /**
     * Prints the {@link #IPhone}'s instance variables to the screen
     */
    @Override
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns the {@link #IPhone}'s instance variables as a string
     *
     * @return a string of the {@link #IPhone}'s instance variables
     */
    @Override
    public String toString()
    {
        final StringBuilder output;
        output = new StringBuilder();

        output.append(super.toString());
        output.append("\nRemaining Plan Minutes: ");
        output.append(remainingPlanMinutes);
        output.append("\nPlan Carrier: ");
        output.append(planCarrier);

        return output.toString();
    }

    /**
     * Gets IPhone's {@link #remainingPlanMinutes}
     *
     * @return {@link #remainingPlanMinutes} as double
     */
    public double getRemainingPlanMinutes()
    {
        return remainingPlanMinutes;
    }

    /**
     * Compares this {@link #IPhone} to the specified object for equality.
     * Two {@link #IPhone} objects are considered equal if they are of
     * the same class and have the same value for {@link #remainingPlanMinutes}.
     *
     * @param o the object to compare with this {@link #IPhone}
     * @return true if the specified object is an {@link #IPhone} with the same
     *         {@link #remainingPlanMinutes}, false otherwise
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
     * Returns the hash code value for this {@link #IPhone}.
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
