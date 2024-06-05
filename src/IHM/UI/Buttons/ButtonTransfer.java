package IHM.UI.Buttons;

import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Creature;
import Zoo.Enclosure.*;
import Zoo.Enclosure.Enclosure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class ButtonTransfer extends JButton {

    public ButtonTransfer(Creature creature, Enclosure sourceEnclosure,List<EnclosureIHM> enclosureIHMs) {
        super("Transfer");
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/IHM/Content/Images/Buttons/button-clear-up.png")));

        // Resize the original image to the desired size
        Image scaledImage = originalIcon.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Load the pressed image (left click pressed)
        ImageIcon pressedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/IHM/Content/Images/Buttons/button-clear-down.png")));

        // Resize the pressed image to the desired size
        Image scaledPressedImage = pressedIcon.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledPressedIcon = new ImageIcon(scaledPressedImage);

        setIcon(scaledIcon); // Set the original image as the button icon
        setBorderPainted(false); // Remove the button border
        setContentAreaFilled(false); // Remove the content area fill


        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                Class<? extends Enclosure> enclosureType;

                switch (sourceEnclosure.getClass().getSimpleName().toLowerCase()) {
                    case "aviary":
                        enclosureType = Aviary.class;
                        break;
                    case "aquarium":
                        enclosureType = Aquarium.class;
                        break;
                    default:
                        enclosureType = Enclosure.class;
                        break;
                }

                List<Enclosure> targetEnclosureIHMs = Enclosure.enclosuresWithFreeSpace(enclosureIHMs,sourceEnclosure.getClass().getSimpleName());


                if (targetEnclosureIHMs.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Aucun enclos libre pour un transfert");
                    return;
                }

                JDialog dialog = new JDialog((Frame) null, "Transfer Creature", true);
                dialog.setLayout(new BorderLayout());
                    JComboBox<Enclosure> enclosureComboBox = new JComboBox<>(targetEnclosureIHMs.toArray(new Enclosure[0]));
                    dialog.add(enclosureComboBox, BorderLayout.CENTER);

                JButton confirmButton = new JButton("Confirm");
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Enclosure destinationEnclosure = (Enclosure) enclosureComboBox.getSelectedItem();
                        if (destinationEnclosure != null) {
                            System.out.println(creature);
                            Enclosure.makeTransfer(creature, sourceEnclosure, destinationEnclosure);
                            JOptionPane.showMessageDialog(null, creature.getName() + " has been transferred to " + destinationEnclosure.getName());
                            EnclosureIHM.addCreatureImgToEnclosure(enclosureIHMs);
                        }
                        dialog.dispose();
                    }
                });

                dialog.add(confirmButton, BorderLayout.SOUTH);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
}