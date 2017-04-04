package gui;

import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import static gui.MainPanel.TAG_GAME;

/**
 * Created by Thaotonto on 3/30/2017.
 */
public class StartPanel extends JPanel implements MouseListener {
    private JComboBox boxnPlayer;
    private JComboBox boxTheme;
    private Vector<String> theme = Utils.loadFile("theme.txt");
    private String[] numberOfPlayer = {"2", "3", "4"};
    private JLabel jLabel1 = new JLabel("Player1 name: ");
    private JLabel jLabel2 = new JLabel("Player2 name: ");
    private JLabel jLabel3 = new JLabel("Player3 name: ");
    private JLabel jLabel4 = new JLabel("Player4 name: ");
    private JTextField namePlayer1 = new JTextField("Player1", 25);
    private JTextField namePlayer2 = new JTextField("Player2", 25);
    private JTextField namePlayer3 = new JTextField("Player3", 25);
    private JTextField namePlayer4 = new JTextField("Player4", 25);
    private JButton playBtn = new JButton("Play");
    GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public StartPanel() {
        setLayout(new BorderLayout());
        GamePanel.getPlayerName().add(0, namePlayer1.getText());
        GamePanel.getPlayerName().add(1, namePlayer2.getText());
        GamePanel.getPlayerName().add(2, namePlayer3.getText());
        GamePanel.getPlayerName().add(3, namePlayer4.getText());
        initComp();
    }

    private void initComp() {
        boxnPlayer = new JComboBox(numberOfPlayer);
        boxnPlayer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    GamePanel.setnPlayer(boxnPlayer.getSelectedIndex() + 2);
                }
            }
        });

        boxTheme = new JComboBox(theme);
        boxTheme.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                }
            }
        });


        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));

        JPanel jPanel = new JPanel(new FlowLayout());
        JLabel jLabel = new JLabel("Number Of player: ");
        jPanel.add(jLabel);
        jPanel.add(boxnPlayer);
        panelNorth.add(jPanel);

        jPanel = new JPanel(new FlowLayout());
        jLabel = new JLabel("Theme");
        jPanel.add(jLabel);
        jPanel.add(boxTheme);
        panelNorth.add(jPanel);
        add(panelNorth, BorderLayout.NORTH);

        gridBagConstraints.insets = new Insets(40, 15, 15, 40);
        jPanel = new JPanel(new GridBagLayout());

        //Player1
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel.add(jLabel1, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
        jPanel.add(namePlayer1, gridBagConstraints);

        //Player2
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel.add(jLabel2, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
        jPanel.add(namePlayer2, gridBagConstraints);

        //Player 3
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel.add(jLabel3, gridBagConstraints);

        namePlayer3.setEnabled(false);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
        jPanel.add(namePlayer3, gridBagConstraints);


        //Player4
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel.add(jLabel4, gridBagConstraints);

        namePlayer4.setEnabled(false);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
        jPanel.add(namePlayer4, gridBagConstraints);


        add(jPanel, BorderLayout.CENTER);
        jPanel = new JPanel(new FlowLayout());
        jPanel.add(playBtn);
        playBtn.addMouseListener(this);
        add(jPanel, BorderLayout.SOUTH);
        boxnPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boxnPlayer.getSelectedItem().toString().equals("3")) {
                    namePlayer3.setEnabled(true);
                    namePlayer4.setEnabled(false);
                }
                if (boxnPlayer.getSelectedItem().toString().equals("4")) {
                    namePlayer3.setEnabled(true);
                    namePlayer4.setEnabled(true);
                }
                if (boxnPlayer.getSelectedItem().toString().equals("2")) {
                    namePlayer3.setEnabled(false);
                    namePlayer4.setEnabled(false);
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == playBtn) {
            GameFrame.mainPanel.showPanel(TAG_GAME);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}