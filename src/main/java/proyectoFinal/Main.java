/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyectoFinal;

/**
 *
 * @author Home
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setTitle("AJEDREZ");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(700, 700)); // Corrección aquí
        frame.setLocationRelativeTo(null);

        Board board = new Board();
        board.agregarFichas();
        frame.add(board);

        frame.setVisible(true);
        board.repaint();
    }
}
