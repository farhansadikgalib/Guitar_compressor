package com.farhan.guitarcompressor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.DynamicsProcessing;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.gauravk.audiovisualizer.visualizer.WaveVisualizer;

import it.beppi.knoblibrary.Knob;

public class MainActivity extends AppCompatActivity  {



    boolean isRecording = false;
    AudioManager am = null;
    AudioRecord record = null;
    AudioTrack track = null;

    ImageView startButton,stopButton,clixk;
    TextView show_state;
    Knob knob;
    WaveVisualizer mVisualizer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.MODE_IN_COMMUNICATION);

        knob = (Knob) findViewById(R.id.knob);
        show_state = findViewById(R.id.text_view_threshold);
        mVisualizer = findViewById(R.id.blast);



        //////////Record & play
        initRecordAndTrack();

        am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        am.setSpeakerphoneOn(true);


        (new Thread()
        {
            @Override
            public void run()
            {
                recordAndPlay();
            }
        }).start();
         startButton =  findViewById(R.id.audio_Play);


      startButton =  findViewById(R.id.audio_Play);
        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startButton.setVisibility(View.GONE);
                stopButton.setVisibility(View.VISIBLE);
                if (!isRecording)
                {
                    startRecordAndPlay();







                }
            }
        });
       stopButton =  findViewById(R.id.audio_stop);
        stopButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.GONE);

                if (isRecording)
                {
                    stopRecordAndPlay();
                }
            }
        });





















        ///alert dialog

        clixk = findViewById(R.id.hacker);

        clixk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.alartdialog);
                dialog.show();


            }
        });
















//////////knob





        knob.setState(0);

        knob.setOnStateChanged(new Knob.OnStateChanged() {
            @Override
            public void onState(int state) {
                // do something


                //show_state.setText(state);
                show_state.setText(String.valueOf(state));

                switch (state) {

                    case 0:
                        track.play();
                        break;
                    case 1:
                        track.play();
                        break;
                    case 2:
                        track.play();
                        break;

                    case 3:
                        track.play();

                        break;

                    case 4:
                        track.play();
                        break;

                    case 5:
                        track.play();
                        // Toast.makeText(MainActivity.this, "You", Toast.LENGTH_SHORT).show();
                        break;

                    case 6:
                        track.play();
                        break;
                    case 7:
                        track.play();
                        break;

                    case 8:
                        track.play();
                        break;


                    case 9:
                        track.play();
                        break;
                    case 10:
                        track.play();
                        break;


                }




            }
        });



    }




    private void initRecordAndTrack()
    {
        int min = AudioRecord.getMinBufferSize(8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        record = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION, 8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,
                min);
        if (AcousticEchoCanceler.isAvailable())
        {
            AcousticEchoCanceler echoCancler = AcousticEchoCanceler.create(record.getAudioSessionId());
            echoCancler.setEnabled(true);
        }
        int maxJitter = AudioTrack.getMinBufferSize(8000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
        track = new AudioTrack(AudioManager.MODE_IN_COMMUNICATION, 8000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, maxJitter,
                AudioTrack.MODE_STREAM);
    }

    private void recordAndPlay()
    {
        short[] lin = new short[1024];
        int num = 0;
        am.setMode(AudioManager.MODE_IN_COMMUNICATION);
        while (true)
        {
            if (isRecording)
            {
                num = record.read(lin, 0, 1024);
                track.write(lin, 0, num);
            }
        }
    }

    private void startRecordAndPlay()
    {
       // int xx;
        record.startRecording();
        track.play();
       // xx= record.getAudioSessionId();
       // Toast.makeText(this, ""+xx, Toast.LENGTH_SHORT).show();
        
        isRecording = true;



        // track.





        int audioSessionId = track.getAudioSessionId();

        if (audioSessionId != -1){
            mVisualizer.setAudioSessionId(audioSessionId);

        }



    }

    private void stopRecordAndPlay()
    {
        record.stop();
        track.pause();
        isRecording = false;
    }


    ////////back press

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you really want to exit ?").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

///////////////about me


    public void facebook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/farhansadikgalib"));
        startActivity(i);
        return ;

    }

    public void github(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://github.com/farhansadikgalib"));
        startActivity(i);
        return ;
    }

    public void aboutme(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.fiverr.com/users/farhaansadik"));
        startActivity(i);
        return ;


    }



//////////////////////////





}