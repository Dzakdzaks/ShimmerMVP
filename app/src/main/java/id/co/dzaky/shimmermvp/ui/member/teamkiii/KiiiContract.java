package id.co.dzaky.shimmermvp.ui.member.teamkiii;

import java.util.List;

import id.co.dzaky.shimmermvp.base.BasePresenter;
import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.ui.member.teamj.JContract;

public class KiiiContract {
        public interface MainView {

            void onSuccess(List<TeamKiiiItem> menuResponses, String msg);

            void onError(String msg);
        }

        public interface MainPresenter extends BasePresenter<MainView> {

            void onAttachView(MainView view);

            void onDetachView();

            void getData();
        }
    }
