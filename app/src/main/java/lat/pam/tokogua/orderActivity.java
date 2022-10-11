package lat.pam.tokogua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class orderActivity extends AppCompatActivity {

    private final String[] Item = {"Aceh", "Bandung", "Bali", "Bogor", "Cianjur", "Ciamis" , "Jakarta", "Jambi", "Medan", "Sukabumi", "Tasikmalaya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textview = findViewById(R.id.order_text);
        textview.setText(message);

        final Spinner list = findViewById(R.id.city_spinner);
        final ArrayAdapter<String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Item);

        list.setAdapter(adapter);

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                displayToast(adapter.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onRadioButtonCLicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.smaeday:
                if (checked)
                    displayToast(getString(R.string.same_day));
                    break;
            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.next_day));
                break;
            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                break;
        }
    }

    public void displayToast (String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}