package id.co.dzaky.shimmermvp.repository.members.teamj;

import android.support.annotation.NonNull;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamJItem;

public interface JDataResource {
    void getData(@NonNull DataCallback dataCallback);

    interface DataCallback {

        void onSucces(List<TeamJItem> menuResponses, String msg);

        void onError(String msg);

    }
}
