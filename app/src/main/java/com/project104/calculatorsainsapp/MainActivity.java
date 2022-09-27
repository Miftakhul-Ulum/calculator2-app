package com.project104.calculatorsainsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textInput);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }
    private void updateText(String strAdd){
        String oldStr = display.getText().toString();
        int cusorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cusorPos);
        String rightStr = oldStr.substring(cusorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strAdd);
            display.setSelection(cusorPos +1);
        }else {
            display.setText(String.format("%s%s%s",leftStr,strAdd,rightStr));
            display.setSelection(cusorPos +1);
        }

    }
    public void nolBtn(View view){
        updateText("0");
    }
    public void plusminusBtn(View view){
        updateText("-");
    }
    public void pointBtn(View view){
        updateText(".");
    }
    public void equelsBtn(View view){
        String userExpresion = display.getText().toString();
        Expression exp = new Expression(userExpresion);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void addBtn(View view){
        updateText("+");
    }
    public void substructBtn(View view){
        updateText("-");
    }
    public void multiplyBtn(View view){
        updateText("*");
    }
    public void divideBtn(View view){
        updateText("/");
    }
    public void exponentBtn(View view){
        updateText("^");
    }
    public void parenthesesBtn(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLengt = display.getText().length();

        for (int i = 0; i<cursorPos; i++){
            if (display.getText().toString().substring(i,i+1).equals("(")){
                openPar +=1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closePar +=1;
            }
        }
        if (openPar==closePar || display.getText().toString().substring(textLengt-1,textLengt).equals("(")){
            updateText("(");
        }
        else if (closePar<openPar && !display.getText().toString().substring(textLengt-1,textLengt).equals("(")){
            updateText(")");
        }

        display.setSelection(cursorPos+1);
    }
    public void clearBtn(View view){
        display.setText("");
    }
    public void backspaceBtn(View view){
        int cursorPos = display.getSelectionStart();
        int textLenght = display.getText().length();
        if (cursorPos != 0 && textLenght !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void satuBtn(View view){
        updateText("1");
    }
    public void duaBtn(View view){
        updateText("2");
    }
    public void tigaBtn(View view){
        updateText("3");
    }
    public void empatBtn(View view){
        updateText("4");
    }
    public void limaBtn(View view){
        updateText("5");
    }
    public void enamBtn(View view){
        updateText("6");
    }
    public void tujuhBtn(View view){
        updateText("7");
    }
    public void delapanBtn(View view){
        updateText("8");
    }
    public void sembilanBtn(View view){
        updateText("9");
    }
}