package gb.android1.wreport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

    CheckBox airPressureCheckBox;
    CheckBox windSpeedCheckBox;
    AppCompatAutoCompleteTextView searchBox;

    TextView favoriteCity1;
    TextView favoriteCity2;
    TextView favoriteCity3;
    TextView favoriteCity4;
    TextView favoriteCity5;
    TextView favoriteCity6;
    TextView favoriteCity7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice2);
        airPressureCheckBox = findViewById(R.id.airPressureCheckbox);
        windSpeedCheckBox = findViewById(R.id.windSpeedCheckbox);
    }
}
