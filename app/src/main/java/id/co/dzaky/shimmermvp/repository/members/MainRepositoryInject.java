package id.co.dzaky.shimmermvp.repository.members;

import android.content.Context;

import id.co.dzaky.shimmermvp.repository.members.teamj.JDataRemote;
import id.co.dzaky.shimmermvp.repository.members.teamj.JRepository;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiDataRemote;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiRepository;
import id.co.dzaky.shimmermvp.repository.members.teamt.TDataRemote;
import id.co.dzaky.shimmermvp.repository.members.teamt.TRepository;

public class MainRepositoryInject {
    public static JRepository provideToInjectJ(Context context){
        return new JRepository(new JDataRemote(context));
    }

    public static KiiiRepository provideToInjectK(Context context){
        return new KiiiRepository(new KiiiDataRemote(context));
    }

    public static TRepository provideToInjectT(Context context){
        return new TRepository(new TDataRemote(context));
    }
}
