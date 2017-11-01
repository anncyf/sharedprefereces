package sg.com.cyf.sharedprefereces;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double hiscore=0;//variabe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView= (TextView) findViewById(R.id.textview);
        final EditText editText=(EditText) findViewById(R.id.editText);
        Button button =(Button) findViewById(R.id.button);

        textView.setText("Hight score:" +hiscore);//initial disply

        final SharedPreferences sharedPref=getPreferences(Context.MODE_PRIVATE);//handle its like a file
        hiscore=sharedPref.getFloat("Highscore",0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v=Double.parseDouble(editText.getText().toString());
                hiscore=v; //check which is higher compare .
                textView.setText("Hight score:" +hiscore);
                //save to app
                SharedPreferences.Editor editor= sharedPref.edit();
                editor.putFloat("High Score",(float)hiscore);
                editor.commit();
            }
        });


    }
}
