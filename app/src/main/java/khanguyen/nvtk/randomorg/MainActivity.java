package khanguyen.nvtk.randomorg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
        EditText edtMaxNumber, edtMinNumber;
        TextView txtNumber;
        Button btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        btnGet.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                String maxString = edtMaxNumber.getText().toString().trim();
                String minString = edtMinNumber.getText().toString().trim();
                if(maxString.length() == 0 || minString.length() == 0){
                    Toast.makeText(MainActivity.this,"Nhập cho đủ bạn êi",Toast.LENGTH_SHORT).show();
                }
                else{
                    int max = Integer.parseInt(maxString);
                    int min = Integer.parseInt(minString);
                    int number = randInt(max,min);
                    String aNamDepTrai = Integer.toString(number);
                    txtNumber.setText(aNamDepTrai);
                }

            }
        });

}
    public static int randInt(int a, int b){
        Random rand = new Random();
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        return rand.nextInt((max - min ) + 1) + min;
    }
    private void mapping(){
        edtMaxNumber = (EditText)findViewById(R.id.maxValue);
        edtMinNumber = (EditText)findViewById(R.id.minValue);
        txtNumber = (TextView)findViewById(R.id.randomNumber);
        btnGet = (Button)findViewById(R.id.buttonGet);
    }
}