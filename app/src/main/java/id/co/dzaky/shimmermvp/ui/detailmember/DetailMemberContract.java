package id.co.dzaky.shimmermvp.ui.detailmember;

import id.co.dzaky.shimmermvp.base.BasePresenter;

public class DetailMemberContract {
    public interface DetailMemberView {

        void onSucces(String surname, String nickname, String birthday, String blood, String horoskop, String height, String twitterLink, String igLink, String vLink, String msg);

        void onError(String msg);
    }

    public interface DetailMemberPresenter extends BasePresenter<DetailMemberView> {

        void getData(int id);

        void onAttachView(DetailMemberView view);
    }
}
