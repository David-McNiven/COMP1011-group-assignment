package georgian.general.goods.gui;

import javax.swing.JFrame;

public class TestClass {
    public static void main (String[] args){
        GeorgianGeneralGoodsGUI gooey = new GeorgianGeneralGoodsGUI();
        gooey.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gooey.pack();
        gooey.setLocationRelativeTo(null);
        gooey.setVisible(true);
    }
}
