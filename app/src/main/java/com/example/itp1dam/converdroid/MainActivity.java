package com.example.itp1dam.converdroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.function.BinaryOperator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bConvertir;
    private RadioGroup rgBase;
    private EditText etNumero;
    private TextView tBinario;
    private TextView tOctal;
    private TextView tDecimal;
    private TextView tHexadecimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bConvertir = (Button)findViewById(R.id.bConvertir);
        rgBase = (RadioGroup)findViewById(R.id.rgBase);
        etNumero = (EditText)findViewById(R.id.etNumero);
        tBinario = (TextView)findViewById(R.id.tBinario);
        tOctal = (TextView)findViewById(R.id.tOctal);
        tDecimal = (TextView)findViewById(R.id.tDecimal);
        tHexadecimal = (TextView)findViewById(R.id.tHexadecimal);


        bConvertir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        try {
            int base = 0;

            switch (rgBase.getCheckedRadioButtonId()) {
                case R.id.bBinario:
                    System.out.println("Binario");
                    base = Integer.parseInt(String.valueOf(etNumero.getText()), 2);
                    break;
                case R.id.bOctal:
                    System.out.println("Octal");
                    base = Integer.parseInt(String.valueOf(etNumero.getText()), 8);
                    break;
                case R.id.bDecimal:
                    System.out.println("Decimal");
                    base = Integer.parseInt(String.valueOf(etNumero.getText()));
                    break;
                case R.id.bHexadecimal:
                    System.out.println("Hexadecimal");
                    base = Integer.parseInt(String.valueOf(etNumero.getText()), 16);
                    break;
            }
            tBinario.setText(Integer.toBinaryString(base).toString());
            tOctal.setText(Integer.toOctalString(base).toString());
            tDecimal.setText(Integer.toString(base));
            tHexadecimal.setText(Integer.toHexString(base).toString());
        } catch (Exception ex) {
            tBinario.setText("Numero Invalido");
            tOctal.setText("Numero Invalido");
            tDecimal.setText("Numero Invalido");
            tHexadecimal.setText("Numero Invalido");
        }
    }
}
