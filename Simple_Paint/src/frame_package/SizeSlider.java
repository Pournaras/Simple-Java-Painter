package frame_package;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SizeSlider extends JSlider{

    SizeSlider(int min, int max, int start){
        super(min,max,start);
        this.setPreferredSize(new Dimension(150,50));
        this.setPaintTicks(true);
        this.setMinorTickSpacing(10);
        this.setPaintTrack(true);
        this.setMajorTickSpacing(50);
        this.setPaintLabels(true);

        MyFrame.setSizeLabel("Brush size: "+this.getValue());
        Canvas.setSize(getValue());

        this.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e){
                MyFrame.setSizeLabel("Brush size: "+getValue());
                Canvas.setSize(getValue());
            }
        });

    }


}
