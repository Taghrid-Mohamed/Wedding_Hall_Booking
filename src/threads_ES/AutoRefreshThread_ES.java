package threads_ES;

import gui_TM.ReportsView_TM;

public class AutoRefreshThread_ES extends Thread {

    private ReportsView_TM reportsView;
    private boolean running = true;
    private int intervalMillis = 10000; // كل 10 ثواني

    public AutoRefreshThread_ES(ReportsView_TM reportsView) {
        this.reportsView = reportsView;
    }

    public void stopRefreshing() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(intervalMillis);

                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        reportsView.refreshFromThread();
                    }
                });

            } catch (InterruptedException ex) {
                running = false;
            }
        }
    }
}
