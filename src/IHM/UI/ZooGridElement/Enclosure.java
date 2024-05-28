package IHM.UI.ZooGridElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import IHM.Content.Drawers.ImagePanel;
import IHM.UI.Panels.SidePanel;
import IHM.UI.ZooElement.Creature;

public class Enclosure extends JPanel {
    private List<Creature> creatures;
    private JPanel creaturePanel;
    private MutableInteger currentLevel;
    private String enclosureName;
    private SidePanel sidePanel;
    private Random random;
    private boolean isInitialized;

    public Enclosure(Integer level, String name, SidePanel sidePanel) {
        this.currentLevel = new MutableInteger(level);
        this.enclosureName = name;
        this.sidePanel = sidePanel;
        this.creatures = new ArrayList<>();
        this.random = new Random();
        this.isInitialized = false;

        setLayout(new BorderLayout());
        ImagePanel imagePanel = new ImagePanel("/IHM/Content/Images/enclosure-earth.png");
        imagePanel.setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel(name);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel levelLabel = new JLabel("Level: " + level);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setOpaque(false);
        infoPanel.add(nameLabel);
        infoPanel.add(levelLabel);
        imagePanel.add(infoPanel, BorderLayout.CENTER);

        creaturePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Creature creature : creatures) {
                    ImageIcon imageIcon = creature.getImageIcon();
                    Point position = creature.getPosition();
                    g.drawImage(imageIcon.getImage(), position.x, position.y, null);
                }
            }
        };
        creaturePanel.setOpaque(false);
        imagePanel.add(creaturePanel, BorderLayout.CENTER);

        add(imagePanel, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentLevel.increment();
                sidePanel.updateInfo(enclosureName, currentLevel.getValue(), creatures);
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (!isInitialized) {
                    isInitialized = true;
                    initializeCreatures();
                }
            }
        });
    }

    private void initializeCreatures() {
        for (Creature creature : creatures) {
            int panelWidth = creaturePanel.getWidth();
            int panelHeight = creaturePanel.getHeight();
            int imageWidth = creature.getImageIcon().getIconWidth();
            int imageHeight = creature.getImageIcon().getIconHeight();

            int x = random.nextInt(Math.max(1, panelWidth - imageWidth));
            int y = random.nextInt(Math.max(1, panelHeight - imageHeight));

            creature.setPosition(x, y);
        }
        updateCreaturePanel();
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
        if (isInitialized) {
            int panelWidth = creaturePanel.getWidth();
            int panelHeight = creaturePanel.getHeight();
            int imageWidth = creature.getImageIcon().getIconWidth();
            int imageHeight = creature.getImageIcon().getIconHeight();

            int x = random.nextInt(Math.max(1, panelWidth - imageWidth));
            int y = random.nextInt(Math.max(1, panelHeight - imageHeight));

            creature.setPosition(x, y);
            updateCreaturePanel();
        }
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
        updateCreaturePanel();
    }

    private void updateCreaturePanel() {
        creaturePanel.revalidate();
        creaturePanel.repaint();
    }

    private static class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void increment() {
            value++;
        }
    }
}
