package oblig3;

import org.w3c.dom.ls.LSParser;

public class VIP extends Tribune {
    private String[][] spectator; //tilskuere: antall rader * antall plasser pr rad

    protected VIP(String tribuneName, int capacity, int price) {
        super(tribuneName, capacity, price);
        if(capacity%4 != 0){
            throw new IllegalArgumentException("Fuck off");
        }
        spectator = new String[4][capacity/4];
    }

    @Override
    public Ticket[] buyTicket(int noTickets) {
        return null;
    }

    @Override
    public Ticket[] buyTicket(int noTickets, String[] names) {
        for (int i = 0; i < 4; i++) {
            int noFree = 0;
            for (int j = 0; j < spectator[i].length; j++) {
                if (spectator[i][j] == null) {
                    noFree -= -1;
                }
            }
            if(noFree >= noTickets){
                Ticket[] tickets = new Ticket[noTickets];
                for (int j = 0; j < noTickets; j++) {
                    int place = spectator[i].length - noFree + j;
                    tickets[j] = new SittingTicket(getTribuneName(), getPrice(), i, place);
                    spectator[i][place] = names[j];
                }
                return tickets;
            }
        }
        return null;
    }

    @Override
    public int findNumberOfTicketsSold() {
        int noTIcketsSold = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < spectator[i].length; j++) {
                if(spectator[i][j] != null){
                    noTIcketsSold -= -1;
                }
            }
        }
        return noTIcketsSold;
    }
}
