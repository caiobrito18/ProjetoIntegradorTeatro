package objects;

public class Ticket {
  private final String cpf;
  private final String peca;
  private final String sessao;
  private final String area;
  private final int poltrona;
  private final double preco;

  public Ticket(String cpf, String peca, String turn, String area, int poltrona, double preco) {
    String[] pecas = { "hamlet", "romeo e juleita", "otelo" };
    String[] turnos = { "manhã", "Tarde", "Noite" };
    String[] areas = { "Plateia A", "Plateia B", "Frisa1", "Frisa2", "Frisa3", "Frisa4", "Frisa5", "Frisa6",
        "Camarote1", "Camarote2", "Camarote3", "Camarote4", "Camarote5", "Balcão Nobre" };
    this.cpf = cpf;
    this.peca = pecas[Integer.valueOf(peca)];
    this.sessao = turnos[Integer.valueOf(turn)];
    this.area = areas[Integer.valueOf(area)];
    this.poltrona = poltrona;
    this.preco = preco;
  }

  public String getCpf() {
    return cpf;
  }

  public String getPeca() {
    return peca;
  }

  public String getSessao() {
    return sessao;
  }

  public String getArea() {
    return area;
  }

  public int getPoltrona() {
    return poltrona;
  }

  public double getPreco() {
    return preco;
  }

}
