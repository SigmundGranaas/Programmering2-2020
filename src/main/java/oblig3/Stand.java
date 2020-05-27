package oblig3;

public class Stand extends Tribune {
    private int noSoldTickets;

    protected Stand(String tribuneName, int capacity, int price) {
        super(tribuneName, capacity, price);
    }

    @Override
    public Ticket[] buyTicket(int noTickets) {
        if(getCapacity() - noSoldTickets > noTickets){
            noSoldTickets += noTickets;
            Ticket[] tickets = new Ticket[noTickets];
            for (int i = 0; i < noTickets; i++) {
                tickets[i] = new StandingTicket(getTribuneName(), getPrice());

            }
            return tickets;
        }
        return null;
    }

    @Override
    public Ticket[] buyTicket(int noTickets, String[] names) {
        return buyTicket(noTickets);
    }

    @Override
    public int findNumberOfTicketsSold() {
        return noSoldTickets;
    }
}
