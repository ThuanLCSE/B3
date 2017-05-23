package hcm.fpt.doan.tap.b3;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
String selectedSpn;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spn = (Spinner) findViewById(R.id.spn1);
        List<String> dataSpn = new ArrayList<String>();
        dataSpn.add("Kinh");
        dataSpn.add("France");
        dataSpn.add("Australian");
        dataSpn.add("Espanolisa");
        ArrayAdapter<String> dataAdap = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,dataSpn);
        dataAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(dataAdap);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSpn = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                EditText edit = (EditText) findViewById(R.id.txtUser);
                bundle.putString("username", edit.getText().toString());
                EditText editP = (EditText) findViewById(R.id.txtPass);
                bundle.putString("password", editP.getText().toString());
                EditText editF = (EditText) findViewById(R.id.txtName);
                bundle.putString("fullname", editF.getText().toString());

                CheckBox chk = (CheckBox) findViewById(R.id.chk1);
                bundle.putBoolean("male", chk.isChecked());

                RadioGroup rdg = (RadioGroup) findViewById(R.id.rdoGR);
                int chkRdoId = rdg.getCheckedRadioButtonId();
                RadioButton rdo = (RadioButton) findViewById(chkRdoId);
                bundle.putString("status", rdo.getText().toString());

                DatePicker txtBirth = (DatePicker) findViewById(R.id.txtBirth);
                bundle.putString("birthday", txtBirth.getDayOfMonth()+"-"+txtBirth.getMonth()+"-"+txtBirth.getYear());

                bundle.putString("nationality",selectedSpn );
                SeekBar sk = (SeekBar) findViewById(R.id.seekBar);
                bundle.putString("exp",sk.getProgress()+"" );

                ToggleButton tgl = (ToggleButton) findViewById(R.id.toggleButton);
                bundle.putString("sport",tgl.getText().toString());

                RatingBar rt = (RatingBar) findViewById(R.id.ratingBar);
                bundle.putString("rating",rt.getRating()+"");

                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                intent.putExtra("INFO",bundle);

                startActivity(intent);
            }
        });
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}
