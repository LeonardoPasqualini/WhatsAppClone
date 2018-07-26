package br.com.watsapp.cursoadroid.whatsapp.Adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.watsapp.cursoadroid.whatsapp.fragment.ContatosFragments;
import br.com.watsapp.cursoadroid.whatsapp.fragment.ConversaFragment;

public class TabAdapter extends FragmentStatePagerAdapter{

    private String[] tituloAbas = {"CONVERSAS", "CONTATOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch ( position ){
            case 0 :
                fragment = new ConversaFragment();
                break;
            case 1 :
                fragment = new ContatosFragments();
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return tituloAbas.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tituloAbas [ position ];
    }
}
