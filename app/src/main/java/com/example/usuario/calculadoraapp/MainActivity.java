package com.example.usuario.calculadoraapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView campoTexto;
    private float numeroA = 0;
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = (TextView) findViewById(R.id.campoResultado);
        campoTexto.setText("");

    }

    public void clicaBotao(View view){
        switch (view.getId()){      //Pega o id do objeto que foi clicado
            case R.id.botaoClear:
                campoTexto.setText("");     //Limpa os campos
                numeroA = 0;
                operacao = "";
                break;
            case R.id.botaoSomar:       //Chama a função calculaNumero com o parametro clicado
                calculaNumero("+");
                break;
            case R.id.botaoSubtrair:
                calculaNumero("-");
                break;
            case R.id.botaoMultiplicar:
                calculaNumero("*");
                break;
            case R.id.botaoDividir:
                calculaNumero("/");
                break;
            case R.id.botaoIgual:
                mostraResultado();
                break;
            default:
                String numb;
                numb = ((Button)view).getText().toString();     //Recebe o valor do botao
                getKeyboard(numb);      //Chama a função e passa o valor do botao
                break;
        }
    }

    public void calculaNumero(String tipoOperacao) {
        numeroA = Float.parseFloat(campoTexto.getText().toString()); //Pega o valor do campo de texto e converte para float
        operacao = tipoOperacao; //Guarda o tipo de operação a ser executada
        campoTexto.setText("");
    }

    public void getKeyboard(String str){
        String StrCurrent = campoTexto.getText().toString();    //Pega o campo do botão e transforma em String
        StrCurrent += str;  //Adiciona o valor do campo em outra String
        campoTexto.setText(StrCurrent);     //Atualiza o campo de texto com o valor
    }

    public void mostraResultado(){
        float numeroB = Float.parseFloat(campoTexto.getText().toString());
        float result = 0;
        if (operacao.equals("+")){
            result = numeroB + numeroA;
        }
        if (operacao.equals("-")){
            result = numeroA - numeroB;
        }
        if (operacao.equals("*")){
            result = numeroB * numeroA;
        }
        if (operacao.equals("/")){
            result = numeroB / numeroA;
        }
        campoTexto.setText(String.valueOf(result));
    }

}
