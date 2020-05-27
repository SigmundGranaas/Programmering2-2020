package oblig3;

public abstract class Tribune {
    private final String tribuneName;
    private final int capacity;
    private final int price;

    protected Tribune(String tribuneName, int capacity, int price) {
        this.tribuneName = tribuneName;
        this.capacity = capacity;
        this.price = price;
    }
    public abstract Ticket[] buyTicket(int noTickets);

    public abstract Ticket[] buyTicket(int noTickets, String[] names);

    public abstract int findNumberOfTicketsSold();

    public int findIncome(){
        return findNumberOfTicketsSold()*price;
    }

    public String getTribuneName() {
        return tribuneName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Tribune{" +
                "tribuneName='" + tribuneName + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", income=" + findIncome() +
                ", noTicketsSold=" + findNumberOfTicketsSold() +
                '}';
    }
}
