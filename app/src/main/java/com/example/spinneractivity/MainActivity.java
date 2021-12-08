package com.example.spinneractivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spActivity, spPlay;
    ActivityAdapter activityAdapter;
    PlayAdapter playAdapter;
    ArrayList<ActivityModel> activities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spActivity = findViewById(R.id.spActivity);
        spPlay = findViewById(R.id.spPlay);

        ArrayList<PlayModel> play1 = new ArrayList<>();
        play1.add(new PlayModel(1, "Play 1"));
        play1.add(new PlayModel(2, "Play 2"));
        activities.add(new ActivityModel(1, "Activity 1",play1));
        activities.add(new ActivityModel(2, "Activity 2",play1));

        activityAdapter = new ActivityAdapter(this, activities);
        spActivity.setAdapter(activityAdapter);
        spActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        // It returns the clicked item.
                        ActivityModel clickedItem = (ActivityModel) parent.getItemAtPosition(position);
                        String name = clickedItem.getName();
                        Toast.makeText(MainActivity.this, name + "selected", Toast.LENGTH_SHORT).show();

                        playAdapter = new PlayAdapter(MainActivity.this, clickedItem.getPlay());
                        spPlay.setAdapter(playAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        spPlay.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        // It returns the clicked item.
                        PlayModel clickedItem = (PlayModel) parent.getItemAtPosition(position);
                        String name = clickedItem.getName();
                        Toast.makeText(MainActivity.this, name + "selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

    public class ActivityAdapter extends ArrayAdapter<ActivityModel> {

        public ActivityAdapter(Context context, ArrayList<ActivityModel> algorithmList) {
            super(context, 0 , algorithmList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return initView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return initView(position, convertView, parent);
        }

        private View initView(int position, View convertView, ViewGroup parent) {
            // It is used to set our custom view.
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item_view, parent, false);
            }

            TextView textViewName = convertView.findViewById(R.id.text_view);
            ActivityModel currentItem = getItem(position);

            // It is used the name to the TextView when the
            // current item is not null.
            if (currentItem != null) {
                textViewName.setText(currentItem.getName());
            }
            return convertView;
        }
    }

    public class PlayAdapter extends ArrayAdapter<PlayModel> {

        public PlayAdapter(Context context, ArrayList<PlayModel> algorithmList) {
            super(context, 0, algorithmList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return initView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return initView(position, convertView, parent);
        }

        private View initView(int position, View convertView, ViewGroup parent) {
            // It is used to set our custom view.
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item_view, parent, false);
            }

            TextView textViewName = convertView.findViewById(R.id.text_view);
            PlayModel currentItem = getItem(position);

            // It is used the name to the TextView when the
            // current item is not null.
            if (currentItem != null) {
                textViewName.setText(currentItem.getName());
            }
            return convertView;
        }
    }
}