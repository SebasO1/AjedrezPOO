package pieces;


import java.awt.image.BufferedImage;
import proyectoFinal.Board;


public class Peon extends Piece{
    
    public Peon(Board board, int col, int fil, boolean esBlanca) {
        super(board);
        this.col=col;
        this.fil=fil;
        this.xpos=col*board.tamano;
        this.ypos=fil*board.tamano;
        this.esBlanca=esBlanca;
        this.nombre="Peon";
        
        this.sprite=sheet.getSubimage(5*Escala,esBlanca? 0:Escala,Escala,Escala).getScaledInstance(board.tamano, board.tamano, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public boolean esMovimientoValido(int col, int fil) {
        // Verifica si el movimiento es hacia adelante una casilla
        if (this.col == col && ((esBlanca && fil == this.fil - 1) || (!esBlanca && fil == this.fil + 1)) && board.obtenerFicha(col, fil) == null) {
            return true;
        }

        // Verifica si es el primer movimiento y se mueve dos casillas hacia adelante
        if (this.col == col && ((esBlanca && fil == this.fil - 2) || (!esBlanca && fil == this.fil + 2)) && board.obtenerFicha(col, fil) == null) {
            if (esBlanca && this.fil == 6 || !esBlanca && this.fil == 1) {
                return true;
            }
        }

        // Verifica si el movimiento es una captura en diagonal
        if (Math.abs(this.col - col) == 1 && ((esBlanca && fil == this.fil - 1) || (!esBlanca && fil == this.fil + 1))) {
            Piece piezaCapturada = board.obtenerFicha(col, fil);
            if (piezaCapturada != null && !board.mismoColor(this, piezaCapturada)) {
                return true;
                
            }
        }

        return false; // El movimiento no es válido
    }

    @Override
    public boolean caminoBloqueado(int col, int fil) {
        // Bloqueo de los peones: solo importa el camino hacia adelante (sin diagonales)
        if (this.col == col) {
            // Verificar si se mueve dos casillas en su primer movimiento
            if (esBlanca && fil == this.fil - 2) {
                if (board.obtenerFicha(col, this.fil - 1) != null) {
                    return true;
                }
            } else if (!esBlanca && fil == this.fil + 2) {
                if (board.obtenerFicha(col, this.fil + 1) != null) {
                    return true;
                }
            }
            // Verificar si se mueve una casilla
            if (board.obtenerFicha(col, fil) != null) {
                return true; // Hay una pieza bloqueando
            }
        }
        return false; // No hay bloqueo en el camino
    }
}