package sd4mp.dc.ufc.br.startedsevicelifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartSeviceActivity extends AppCompatActivity {

    Intent service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_sevice_acevity);

        service = new Intent(this, MyService.class);
    }

    public void stop(View view){
        stopService(service);
    }

    public void start(View view){
        startService(service);
    }
}
