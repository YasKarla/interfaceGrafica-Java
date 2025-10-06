package view;

import controller.LanchoneteControllerImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LanchoneteView {
    private JFrame frame;
    private JButton botaoCardapio;
    private JButton botaoAcompanharPedido;
    private JLabel labelEndereco;
    private LanchoneteControllerImpl controller; 

    public LanchoneteView(LanchoneteControllerImpl controller) { 
        this.controller = controller; 
        inicioLanchonete();
        adicionarListeners(); 
    }

    public void inicioLanchonete() {
        frame = new JFrame("Sejam Bem-Vindos a Lanchonete");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(590, 350);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
        Color corFundo = Color.decode("#FFCC99");
        mainPanel.setBackground(corFundo);

        ImageIcon imagemIcon = new ImageIcon("C:\\Users\\ct67ca\\Desktop\\Nova pasta\\untitled\\src\\main\\java\\imagem\\fundo_index.png");
        Image imagem = imagemIcon.getImage();
        Image novaImagem = imagem.getScaledInstance(290, 350, Image.SCALE_SMOOTH);
        imagemIcon = new ImageIcon(novaImagem);
        JLabel imagemLabel = new JLabel(imagemIcon);
        mainPanel.add(imagemLabel, BorderLayout.WEST);

        JPanel centerButtonPanel = new JPanel();
        centerButtonPanel.setLayout(new BoxLayout(centerButtonPanel, BoxLayout.Y_AXIS));
        centerButtonPanel.setBorder(new EmptyBorder(0, 70, 0, 0));
        centerButtonPanel.setBackground(corFundo);

        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        tituloPanel.setBorder(new EmptyBorder(70, 0, 10, 40)); 
        tituloPanel.setBackground(corFundo); 

        JLabel tituloLabel = new JLabel("Burguer Market");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        tituloLabel.setForeground(Color.BLACK); 
        tituloPanel.add(tituloLabel);

        Font botaoFonte = new Font("Arial", Font.BOLD, 14);
        Color textColor = Color.WHITE;

        botaoCardapio = new JButton("Cardápio");
        botaoAcompanharPedido = new JButton("Pedido");
        botaoCardapio.setBackground(Color.BLACK);
        botaoAcompanharPedido.setBackground(Color.BLACK);

        botaoCardapio.setFont(botaoFonte);
        botaoCardapio.setForeground(textColor);
        botaoAcompanharPedido.setFont(botaoFonte);
        botaoAcompanharPedido.setForeground(textColor);

        centerButtonPanel.add(tituloPanel);
        centerButtonPanel.add(botaoCardapio);

        centerButtonPanel.add(botaoCardapio);
        centerButtonPanel.add(botaoAcompanharPedido);



        mainPanel.add(centerButtonPanel, BorderLayout.CENTER);

        /* 
        JPanel panelText = new JPanel();
        labelEndereco = new JLabel("Rua das Delícias, 123 | Bairro: Sabores Alegres | Telefone: (55) 9876-5432");
        panelText.add(labelEndereco);
        mainPanel.add(panelText, BorderLayout.SOUTH);
        panelText.setBackground(Color.ORANGE);
        */

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void adicionarListeners() {
        botaoCardapio.addActionListener(e -> {
            CardapioLancheView cardapio = new CardapioLancheView(controller); // Passe o controlador para o construtor
            cardapio.exibirLanche();
        });
    }
}
