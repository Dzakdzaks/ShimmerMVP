package id.co.dzaky.shimmermvp.ui;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.repository.MainDataResource;
import id.co.dzaky.shimmermvp.repository.MainRepository;

public class MainPresenter implements MainContract.MainPresenter{

    MainContract.MainView mainView;
    MainRepository mainRepository;

    public MainPresenter(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }


    @Override
    public void onAttachView(MainContract.MainView view) {
        this.mainView = view;
    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void getData() {
        mainRepository.getData(new MainDataResource.DataCallback() {
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
