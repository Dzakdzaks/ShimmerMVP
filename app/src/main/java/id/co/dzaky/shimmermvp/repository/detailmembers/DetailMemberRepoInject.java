package id.co.dzaky.shimmermvp.repository.detailmembers;

import android.content.Context;

public class DetailMemberRepoInject {
    public static DetailMemberRepository provideToInject(Context context){
        return new DetailMemberRepository(new DetailMemberRemote(context));
    }
}
