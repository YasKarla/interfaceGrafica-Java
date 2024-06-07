package view;

import controller.LanchoneteControllerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardapioLancheView extends JFrame {

    private LanchoneteControllerImpl controller;

    public CardapioLancheView(LanchoneteControllerImpl controller) {
        this.controller = controller;
        exibirLanche();
    }

    public void exibirLanche() {
        setTitle("Cardápio Lanche");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.ORANGE);

        JLabel tituloLabel = new JLabel("Cardápio lanche");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(tituloLabel, constraints);

        String[] opcoesLanche = {"X-Bacon", "X-Salada", "X-Egg", "X-Cheddar"};
        double[] precos = {10.0, 12.0, 9.0, 11.5}; // Preços correspondentes aos lanches

        JCheckBox[] checkboxes = new JCheckBox[opcoesLanche.length];

        ButtonGroup checkBoxGroup = new ButtonGroup();

        for (int i = 0; i < opcoesLanche.length; i++) {
            checkboxes[i] = new JCheckBox(opcoesLanche[i] + " - R$" + precos[i]); // Adiciona o preço ao texto da opção
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
        constraints.gridy = opcoesLanche.length + 1;
        constraints.gridwidth = 2;
        panel.add(botaoConfirma, constraints);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLanche = null;
                double precoLanche = 0.0; // Preço do lanche selecionado
                for (int i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].isSelected()) {
                        selectedLanche = opcoesLanche[i];
                        precoLanche = precos[i];
                        break;
                    }
                }

                if (selectedLanche == null) {
                    JOptionPane.showMessageDialog(CardapioLancheView.this, "Selecione um lanche!");
                } else {
                    // Passar as informações para o controller
                    controller.lancheSelecionado(selectedLanche, precoLanche);
                    dispose();
                    CardapioRefriView view = new CardapioRefriView(controller);
                }
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
