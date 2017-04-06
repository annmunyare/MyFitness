package com.example.nyambura.myfitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nyambura on 3/23/17.
 */

public class BmiActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = GymListActivity.class.getSimpleName();

    @Bind(R.id.heightEditText)
    EditText mHeightEditText;
    @Bind(R.id.weightEditText)  EditText mWeightEditText;
    @Bind(R.id.totalTextView) TextView mTotalTextView;
    @Bind(R.id.calcBmiButton) Button mCalcBmiButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        ButterKnife.bind(this);

        mCalcBmiButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == mCalcBmiButton) {
            float weight = Float.parseFloat(mWeightEditText.getText().toString());
            float height = Float.parseFloat(mHeightEditText.getText().toString());
            float total = (weight/(height*height));
            mTotalTextView.setText(Float.toString(total));

        }
    }
}


//