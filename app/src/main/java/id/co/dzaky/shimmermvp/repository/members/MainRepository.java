package id.co.dzaky.shimmermvp.repository.members;

import android.support.annotation.NonNull;

public class MainRepository implements MainDataResource {

    MainDataResource mainDataResource;

    public MainRepository(MainDataResource mainDataResource) {
        this.mainDataResource = mainDataResource;
    }

    @Override
    public void getData(@NonNull DataCallback dataCallback) {
        mainDataResource.getData(dataCallback);
    }
}
