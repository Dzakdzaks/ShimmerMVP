package id.co.dzaky.shimmermvp.ui.detailmember;

import java.util.List;

import id.co.dzaky.shimmermvp.base.BasePresenter;
import id.co.dzaky.shimmermvp.model.detail.DetailItem;
import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.ui.member.MainContract;

public class DetailMemberContract {
    public interface DetailMemberView {

        void onSucces(String surname, String nickname, String birthday, String blood, String horoskop, String height, String msg);

        void onError(String msg);
    }

    public interface DetailMemberPresenter extends BasePresenter<DetailMemberView> {

        void getData(int id);
    }
}
