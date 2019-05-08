import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class App extends JFrame {
    ImageIcon circle = new ImageIcon("src/circle.png");
    ImageIcon cross = new ImageIcon("src/cross.png");
    int k0;
    int k1;
    int k2;
    int k3;
    int k4;
    int k5;
    int k6;
    int k7;
    int k8;
    int j;
    JLabel[] jLabels;
    JButton jButton=new JButton("restart");

    public App() {


        initUI();
    }

    public void Restart(){
        for(int i=0;i<9;i++){
            jLabels[i].setIcon(null);
        }
        k0=0;
        k1=0;
        k2=0;
        k3=0;
        k4=0;
        k5=0;
        k6=0;
        k7=0;
        k8=0;
        j=0;
    }

    private void initUI() {

        jButton.setSize(100,30);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restart();
                System.out.println("hi");

            }
        });
        var labels = new ArrayList<JLabel>();

        for (int i = 0; i < 9; i++) {

            var lbl = createColouredLabel(Color.lightGray);
            labels.add(lbl);
        }
        jLabels = labels.toArray(new JLabel[labels.size()]);
        createLayout(labels.toArray(new JLabel[labels.size()]));

        jLabels[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k0==0){
                    k0++;
                if(j%2==0){
                    jLabels[0].setIcon(circle);
                    j++;

                }
                else {
                    jLabels[0].setIcon(cross);
                    j++;

                }
                    if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");

                }

            }

        });
        jLabels[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k1==0){
                    k1++;
                    if(j%2==0){
                        jLabels[1].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[1].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });
        jLabels[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k2==0){
                    k2++;
                    if(j%2==0){
                        jLabels[2].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[2].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });
        jLabels[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k3==0){
                    k3++;
                    if(j%2==0){
                        jLabels[3].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[3].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });
        jLabels[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k4==0){
                    k4++;
                    if(j%2==0){
                        jLabels[4].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[4].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });
        jLabels[5].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k5==0){
                    k5++;
                    if(j%2==0){
                        jLabels[5].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[5].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });
        jLabels[6].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k6==0){
                    k6++;
                    if(j%2==0){
                        jLabels[6].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[6].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });
        jLabels[7].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k7==0){
                    k7++;
                    if(j%2==0){
                        jLabels[7].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[7].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });
        jLabels[8].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(k8==0){
                    k8++;
                    if(j%2==0){
                        jLabels[8].setIcon(circle);
                        j++;
                    }
                    else {
                        jLabels[8].setIcon(cross);
                        j++;
                    }if(k0+k1+k2+k3+k4+k5+k6+k7+k8==9)
                        JOptionPane.showMessageDialog(null,"Game Over");
                }
            }

        });


        setTitle("TicTacToe");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel createColouredLabel(Color col) {

        var lbl = new MyLabel();
        lbl.setMinimumSize(new Dimension(150, 150));
        lbl.setBackground(col);

        return lbl;
    }

    private void createLayout(JLabel[] labels) {

        var pane = (JPanel) getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        pane.setToolTipText("Content pane");

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(jButton)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(labels[0])
                        .addComponent(labels[1])
                        .addComponent(labels[2]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(labels[3])
                        .addComponent(labels[4])
                        .addComponent(labels[5]))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(labels[6])
                        .addComponent(labels[7])
                        .addComponent(labels[8]))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(jButton)
                .addGroup(gl.createParallelGroup()
                        .addComponent(labels[0])
                        .addComponent(labels[1])
                        .addComponent(labels[2]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(labels[3])
                        .addComponent(labels[4])
                        .addComponent(labels[5]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(labels[6])
                        .addComponent(labels[7])
                        .addComponent(labels[8]))
        );

        pack();
    }


    public static void main(String[] args) {


        JFrame jFrame = new App();


        jFrame.setVisible(true);

    }


}
