package com.example.mads.appnea;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    Button logonBtn;
    EditText usernameET;
    EditText passwordET;
    private SyncService syncService;
    private boolean bound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logonBtn = (Button) findViewById(R.id.logonBtn);
        usernameET = (EditText) findViewById(R.id.userNameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        bound = false;
        syncService = new SyncService();
        BindToService();
        logonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                syncService.logon(usernameET.getText().toString(),passwordET.getText().toString());
            }
        });
    }
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            syncService = ((SyncService.BindService) service).getService();
            bound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }
    };
    public void BindToService() {
        bindService(new Intent(LogInActivity.this,SyncService.class),myConnection, Context.BIND_AUTO_CREATE);
    }
}