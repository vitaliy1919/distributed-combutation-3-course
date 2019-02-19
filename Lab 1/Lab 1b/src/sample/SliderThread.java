package sample;

import javafx.scene.control.Slider;

public class SliderThread extends PriorityThread {
    private int value;
    private Slider slider;

    public SliderThread(int value, Slider slider) {
        this.value = value;
        this.slider = slider;
    }

    @Override
    public void run() {
        try {
            while (true) {
                slider.setValue(value);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
