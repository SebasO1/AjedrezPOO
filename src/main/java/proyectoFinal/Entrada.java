/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoFinal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import pieces.Piece;

/**
 *
 * @author Home
 */
public class Entrada extends MouseAdapter {
    
    Board board;

    public Entrada(Board board) {
        this.board = board;
    }
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        int col =e.getX()/board.tamano;
        int fil= e.getY()/board.tamano;
        
        Piece fichaXY = board.obtenerFicha(col, fil);
        if(fichaXY!=null){
            board.fichaSeleccionada=fichaXY;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(board.fichaSeleccionada!=null){
            board.fichaSeleccionada.xpos=e.getX()-board.tamano/2;
            board.fichaSeleccionada.ypos=e.getY()-board.tamano/2;
            
            board.repaint();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        int col =e.getX()/board.tamano;
        int fil= e.getY()/board.tamano;
        if (board.fichaSeleccionada!=null){
            Movimiento movimiento=new Movimiento(board,board.fichaSeleccionada,col,fil);
            if(board.validarMovimiento(movimiento)){
                board.hacerMovimiento(movimiento);
            }
            else {
                board.fichaSeleccionada.xpos=board.fichaSeleccionada.col*board.tamano;
                board.fichaSeleccionada.ypos=board.fichaSeleccionada.fil*board.tamano;
            }
        }
        board.fichaSeleccionada=null;
        board.repaint();
    }


    
    
}
