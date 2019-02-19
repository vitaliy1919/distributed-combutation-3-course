package sample;

import javafx.scene.control.Slider;

public class SliderThread extends PriorityThread {
    private int valueChange;
    private Slider slider;

    public SliderThread(int value, Slider slider) {
        this.valueChange = valueChange;
        this.slider = slider;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (slider){
                slider.setValue(slider.getValue() + valueChange);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
