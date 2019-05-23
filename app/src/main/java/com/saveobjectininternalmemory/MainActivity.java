package com.saveobjectininternalmemory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY = "KEY_USER";
    private ArrayList<User> userArrayList;
    private TextView tvObjectData;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userArrayList = new ArrayList<>();
        userList = new ArrayList<>();
        tvObjectData = findViewById(R.id.tvObjectData);

        findViewById(R.id.btnSaveObjectInLocalMemoryHeap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsers();
                tvObjectData.setText("Local Data: \n\n" + userArrayList.toString());
                tvObjectData.setText("Data Added In Object");
            }
        });
        findViewById(R.id.btnSaveObjectInInternalMemory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Save the list of entries to internal storage
                    InternalStorage.writeObject(MainActivity.this, KEY, userArrayList);
                    tvObjectData.setText("Object Saved in Internal Storage");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btnRetrieveObjectFromLocalMeMoryHeap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvObjectData.setText("Local Object Data: \n\n" + userArrayList.toString());
            }
        });
        findViewById(R.id.btnRetrieveObjectFromInternalMemory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the list from internal storage
                try {
                    userList = (List<User>) InternalStorage.readObject(MainActivity.this, KEY);
                    tvObjectData.setText("Object Retrieve from Internal Storage :\n\n" + userList.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addUsers() {
        userArrayList.add(new User("dilip", "dilip.dsp@gmail.com", "ratlam"));
        userArrayList.add(new User("abc", "abc@gmail.com", "ratlam"));
        userArrayList.add(new User("pqr", "pqr@gmail.com", "ratlam"));
        userArrayList.add(new User("xyz", "xyz@gmail.com", "ratlam"));
    }

}