package id.co.dzaky.shimmermvp.repository.detailmembers;

import android.support.annotation.NonNull;

import java.util.List;

import id.co.dzaky.shimmermvp.model.detail.DetailItem;
import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.repository.members.MainDataResource;

public interface DetailMemberDataResource {
    void getData(int id, @NonNull DataCallback dataCallback);

    interface DataCallback {

        void onSucces(String surname, String nickname, String birthday, String blood, String horoskop, String height, String twitterLink, String igLink, String vLink, String msg);

        void onError(String msg);

    }
}
