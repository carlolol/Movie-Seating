package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeatingArrangementUI extends JPanel {

    private int rows = 5;
    private int columns = 8;
    private Icon res = (UIManager.getIcon("OptionPane.errorIcon"));
    private SystemUI systemUI;
    private JPanel centerP;
    
    public SeatingArrangementUI(SystemUI systemUI) 
    {
    	setLayout(new GridLayout(1, 1));
    	
    	this.systemUI = systemUI;
        centerP = new JPanel(new GridLayout(rows, columns));
        
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                final JToggleButton button = new JToggleButton("Row " + row + " seat " + column);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                        boolean selected = abstractButton.getModel().isSelected();
                        if (selected) {
                            button.setIcon(res);
                        } else {
                            button.setIcon(null);
                        }
                    }
                });
                centerP.add(button);
            }
        }
        validate();
        
        add(centerP);
    }
}