import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class Main extends JFrame {

    private static class Teatro {
        private final Map<String, Area> areas;

        public Teatro() {
            areas = new HashMap<>();
            areas.put("Plateia A", new Area(20, 40.00));
            areas.put("Plateia B", new Area(20, 60.00));
            areas.put("Camarote", new Area(10, 80.00));
            areas.put("Frisa", new Area(10, 120.00));
            areas.put("Balcão Nobre", new Area(10, 250.00));
            areas.put("Assentos Especiais", new Area(5, 40.00)); // Assentos para deficientes
        }

        public Map<String, Area> getAreas() {
            return areas;
        }

        public int getTotalIngressosVendidos() {
            return areas.values().stream().mapToInt(Area::getTotalIngressosVendidos).sum();
        }

        public double getReceitaTotal() {
            return areas.values().stream().mapToDouble(Area::getReceita).sum();
        }
    }

    private static class Cliente {
        private final String cpf;
        private final List<Ingresso> ingressos;

        public Cliente(String cpf) {
            this.cpf = cpf;
            this.ingressos = new ArrayList<>();
        }

        public String getCpf() {
            return cpf;
        }

        public List<Ingresso> getIngressos() {
            return ingressos;
        }

        public void adicionarIngresso(Ingresso ingresso) {
            ingressos.add(ingresso);
        }

        public void removerIngresso(Ingresso ingresso) {
            ingressos.remove(ingresso);
        }
    }

    private static class Peca {
        private final String nome;
        private final Map<String, Sessao> sessoes;

        public Peca(String nome) {
            this.nome = nome;
            this.sessoes = new HashMap<>();
            sessoes.put("Manhã", new Sessao());
            sessoes.put("Tarde", new Sessao());
            sessoes.put("Noite", new Sessao());
        }

        public String getNome() {
            return nome;
        }

        public Map<String, Sessao> getSessoes() {
            return sessoes;
        }

        public int getTotalIngressosVendidos() {
            return sessoes.values().stream().mapToInt(Sessao::getTotalIngressosVendidos).sum();
        }

        public double getReceitaTotal() {
            return sessoes.values().stream().mapToDouble(Sessao::getReceita).sum();
        }
    }

    private static class Sessao {
        private final List<Ingresso> ingressos;

        public Sessao() {
            this.ingressos = new ArrayList<>();
        }

        public void adicionarIngresso(Ingresso ingresso) {
            ingressos.add(ingresso);
        }

        public void removerIngresso(Ingresso ingresso) {
            ingressos.remove(ingresso);
        }

        public int getTotalIngressosVendidos() {
            return ingressos.size();
        }

        public double getReceita() {
            return ingressos.stream().mapToDouble(Ingresso::getPreco).sum();
        }
    }

    private static class Ingresso {
        private final String cpf;
        private final String peca;
        private final String sessao;
        private final String area;
        private final int poltrona;
        private final double preco;

        public Ingresso(String cpf, String peca, String sessao, String area, int poltrona, double preco) {
            this.cpf = cpf;
            this.peca = peca;
            this.sessao = sessao;
            this.area = area;
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

        @Override
        public String toString() {
            return peca + " - " + sessao + " - " + area + " - Poltrona: " + poltrona + " - Preço: R$ " + preco;
        }
    }

    private static class Area {
        private final boolean[] poltronas;
        private final double preco;

        public Area(int totalPoltronas, double preco) {
            this.poltronas = new boolean[totalPoltronas];
            this.preco = preco;
        }

        public int getTotalPoltronas() {
            return poltronas.length;
        }

        public double getPreco() {
            return preco;
        }

        public boolean isPoltronaOcupada(int index) {
            return poltronas[index];
        }

        public void comprarPoltrona(int index) {
            poltronas[index] = true;
        }

        public void cancelarPoltrona(int index) {
            poltronas[index] = false;
        }

        public int getTotalIngressosVendidos() {
            int total = 0;
            for (boolean poltrona : poltronas) {
                if (poltrona) {
                    total++;
                }
            }
            return total;
        }

        public double getReceita() {
            return getTotalIngressosVendidos() * preco;
        }
    }

    private final Teatro teatro;
    private final Map<String, Cliente> clientes;
    private final Map<String, Peca> pecas;
    private final JComboBox<String> areaComboBox;
    private final JPanel poltronasPanel;

    public Main() {
        teatro = new Teatro();
        clientes = new HashMap<>();
        pecas = new HashMap<>();

        pecas.put("Peça 1", new Peca("Peça 1"));
        pecas.put("Peça 2", new Peca("Peça 2"));
        pecas.put("Peça 3", new Peca("Peça 3"));

        setTitle("Teatro Implacável - Sistema de Vendas");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Adicionando o logo do Teatro Implacável no topo da interface
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon logo = new ImageIcon("teatro_logo.png");
        JLabel logoLabel = new JLabel("Teatro Implacável", logo, JLabel.CENTER);
        logoLabel.setFont(new Font("Serif", Font.BOLD, 24));
        logoLabel.setHorizontalTextPosition(JLabel.CENTER);
        logoLabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoPanel.add(logoLabel);
        add(logoPanel, BorderLayout.NORTH);

        // Painel de controle com botões
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 1, 10, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton comprarButton = new JButton("Comprar Ingresso");
        comprarButton.addActionListener(new ComprarIngressoListener());
        controlPanel.add(comprarButton);

        JButton cancelarButton = new JButton("Cancelar Ingresso");
        cancelarButton.addActionListener(new CancelarIngressoListener());
        controlPanel.add(cancelarButton);

        JButton imprimirButton = new JButton("Imprimir Ingresso");
        imprimirButton.addActionListener(new ImprimirIngressoListener());
        controlPanel.add(imprimirButton);

        JButton estatisticaButton = new JButton("Estatística de Vendas");
        estatisticaButton.addActionListener(new EstatisticaVendasListener());
        controlPanel.add(estatisticaButton);

        JButton listarPoltronasButton = new JButton("Listar Poltronas");
        listarPoltronasButton.addActionListener(new ListarPoltronasListener());
        controlPanel.add(listarPoltronasButton);

        add(controlPanel, BorderLayout.WEST);

        // Painel de áreas com informações
        JPanel areasPanel = new JPanel();
        areasPanel.setLayout(new GridLayout(6, 2, 10, 10));
        areasPanel.setBorder(BorderFactory.createTitledBorder("Áreas e Preços"));
        areasPanel.add(new JLabel("Área", JLabel.CENTER));
        areasPanel.add(new JLabel("Preço (R$)", JLabel.CENTER));

        teatro.getAreas().forEach((nome, area) -> {
            areasPanel.add(new JLabel(nome, JLabel.CENTER));
            areasPanel.add(new JLabel(String.format("%.2f", area.getPreco()), JLabel.CENTER));
        });

        add(areasPanel, BorderLayout.CENTER);

        // Painel de poltronas
        JPanel poltronasOuterPanel = new JPanel();
        poltronasOuterPanel.setLayout(new BorderLayout());
        poltronasOuterPanel.setBorder(BorderFactory.createTitledBorder("Seleção de Poltronas"));
        areaComboBox = new JComboBox<>(teatro.getAreas().keySet().toArray(new String[0]));
        areaComboBox.addActionListener(new ListarPoltronasListener());
        poltronasOuterPanel.add(areaComboBox, BorderLayout.NORTH);

        poltronasPanel = new JPanel();
        poltronasPanel.setLayout(new GridLayout(5, 4, 5, 5)); // Placeholder para layout dinâmico
        poltronasOuterPanel.add(new JScrollPane(poltronasPanel), BorderLayout.CENTER);
        add(poltronasOuterPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private class ComprarIngressoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpf = JOptionPane.showInputDialog(Main.this, "Digite o CPF do cliente:");
            if (cpf == null || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(Main.this, "CPF não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String pecaNome = (String) JOptionPane.showInputDialog(Main.this, "Selecione a Peça:", "Peça", JOptionPane.QUESTION_MESSAGE, null, pecas.keySet().toArray(), null);
            if (pecaNome == null) {
                return;
            }

            String sessaoNome = (String) JOptionPane.showInputDialog(Main.this, "Selecione a Sessão:", "Sessão", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Manhã", "Tarde", "Noite"}, null);
            if (sessaoNome == null) {
                return;
            }

            String areaNome = (String) areaComboBox.getSelectedItem();
            if (areaNome == null) {
                JOptionPane.showMessageDialog(Main.this, "Área não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int poltrona;
            try {
                poltrona = Integer.parseInt(JOptionPane.showInputDialog(Main.this, "Selecione a Poltrona:"));
                if (poltrona < 1 || poltrona > teatro.getAreas().get(areaNome).getTotalPoltronas()) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Main.this, "Número de poltrona inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!clientes.containsKey(cpf)) {
                clientes.put(cpf, new Cliente(cpf));
            }
            Cliente cliente = clientes.get(cpf);
            Peca peca = pecas.get(pecaNome);
            Sessao sessao = peca.getSessoes().get(sessaoNome);
            Area area = teatro.getAreas().get(areaNome);

            if (area.isPoltronaOcupada(poltrona - 1)) {
                JOptionPane.showMessageDialog(Main.this, "Poltrona já está ocupada!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Ingresso ingresso = new Ingresso(cpf, pecaNome, sessaoNome, areaNome, poltrona, area.getPreco());
                cliente.adicionarIngresso(ingresso);
                sessao.adicionarIngresso(ingresso);
                area.comprarPoltrona(poltrona - 1);
                JOptionPane.showMessageDialog(Main.this, "Ingresso comprado com sucesso!");
                atualizarPoltronas();
            }
        }
    }

    private class CancelarIngressoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpf = JOptionPane.showInputDialog(Main.this, "Digite o CPF do cliente:");

            if (!clientes.containsKey(cpf)) {
                JOptionPane.showMessageDialog(Main.this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cliente cliente = clientes.get(cpf);
            List<Ingresso> ingressos = cliente.getIngressos();

            if (ingressos.isEmpty()) {
                JOptionPane.showMessageDialog(Main.this, "Cliente não possui ingressos comprados!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Ingresso[] ingressosArray = ingressos.toArray(new Ingresso[0]);
            Ingresso ingresso = (Ingresso) JOptionPane.showInputDialog(Main.this, "Selecione o ingresso a cancelar:", "Cancelar Ingresso", JOptionPane.QUESTION_MESSAGE, null, ingressosArray, null);

            if (ingresso != null) {
                cliente.removerIngresso(ingresso);
                Peca peca = pecas.get(ingresso.getPeca());
                Sessao sessao = peca.getSessoes().get(ingresso.getSessao());
                sessao.removerIngresso(ingresso);
                Area area = teatro.getAreas().get(ingresso.getArea());
                area.cancelarPoltrona(ingresso.getPoltrona() - 1);
                JOptionPane.showMessageDialog(Main.this, "Ingresso cancelado com sucesso!");
                atualizarPoltronas();
            }
        }
    }

    private class ImprimirIngressoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpf = JOptionPane.showInputDialog(Main.this, "Digite o CPF do cliente:");

            if (!clientes.containsKey(cpf)) {
                JOptionPane.showMessageDialog(Main.this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cliente cliente = clientes.get(cpf);
            List<Ingresso> ingressos = cliente.getIngressos();

            if (ingressos.isEmpty()) {
                JOptionPane.showMessageDialog(Main.this, "Cliente não possui ingressos comprados!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder recibo = new StringBuilder("Recibo de Ingressos:\n\n");
            ingressos.forEach(ingresso -> recibo.append(ingresso).append("\n"));
            recibo.append("\nTotal: R$ ").append(String.format("%.2f", ingressos.stream().mapToDouble(Ingresso::getPreco).sum()));

            JOptionPane.showMessageDialog(Main.this, recibo.toString(), "Recibo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class EstatisticaVendasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder estatisticas = new StringBuilder("Estatísticas de Vendas:\n\n");
            estatisticas.append("Total de Ingressos Vendidos: ").append(teatro.getTotalIngressosVendidos()).append("\n");
            estatisticas.append("Receita Total: R$ ").append(String.format("%.2f", teatro.getReceitaTotal())).append("\n\n");

            pecas.values().forEach(peca -> {
                estatisticas.append("Peça: ").append(peca.getNome()).append("\n");
                estatisticas.append("Ingressos Vendidos: ").append(peca.getTotalIngressosVendidos()).append("\n");
                estatisticas.append("Receita: R$ ").append(String.format("%.2f", peca.getReceitaTotal())).append("\n\n");
            });

            JOptionPane.showMessageDialog(Main.this, estatisticas.toString(), "Estatísticas de Vendas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class ListarPoltronasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            atualizarPoltronas();
        }
    }

    private void atualizarPoltronas() {
        poltronasPanel.removeAll();
        String areaNome = (String) areaComboBox.getSelectedItem();
        Area area = teatro.getAreas().get(areaNome);
        for (int i = 0; i < area.getTotalPoltronas(); i++) {
            JButton poltronaButton = new JButton(String.valueOf(i + 1));
            poltronaButton.setBackground(area.isPoltronaOcupada(i) ? Color.RED : Color.GREEN);
            poltronasPanel.add(poltronaButton);
        }
        poltronasPanel.revalidate();
        poltronasPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
}
}