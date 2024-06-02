package IHM.UI.Buttons;

import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;
import Zoo.Enclosure.Enclosure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

public class ButtonAddCreature extends JButton {
    public ButtonAddCreature(Enclosure enclosure, List<Creature> creatures, List<EnclosureIHM> enclosureIHMS) {
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/IHM/Content/Images/Buttons/button_addcreature.png")));
        Image scaledImage = originalIcon.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        setIcon(scaledIcon);
        setBorderPainted(false);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JDialog dialog = new JDialog((Frame) null, "Create New Creature", true);
                dialog.setLayout(new GridLayout(0, 2));

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameField = new JTextField();

                dialog.add(nameLabel);
                dialog.add(nameField);

                String species = "";
                switch (enclosure.getClass().getSimpleName().toLowerCase()){
                    case "aviary" -> {
                        String[] options = {"Dragon", "Phoenix"};
                        int choice = JOptionPane.showOptionDialog(
                                null,
                                "Choisir l'espèce",
                                "Vol",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]
                        );
                        species = options[choice];
                        break;
                    }
                    case "aquarium" -> {
                        String[] options = {"Kraken", "Megalodon","Mermaid"};
                        int choice = JOptionPane.showOptionDialog(
                                null,
                                "Choisir l'espèce",
                                "Eau",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]
                        );
                        species = options[choice];
                        break;
                    }
                    default -> {
                        String[] options = {"Wirewolf", "Unicorn","Nymph"};
                        int choice = JOptionPane.showOptionDialog(
                                null,
                                "Choisir l'espèce",
                                "Terre",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]
                        );
                        species = options[choice];
                        break;
                    }
                }


                JButton okButton = new JButton("OK");
                JButton cancelButton = new JButton("Cancel");

                dialog.add(okButton);
                dialog.add(cancelButton);

                String finalSpecies = species;
                okButton.addActionListener(event -> {
                    String name = nameField.getText();
                    
                    Creature.addCreature(name,finalSpecies,creatures,enclosure,enclosureIHMS);
                    dialog.dispose();
                });

                cancelButton.addActionListener(event -> {
                    dialog.dispose();
                });

                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
}
