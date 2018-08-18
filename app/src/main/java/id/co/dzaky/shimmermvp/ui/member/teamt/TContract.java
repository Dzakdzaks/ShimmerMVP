package id.co.dzaky.shimmermvp.ui.member.teamt;

import java.util.List;

import id.co.dzaky.shimmermvp.base.BasePresenter;
import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.model.member.TeamTItem;
import id.co.dzaky.shimmermvp.ui.member.teamkiii.KiiiContract;

public class TContract {
    public interface MainView {

        void onSuccesss(List<TeamTItem> menuResponses, String msg);

        void onError(String msg);
    }

    public interface MainPresenter extends BasePresenter<MainView> {

        void onAttachView(MainView view);

        void onDetachView();

        void getData();
    }
}
