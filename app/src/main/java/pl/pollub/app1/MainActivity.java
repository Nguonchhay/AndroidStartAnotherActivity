package pl.pollub.app1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final int ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendData = (Button) findViewById(R.id.btnSendData);
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                EditText txtFirstValue = (EditText) findViewById(R.id.txtFirstValue);
                EditText txtSecondValue = (EditText) findViewById(R.id.txtSecondValue);
                intent.putExtra("firstValue", txtFirstValue.getText().toString());
                intent.putExtra("secondValue", txtSecondValue.getText().toString());
                startActivityForResult(intent, MainActivity.ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == MainActivity.ACTIVITY_REQUEST_CODE) {
            if (data.hasExtra("firstValue") && data.hasExtra("secondValue")) {
                Float value1 = Float.parseFloat(data.getStringExtra("firstValue"));
                Float value2 = Float.parseFloat(data.getStringExtra("secondValue"));

                TextView lblAdd = (TextView) findViewById(R.id.lblAdd);
                Float addValue = value1 + value2;
                lblAdd.setText(addValue.toString());

                TextView lblSub = (TextView) findViewById(R.id.lblSub);
                Float subValue = value1 - value2;
                lblSub.setText(subValue.toString());

                TextView lblMul = (TextView) findViewById(R.id.lblMultiply);
                Float mulValue = value1 * value2;
                lblMul.setText(mulValue.toString());

                TextView lblDiv = (TextView) findViewById(R.id.lblDivide);
                if (value2 == 0) {
                    lblDiv.setText("Cannot divide by zero");
                } else {
                    Float divValue = value1 / value2;
                    lblDiv.setText(divValue.toString());
                }
            }
        }
    }
}
