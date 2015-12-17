package sd4mp.dc.ufc.br.startedsevicebybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StartSeviceActivity extends AppCompatActivity {

    Intent service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        service = new Intent(this, MyService.class);

        registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_BOOT_COMPLETED));
    }

    public void stop(View view){
        stopService(service);
    }

    BroadcastReceiver mybroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("exclusivo", "MyReceiver");
            startService(service);
        }
    };


}
