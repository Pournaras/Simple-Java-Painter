package frame_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    PaintOptionsPanel paintOptionsPanel = new PaintOptionsPanel();

    Canvas canvas = new Canvas();

    static JLabel sizeLabel = new JLabel();

    MyFrame(){
        this.setTitle("Java Painter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(800,600);

        addComponents();

        this.setVisible(true);

    }

    private void addComponents(){

        addToOptionsPanel();

        add(canvas);
        add(paintOptionsPanel);
    }

    private void addToOptionsPanel(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(25,0,0,0);

        ChooseColorButton chooseColorButton = new ChooseColorButton("Choose Color");
        gbc.gridy=0;
        paintOptionsPanel.add(chooseColorButton, gbc);

        SizeSlider sizeSlider = new SizeSlider(0, 200, 25);
        gbc.gridy=1;
        paintOptionsPanel.add(sizeSlider,gbc);
        gbc.gridy=2;
        paintOptionsPanel.add(sizeLabel,gbc);

        JButton clearCanvasButton = new JButton("Clear Canvas");
        clearCanvasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                canvas.clearCanvas();
            }
        });
        gbc.gridy=3;
        paintOptionsPanel.add(clearCanvasButton,gbc);
    }

    public static void setSizeLabel(String text){

        sizeLabel.setText(text);
    }
}
