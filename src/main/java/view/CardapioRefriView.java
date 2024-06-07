package view;

import controller.LanchoneteControllerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardapioRefriView extends JFrame {

    private LanchoneteControllerImpl controller;

    public CardapioRefriView(LanchoneteControllerImpl controller) {
        this.controller = controller;
        exibirRefri();
    }

    public void exibirRefri() {
        setTitle("Cardápio Refrigerante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.ORANGE);

        JLabel tituloLabel = new JLabel("Cardápio Refrigerante");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(tituloLabel, constraints);

        String[] opcoesRefri = {"Coca-Cola", "Fanta-Uva", "Energético", "Guaraná"};
        double[] precosRefri = {4.0, 3.5, 5.0, 4.5}; // Preços correspondentes aos refrigerantes

        JCheckBox[] checkboxes = new JCheckBox[opcoesRefri.length];

        ButtonGroup checkBoxGroup = new ButtonGroup();

        for (int i = 0; i < opcoesRefri.length; i++) {
            checkboxes[i] = new JCheckBox(opcoesRefri[i] + " - R$" + precosRefri[i]); // Adiciona o preço ao texto da opção
            checkBoxGroup.add(checkboxes[i]);

            // Adiciona cor de fundo
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
        constraints.gridy = opcoesRefri.length + 1;
        constraints.gridwidth = 2;
        panel.add(botaoConfirma, constraints);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRefri = null;
                double precoRefri = 0.0; // Preço do refrigerante selecionado
                for (int i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].isSelected()) {
                        selectedRefri = opcoesRefri[i];
                        precoRefri = precosRefri[i];
                        break;
                    }
                }

                if (selectedRefri == null) {
                    JOptionPane.showMessageDialog(CardapioRefriView.this, "Selecione um refrigerante!");
                } else {
                    // Passar as informações para o controller
                    controller.refrigeranteSelecionado(selectedRefri, precoRefri);
                    dispose();
                    CardapioSobremesaView view = new CardapioSobremesaView(controller);
                }
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
