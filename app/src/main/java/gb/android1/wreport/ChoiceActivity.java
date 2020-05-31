package gb.android1.wreport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

    private CheckBox airPressureCheckBox;
    private CheckBox windSpeedCheckBox;
    private TextView searchBox;
    String chosenCity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice2);
        airPressureCheckBox = findViewById(R.id.airPressureCheckbox);
        windSpeedCheckBox = findViewById(R.id.windSpeedCheckbox);
        searchBox = findViewById(R.id.search_field);
        airPressureCheckBox.setChecked(getIntent().getBooleanExtra("air pressure", false));
        windSpeedCheckBox.setChecked(getIntent().getBooleanExtra("wind speed", false));
        if (getIntent().getStringExtra("city choice") == null) {
            searchBox.setText("Не выбрано");
        } else {
            searchBox.setText(getIntent().getStringExtra("city choice"));
        }
        Button okBtn = findViewById(R.id.chooseCityBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this, MainActivity.class);
                intent.putExtra("air pressure", airPressureCheckBox.isChecked());
                intent.putExtra("wind speed", windSpeedCheckBox.isChecked());
                intent.putExtra("city choice", searchBox.getText().toString());
                startActivity(intent);
            }
        });
        initCityNames();
    }

    private void initCityNames() {
        TextView city1 = findViewById(R.id.cityFavorite1);
        TextView city2 = findViewById(R.id.cityFavorite2);
        TextView city3 = findViewById(R.id.cityFavorite3);
        TextView city4 = findViewById(R.id.cityFavorite4);
        TextView city5 = findViewById(R.id.cityFavorite5);
        TextView city6 = findViewById(R.id.cityFavorite6);
        TextView city7 = findViewById(R.id.cityFavorite7);
        TextView[] cities = {city1, city2, city3, city4, city5, city6, city7};
        for (final TextView c : cities) {
            c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosenCity = c.getText().toString();
                    searchBox.setText(chosenCity);
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("air pressure", airPressureCheckBox.isChecked());
        outState.putBoolean("wind speed", windSpeedCheckBox.isChecked());
        outState.putString("city choice", searchBox.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        airPressureCheckBox.setChecked(savedInstanceState.getBoolean("air pressure", false));
        windSpeedCheckBox.setChecked(savedInstanceState.getBoolean("wind speed", false));
        searchBox.setText(savedInstanceState.getString("city choice", "Не выбрано"));
    }
}
