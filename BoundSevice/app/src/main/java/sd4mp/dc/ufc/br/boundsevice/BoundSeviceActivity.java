package sd4mp.dc.ufc.br.boundsevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BoundSeviceActivity extends AppCompatActivity {

    private CalculadoraService service;
    boolean isBound = false;
    private EditText n1;
    private EditText n2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_sevice);
        Intent intent = new Intent(this, CalculadoraService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        n1 = (EditText) findViewById(R.id.edtN1);
        n2 = (EditText) findViewById(R.id.edtN2);
        resultado = (TextView) findViewById(R.id.txtResultado);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder serv) {
            CalculadoraService.BinderCalculadora binder = (CalculadoraService.BinderCalculadora) serv;
            service = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    public void somar(View view){
        if(isBound){
            resultado.setText(service.soma(Float.parseFloat(n1.getText().toString()), Float.parseFloat(n2.getText().toString())) + "");
        }
    }

    public void subtrair(View view){
        if(isBound){
            resultado.setText(service.subtracao(Float.parseFloat(n1.getText().toString()), Float.parseFloat(n2.getText().toString()))+"");
        }
    }

    public void multiplicar(View view){
        if(isBound){
            resultado.setText(service.multiplicacao(Float.parseFloat(n1.getText().toString()), Float.parseFloat(n2.getText().toString()))+"");
        }
    }

    public void dividir(View view){
        if(isBound){
            resultado.setText(service.divisao(Float.parseFloat(n1.getText().toString()), Float.parseFloat(n2.getText().toString()))+"");
        }
    }
}
