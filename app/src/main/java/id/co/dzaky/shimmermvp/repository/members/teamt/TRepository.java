package id.co.dzaky.shimmermvp.repository.members.teamt;

import android.support.annotation.NonNull;

import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiDataResource;

public class TRepository implements TDataResource {
    TDataResource tDataResource;

    public TRepository(TDataResource tDataResource) {
        this.tDataResource = tDataResource;
    }

    @Override
    public void getData(@NonNull TDataResource.DataCallback dataCallback) {
        tDataResource.getData(dataCallback);
    }
}
