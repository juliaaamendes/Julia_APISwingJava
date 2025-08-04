import javax.swing.*;
import java.awt.*;

public class CadastroUsuario extends JFrame {

    // Classe para criar uma janela de cadastro de usuário
    public CadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(idadeLabel);
        panel.add(idadeField);
        panel.add(new JLabel());
        panel.add(cadastrarButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroUsuario frame = new CadastroUsuario();
            frame.setVisible(true);
        });
    }
}