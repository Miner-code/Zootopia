package IHM.UI.Panels;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The type Text area output stream.
 */
public class TextAreaOutputStream extends OutputStream {
    private final JTextArea textArea;

    /**
     * Instantiates a new Text area output stream.
     *
     * @param textArea the text area
     */
    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        textArea.append(new String(b, off, len));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
