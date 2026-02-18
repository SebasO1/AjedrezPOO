/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

/**
 *
 * @author Home
 */
import java.awt.image.BufferedImage;
import proyectoFinal.Board;

public class Alfil extends Piece{
    
    public Alfil(Board board, int col, int fil, boolean esBlanca) {
        super(board);
        this.col=col;
        this.fil=fil;
        this.xpos=col*board.tamano;
        this.ypos=fil*board.tamano;
        this.esBlanca=esBlanca;
        this.nombre="Alfil";
        
        this.sprite=sheet.getSubimage(2*Escala,esBlanca? 0:Escala,Escala,Escala).getScaledInstance(board.tamano, board.tamano, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public boolean esMovimientoValido(int col,int fil){
        return Math.abs(this.col-col)==Math.abs(this.fil-fil);
    }
    @Override
    public boolean caminoBloqueado(int col, int fil) {
        // Arriba derecha
        if (this.col < col && this.fil>fil) {
            for (int i = 1; i < Math.abs(this.col-col); i++) { 
                if (board.obtenerFicha(this.col +i, this.fil-i) != null) {
                    return true; // Hay una pieza bloqueando el camino
                }
            }
        }
        // Arriba izquierda
        if (this.col > col && this.fil>fil) {
            for (int i = 1; i < Math.abs(this.col-col); i++) { 
                if (board.obtenerFicha(this.col -i, this.fil-i) != null) {
                    return true; // Hay una pieza bloqueando el camino
                }
            }
        }
        // Abajo izquierda
        if (this.col > col && this.fil<fil) {
            for (int i = 1; i < Math.abs(this.col-col); i++) { 
                if (board.obtenerFicha(this.col -i, this.fil+i) != null) {
                    return true; // Hay una pieza bloqueando el camino
                }
            }
        }
        // Abajo derecha
        if (this.col < col && this.fil<fil) {
            for (int i = 1; i < Math.abs(this.col-col); i++) { 
                if (board.obtenerFicha(this.col +i, this.fil+i) != null) {
                    return true; // Hay una pieza bloqueando el camino
                }
            }
        }
        return false; 
    }
}
