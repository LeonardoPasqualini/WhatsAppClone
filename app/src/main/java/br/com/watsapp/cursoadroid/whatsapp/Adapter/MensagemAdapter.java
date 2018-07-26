package br.com.watsapp.cursoadroid.whatsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.watsapp.cursoadroid.whatsapp.Model.Mensagem;
import br.com.watsapp.cursoadroid.whatsapp.R;
import br.com.watsapp.cursoadroid.whatsapp.activity.Preferencias;


public class MensagemAdapter extends ArrayAdapter<Mensagem> {

    private Context context;
    private ArrayList<Mensagem> mensagens;


    public MensagemAdapter(Context c,  ArrayList<Mensagem> objects) {
        super(c, 0, objects);
        this.context = c;
        this.mensagens = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        //Verifica se a lista esta preenchida
        if (mensagens != null ){

            //Recuperar dados do remetente
            Preferencias preferencias = new Preferencias(context);
            String idUsuarioRemetente = preferencias.getIdentificador();

            //Inicializar objeto para montagem do layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            //Recupera mensgem
            Mensagem mensaem = mensagens.get( position );

            //Monta View a partir do xml
            if (idUsuarioRemetente.equals( mensaem.getIdUsuario() )  ){
                view = inflater.inflate(R.layout.item_mansagem_direita, parent, false);
            }else{
                view = inflater.inflate(R.layout.intem_mensagem_esquerda, parent, false);
            }


            //Recupera elemento para exibição
            TextView textoMensagem = (TextView) view.findViewById(R.id.tv_mensagem);
            textoMensagem.setText( mensaem.getMensagem() );

        }

        return view;
    }
}
