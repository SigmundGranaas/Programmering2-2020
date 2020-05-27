package oblig4.B;

import java.time.LocalDate;

/**
 * The type Gold member.
 */
public class GoldMember extends BonusMember {
    /**
     * Instantiates a new Gold member.
     *
     * @param memberNo     the member no
     * @param personals    the personals
     * @param enrolledDate the enrolled date
     * @param points       the points
     */
    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        super(memberNo, personals, enrolledDate);
        super.registerPoints(points);
    }

    @Override
    public void registerPoints(int addPoints) {
        super.registerPoints((int) (addPoints* BonusMember.getFactorGold()));
    }

}