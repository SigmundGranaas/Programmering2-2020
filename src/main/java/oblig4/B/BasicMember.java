package oblig4.B;

import java.time.LocalDate;

/**
 * The type Basic member.
 */
public class BasicMember extends BonusMember {
    /**
     * Instantiates a new Basic member.
     *
     * @param memberNo     the member no
     * @param personals    the personals
     * @param enrolledDate the enrolled date
     */
    public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        super(memberNo, personals, enrolledDate);
    }
}
