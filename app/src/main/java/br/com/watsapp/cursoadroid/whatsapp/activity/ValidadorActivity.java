package br.com.watsapp.cursoadroid.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;

import br.com.watsapp.cursoadroid.whatsapp.R;

public class ValidadorActivity extends AppCompatActivity {

    private EditText codigoValidação;
    private Button validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        codigoValidação = (EditText) findViewById(R.id.edit_cod_validacao);
        validar         = (Button)   findViewById(R.id.bt_validar);

        SimpleMaskFormatter simpleMaskFormatter = new SimpleMaskFormatter("NNNN");
        MaskTextWatcher mascaraCodigoValidacao = new MaskTextWatcher(codigoValidação, simpleMaskFormatter);

        codigoValidação.addTextChangedListener( mascaraCodigoValidacao );

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Recuperando dados das preferências do usuário
              /* Preferencias preferencias = new Preferencias( ValidadorActivity.this );
                HashMap<String, String> usuario = preferencias.getDadosUsuario();

                String tokenGerado = usuario.get("token");
                String tokenDigitado = codigoValidação.getText().toString();

                if ( tokenDigitado.equals( tokenGerado ) ){
                    Toast.makeText(ValidadorActivity.this, "Token VALIDADO!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ValidadorActivity.this, "Token NÃO VALIDADO!!", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }
}
