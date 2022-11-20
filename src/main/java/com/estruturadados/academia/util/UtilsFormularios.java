/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.util;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author lab202a
 */
public class UtilsFormularios {

    public static void setPosicao(JInternalFrame frame, JDesktopPane panel) {
        int larguraPane = panel.getWidth();
        int alturaPane = panel.getHeight();
        int larguraJInternalFrame = panel.getWidth();
        int alturaJInternalFrame = frame.getHeight();

        frame.setLocation(larguraPane / 2  - larguraJInternalFrame / 2, alturaPane / 2 - alturaJInternalFrame / 2);
    }
}
