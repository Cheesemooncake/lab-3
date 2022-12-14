package com.example.t;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.application.Platform;

public class HelloController {

    @FXML
    Button button;
    private TT t;
    public void onHelloButtonClick() {
        t = new TT(button);
        t.start();
    }
}

class T implements Runnable {

    private Thread t;

    private Button button;

    public T(Button button) {
        this.button = button;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        Thread tt = Thread.currentThread();
        while (true) {
            Platform.runLater(new Runnable() {
                public void run() {
                    button.setText((int)(Math.random() * 10) + 1 + "");
                }
            });
            try {tt.sleep(1000);} catch(Exception e) {};
        }
    }
}

class TT extends Thread {

    private Button button;

    public TT(Button button) {
        this.button = button;
    }

    @Override
    public void run() {
        Thread tt = Thread.currentThread();
        while (true) {
            Platform.runLater(new Runnable() {
                public void run() {
                    button.setText((int)(Math.random() * 10) + 1 + "");
                }
            });
            try {tt.sleep(1000);} catch(Exception e) {};
        }
    }
}