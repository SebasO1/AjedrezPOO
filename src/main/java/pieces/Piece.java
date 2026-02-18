/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

/**
 *
 * @author Home
 */
import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import proyectoFinal.Board;

public class Piece {
    public int col,fil;
    public int xpos,ypos;
    public boolean esBlanca;
    public String nombre;
    public int valor;
    
    BufferedImage sheet;
    {
        try{
            sheet=ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    protected int Escala=sheet.getWidth()/6;
    
    Image sprite;
    
    public Board board;

    public Piece(Board board) {
        this.board = board;
    }
    
    public void pintar(Graphics2D g2d){
        g2d.drawImage(sprite, xpos,ypos,null);
    }

    public boolean esMovimientoValido(int col,int fil){return true;}
    public boolean caminoBloqueado(int col, int fil){return false;}
}
