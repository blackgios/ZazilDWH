/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileFilterPDF extends FileFilter{

    @Override
    public boolean accept(File f) {
        //throw new UnsupportedOperationException("Not supported yet.");
        boolean opcion = false;
        if(f.isDirectory()){
            opcion = true;
        }
        String nombre = f.getName().toLowerCase();
        if(nombre != null){
            if(nombre.endsWith(".pdf"));
            opcion = true;
        }
        return opcion;
    }

    @Override
    public String getDescription() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return " Filtro *.pdf";
    }
    
}
