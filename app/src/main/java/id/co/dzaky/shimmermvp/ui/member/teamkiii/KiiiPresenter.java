package id.co.dzaky.shimmermvp.ui.member.teamkiii;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.model.member.TeamTItem;
import id.co.dzaky.shimmermvp.repository.members.teamj.JDataResource;
import id.co.dzaky.shimmermvp.repository.members.teamj.JRepository;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiDataResource;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiRepository;
import id.co.dzaky.shimmermvp.ui.member.teamj.JContract;


public class KiiiPresenter implements KiiiContract.MainPresenter{

    KiiiContract.MainView mainView;
    KiiiRepository mainRepository;

    public KiiiPresenter(KiiiRepository mainRepository) {
        this.mainRepository = mainRepository;
    }


    @Override
    public void onAttachView(KiiiContract.MainView view) {
        this.mainView = view;
    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void getData() {
        mainRepository.getData(new KiiiDataResource.DataCallback() {
            @Override
            public void onSucces(List<TeamKiiiItem> menuResponses, String msg) {
                mainView.onSuccess(menuResponses, msg);

            }
            @Override
            public void onError(String msg) {
                mainView.onError(msg);
            }
        });
    }
}