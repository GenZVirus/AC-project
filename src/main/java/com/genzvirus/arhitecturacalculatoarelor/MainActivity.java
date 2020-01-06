package com.genzvirus.arhitecturacalculatoarelor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView num0;
    private ImageView num1;
    private ImageView sum;
    private ImageView min;
    private ImageView OR;
    private ImageView AND;
    private ImageView XOR;
    private ImageView enter;
    private ImageView reset;
    private ImageView BCS;
    private ImageView NOT;

    private TextView nr1;
    private TextView nr2;
    private TextView result;
    private TextView onFocus;
    private TextView SelectedFunction;

    private int resID;
    private ImageView image;

    private boolean plus = false;
    private boolean minus = false;
    private boolean or = false;
    private boolean and = false;
    private boolean xor = false;
    private boolean not = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.num0 = (ImageView) findViewById(R.id.imageViewNUM0);
        this.num1 = (ImageView) findViewById(R.id.imageViewNUM1);
        this.sum = (ImageView) findViewById(R.id.imageViewSUM);
        this.min = (ImageView) findViewById(R.id.imageViewMINUS);
        this.OR = (ImageView) findViewById(R.id.imageViewOR);
        this.AND = (ImageView) findViewById(R.id.imageViewAND);
        this.enter = (ImageView) findViewById(R.id.imageViewEnter);
        this.BCS = (ImageView) findViewById(R.id.imageViewBCS);
        this.XOR = (ImageView) findViewById(R.id.imageViewXOR);
        this.NOT = (ImageView) findViewById(R.id.imageViewNOT);
        this.reset = (ImageView) findViewById(R.id.imageViewReset);


        this.nr1 = (TextView) findViewById(R.id.textViewNUM1);
        this.nr2 = (TextView) findViewById(R.id.textViewNUM2);
        this.result = (TextView) findViewById(R.id.textViewResult);
        this.SelectedFunction = (TextView) findViewById(R.id.textViewSF);
        this.onFocus = nr1;

        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        num0.getLayoutParams().height = num0.getLayoutParams().width = displayMetrics.widthPixels/6;
        num0.requestLayout();
        num1.getLayoutParams().height = num1.getLayoutParams().width = displayMetrics.widthPixels/6;
        num1.requestLayout();

        sum.getLayoutParams().height = sum.getLayoutParams().width = displayMetrics.widthPixels/6;
        sum.requestLayout();
        min.getLayoutParams().height = min.getLayoutParams().width = displayMetrics.widthPixels/6;
        min.requestLayout();

        AND.getLayoutParams().height = AND.getLayoutParams().width = displayMetrics.widthPixels/6;
        AND.requestLayout();
        OR.getLayoutParams().height = OR.getLayoutParams().width = displayMetrics.widthPixels/6;
        OR.requestLayout();
        NOT.getLayoutParams().height = NOT.getLayoutParams().width = displayMetrics.widthPixels/6;
        NOT.requestLayout();
        XOR.getLayoutParams().height = XOR.getLayoutParams().width = displayMetrics.widthPixels/6;
        XOR.requestLayout();

        enter.getLayoutParams().height = displayMetrics.widthPixels/6;
        enter.getLayoutParams().width = displayMetrics.widthPixels/6*2;
        enter.requestLayout();
        reset.getLayoutParams().height = displayMetrics.widthPixels/6;
        reset.getLayoutParams().width = displayMetrics.widthPixels/6*2;
        reset.requestLayout();

        BCS.getLayoutParams().height = displayMetrics.widthPixels/6;
        BCS.getLayoutParams().width = displayMetrics.widthPixels;
        BCS.requestLayout();
    }

    public void onClickText(View v) {
        if (v.getTag().toString().charAt(v.getTag().toString().length() - 1) == '3') {
            onFocus = nr1;
        } else if (v.getTag().toString().charAt(v.getTag().toString().length() - 1) == '2') {
            onFocus = nr2;
        }
    }

            public void onClick(View v){
            changeImage(v);
        if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='0' ||
                v.getTag().toString().charAt(v.getTag().toString().length()-1)=='1' ||
                v.getTag().toString().charAt(v.getTag().toString().length()-1)=='B'){
        focusOn(onFocus,v,8);
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='+'){
            reset();
            SelectedFunction.setText("SUM");
            plus = true;
            onFocus = nr2;
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='-'){
            reset();
            SelectedFunction.setText("MINUS");
            minus = true;
            onFocus = nr2;
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='|'){
            reset();
            SelectedFunction.setText("OR");
            or = true;
            onFocus = nr2;
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='&'){
            reset();
            SelectedFunction.setText("AND");
            and = true;
            onFocus = nr2;
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='*'){
            reset();
            SelectedFunction.setText("XOR");
            xor = true;
            onFocus = nr2;
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='!'){
            not = true;
            SelectedFunction.append(" + NOT");
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='R'){
            reset();
            SelectedFunction.setText("");
            not = false;
            onFocus = nr1;
            nr1.setText("");
            nr2.setText("");
            result.setText("");
        }else if(v.getTag().toString().charAt(v.getTag().toString().length()-1)=='E'){
            onFocus = null;
            String finalResult = nr1.getText().toString();
            if(plus) {
                finalResult = Functii.Sum(nr1.getText().toString(), nr2.getText().toString());
                plus = false;
            }
            if(minus) {
                finalResult = Functii.Minus(nr1.getText().toString(), nr2.getText().toString());
                minus = false;
            }
            if(or) {
                finalResult = Functii.OR(nr1.getText().toString(), nr2.getText().toString());
                or = false;
            }
            if(and) {
                finalResult = Functii.AND(nr1.getText().toString(), nr2.getText().toString());
                and = false;
            }
            if(xor) {
                finalResult = Functii.XOR(nr1.getText().toString(), nr2.getText().toString());
                xor = false;
            }
            if(not){
                finalResult = Functii.NOT(finalResult);
                not = false;
            }
            result.setText(finalResult);
        }

    }
    private void reset(){
        minus = false;
        plus = false;
        or = false;
        and = false;
        xor = false;
        not = false;
    }

    private void focusOn(TextView tv, View v,int limit){
        if(tv == null) return;
        String text = v.getTag().toString();
        text = Character.toString(text.charAt(text.length()-1)).toUpperCase();
        String copy = tv.getText().toString();
        if (((ImageView) v) != (ImageView) findViewById(R.id.imageViewBCS)) {
            if (tv.getText().toString().length() < limit)
                tv.append(text);
            copy = tv.getText().toString();
        } else {
            if (copy != null && copy.length() > 0) {
                copy = copy.substring(0, copy.length() - 1);
                tv.setText(copy);
            }
        }
    }
    private void changeImage(View v){
        String name = v.getTag().toString();
        name = name.substring(0,name.length()-1) + "_on";
        resID = getResources().getIdentifier(name , "drawable", getPackageName());
        image = (ImageView) v;
        image.setImageResource(resID);

        name = v.getTag().toString();
        name = name.substring(0,name.length()-1) + "_off";
        resID = getResources().getIdentifier(name , "drawable", getPackageName());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                image.setImageResource(resID);
            }
        }, 50);


    }
}
