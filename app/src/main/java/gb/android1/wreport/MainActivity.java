package gb.android1.wreport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main activity";

    private boolean airPressureChecked;
    private boolean windSpeedChecked;
    private TextView currentCity;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentCity = findViewById(R.id.chosenCity);
        airPressureChecked = getIntent().getBooleanExtra("air pressure", false);
        windSpeedChecked = getIntent().getBooleanExtra("wind speed", false);
        if (getIntent().getStringExtra("city choice") == null) {
            currentCity.setText("Не выбрано");
        } else {
            currentCity.setText(getIntent().getStringExtra("city choice"));
        }
        currentCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                intent.putExtra("air pressure", airPressureChecked);
                intent.putExtra("wind speed", windSpeedChecked);
                intent.putExtra("city choice", currentCity.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "program started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "program stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "program destroyed");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("air pressure", airPressureChecked);
        outState.putBoolean("wind speed", windSpeedChecked);
        outState.putString("city choice", currentCity.getText().toString());
        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "state saving");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "program paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "program resumed");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        airPressureChecked = savedInstanceState.getBoolean("air pressure", false);
        windSpeedChecked = savedInstanceState.getBoolean("wind speed", false);
        currentCity.setText(savedInstanceState.getString("city choice", "Не выбрано"));
        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "state restoring");
    }
}
