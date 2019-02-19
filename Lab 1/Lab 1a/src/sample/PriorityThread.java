package sample;

public class PriorityThread extends Thread {
    void increasePriority() {
        if (getPriority() < 10) {
            setPriority(getPriority() + 1);
        }
    }
    void decreasePriority() {
        if (getPriority() > 1) {
            setPriority(getPriority() - 1);
        }
    }
}
