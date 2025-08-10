import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuario extends JFrame {
    // Componentes da interface
    private JLabel lblNome, lblEmail, lblIdade, lblSexo;
    private JTextField txtNome, txtEmail, txtIdade;
    private JRadioButton rbMasculino, rbFeminino, rbOutro;
    private ButtonGroup grupoSexo;
    private JButton btnCadastrar, btnLimpar;

    public CadastroUsuario() {
        // Configuração básica do JFrame
        setTitle("Cadastro de Usuário");
        setSize(400, 350); // Aumentamos a altura para acomodar os novos componentes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Inicializa os componentes
        inicializarComponentes();
        
        // Organiza os componentes na janela
        organizarComponentes();
    }

    private void inicializarComponentes() {
        // Labels
        lblNome = new JLabel("Nome:");
        lblEmail = new JLabel("E-mail:");
        lblIdade = new JLabel("Idade:");
        lblSexo = new JLabel("Sexo:");

        // Campos de texto
        txtNome = new JTextField(20);
        txtEmail = new JTextField(20);
        txtIdade = new JTextField(20);

        // Radio buttons para sexo
        rbMasculino = new JRadioButton("Masculino");
        rbFeminino = new JRadioButton("Feminino");
        rbOutro = new JRadioButton("Outro");
        
        // Agrupa os radio buttons
        grupoSexo = new ButtonGroup();
        grupoSexo.add(rbMasculino);
        grupoSexo.add(rbFeminino);
        grupoSexo.add(rbOutro);
        
        // Seleciona um por padrão
        rbMasculino.setSelected(true);

        // Botões
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        
        // Configura os listeners dos botões
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    }

    private void organizarComponentes() {
        // Usando GridLayout para organização simples
        setLayout(new GridLayout(8, 2, 10, 10)); // Ajustado para 8 linhas
        
        // Adiciona os componentes ao JFrame
        add(lblNome);
        add(txtNome);
        add(lblEmail);
        add(txtEmail);
        add(lblIdade);
        add(txtIdade);
        add(lblSexo);
        add(rbMasculino);
        add(new JLabel()); // Espaço vazio
        add(rbFeminino);
        add(new JLabel()); // Espaço vazio
        add(rbOutro);
        add(new JLabel()); // Espaço vazio
        add(btnCadastrar);
        add(new JLabel()); // Espaço vazio
        add(btnLimpar);
    }

    private boolean validarEmail(String email) {
        // Expressão regular simples para validar e-mail
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }

    private void cadastrarUsuario() {
        // Obtém os valores dos campos
        String nome = txtNome.getText().trim();
        String email = txtEmail.getText().trim();
        String idade = txtIdade.getText().trim();

        // Validação simples - verifica se os campos estão vazios
        if (nome.isEmpty() || email.isEmpty() || idade.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, preencha todos os campos!", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validação do e-mail
        if (!validarEmail(email)) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, insira um e-mail válido!", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtém o sexo selecionado
        String sexo = "";
        if (rbMasculino.isSelected()) sexo = "Masculino";
        else if (rbFeminino.isSelected()) sexo = "Feminino";
        else sexo = "Outro";

        // Exibe os dados em uma JOptionPane
        String mensagem = "Usuário cadastrado:\n" +
                         "Nome: " + nome + "\n" +
                         "E-mail: " + email + "\n" +
                         "Idade: " + idade + "\n" +
                         "Sexo: " + sexo;

        JOptionPane.showMessageDialog(this, mensagem, "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtIdade.setText("");
        rbMasculino.setSelected(true); // Volta ao valor padrão
    }

    public static void main(String[] args) {
        // Executa a aplicação
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }
}
