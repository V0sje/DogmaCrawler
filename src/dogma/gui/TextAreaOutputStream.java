/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogma.gui;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author arjen
 */
public class TextAreaOutputStream extends OutputStream {
        private javax.swing.JTextArea jTextArea1;

        /**
         * Creates a new instance of TextAreaOutputStream which writes
         * to the specified instance of javax.swing.JTextArea control.
         *
         * @param textArea   A reference to the javax.swing.JTextArea
         *                 control to which the output must be redirected to.
         */
        
        public TextAreaOutputStream( JTextArea textArea ) {
            this.jTextArea1 = textArea;
        }

        public void write( int b ) throws IOException {
            jTextArea1.append( String.valueOf( ( char )b ) );
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        }

        public void write(char[] cbuf, int off, int len) throws IOException {
            jTextArea1.append(new String(cbuf, off, len));
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        }
    }