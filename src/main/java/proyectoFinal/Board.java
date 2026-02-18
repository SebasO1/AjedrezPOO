/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoFinal;

/**
 *
 * @author Home
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import pieces.Alfil;
import pieces.Caballo;
import pieces.Peon;
import pieces.Piece;
import pieces.Reina;
import pieces.Rey;
import pieces.Torre;

public class Board extends JPanel {
    public int tamano = 60;

    int cols = 8;
    int rows = 8;

    Entrada entrada=new Entrada(this);
    public boolean turnoBlancas = true;
    
    ArrayList<Piece> listaFichas=new ArrayList<>();
    public Board(){
        this.setPreferredSize(new Dimension(cols*tamano,rows*tamano));
        this.addMouseListener(entrada);
        this.addMouseMotionListener(entrada);
    }

    public Piece obtenerFicha(int col, int fil){
        for(Piece ficha:listaFichas){
            if(ficha.fil==fil && ficha.col==col){
                return ficha;
            }
        }
        return null;
    }
    
    public Piece fichaSeleccionada;
    
    public void hacerMovimiento(Movimiento movimiento) { 
        if (!validarMovimiento(movimiento)) {
            return; 
    }

    movimiento.ficha.col = movimiento.colNueva;
    movimiento.ficha.fil = movimiento.filaNueva;
    movimiento.ficha.xpos = movimiento.colNueva * tamano;
    movimiento.ficha.ypos = movimiento.filaNueva * tamano;
    captura(movimiento);
    turnoBlancas = !turnoBlancas;
    
}
    
    public void captura(Movimiento movimiento){
        if (movimiento.captura != null) { 
        listaFichas.remove(movimiento.captura); 
        }
    }
    
    public boolean mismoColor(Piece f1,Piece f2){
        if(f1==null || f2==null){
            return false;
        }
        return f1.esBlanca==f2.esBlanca;
    }
    
    public boolean validarMovimiento(Movimiento movimiento) {
        if (movimiento.ficha.esBlanca != turnoBlancas) {
            return false;
        }
        if (mismoColor(movimiento.ficha, movimiento.captura)) {
            return false;
        }
        if (!movimiento.ficha.esMovimientoValido(movimiento.colNueva, movimiento.filaNueva)) {
            return false;
        }
        if (movimiento.ficha.caminoBloqueado(movimiento.colNueva, movimiento.filaNueva)) {
            return false;
        }
        if (movimiento.captura instanceof Rey) {
            return false;
        }

        return true;
    }
    
    
    public void agregarFichas(){
        //fichas negras
        listaFichas.add(new Caballo(this, 1, 0, false));
        listaFichas.add(new Caballo(this, 6, 0, false));
        listaFichas.add(new Torre(this, 0, 0, false));
        listaFichas.add(new Torre(this, 7, 0, false));
        listaFichas.add(new Alfil(this, 2, 0, false));
        listaFichas.add(new Alfil(this, 5, 0, false));
        listaFichas.add(new Reina(this, 3, 0, false));
        listaFichas.add(new Rey(this, 4, 0, false));
        listaFichas.add(new Peon(this, 0, 1, false));
        listaFichas.add(new Peon(this, 1, 1, false));
        listaFichas.add(new Peon(this, 2, 1, false));
        listaFichas.add(new Peon(this, 3, 1, false));
        listaFichas.add(new Peon(this, 4, 1, false));
        listaFichas.add(new Peon(this, 5, 1, false));
        listaFichas.add(new Peon(this, 6, 1, false));
        listaFichas.add(new Peon(this, 7, 1, false));
        
        //fichas blancas
        listaFichas.add(new Caballo(this, 1, 7, true));
        listaFichas.add(new Caballo(this, 6, 7, true));
        listaFichas.add(new Torre(this, 0, 7, true));
        listaFichas.add(new Torre(this, 7, 7, true));
        listaFichas.add(new Alfil(this, 2, 7, true));
        listaFichas.add(new Alfil(this, 5, 7, true));
        listaFichas.add(new Reina(this, 3, 7, true));
        listaFichas.add(new Rey(this, 4, 7, true));
        listaFichas.add(new Peon(this, 0, 6, true));
        listaFichas.add(new Peon(this, 1, 6, true));
        listaFichas.add(new Peon(this, 2, 6, true));
        listaFichas.add(new Peon(this, 3, 6, true));
        listaFichas.add(new Peon(this, 4, 6, true));
        listaFichas.add(new Peon(this, 5, 6, true));
        listaFichas.add(new Peon(this, 6, 6, true));
        listaFichas.add(new Peon(this, 7, 6, true));
    }
            
            
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        //Colorea el tablero
        for (int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                g2d.setColor((c + r) % 2 == 0 ? new Color(255,255,255) : new Color(80,80,80));
                g2d.fillRect(c*tamano, r*tamano, tamano, tamano);
            }
        }
        //Colorea de verde si se puede hacer el movimiento
        if(fichaSeleccionada!=null){
            for (int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(validarMovimiento(new Movimiento(this,fichaSeleccionada,i,j))){
                        g2d.setColor(new Color(100,100,150));
                        g2d.fillRect(i*tamano, j*tamano, tamano, tamano);
                    }
                }
            }
            
        }
        //Colorea las piezas
        for(Piece ficha:listaFichas){
                ficha.pintar(g2d);
        }

    }

}