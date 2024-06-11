package classes;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String cpf;
    private final List<Ticket> tickets;

    public Client(String cpf) {
        this.cpf = cpf;
        this.tickets = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void adicionarTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removerTicket(Ticket ticket) {
        tickets.remove(ticket);
    }
}
