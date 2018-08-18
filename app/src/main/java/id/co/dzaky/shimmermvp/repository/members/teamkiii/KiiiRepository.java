package id.co.dzaky.shimmermvp.repository.members.teamkiii;

import android.support.annotation.NonNull;

import id.co.dzaky.shimmermvp.repository.members.teamj.JDataResource;

public class KiiiRepository implements KiiiDataResource {

    KiiiDataResource kiiiDataResource;

    public KiiiRepository(KiiiDataResource kiiiDataResource) {
        this.kiiiDataResource = kiiiDataResource;
    }

    @Override
    public void getData(@NonNull KiiiDataResource.DataCallback dataCallback) {
        kiiiDataResource.getData(dataCallback);
    }
}
