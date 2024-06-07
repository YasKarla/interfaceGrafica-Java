package view;

import controller.LanchoneteControllerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardapioSobremesaView extends JFrame {
    private LanchoneteControllerImpl controller;

    public CardapioSobremesaView(LanchoneteControllerImpl controller) {
        this.controller = controller;
        exibirSobremesa();
    }

    public void exibirSobremesa() {
        setTitle("Cardápio Sobremesa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.ORANGE);

        JLabel tituloLabel = new JLabel("Cardápio Sobremesa");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(tituloLabel, constraints);

        String[] opcoesSobremesa = {"Banoffee", "Sorvete", "Bolo de Chocolate", "Pudim"};
        double[] precosSobremesa = {8.0, 5.0, 6.5, 4.0}; // Preços correspondentes às sobremesas

        JCheckBox[] checkboxes = new JCheckBox[opcoesSobremesa.length];

        for (int i = 0; i < opcoesSobremesa.length; i++) {
            checkboxes[i] = new JCheckBox(opcoesSobremesa[i] + " - R$" + precosSobremesa[i]); // Adiciona o preço ao texto da opção

            checkboxes[i].setOpaque(true);
            checkboxes[i].setBackground(Color.ORANGE);

            constraints.gridx = 0;
            constraints.gridy = i + 1;
            constraints.gridwidth = 1;
            panel.add(checkboxes[i], constraints);
        }

        JButton botaoConfirma = new JButton("Continuar");
        botaoConfirma.setBackground(Color.BLACK);
        botaoConfirma.setFont(new Font("Arial", Font.BOLD, 14));
        botaoConfirma.setForeground(Color.WHITE);

        constraints.gridx = 0;
        constraints.gridy = opcoesSobremesa.length + 1;
        constraints.gridwidth = 2;
        panel.add(botaoConfirma, constraints);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSobremesa = null;
                double precoSobremesa = 0.0; // Preço da sobremesa selecionada
                for (int i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].isSelected()) {
                        selectedSobremesa = opcoesSobremesa[i];
                        precoSobremesa = precosSobremesa[i];
                        break;
                    }
                }

                if (selectedSobremesa == null) {
                    JOptionPane.showMessageDialog(CardapioSobremesaView.this, "Selecione uma sobremesa!");
                } else {
                    // Passar as informações para o controller
                    controller.sobremesaSelecionada(selectedSobremesa, precoSobremesa);
                    dispose();
                }
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
