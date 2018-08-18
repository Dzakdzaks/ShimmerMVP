package id.co.dzaky.shimmermvp.repository.members.teamt;

import android.support.annotation.NonNull;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.model.member.TeamTItem;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiDataResource;

public interface TDataResource {
    void getData(@NonNull TDataResource.DataCallback dataCallback);

    interface DataCallback {

        void onSucces(List<TeamTItem> menuResponses, String msg);

        void onError(String msg);

    }
}