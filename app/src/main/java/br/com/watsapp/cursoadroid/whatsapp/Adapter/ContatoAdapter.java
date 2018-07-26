package br.com.watsapp.cursoadroid.whatsapp.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.watsapp.cursoadroid.whatsapp.Model.Contato;
import br.com.watsapp.cursoadroid.whatsapp.R;

public class ContatoAdapter extends ArrayAdapter< Contato > {

    private ArrayList<Contato> contatos;
    private Context context;

    public ContatoAdapter(Context c, ArrayList<Contato> objects) {
        super(c, 0, objects);
        this.contatos = objects;
        this.context = c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        //Verifica se a lista de contatos esta vazia
        if( contatos != null ){

            //inicializar objeto para montagem da view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            //Monta a view a partir do xml
            view = inflater.inflate(R.layout.lista_contato, parent, false);

            // recupera elemento para exibição
            TextView nomeContato = (TextView) view.findViewById(R.id.tv_titulo);
            TextView emailContato = (TextView) view.findViewById(R.id.tv_subtitulo);

            Contato contato = contatos.get( position );
            nomeContato.setText( contato.getNome());
            emailContato.setText( contato.getEmail() );
        }

        return view;
    }
}
