package id.co.dzaky.shimmermvp.repository.members;

import android.content.Context;

public class MainRepositoryInject {
    public static MainRepository provideToInject(Context context){
        return new MainRepository(new MainDataRemote(context));
    }
}
