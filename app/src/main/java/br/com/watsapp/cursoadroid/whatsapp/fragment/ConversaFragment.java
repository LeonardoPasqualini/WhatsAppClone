package br.com.watsapp.cursoadroid.whatsapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.watsapp.cursoadroid.whatsapp.Adapter.ConversaAdapter;
import br.com.watsapp.cursoadroid.whatsapp.Helper.Base64Custom;
import br.com.watsapp.cursoadroid.whatsapp.Model.Conversa;
import br.com.watsapp.cursoadroid.whatsapp.R;
import br.com.watsapp.cursoadroid.whatsapp.activity.ConversaActivity;
import br.com.watsapp.cursoadroid.whatsapp.activity.Preferencias;
import br.com.watsapp.cursoadroid.whatsapp.config.ConfiguracaoFirebase;


public class ConversaFragment extends Fragment {

    private ListView listView;
    private ArrayList<Conversa> conversas;
    private ArrayAdapter<Conversa> adapter;

    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerConversa;


    public ConversaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conversa, container, false);

        //Monta listview e adapter
        conversas = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.lv_conversas_frag);
        adapter = new ConversaAdapter(getActivity(), conversas);
        listView.setAdapter( adapter );

        //recupera dados do usuario
        Preferencias preferencias = new Preferencias(getActivity());
        String idUsuarioLogado = preferencias.getIdentificador();

        //recupera conversas do firebase
        firebase = ConfiguracaoFirebase.getFirebase()
                .child("Conversas")
                .child( idUsuarioLogado );

        valueEventListenerConversa = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                conversas.clear();
                for ( DataSnapshot dados: dataSnapshot.getChildren()){
                    Conversa conversa = dados.getValue(Conversa.class);
                    conversas.add(conversa);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        //Adicionar evento de clique na lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Conversa conversa = conversas.get(position);
                Intent intent = new Intent(getActivity(), ConversaActivity.class);

                intent.putExtra("nome", conversa.getNome());
                String email = Base64Custom.decodificarBase64(conversa.getIdUsuario());
                intent.putExtra("email", email);

                startActivity(intent);

            }
        });

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerConversa);
    }

    @Override
    public void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerConversa);
    }
}
