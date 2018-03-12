package com.demo.tomcat.jobservicedemo;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class JobSchedulerService extends JobService
{
    private static final String TAG = JobSchedulerService.class.getSimpleName();

    public JobSchedulerService()
    {}

    @Override
    public boolean onStartJob(JobParameters params)
    {
        Log.d(TAG, "onStartJob()...");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params)
    {
        Log.d(TAG, "onStopJob()...");

        return false;
    }




}

