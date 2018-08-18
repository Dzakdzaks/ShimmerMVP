package id.co.dzaky.shimmermvp.ui.member.teamt;

import java.util.List;

import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.model.member.TeamTItem;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiDataResource;
import id.co.dzaky.shimmermvp.repository.members.teamkiii.KiiiRepository;
import id.co.dzaky.shimmermvp.repository.members.teamt.TDataResource;
import id.co.dzaky.shimmermvp.repository.members.teamt.TRepository;
import id.co.dzaky.shimmermvp.ui.member.teamkiii.KiiiContract;

public class TPresenter implements TContract.MainPresenter{

    TContract.MainView mainView;
    TRepository mainRepository;

    public TPresenter(TRepository mainRepository) {
        this.mainRepository = mainRepository;
    }


    @Override
    public void onAttachView(TContract.MainView view) {
        this.mainView = view;
    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void getData() {
        mainRepository.getData(new TDataResource.DataCallback() {
            @Override
            public void onSucces(List<TeamTItem> menuResponses, String msg) {
                mainView.onSuccesss(menuResponses, msg);

            }
            @Override
            public void onError(String msg) {
                mainView.onError(msg);
            }
        });
    }
}
