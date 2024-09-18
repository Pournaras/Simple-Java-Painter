package frame_package;

import javax.swing.JColorChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseColorButton extends JButton{

    ChooseColorButton(String name){
        super(name);
        this.setSize(50,25);
        this.setBackground(Color.black);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JColorChooser colorChooser = new JColorChooser();

                Color color = JColorChooser.showDialog(null,"Choose Color",Color.black);

                Canvas.setColor(color);

                setBackground(color);
            }
        });
    }


}
