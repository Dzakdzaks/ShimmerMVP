package id.co.dzaky.shimmermvp.repository.members;

import android.support.annotation.NonNull;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamJItem;

public interface MainDataResource {
    void getData(@NonNull DataCallback dataCallback);

    interface DataCallback {

        void onSucces(List<TeamJItem> menuResponses, String msg);

        void onError(String msg);

    }
}
