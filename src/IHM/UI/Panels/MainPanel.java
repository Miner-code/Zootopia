package IHM.UI.Panels;

import IHM.Content.Drawers.ImagePanel;
import IHM.UI.ZooElement.CreatureImg;
import IHM.UI.ZooElement.CreatureType;
import IHM.UI.ZooGridElement.EmptyZone;
import IHM.UI.ZooGridElement.EnclosureIHM;

import javax.swing.*;
import java.awt.*;
import java.util.List;


import IHM.Content.Drawers.ImageButton;
import Zoo.Creature.Creature;
import Zoo.Enclosure.Enclosure;
import Zoo.Game.Turn;

import java.util.Random;


public class MainPanel extends JPanel {

    private SidePanel sidePanel;
    private Random random;


    public MainPanel(SidePanel sidePanel, List<Creature> creatures, List<EnclosureIHM> enclosureIHMS) {
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

        // Ajouter 4 enclos a IHM et créer  4instance EnclosureIMH qui appellera enclosur
        for (int i = 1; i <= 12; i++) {

            EnclosureIHM enclosureIHM = new EnclosureIHM(0, "Enclos" + i, sidePanel);
            enclosureIHMS.add(enclosureIHM);
            gridPanel.add(enclosureIHM);

            // ajouter les créature a l'enclos
            if (i-1 < creatures.size() && creatures.get(i-1) != null) {
                Creature creature = creatures.get(i-1);
                // Transfère la créature à l'enclos
                Enclosure.makeTransfer(creature, null, enclosureIHM);
            }


        }

        gridPanel.add(addNextTurn(creatures, enclosureIHMS));
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

    public JPanel addNextTurn(List<Creature> creatures,List<EnclosureIHM> enclosureIHMS) {
        JPanel nextTurn = new JPanel(new BorderLayout());
        nextTurn.setBackground(Color.GRAY);


        ImageButton nextTurnButton = new ImageButton("/IHM/Content/Images/Buttons/button-next-turn.png");
        nextTurnButton.addActionListener(e ->
                new Turn(creatures,enclosureIHMS)
        );

        nextTurn.add(nextTurnButton, BorderLayout.CENTER);

        return nextTurn;
    }
}
