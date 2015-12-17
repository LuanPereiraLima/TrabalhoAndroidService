package sd4mp.dc.ufc.br.boundsevice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by loopback on 16/12/15.
 */
public class CalculadoraService extends Service {

    private final IBinder calculadoraService = new BinderCalculadora();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return calculadoraService;
    }

    public class BinderCalculadora extends Binder{
        CalculadoraService getService(){
            return CalculadoraService.this;
        }
    }

    public float soma(float a, float b){
        return a+b;
    }

    public float subtracao(float a, float b){
        return a-b;
    }

    public float multiplicacao(float a, float b){
        return a*b;
    }

    public float divisao(float a, float b){
        return a/b;
    }


}
