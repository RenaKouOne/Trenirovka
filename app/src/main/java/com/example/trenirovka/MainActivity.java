package com.example.trenirovka;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView textView3;
    private TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
    }
    public void clickButton(View v) {

        double a, b, c, d, e, x;
        c = 0;
        b = Double.parseDouble(editText1.getText().toString());
        d = Double.parseDouble(editText2.getText().toString());
        a = 0;
        e = 0;
        x = 0;
        while (true){
            c = (b/100*d);
            b = b + c;
            e = e + 1;
            if (b>=20) break;
        }
        String c1 = Double.toString(e);
        textView3.setText("Пробежал больше 20 км за "+ c1 +" дней");

        while (true){
            c = (b/100*d);
            b = b + c;
            x = x + 1;
            if (b>=100) break;
        }
        String c2 = Double.toString(x);
        textView4.setText("Достиг суммарно 100 км за "+ c2 +" дней");

    }


    public void clickButton1(View v) {
        editText1.setText("10");
        editText2.setText("10");
        textView3.setText("Пробежал больше 20 км за ");
        textView4.setText("Достиг суммарно 100 км за ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.btn_alertBtn1:
                createOneButtonAlertDialog("Автор", "Пшеницына Екатерина Максимовна");
                return true;
            case R.id.btn_alertBtn2:
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);

    }

    private void createOneButtonAlertDialog(String title, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setPositiveButton("Закрыть",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        showMessage("Вы нажали кнопку Закрыть");
                    }
                });
        builder.show();
    }
    private void showMessage(String textInMessage) {
        Toast.makeText(getApplicationContext(), textInMessage, Toast.LENGTH_LONG).show();
    }
}