import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    public Interface() {
        super("Ficha de Avaliação");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuEditar = new JMenu("Editar");

        JMenu menuEnviar = new JMenu("Enviar");
        JMenuItem itemEmail = new JMenuItem("email");
        JMenuItem itemImpressora = new JMenuItem("impressora");
        menuEnviar.add(itemEmail);
        menuEnviar.add(itemImpressora);

        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemSair = new JMenuItem("Sair");

        menuArquivo.add(menuEnviar);
        menuArquivo.add(itemSalvar);
        menuArquivo.add(itemSair);

        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        setJMenuBar(menuBar);

        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel titulo = new JLabel("Ficha de Avaliação", JLabel.CENTER);
        titulo.setForeground(Color.RED);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelPrincipal.add(titulo, gbc);

        JPanel painelDados = new JPanel(new GridBagLayout());
        painelDados.setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));
        GridBagConstraints gbcDados = new GridBagConstraints();
        gbcDados.insets = new Insets(4, 4, 4, 4);
        gbcDados.fill = GridBagConstraints.HORIZONTAL;

        JTextField campoCodigo = new JTextField(15);
        JTextField campoNome = new JTextField(15);
        JRadioButton rbFeminino = new JRadioButton("Feminino");
        JRadioButton rbMasculino = new JRadioButton("Masculino");
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbFeminino);
        grupoSexo.add(rbMasculino);

        gbcDados.gridx = 0; gbcDados.gridy = 0;
        painelDados.add(new JLabel("Código:"), gbcDados);
        gbcDados.gridx = 1;
        painelDados.add(campoCodigo, gbcDados);

        gbcDados.gridx = 0; gbcDados.gridy = 1;
        painelDados.add(new JLabel("Nome:"), gbcDados);
        gbcDados.gridx = 1;
        painelDados.add(campoNome, gbcDados);

        gbcDados.gridx = 0; gbcDados.gridy = 2;
        painelDados.add(new JLabel("Sexo:"), gbcDados);
        gbcDados.gridx = 1;
        JPanel painelSexo = new JPanel();
        painelSexo.add(rbFeminino);
        painelSexo.add(rbMasculino);
        painelDados.add(painelSexo, gbcDados);

        gbc.gridy = 1;
        painelPrincipal.add(painelDados, gbc);

        JTextArea areaCV = new JTextArea(5, 30);
        JScrollPane scrollCV = new JScrollPane(areaCV);
        JPanel painelCV = new JPanel(new BorderLayout());
        painelCV.setBorder(BorderFactory.createTitledBorder("Curriculum Vitae"));
        painelCV.add(scrollCV, BorderLayout.CENTER);

        gbc.gridy = 2;
        painelPrincipal.add(painelCV, gbc);

        JComboBox<String> comboInteresse = new JComboBox<>(new String[]{"Desenvolvedor", "Analista", "Designer"});
        comboInteresse.setForeground(Color.RED);

        JComboBox<String> comboAtuacao = new JComboBox<>(new String[]{"Programação", "Testes", "Banco de Dados"});
        comboAtuacao.setForeground(Color.BLUE);

        JPanel painelAreas = new JPanel(new GridBagLayout());
        painelAreas.setBorder(BorderFactory.createTitledBorder("Áreas"));
        GridBagConstraints gbcAreas = new GridBagConstraints();
        gbcAreas.insets = new Insets(4, 4, 4, 4);
        gbcAreas.fill = GridBagConstraints.HORIZONTAL;

        gbcAreas.gridx = 0; gbcAreas.gridy = 0;
        painelAreas.add(new JLabel("Interesse:"), gbcAreas);
        gbcAreas.gridx = 1;
        painelAreas.add(comboInteresse, gbcAreas);
        gbcAreas.gridx = 2;
        painelAreas.add(new JLabel("Atuação:"), gbcAreas);
        gbcAreas.gridx = 3;
        painelAreas.add(comboAtuacao, gbcAreas);

        gbc.gridy = 3;
        painelPrincipal.add(painelAreas, gbc);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.GREEN);

        painelBotoes.add(new JButton("Salvar"));
        painelBotoes.add(new JButton("Anterior"));
        painelBotoes.add(new JButton("Proximo"));
        painelBotoes.add(new JButton("Novo"));
        painelBotoes.add(new JButton("Cancelar"));

        add(painelPrincipal, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interface frame = new Interface();
            frame.setVisible(true);
        });
    }
}