package oblig4.B;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberArchiveTest {
    private MemberArchive memberArchive;
    @Before
    void makeMemArch(){
        memberArchive = new MemberArchive();
        memberArchive.getMemberHashMap().put(0, null);
    }

    @Test
    void checkMembers() {
        try {
            memberArchive.checkMembers();
        } catch (NullPointerException e) {
        }
    }
}