import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPanel;
    JPanel topP;
    ImageIcon icon;
    JLabel topLabel;
    JPanel midP;
    JTextArea textArea;
    JScrollPane scroll;
    JPanel botP;
    JLabel botLabel;
    JButton quitBtn;
    JButton getFortune = new JButton("Read My Fortune");
    int savedValue = -1;
    int value;

    static ArrayList<String> fortunes = new ArrayList<String>();
        static {
            fortunes.add("Look left three times before turning right.");
            fortunes.add("Sometimes the best path is straight ahead.");
            fortunes.add("Forget about past mistakes, make new ones.");
            fortunes.add("Sleep as if you left your refrigerator running.");
            fortunes.add("The third blind mouse is the most cautious.");
            fortunes.add("The key is under the doormat.");
            fortunes.add("Stop worrying about spelling errors, there hear to.");
            fortunes.add("The dog gets the bone always.");
            fortunes.add("Your lucky numbers are 8675309");
            fortunes.add("+24 Reddit Karma");
            fortunes.add("The password for my phone is 12345");
            fortunes.add("Brazil will win the World Cup!");
        }
    public FortuneTellerFrame() {
        super("Great Fortune");
        mainPanel = new JPanel();
        topPanel();
        midPanel();
        botPanel();
        mainPanel.add(topP);
        mainPanel.add(midP);
        mainPanel.add(botP);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);
    }

        private void topPanel(){
            topP = new JPanel();
            icon = new ImageIcon("src/fortune.png");
            topLabel = new JLabel("Great Fortune", icon, JLabel.CENTER);
            topLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,36));
            topLabel.setHorizontalTextPosition(JLabel.CENTER);
            topLabel.setVerticalTextPosition(JLabel.NORTH);
            topP.add(topLabel);
        }
        private void midPanel(){
            midP = new JPanel();
            textArea = new JTextArea("",8,35);
            textArea.setFont(new Font("Serif",Font.ITALIC,20));
            textArea.setEditable(false);
            scroll = new JScrollPane(textArea);
            midP.add(scroll);
        }
        private void botPanel(){
            botP = new JPanel();
            botLabel = new JLabel();
            quitBtn = new JButton("Quit");
            quitBtn.addActionListener((ActionEvent ae) -> {System.exit(0);});
            getFortune = new JButton("Read My Fortune");
            getFortune.addActionListener(new fortuneListener());
            botP.add(quitBtn);
            botP.add(getFortune);


        }
        public class fortuneListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                do {
                    value = random.nextInt(11);
                }while (savedValue == value);
                savedValue = value;
                textArea.append(fortunes.get(value) + "\n");
            }
        }
}
