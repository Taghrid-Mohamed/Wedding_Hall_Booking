package threads_ES;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressBarThread_ES extends Thread {

    private final JProgressBar progressBar;
    private volatile boolean running = true;

    public ProgressBarThread_ES(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void stopRunning() {
        running = false;
    }

    @Override
    public void run() {
        int value = 0;
        while (running) {
            value += 5;
            if (value > 95) {   // نخليه يلف بين 0 و 95
                value = 0;
            }

            final int v = value;
            SwingUtilities.invokeLater(() -> progressBar.setValue(v));

            try {
                Thread.sleep(150);   // يحدّث كل 0.15 ثانية
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}
