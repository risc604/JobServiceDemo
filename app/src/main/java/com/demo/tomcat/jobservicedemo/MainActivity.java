package com.demo.tomcat.jobservicedemo;

import android.app.AlarmManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


//  https://foolcodefun.github.io/blog/android/2018/01/08/Android-JobSchedule.html


public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int JOB_TEST = 11;

    private Button btnSetting;
    private boolean enable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initControl();

    }


    //--------------------- User define function ---------------------------------------//
    private void initView()
    {
        Log.d(TAG, "initView()...");

        btnSetting = findViewById(R.id.btnStart);
    }

    private void initControl()
    {
        Log.d(TAG, "initControl()...");

        enable = false;
        btnSetting.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                enable = enable == false ? true : false;
                Log.d(TAG, "onClick(), enable: " + enable);
                schedulJob(enable);
            }
        });

    }

    public void schedulJob(boolean enable)
    {
        Log.d(TAG, "schedulJob(), enable: " + enable);
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        if (enable) {
            JobInfo jobInfo = new JobInfo.Builder(
                    JOB_TEST
                    ,new ComponentName(getPackageName()
                    ,JobSchedulerService.class.getName()))
                    .setPersisted(true)
                    .setPeriodic(AlarmManager.INTERVAL_FIFTEEN_MINUTES)
                    .build();
            jobScheduler.schedule(jobInfo);
        }
        else
        {
            Log.d(TAG, "");
            jobScheduler.cancel(JOB_TEST);
        }

    }
}

