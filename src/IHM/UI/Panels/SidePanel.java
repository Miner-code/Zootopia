package IHM.UI.Panels;

import IHM.Content.Drawers.ImagePanel;
import IHM.MainGamePanel;
import IHM.UI.Buttons.ButtonClear;
import IHM.UI.Buttons.ButtonClose;
import IHM.UI.Buttons.ButtonTransfer;
import IHM.UI.Buttons.ButtonUpgrade;
import IHM.UI.ZooElement.CreatureImg;
import IHM.UI.ZooGridElement.EnclosureIHM;
import Zoo.Creature.Action.Health;
import Zoo.Creature.Action.Hungry;
import Zoo.Creature.Action.Slept;
import Zoo.Creature.Creature;
import Zoo.Enclosure.Enclosure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.util.List;

public class SidePanel extends JPanel {

    private JLabel enclosureNameLabel;
    private JLabel levelLabel;
    private JPanel creaturesListPanel;
    private JPanel dynamicButtonPanel; // Panel pour les boutons dynamiques
    private JButton cleanButton;
    private JButton upgradeButton;
    private JButton closeButton;
    private JPanel buttonPanel;
    private JTextArea consoleTextArea;

    private MainGamePanel mainGamePanel;

    private boolean enclosureSelected = false;

    public SidePanel(MainGamePanel mainGamePanel) {
        this.mainGamePanel = mainGamePanel;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int sidePanelWidth = (int) (screenWidth * 0.35);
        int screenHeight = (int) screenSize.getHeight();

        setLayout(new BorderLayout());

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(sidePanelWidth, screenHeight));

        ImagePanel backgroundPanel = new ImagePanel("/IHM/Content/Images/bg-side.png");
        backgroundPanel.setBounds(0, 0, sidePanelWidth, screenHeight);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        JPanel contentPanel = new JPanel(new GridLayout(2, 1));
        contentPanel.setOpaque(false);

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.setOpaque(false);

        enclosureNameLabel = new JLabel("");
        levelLabel = new JLabel("");

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        Color labelColor = new Color(139, 69, 19);

        enclosureNameLabel.setFont(labelFont);
        enclosureNameLabel.setForeground(labelColor);
        levelLabel.setFont(labelFont);
        levelLabel.setForeground(labelColor);

        labelPanel.add(enclosureNameLabel, BorderLayout.WEST);
        labelPanel.add(levelLabel, BorderLayout.EAST);

        infoPanel.add(labelPanel, BorderLayout.NORTH);

        creaturesListPanel = new JPanel();
        creaturesListPanel.setLayout(new BoxLayout(creaturesListPanel, BoxLayout.Y_AXIS));
        creaturesListPanel.setOpaque(false);
        infoPanel.add(new JScrollPane(creaturesListPanel), BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setVisible(false);

        JPanel zone1 = new JPanel(new BorderLayout());
        zone1.setOpaque(false);
        zone1.add(infoPanel, BorderLayout.NORTH);
        zone1.add(buttonPanel, BorderLayout.SOUTH);

        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);
        consoleTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        consoleTextArea.setForeground(Color.WHITE);
        consoleTextArea.setBackground(Color.BLACK);
        consoleTextArea.setMargin(new Insets(50, 50, 50, 50));

        JScrollPane consoleScrollPane = new JScrollPane(consoleTextArea);
        consoleScrollPane.setOpaque(false);
        consoleScrollPane.getViewport().setOpaque(false);

        JPanel zone2 = new JPanel(new BorderLayout());
        zone2.setOpaque(false);
        zone2.add(consoleScrollPane, BorderLayout.CENTER);

        contentPanel.add(zone1);
        contentPanel.add(zone2);

        contentPanel.setBounds(0, 0, sidePanelWidth, screenHeight);
        layeredPane.add(contentPanel, JLayeredPane.PALETTE_LAYER);

        add(layeredPane, BorderLayout.CENTER);

        closeButton = new ButtonClose();
        buttonPanel.add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enclosureNameLabel.setText("");
                levelLabel.setText("");
                creaturesListPanel.removeAll();
                creaturesListPanel.revalidate();
                creaturesListPanel.repaint();
                buttonPanel.removeAll();
                buttonPanel.add(closeButton); // Ajouter à nouveau le bouton de fermeture
                enclosureSelected = false;
            }
        });

        PrintStream consoleStream = new PrintStream(new TextAreaOutputStream(consoleTextArea));
        System.setOut(consoleStream);
        System.setErr(consoleStream);
    }

    public void updateInfo(String name, int level, List<Creature> creatures, Enclosure enclosure) {
        SwingUtilities.invokeLater(() -> {
            enclosureNameLabel.setText(name);
            levelLabel.setText("Level: " + level);

            creaturesListPanel.removeAll();
            buttonPanel.removeAll();
            for (Creature creature : creatures) {
                JPanel creaturePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                creaturePanel.setOpaque(false);

                JLabel creatureImageLabel = new JLabel(creature.getName());
                JLabel creatureNameLabel = new JLabel(creature.getClass().getTypeName());
                creatureNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                creatureNameLabel.setForeground(Color.WHITE);

                creaturePanel.add(creatureImageLabel);
                creaturePanel.add(creatureNameLabel);

                creatureNameLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        JButton infoButton = new JButton("Info");
                        infoButton.addActionListener(event -> {
                            JOptionPane.showMessageDialog(null, creature.toString(), "Voici les informations de " + creature.getName(), JOptionPane.INFORMATION_MESSAGE);
                        });

                        JButton feedButton = new JButton("Feed");
                        feedButton.addActionListener(event -> {
                            Hungry.eat(creature);
                        });

                        JButton sleepButton = new JButton("Dormir");
                        sleepButton.addActionListener(event -> {
                            Slept.sleep(creature);
                        });

                        JButton diseaseButton = new JButton("Soigner");
                        diseaseButton.addActionListener(event -> {
                            Health.disease(creature);
                        });


                        if(creature.getSlept().getCntTurnBeforeSleep() == creature.getSlept().getNeedSleep()){
                             sleepButton.setEnabled(false);
                         }else{
                            sleepButton.setEnabled(true);
                        }

                        if(creature.getHealth().getSick() == 0 ){
                            diseaseButton.setEnabled(false);
                        }else{
                            diseaseButton.setEnabled(true);
                        }

                        if (dynamicButtonPanel != null) {
                            buttonPanel.remove(dynamicButtonPanel);
                        }
                        dynamicButtonPanel = new JPanel();
                        dynamicButtonPanel.add(infoButton);
                        dynamicButtonPanel.add(feedButton);
                        dynamicButtonPanel.add(sleepButton);
                        dynamicButtonPanel.add(diseaseButton);

                        buttonPanel.add(dynamicButtonPanel);
                        buttonPanel.revalidate();
                        buttonPanel.repaint();
                    }
                });

                creaturesListPanel.add(creaturePanel);
            }

            buttonPanel.add(new ButtonClear(enclosure));
            buttonPanel.add(new ButtonUpgrade(enclosure));

            creaturesListPanel.revalidate();
            creaturesListPanel.repaint();
            buttonPanel.revalidate();
            buttonPanel.repaint();

            if (!enclosureSelected) {
                buttonPanel.setVisible(true);
                enclosureSelected = true;
            }
        });
    }
}
