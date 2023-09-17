package quanlysieuthimini.GUI.MyButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FileButton extends JButton {

    public FileButton() {
        this.setIcon(new ImageIcon(this.getClass().getResource("/Images/add.png")));
    }
}
