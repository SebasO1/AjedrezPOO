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

public class Torre extends Piece{
    
    public Torre(Board board, int col, int fil, boolean esBlanca) {
        super(board);
        this.col=col;
        this.fil=fil;
        this.xpos=col*board.tamano;
        this.ypos=fil*board.tamano;
        this.esBlanca=esBlanca;
        this.nombre="Torre";
        
        this.sprite=sheet.getSubimage(4*Escala,esBlanca? 0:Escala,Escala,Escala).getScaledInstance(board.tamano, board.tamano, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public boolean esMovimientoValido(int col,int fil){
        return this.col==col||this.fil==fil;
    }
    @Override
    public boolean caminoBloqueado(int col, int fil) {
        // derecha
        if (this.col < col) {
            for (int i = this.col + 1; i < col; i++) { 
                if (board.obtenerFicha(i, this.fil) != null) {
                    return true; // Hay una pieza bloqueando el camino
                }
            }
        }
        //izquierda
        else if (this.col > col) {
            for (int i = this.col - 1; i > col; i--) {
                if (board.obtenerFicha(i, this.fil) != null) {
                    return true;
                }
            }
        }
        //arriba
        else if (this.fil > fil) {
            for (int i = this.fil - 1; i > fil; i--) {
                if (board.obtenerFicha(this.col, i) != null) {
                    return true;
                }
            }
        }
        //abajo
        else if (this.fil < fil) {
            for (int i = this.fil + 1; i < fil; i++) {
                if (board.obtenerFicha(this.col, i) != null) {
                    return true;
                }
            }
        }

        return false; 
    }
    
}
