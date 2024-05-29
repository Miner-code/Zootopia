package IHM.UI.Panels;

import IHM.Content.Drawers.ImagePanel;
import IHM.UI.ZooElement.CreatureImg;
import IHM.UI.ZooElement.CreatureType;
import IHM.UI.ZooGridElement.EmptyZone;
import IHM.UI.ZooGridElement.Enclosure;

import javax.swing.*;
import java.awt.*;
import java.util.List;


import IHM.Content.Drawers.ImageButton;
import Zoo.Creature.Creature;
import Zoo.Game.Turn;

import java.util.Random;


public class MainPanel extends JPanel {

    private SidePanel sidePanel;
    private Random random;


    public MainPanel(SidePanel sidePanel, List<Creature> creatures) {
        this.sidePanel = sidePanel;
        this.random = new Random();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int mainPanelWidth = (int) (screenWidth * 0.65);
        int screenHeight = (int) screenSize.getHeight();

        setLayout(new BorderLayout());

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(mainPanelWidth, screenHeight));

        ImagePanel backgroundPanel = new ImagePanel("/IHM/Content/Images/bg-zoo-bottom.png");
        backgroundPanel.setBounds(0, 0, mainPanelWidth, screenHeight);
        backgroundPanel.setOpaque(false);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 50, 50));
        gridPanel.setOpaque(false);

        for (int i = 1; i <= 12; i++) {
            Enclosure enclosure = new Enclosure(0, "Enclosure " + i, sidePanel,creatures);
            enclosure.addCreature(new CreatureImg("Creature " + (i * 2 - 1), CreatureType.getRandomType()));
            enclosure.addCreature(new CreatureImg("Creature " + (i * 2), CreatureType.getRandomType()));
            gridPanel.add(enclosure);
        }
        gridPanel.add(addNextTurn(creatures));
        gridPanel.add(new EmptyZone());
        gridPanel.add(new EmptyZone());
        gridPanel.add(new EmptyZone());


        gridPanel.setBounds(50, 50, (mainPanelWidth - 100), (screenHeight - 100));
        layeredPane.add(gridPanel, JLayeredPane.PALETTE_LAYER);

        ImagePanel topPanel = new ImagePanel("/IHM/Content/Images/bg-zoo-top.png");
        topPanel.setOpaque(false);
        topPanel.setBounds(0, 0, mainPanelWidth, screenHeight);
        layeredPane.add(topPanel, JLayeredPane.POPUP_LAYER);

        add(layeredPane, BorderLayout.CENTER);
    }

    public JPanel addNextTurn(List<Creature> creatures) {
        JPanel nextTurn = new JPanel(new BorderLayout());
        nextTurn.setBackground(Color.GRAY);


        ImageButton nextTurnButton = new ImageButton("/IHM/Content/Images/Buttons/button-next-turn.png");
        nextTurnButton.addActionListener(e ->
                new Turn(creatures)
        );

        nextTurn.add(nextTurnButton, BorderLayout.CENTER);

        return nextTurn;
    }
}
