package oblig2;

import java.time.LocalDate;

/**
 * The type Silver member.
 */
public class SilverMember extends BonusMember {
    /**
     * Instantiates a new Silver member.
     *
     * @param memberNo     the member no
     * @param personals    the personals
     * @param enrolledDate the enrolled date
     * @param points       the points
     */
    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        super(memberNo, personals, enrolledDate);
        super.registerPoints(points);
    }

    @Override
    public void registerPoints(int addPoints) {
       super.registerPoints((int) (addPoints*BonusMember.getFactorSilver()));
    }

}
