package IHM.UI.ZooGridElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import IHM.Content.Drawers.ImagePanel;
import IHM.UI.Panels.SidePanel;
import IHM.UI.ZooElement.CreatureImg;
import IHM.UI.ZooElement.CreatureType;
import Zoo.Creature.Creature;
import Zoo.Enclosure.Aquarium;
import Zoo.Enclosure.Aviary;
import Zoo.Enclosure.Enclosure;

import static Zoo.Widget.Widget.RandomNumberGenerator.generateRandomNumber;

public class EnclosureIHM extends JPanel {
    private final List<CreatureImg> creatureImgs;
    private final JPanel creaturePanel;
    private final MutableInteger currentLevel;
    private final String enclosureName;
    private SidePanel sidePanel;
    private boolean isInitialized;
    private final Enclosure enclosure;
    private Random random;

    public List<CreatureImg> getCreatureImgs() {
        return creatureImgs;
    }

    public EnclosureIHM(Integer level, String name, SidePanel sidePanel, String type, List<Creature> creatures, List<EnclosureIHM> enclosureIHMS) {//, SidePanel sidePanel
        this.currentLevel = new MutableInteger(level);
        this.enclosureName = name;
        this.sidePanel = sidePanel;
        this.creatureImgs = new ArrayList<>();
        this.random = new Random();
        this.isInitialized = false;
        //Mettre le bon enclos en fonction de son type
        ImagePanel imagePanel = null;
        switch (type.toLowerCase()){
            case "aquarium":
                this.enclosure = new Aquarium(name,(int)generateRandomNumber(2,8),(int)generateRandomNumber(1,5));
                imagePanel = new ImagePanel("/IHM/Content/Images/enclosure-water.png");
                break;
            case "aviary":
                this.enclosure = new Aviary(name,(int)generateRandomNumber(5,15));
                imagePanel = new ImagePanel("/IHM/Content/Images/enclosure-aviary.png");
                break;
            default:
                this.enclosure = new Enclosure(name,null);
                imagePanel = new ImagePanel("/IHM/Content/Images/enclosure-earth.png");
                break;
        }
        setLayout(new BorderLayout());



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
                for (CreatureImg creatureImg : creatureImgs) {
                    ImageIcon imageIcon = creatureImg.getImageIcon();
                    Point position = creatureImg.getPosition();
                    g.drawImage(imageIcon.getImage(), position.x, position.y, null);
                }
            }
        };
        creaturePanel.setOpaque(false);
        imagePanel.add(creaturePanel, BorderLayout.CENTER);

        add(imagePanel, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (enclosure.getClass().getSimpleName().toLowerCase().equals("aquarium")) {
                    // Si c'est un aquarium, afficher ses caractéristiques
                    sidePanel.updateInfo(enclosure.getName(), enclosure.getLevel(), creatures, enclosure, enclosureIHMS);
                    enclosure.displayCharacteristics();
                } else if(enclosure.getClass().getSimpleName().toLowerCase().equals("aviary")){
                    sidePanel.updateInfo(enclosure.getName(), enclosure.getLevel(), creatures, enclosure, enclosureIHMS);
                    enclosure.displayCharacteristics();
                }else {
                    // Sinon, afficher les caractéristiques de l'enclos par défaut

                    enclosure.displayCharacteristics();
                    sidePanel.updateInfo(enclosure.getName(), enclosure.getLevel(), creatures, enclosure, enclosureIHMS);
                }
            }
        });

    }
    public Enclosure getEnclosure(){
        return enclosure;
    }
    private void initializeCreatures(Random random) {
        for (CreatureImg creatureImg : creatureImgs) {
            int panelWidth = creaturePanel.getWidth();
            int panelHeight = creaturePanel.getHeight();
            int imageWidth = creatureImg.getImageIcon().getIconWidth();
            int imageHeight = creatureImg.getImageIcon().getIconHeight();

            int x = random.nextInt(Math.max(1, panelWidth - imageWidth));
            int y = random.nextInt(Math.max(1, panelHeight - imageHeight));

            creatureImg.setPosition(x, y);
        }
        updateCreaturePanel();
    }

    public void addCreatureImg(CreatureImg creatureImg) {

        creatureImgs.add(creatureImg);
        if (isInitialized) {
            int panelWidth = creaturePanel.getWidth();
            int panelHeight = creaturePanel.getHeight();
            int imageWidth = creatureImg.getImageIcon().getIconWidth();
            int imageHeight = creatureImg.getImageIcon().getIconHeight();

            int x = random.nextInt(Math.max(1, panelWidth - imageWidth));
            int y = random.nextInt(Math.max(1, panelHeight - imageHeight));

            creatureImg.setPosition(x, y);

        }
    }


    public void removeCreatureImg(CreatureImg creatureImg) {
        creatureImgs.remove(creatureImg);
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
    public static void addCreatureImgToEnclosure(List<EnclosureIHM> enclosureIHMS){

        for (EnclosureIHM enclosureIHM: enclosureIHMS){
            enclosureIHM.getCreatureImgs().clear();
            if(!enclosureIHM.getEnclosure().getCreaturesPresent().isEmpty()) {
                for (int i = 0; i < enclosureIHM.getEnclosure().getCreaturesPresent().size(); i++) {
                    enclosureIHM.addCreatureImg(new CreatureImg(enclosureIHM.getEnclosure().getCreaturesPresent().get(i).getName(), CreatureType.getType(enclosureIHM.getEnclosure().getCreaturesPresent().get(i).getSpecies())));
                }

            }
            enclosureIHM.repaint();
        }



    }




}
