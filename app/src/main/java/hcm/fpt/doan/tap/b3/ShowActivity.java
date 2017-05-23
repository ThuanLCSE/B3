package hcm.fpt.doan.tap.b3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TextView user = (TextView) findViewById(R.id.textView);
        TextView pass = (TextView) findViewById(R.id.textView2);
        TextView name = (TextView) findViewById(R.id.textView3);
        TextView male = (TextView) findViewById(R.id.textView4);
        TextView national = (TextView) findViewById(R.id.textView5);
        TextView birth = (TextView) findViewById(R.id.textView6);
        TextView sport = (TextView) findViewById(R.id.textView7);
        TextView status = (TextView) findViewById(R.id.textView8);
        TextView exp = (TextView) findViewById(R.id.textView9);
        TextView rating = (TextView) findViewById(R.id.textView10);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("INFO");

        user.setText("Username : "+bundle.getString("username"));
        pass.setText("Password : "+bundle.getString("password"));
        name.setText("Fullname : "+bundle.getString("fullname"));
        male.setText("Male : "+bundle.getString("male"));
        status.setText("Status : "+bundle.getString("status"));
        birth.setText("Birthday : "+bundle.getString("birthday"));
        national.setText("Nationality : "+bundle.getString("nationality"));
        exp.setText("Experiemtn: "+bundle.getString("exp"));
        sport.setText("Sport : "+bundle.getString("sport"));
        rating.setText("Rating : "+bundle.getString("rating"));
    }
}
