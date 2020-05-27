package oblig3;

import java.util.Arrays;

public class Sit extends Tribune {
    private int[] noBusy;

    protected Sit(String tribuneName, int capacity, int price) {
        super(tribuneName, capacity, price);
        if(capacity%4 != 0){
            throw new IllegalArgumentException("Fuck off");
        }
        noBusy = new int[4];
    }

    @Override
    public Ticket[] buyTicket(int noTickets) {
        for (int i = 0; i < 4; i++) {
            if(getCapacity()/4 - noBusy[i] > noTickets){
                Ticket[] tickets = new Ticket[noTickets];
                for (int j = 0; j < noTickets; j++) {
                    tickets[j] = new SittingTicket(getTribuneName(), getPrice(), i,noBusy[i]+j);
                }
                noBusy[i] += noTickets;
                return tickets;
            }

        }
        return null;
    }

    @Override
    public Ticket[] buyTicket(int noTickets, String[] names) {
        return buyTicket(noTickets);
    }

    @Override
    public int findNumberOfTicketsSold() {
        return Arrays.stream(noBusy).reduce(Integer::sum).getAsInt();
    }
}
