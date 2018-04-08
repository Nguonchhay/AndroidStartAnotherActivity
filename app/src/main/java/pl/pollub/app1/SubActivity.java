package pl.pollub.app1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent returnIntent = getIntent();
        TextView lblFirst = (TextView) findViewById(R.id.lblFirst);
        lblFirst.setText(returnIntent.getStringExtra("firstValue"));

        TextView lblSecond = (TextView) findViewById(R.id.lblSecond);
        lblSecond.setText(returnIntent.getStringExtra("secondValue"));
    }

    public void finish() {
        TextView lblFirst = (TextView) findViewById(R.id.lblFirst);
        TextView lblSecond = (TextView) findViewById(R.id.lblSecond);

        Intent intent = new Intent();
        intent.putExtra("firstValue", lblFirst.getText().toString());
        intent.putExtra("secondValue", lblSecond.getText().toString());
        setResult(RESULT_OK, intent);

        super.finish();
    }
}
