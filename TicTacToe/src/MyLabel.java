import javax.swing.*;

public class MyLabel extends JLabel {
    MyLabel(){
        super("", null, LEADING);
    }
    @Override
    public boolean isOpaque() {
        return true;
    }
}
