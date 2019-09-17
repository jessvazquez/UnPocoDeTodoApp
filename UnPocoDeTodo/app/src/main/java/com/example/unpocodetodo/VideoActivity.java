package com.example.unpocodetodo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //Inicializamos la clase VideoView asociandole el fichero de Video

        video = (VideoView) findViewById(R.id.videoView);
       // String path = "android.resource://" + getPackageName() + "/" + R.raw.drift;
        // video.setVideoURI(Uri.parse("https://r1---sn-q4fl6nle.googlevideo.com/videoplayback?expire=1568077779&ei=cqN2Xe2uO-XQ8gP-1KyABQ&ip=179.61.131.48&id=o-AMIg5wZ6mdFYO3VjUJKQHN1hCWA0M5bIx3rkGs2PxeG5&itag=18&source=youtube&requiressl=yes&mime=video%2Fmp4&gir=yes&clen=68170773&ratebypass=yes&dur=2004.996&lmt=1553888485337703&fvip=1&c=WEB&txp=2211222&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=ALgxI2wwRQIhAPmYd6OG_F0KY-DRfbSrnq6liHR6D4fZK3fZ8BIl7gdbAiAZa3BQjWljTcHXxMllsloxbSt32AdXWuGarge6bRkudQ%3D%3D&video_id=smPjbSQQu10&title=Usar+GPS+y+mostrar+en+Maps+en+Android+Studio&rm=sn-ab5e767e&req_id=8dd2c8840b20a3ee&ipbypass=yes&cm2rm=sn-hxb5j5cax-uajz7e,sn-ug5onuxajv-gxme7r,sn-q4feel7e&redirect_counter=4&cms_redirect=yes&mip=177.247.118.225&mm=34&mn=sn-q4fl6nle&ms=ltu&mt=1568056107&mv=m&mvi=0&pl=22&lsparams=ipbypass,mip,mm,mn,ms,mv,mvi,pl&lsig=AHylml4wRgIhAItR4CB77qTLtlYuOW0fmAidIo1SL7G47Ks-lE1Y54_RAiEA8TfC3_GiuGI7gdpnJNg3QaMQDr_2-_5cQ6HEzHETTT8="));
        //video.setVideoURI(Uri.parse(path));

        //Obtenemos los tres botones de la interfaz
        btnPlay = (Button) findViewById(R.id.buttonPlay);
        btnStop = (Button) findViewById(R.id.buttonStop);
        btnPause = (Button) findViewById(R.id.buttonPause);

        //Y les asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPause.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch (v.getId()) {
            case R.id.buttonPlay:
                //Iniciamos el video
                video.start();
                break;
            case R.id.buttonPause:
                //Pausamos el video
                video.pause();
                break;
            case R.id.buttonStop:
                //Paramos el video y volvemos a inicializar

                video.stopPlayback();
                video.seekTo(0);


                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

