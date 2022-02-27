import java.lang.reflect.Array;

/**
 * Write a description of class SIRModel here.
 *
 * @author Jake Chambers K5467717
 * @version 24/02/2022 v1.0
 */
public class SIRModel
{
    //declare class and instance variables
    //Q3b.
    private static final int POPULATION = 150;
    private static final int INITIAL_INFECTIONS = 4;
    private static final int DAYS = 60;
    private static double TRANS_RATE;
    private static double REC_RATE;
    private double[] susceptible;
    private double[] infected;
    private double[] recovered;

    /**
     * public constructor for the SIRModel class
     * Q3c.
     * @param transRate
     * @param recRate
     */
    public SIRModel(double transRate, double recRate) 
    {
        //initialise instance/class variables
        TRANS_RATE = transRate;
        REC_RATE = recRate;
        susceptible = new double[DAYS];
        infected = new double[DAYS];
        recovered = new double[DAYS];

        infected[0] = INITIAL_INFECTIONS;
        susceptible[0] = (POPULATION - INITIAL_INFECTIONS);
    }

    /**
     * perform a calculation and return the number of newly infected pepople per day
     * Q3d.
     * @param currentInfected
     * @param currentSusceptible
     * @return type double - number of newly infected people per day
     */
    public double newlyInfected(double currentInfected, double currentSusceptible)
    {
        return (TRANS_RATE * currentInfected * currentSusceptible) / POPULATION;
    }

    /**
     * perform a calculation and return the number of people expected to recover per day
     * Q3e.
     * @param currentInfected
     * @return type double - number of people expected to recover in a day
     */
    public double newlyRecovered(double currentInfected) 
    {
        return (REC_RATE * currentInfected);
    }

    /**
     * perform a calculation and return the change in the number of expected infections
     * Q2f.
     * @param currentInfected
     * @param currentSusceptible
     * @return type double - change in the number of expected infectinos after a day has passed
     */
    public double changeInInfected(double currentInfected, double currentSusceptible) 
    {
        return (newlyInfected(currentInfected, currentSusceptible) - newlyRecovered(currentInfected));
    }

}
