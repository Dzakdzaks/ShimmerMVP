package id.co.dzaky.shimmermvp.base;

import android.support.v4.app.FragmentActivity;
import android.view.View;

public interface BasePresenter<T> {
    void onAttachView(T view);
    void onDetachView();
}
