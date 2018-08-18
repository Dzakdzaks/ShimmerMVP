package id.co.dzaky.shimmermvp.ui.member.teamj;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.repository.members.teamj.JDataResource;
import id.co.dzaky.shimmermvp.repository.members.teamj.JRepository;

public class JPresenter implements JContract.MainPresenter{

    JContract.MainView mainView;
    JRepository mainRepository;

    public JPresenter(JRepository mainRepository) {
        this.mainRepository = mainRepository;
    }


    @Override
    public void onAttachView(JContract.MainView view) {
        this.mainView = view;
    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void getData() {
        mainRepository.getData(new JDataResource.DataCallback() {
            @Override
            public void onSucces(List<TeamJItem> menuResponses, String msg) {
                mainView.onSucces(menuResponses, msg);

            }

            @Override
            public void onError(String msg) {
                mainView.onError(msg);
            }
        });
    }
}
