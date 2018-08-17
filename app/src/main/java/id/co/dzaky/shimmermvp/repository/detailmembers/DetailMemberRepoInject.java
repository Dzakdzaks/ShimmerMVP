package id.co.dzaky.shimmermvp.repository.detailmembers;

import android.content.Context;

import id.co.dzaky.shimmermvp.repository.members.MainDataRemote;
import id.co.dzaky.shimmermvp.repository.members.MainRepository;

public class DetailMemberRepoInject {
    public static DetailMemberRepository provideToInject(Context context){
        return new DetailMemberRepository(new DetailMemberRemote(context));
    }
}
