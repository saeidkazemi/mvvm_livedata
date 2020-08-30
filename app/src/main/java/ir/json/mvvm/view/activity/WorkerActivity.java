package ir.json.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import ir.json.mvvm.R;
import ir.json.mvvm.utils.Vmanager;

public class WorkerActivity extends AppCompatActivity {
    WorkManager workManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        Data.Builder data = new Data.Builder().putString("tag","download");
        Constraints.Builder constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED);
        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(Vmanager.class,1, TimeUnit.MINUTES)
                .setInputData(data.build())
                .setConstraints(constraints.build())
                .build();
//        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(Vmanager.class)
//                .setConstraints(constraints.build())
//                .build();
        workManager = WorkManager.getInstance(this);
        workManager.enqueue(request);
        workManager.getWorkInfoByIdLiveData(request.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                if (workInfo != null && (workInfo.getState() == WorkInfo.State.RUNNING))
                {
                    //workManager.cancelWorkById(request.getId());
                    Toast.makeText(WorkerActivity.this, "RUNNING", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}