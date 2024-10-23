import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordFrame extends JFrame {
    private JPanel panel;
    private JButton b,r;
    private JTextField result;
    private GridBagLayout bagLayout;
    private GridBagConstraints gbc;
    private Password p=null;
    public PasswordFrame(){
        this.setTitle("Password Generator");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300,200));
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        p= new Password();

        panel = new JPanel();
        bagLayout =new GridBagLayout();
        panel.setLayout(bagLayout);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,5,5,5);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        panel.add(new JLabel("Password Generator "),gbc);

        gbc.gridy=1;
        b=new JButton("Generate Password");

        panel.add(b,gbc);

        gbc.gridy=2;
        r = new JButton("Clear");
        panel.add(r,gbc);

        gbc.gridy=3;
        panel.add(new JLabel("Generated Password : "),gbc);

        gbc.gridy=4;
        result=new JTextField("Password will be displayed here....");
        result.setEditable(false);
        result.setVisible(true);
        result.setSize(new Dimension(180,30));
        result.setBackground(Color.lightGray);
        panel.add(result,gbc);


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Generate Password")){
                    result.setText(p.generatePassword());
                }
            }
        });

        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Clear")){
                result.setText("");
            }
            }
        });
        //Adding panel to frame
        this.add(panel);
//        this.pack();
    }

}
