package objects;

public class Area {
    private final boolean[] seats;
    private final double preco;

    public Area(int totalSeats, double preco) {
        this.seats = new boolean[totalSeats];
        this.preco = preco;
    }

    public int getTotalSeats() {
        return seats.length;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isSeatOccupied(int index) {
        return seats[index];
    }

    public void buySeats(int index) {
        seats[index] = true;
    }

    public void cancelSeats(int index) {
        seats[index] = false;
    }

    public int getTotalTicketsSold() {
        int total = 0;
        for (boolean Seats : seats) {
            if (Seats) {
                total++;
            }
        }
        return total;
    }

    public double getReceita() {
        return getTotalTicketsSold() * preco;
    }
}
