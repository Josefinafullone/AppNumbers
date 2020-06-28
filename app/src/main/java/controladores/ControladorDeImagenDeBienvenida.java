package controladores;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ControladorDeImagenDeBienvenida {

    private Context context;

    public ControladorDeImagenDeBienvenida(Context context) {
        this.context = context;
    }

    public int getImageId() {

        String[] arrayImages = {"tristeza","rayoo", "jessie"};
        Random random = new Random();
        int randomNumber =  random.nextInt(arrayImages.length);

        return context.getResources().getIdentifier(arrayImages[randomNumber], "drawable", context.getPackageName());


    }

}
