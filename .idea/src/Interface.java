import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    public Interface() {
        super("Ficha de Avaliação");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        // Menu
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

        // Painel principal
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Título
        JLabel titulo = new JLabel("Ficha de Avaliação", JLabel.CENTER);
        titulo.setForeground(Color.RED);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelPrincipal.add(titulo, gbc);

        // Código
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelPrincipal.add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        painelPrincipal.add(new JTextField(20), gbc);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        painelPrincipal.add(new JTextField(20), gbc);

        // Sexo
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelPrincipal.add(new JLabel("Sexo:"), gbc);

        JPanel painelSexo = new JPanel();
        JRadioButton rbFeminino = new JRadioButton("Feminino");
        JRadioButton rbMasculino = new JRadioButton("Masculino");
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbFeminino);
        grupoSexo.add(rbMasculino);
        painelSexo.add(rbFeminino);
        painelSexo.add(rbMasculino);

        gbc.gridx = 1;
        painelPrincipal.add(painelSexo, gbc);

        // Curriculum Vitae
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JLabel labelCV = new JLabel("Curriculum Vitae");
        labelCV.setForeground(Color.BLUE);
        painelPrincipal.add(labelCV, gbc);

        gbc.gridy = 5;
        gbc.ipady = 60;
        JTextArea areaTexto = new JTextArea(5, 30);
        JScrollPane scrollCV = new JScrollPane(areaTexto);
        painelPrincipal.add(scrollCV, gbc);
        gbc.ipady = 0;

        // Áreas
        gbc.gridy = 6;
        JLabel labelAreas = new JLabel("Áreas");
        labelAreas.setForeground(Color.BLUE);
        painelPrincipal.add(labelAreas, gbc);

        // Interesse e Atuação
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        painelPrincipal.add(new JLabel("Interesse:"), gbc);
        gbc.gridx = 1;
        painelPrincipal.add(new JLabel("Atuação:"), gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        JComboBox<String> comboInteresse = new JComboBox<>(new String[]{"Desenvolvedor"});
        comboInteresse.setForeground(Color.RED);
        painelPrincipal.add(comboInteresse, gbc);
        gbc.gridx = 1;
        JComboBox<String> comboAtuacao = new JComboBox<>(new String[]{"Programação"});
        painelPrincipal.add(comboAtuacao, gbc);

        // Botões inferiores
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.GREEN);

        String[] botoes = {"Salvar", "Anterior", "Proximo", "Novo", "Cancelar"};
        for (String texto : botoes) {
            painelBotoes.add(new JButton(texto));
        }

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
