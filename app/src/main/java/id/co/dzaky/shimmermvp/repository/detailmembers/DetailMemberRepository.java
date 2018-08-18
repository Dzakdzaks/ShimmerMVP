package id.co.dzaky.shimmermvp.repository.detailmembers;

import android.support.annotation.NonNull;

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
