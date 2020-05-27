package oblig4.B;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Bonus member.
 */
public abstract class BonusMember {
    private static final Double FACTOR_SILVER = 1.2;
    private static final Double FACTOR_GOLD = 1.5;
    private final int MEMBER_NO;
    private final LocalDate ENROLLED_DATE;
    private int points = 0;
    private Personals PERSONALS;
    Logger logger = Logger.getLogger(BonusMember.class.getName());

    /**
     * Instantiates a new Bonus member.
     *
     * @param memberNo     the member no
     * @param personals    the personals
     * @param enrolledDate the enrolled date
     */
    protected BonusMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        if (personals == null || memberNo < 0 || enrolledDate == null){
            logger.log(Level.SEVERE, "please don't");
            throw new IllegalArgumentException("invalid inputs for creating new member");
        }else{
            MEMBER_NO = memberNo;
            ENROLLED_DATE = enrolledDate;
            PERSONALS = personals;
        }
    }

    /**
     * Gets factor silver.
     *
     * @return the factor silver
     */
    public static Double getFactorSilver() {
        return FACTOR_SILVER;
    }

    /**
     * Gets factor gold.
     *
     * @return the factor gold
     */
    public static Double getFactorGold() {
        return FACTOR_GOLD;
    }

    /**
     * Gets member no.
     *
     * @return the member no
     */
    public int getMEMBER_NO() {
        return MEMBER_NO;
    }

    /**
     * Gets enrolled date.
     *
     * @return the enrolled date
     */
    public LocalDate getENROLLED_DATE() {
        return ENROLLED_DATE;
    }

    /**
     * Gets point.
     *
     * @return the point
     */
    public int getPoints() {
        return points;
    }

    /**
     * Gets personals.
     *
     * @return the personals
     */
    public Personals getPERSONALS() {
        return PERSONALS;
    }

    /**
     * Ok password boolean.
     *
     * @param checkPass the check pass
     * @return the boolean
     */
    public boolean okPassword(String checkPass) {
        return PERSONALS.okPassword(checkPass);
    }

    /**
     * Find qualification points int.
     *
     * @param now the now
     * @return the int
     */
    public int findQualificationPoints() {
        long dagerMellom = ChronoUnit.DAYS.between(ENROLLED_DATE, LocalDate.now());
        if(dagerMellom < 365){
            return points;
        }
        return 0;
    }

    /**
     * Register points.
     *
     * @param addPoints the add points
     */
    public void registerPoints(int addPoints) {
        if (addPoints > 0) {
            points += addPoints;
        }else{
            logger.log(Level.SEVERE, "get out");
            throw new IllegalArgumentException("invalid number of points added");
        }
    }
}
