
package pieces;

import java.awt.image.BufferedImage;
import proyectoFinal.Board;


public class Caballo extends Piece{
    
    public Caballo(Board board, int col, int fil, boolean esBlanca) {
        super(board);
        this.col=col;
        this.fil=fil;
        this.xpos=col*board.tamano;
        this.ypos=fil*board.tamano;
        this.esBlanca=esBlanca;
        this.nombre="Caballo";
        
        this.sprite=sheet.getSubimage(3*Escala,esBlanca? 0:Escala,Escala,Escala).getScaledInstance(board.tamano, board.tamano, BufferedImage.SCALE_SMOOTH);
    }
    
    @Override
    public boolean esMovimientoValido(int col,int fil){
        return Math.abs(col-this.col)*Math.abs(fil-this.fil)==2;
    }
}
