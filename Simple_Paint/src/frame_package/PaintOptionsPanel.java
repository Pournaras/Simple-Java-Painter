package frame_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintOptionsPanel extends JPanel{

    PaintOptionsPanel(){

        this.setBackground(Color.gray);
        this.setBounds(0, 0, 199, 600);
        this.setLayout(new GridBagLayout());
        this.setVisible(true);

    }

}