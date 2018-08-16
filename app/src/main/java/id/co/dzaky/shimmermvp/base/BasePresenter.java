package id.co.dzaky.shimmermvp.base;

public interface BasePresenter<T> {
    void onAttachView(T view);
    void onDetachView();
}
