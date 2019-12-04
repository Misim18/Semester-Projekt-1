package com.group4.gui;

import javafx.application.Platform;
import java.io.OutputStream;
import java.io.IOException;
import javafx.scene.control.TextArea;

public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char)b));
        }
}
