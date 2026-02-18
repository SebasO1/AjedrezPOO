/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoFinal;

import pieces.Piece;

/**
 *
 * @author Home
 */
public class Movimiento {
    int colAnterior;
    int filaAnterior;
    int colNueva;
    int filaNueva;
    
    Piece ficha;
    Piece captura;

    public Movimiento( Board board, Piece ficha, int colNueva, int filaNueva) {
        this.ficha = ficha;
        this.colNueva = colNueva;
        this.filaNueva = filaNueva;
        this.colAnterior=ficha.col;
        this.filaAnterior=ficha.fil;
        this.captura = ficha.board.obtenerFicha(colNueva,filaNueva);
    }
    
            
}
