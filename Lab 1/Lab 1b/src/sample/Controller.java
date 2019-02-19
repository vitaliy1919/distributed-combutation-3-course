package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class Controller {
    @FXML
    private Button start1;

    @FXML
    private Button start2;

    @FXML
    private Button stop1;

    @FXML
    private Button stop2;

    @FXML
    private Slider slider;

    @FXML
    private Label label;

    private int semaphore = 0;
    SliderThread thread1;
    SliderThread thread2;
    @FXML
    void initialize() {
        thread1 = new SliderThread(10, slider);
        thread2 = new SliderThread(90, slider);
    }

    @FXML
    void start1() {
        if (semaphore != 0) {
            label.setText("Занято потоком");
            return;
        }
        label.setText("Потік 1 виконується");
        stop2.setDisable(true);
        semaphore = 1;
        thread1 = new SliderThread(10, slider);
        System.out.println("thread1 started");
        thread1.start();
    }

    @FXML
    void start2() {
        if (semaphore != 0) {
            label.setText("Занято потоком");
            return;
        }
        semaphore = 2;
        stop1.setDisable(true);
        label.setText("Потік 2 виконується");

        System.out.println("thread2 started");

        thread2 = new SliderThread(90, slider);

        thread2.start();
    }


    @FXML
    void stop1() {
        System.out.println("thread1 stoped");
        semaphore = 0;
        label.setText("Потік 1 зупинено");
        thread1.interrupt();
        stop2.setDisable(false);
    }

    @FXML
    void stop2() {
        System.out.println("thread2 stoped");
        semaphore = 0;
        label.setText("Потік 2 зупинено");
        thread2.interrupt();
        stop1.setDisable(false);
    }
}
