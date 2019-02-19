package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class Controller {
    @FXML
    private Button plusD;

    @FXML
    private Button minusD;

    @FXML
    private Button plusI;

    @FXML
    private Button minusI;

    @FXML
    private Slider slider;

    @FXML
    private Label incPriority;

    @FXML
    private Label decPriority;

    SliderThread incThread;
    SliderThread decThread;
    @FXML
    void initialize() {
        incThread = new SliderThread(1, slider);
        decThread = new SliderThread(-1, slider);
        incPriority.setText(Integer.toString(incThread.getPriority()));
        decPriority.setText(Integer.toString(decThread.getPriority()));

        incThread.start();
        decThread.start();
    }

    @FXML
    void increasePriorityI(ActionEvent event) {
        incThread.increasePriority();
        System.out.println("IncThread: " + incThread.getPriority());
        incPriority.setText(Integer.toString(incThread.getPriority()));

    }
    @FXML
    void decreasePriorityI(ActionEvent event) {
        incThread.decreasePriority();
        System.out.println("IncThread: " + incThread.getPriority());

        incPriority.setText(Integer.toString(incThread.getPriority()));

    }
    @FXML
    void increasePriorityD(ActionEvent event) {
        decThread.increasePriority();
        System.out.println("DecThread: " + decThread.getPriority());

        decPriority.setText(Integer.toString(decThread.getPriority()));

    }
    @FXML
    void decreasePriorityD(ActionEvent event) {
        decThread.decreasePriority();
        System.out.println("DecThread: " + decThread.getPriority());

        decPriority.setText(Integer.toString(decThread.getPriority()));

    }
}
