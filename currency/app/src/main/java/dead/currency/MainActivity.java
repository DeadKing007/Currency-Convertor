package dead.currency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText currency;
    private TextView results;
    private Spinner Currency_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currency=findViewById(R.id.Enter_Currency);
        results=findViewById(R.id.Result);
        Currency_list=findViewById(R.id.List);
        Currency_list.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Double c=0.0;
        String s=currency.getText().toString();
        if (s.isEmpty()) {
            results.setText("Enter correct Number");
            return;
        }
        else {
            c= Double.parseDouble(s);
        }
        switch (position){
            case 1:
                results.setText(" "+String.format("%.2f",c * Standards.INR));
                break;
            case 2:
                results.setText(" "+String.format("%.2f",c * Standards.EURO));
                break;
            default:
                results.setText("Choose Currency");
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
