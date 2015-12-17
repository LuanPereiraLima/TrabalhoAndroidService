package sd4mp.dc.ufc.br.startedsevicelifecycle;

import android.app.Service;
        import android.content.Intent;
        import android.os.IBinder;
        import android.support.annotation.Nullable;
        import android.util.Log;

/**
 * Created by loopback on 16/12/15.
 */
public class MyService extends Service implements Runnable{
    static final String LOG = "log";
    public boolean running = true;
    public Thread thread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void run() {
        int i = 0;
        while (running && i <= 10) {
            Log.i(LOG ,"("+ i++ +") MyService is running!!!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }
        running = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(LOG, "onstartcommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LOG, "oncreate");
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(LOG, "onstart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG, "ondestroy");
        thread.interrupt();
        running = false;
    }
}

