
package pieces;


import java.awt.image.BufferedImage;
import proyectoFinal.Board;

public class Reina extends Piece{
    
    public Reina(Board board, int col, int fil, boolean esBlanca) {
        super(board);
        this.col=col;
        this.fil=fil;
        this.xpos=col*board.tamano;
        this.ypos=fil*board.tamano;
        this.esBlanca=esBlanca;
        this.nombre="Reina";
        
        this.sprite=sheet.getSubimage(1*Escala,esBlanca? 0:Escala,Escala,Escala).getScaledInstance(board.tamano, board.tamano, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public boolean esMovimientoValido(int col,int fil){
        return ((this.col==col||this.fil==fil)||Math.abs(this.col-col)==Math.abs(this.fil-fil));
        
    }
    @Override
    public boolean caminoBloqueado(int col, int fil) {
        
        if(this.col==col||this.fil==fil){
            // derecha
            if (this.col < col) {
                for (int i = this.col + 1; i < col; i++) { 
                    if (board.obtenerFicha(i, this.fil) != null) {
                        return true; 
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
        }
        else{
            // Arriba derecha
            if (this.col < col && this.fil>fil) {
                for (int i = 1; i < Math.abs(this.col-col); i++) { 
                    if (board.obtenerFicha(this.col +i, this.fil-i) != null) {
                        return true; 
                    }
                }
            }
            // Arriba izquierda
            if (this.col > col && this.fil>fil) {
                for (int i = 1; i < Math.abs(this.col-col); i++) { 
                    if (board.obtenerFicha(this.col -i, this.fil-i) != null) {
                        return true;
                    }
                }
            }
            // Abajo izquierda
            if (this.col > col && this.fil<fil) {
                for (int i = 1; i < Math.abs(this.col-col); i++) { 
                    if (board.obtenerFicha(this.col -i, this.fil+i) != null) {
                        return true; 
                    }
                }
            }
            // Abajo derecha
            if (this.col < col && this.fil<fil) {
                for (int i = 1; i < Math.abs(this.col-col); i++) { 
                    if (board.obtenerFicha(this.col +i, this.fil+i) != null) {
                        return true; 
                    }
                }
            }
        }
        
        return false; 
    }
    
}