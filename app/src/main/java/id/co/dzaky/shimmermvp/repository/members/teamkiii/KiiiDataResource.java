package id.co.dzaky.shimmermvp.repository.members.teamkiii;

import android.support.annotation.NonNull;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.model.member.TeamTItem;
import id.co.dzaky.shimmermvp.repository.members.teamj.JDataResource;

public interface KiiiDataResource {
    void getData(@NonNull KiiiDataResource.DataCallback dataCallback);

    interface DataCallback {

        void onSucces(List<TeamKiiiItem> menuResponses, String msg);

        void onError(String msg);

    }
}
