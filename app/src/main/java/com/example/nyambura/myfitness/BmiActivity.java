package com.example.nyambura.myfitness;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nyambura on 3/23/17.
 */

public class BmiActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = GymListActivity.class.getSimpleName();
    private static final int REQUEST_IMAGE_CAPTURE = 111;
    private ImageView mImageView;

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
//        setHasOptionsMenu(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_photo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_photo:
                onLaunchCamera();
            default:
                break;
        }
        return false;
    }
    public void onLaunchCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);

        }


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