package id.co.dzaky.shimmermvp.repository.members.teamj;

import android.support.annotation.NonNull;

public class JRepository implements JDataResource {

    JDataResource jDataResource;

    public JRepository(JDataResource jDataResource) {
        this.jDataResource = jDataResource;
    }

    @Override
    public void getData(@NonNull DataCallback dataCallback) {
        jDataResource.getData(dataCallback);
    }
}
