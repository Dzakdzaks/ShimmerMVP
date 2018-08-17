package id.co.dzaky.shimmermvp.repository.detailmembers;

import android.content.Context;
import android.support.annotation.NonNull;

import id.co.dzaky.shimmermvp.repository.members.MainDataRemote;
import id.co.dzaky.shimmermvp.repository.members.MainDataResource;
import id.co.dzaky.shimmermvp.repository.members.MainRepository;

public class DetailMemberRepository implements DetailMemberDataResource {

    DetailMemberDataResource detailMemberDataResource;

    public DetailMemberRepository(DetailMemberDataResource detailMemberDataResource) {
        this.detailMemberDataResource = detailMemberDataResource;
    }

    @Override
    public void getData(int id, @NonNull DataCallback dataCallback) {
        detailMemberDataResource.getData(id, dataCallback);
    }
}
