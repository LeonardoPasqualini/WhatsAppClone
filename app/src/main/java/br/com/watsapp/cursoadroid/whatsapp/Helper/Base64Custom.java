package br.com.watsapp.cursoadroid.whatsapp.Helper;

import android.util.Base64;

/*Metodo usado para converter o e-mail de usuario para Base64 afim de o FireBase identificar
e criar os nós com o e-mail*/
public class Base64Custom {

    public static String codificarBase64(String texto){
        return Base64.encodeToString(texto.getBytes(), Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
    }

    public static String decodificarBase64 (String textoCodificado){
      return new String ( Base64.decode(textoCodificado, Base64.DEFAULT) );
    }
}
