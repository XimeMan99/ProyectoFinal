/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JMenuItem;

/**
 *
 * @author Koka
 */
public class ObjetoPerdido {
    public String detalles, fecha, lugar;
    public int alumno_cod_alumno,cod_objeto;
    public JMenuItem item;
    
    public ObjetoPerdido()
    {
        this.alumno_cod_alumno = 0;
        this.detalles = fecha = lugar = "";
    }
}
