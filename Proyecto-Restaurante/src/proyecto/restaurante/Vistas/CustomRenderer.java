/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import proyecto.restaurante.Entidades.Mesero;

/**
 *
 * @author Emito
 */
public class CustomRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        if (value != null){
                setSize(20,100);
                //setForeground(Color.black);
            Mesero mesero = (Mesero) value;
            if (mesero.isEstado()){
                setForeground(Color.black);
            }else{
                setForeground(Color.red);
            }
            if (this.isEnabled()){
            setText(mesero.toString());
            }else{
                System.out.println("Hola");
            }
        }
        return this;
    }
}
