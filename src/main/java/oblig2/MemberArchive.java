package oblig2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Member archive.
 */
public class MemberArchive {
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;
    private static final int MAKS_TRY = 3;
    private HashMap<Integer, BonusMember> memberHashMap;
    private ArrayList<BonusMember> memberArrayList;
    private int memberNO;

    /**
     * Instantiates a new Member archive.
     */
    public MemberArchive(){
        memberNO = 0;
        memberHashMap = new HashMap<>();
        memberArrayList = new ArrayList<>();
    }

    private void memberIDIncrementer(){
        if(memberHashMap.size() != memberArrayList.size()){
            throw new IllegalStateException("YOU HAVE DIFFERENT MEMBERS NONONONO ABORT");
        }else{
            memberNO++;
        }
    }

    /**
     * Find points int.
     *
     * @param memberNO the member no
     * @param password the password
     * @return the int
     */
    public int findPoints(int memberNO, String password){

        BonusMember foundMember = memberHashMap.get(memberNO);
        if(foundMember != null && foundMember.okPassword(password)){
            return foundMember.getPoints();
        }
        return -1;
    }

    /**
     * Register points boolean.
     *
     * @param points   the points
     * @param memberNO the member no
     * @return the boolean
     */
    public boolean registerPoints(int points, int memberNO){

        BonusMember foundMember = memberHashMap.get(memberNO);
        if(foundMember != null ){
            foundMember.registerPoints(points);
            return true;
        }
        return false;
    }

    /**
     * New member int.
     *
     * @param personals the personals
     * @param localDate the local date
     * @return the int
     */
    public int newMember(Personals personals, LocalDate localDate){
        BasicMember basic = new BasicMember(memberNO, personals, localDate);
        memberArrayList.add(basic);
        memberHashMap.put(memberNO, basic);
        try{
            memberIDIncrementer();
        }catch (IllegalStateException e){
            System.out.println("Fuck off" + e.getMessage());
            return -1;
        }
        return memberNO -1;
    }

    /**
     * Check members.
     */
    public void checkMembers(){
        memberHashMap.values().forEach(this::checkMember);
    }

    private void checkMember(BonusMember member){
        int qualificationPoints = member.findQualificationPoints();
        if(qualificationPoints == 0){
            return;
        }
        if(member instanceof BasicMember){
            if(qualificationPoints >= GOLD_LIMIT){
                GoldMember G = new GoldMember(member.getMEMBER_NO(), member.getPERSONALS(), member.getENROLLED_DATE(), member.getPoints());
                memberHashMap.replace(member.getMEMBER_NO(), G);
                memberArrayList.set(memberArrayList.indexOf(member), G);
            }else if(qualificationPoints >= SILVER_LIMIT){
                BonusMember S = new SilverMember(member.getMEMBER_NO(), member.getPERSONALS(), member.getENROLLED_DATE(), member.getPoints());
                memberHashMap.replace(member.getMEMBER_NO(), S);
                memberArrayList.set(memberArrayList.indexOf(member), S);
            }
        }else if(member instanceof SilverMember){
            if(qualificationPoints >= GOLD_LIMIT){
                BonusMember G = new GoldMember(member.getMEMBER_NO(), member.getPERSONALS(), member.getENROLLED_DATE(), member.getPoints());
                memberHashMap.replace(member.getMEMBER_NO(), G);
                memberArrayList.set(memberArrayList.indexOf(member), G);
            }
        }
    }

    public HashMap<Integer, BonusMember> getMemberHashMap() {
        return memberHashMap;
    }

    public ArrayList<BonusMember> getMemberArrayList() {
        return memberArrayList;
    }

    public static void main(String[] args) {
        MemberArchive memberArchive = new MemberArchive();

        Personals ole = new Personals("Olsen", "Ole", "ole.olsen@dot.com", "ole");
        Personals tove = new Personals("Hansen", "Tove", "tove.hansen@dot.com", "tove");

        memberArchive.newMember(ole, LocalDate.of(2020, 1, 15));
        memberArchive.newMember(ole, LocalDate.of(2020, 1, 15));
        memberArchive.newMember(ole, LocalDate.of(2020, 1, 15));
        memberArchive.newMember(tove, LocalDate.of(2010, 1, 15));

        memberArchive.registerPoints(30000, 0);
        memberArchive.registerPoints(0, 1);
        memberArchive.registerPoints(100000, 2);
        memberArchive.registerPoints(300000, 3);

        memberArchive.getMemberArrayList().stream().forEach(e -> System.out.println(e.getClass().getSimpleName()));
        memberArchive.checkMembers();
        memberArchive.getMemberArrayList().stream().forEach(e -> System.out.println(e.getClass().getSimpleName()));







    }





}
