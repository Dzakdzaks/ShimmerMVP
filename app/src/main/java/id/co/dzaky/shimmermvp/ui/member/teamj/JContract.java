package id.co.dzaky.shimmermvp.ui.member.teamj;

import java.util.List;

import id.co.dzaky.shimmermvp.base.BasePresenter;
import id.co.dzaky.shimmermvp.model.member.TeamJItem;

public class JContract {
    public interface MainView {

        void onSucces(List<TeamJItem> menuResponses, String msg);

        void onError(String msg);
    }

    public interface MainPresenter extends BasePresenter<MainView> {

        void getData();
    }
}
