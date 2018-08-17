package id.co.dzaky.shimmermvp.ui.detailmember;

import java.util.List;

import id.co.dzaky.shimmermvp.model.detail.DetailItem;
import id.co.dzaky.shimmermvp.repository.detailmembers.DetailMemberDataResource;
import id.co.dzaky.shimmermvp.repository.detailmembers.DetailMemberRepository;
import id.co.dzaky.shimmermvp.repository.members.MainRepository;
import id.co.dzaky.shimmermvp.ui.member.MainContract;

public class DetailMemberPresenter implements DetailMemberContract.DetailMemberPresenter {

    DetailMemberContract.DetailMemberView memberView;
    DetailMemberRepository detailMemberRepository;

    public DetailMemberPresenter(DetailMemberRepository detailMemberRepository) {
        this.detailMemberRepository = detailMemberRepository;
    }

    @Override
    public void getData(int id) {
        detailMemberRepository.getData(id, new DetailMemberDataResource.DataCallback() {
            @Override
            public void onSucces(String surname, String nickname, String birthday, String blood, String horoskop, String height, String twitterLink, String igLink, String msg) {
                memberView.onSucces(surname, nickname, birthday, blood, horoskop, height, twitterLink, igLink, msg);
            }

            @Override
            public void onError(String msg) {
                memberView.onError(msg);
            }
        });

    }

    @Override
    public void onAttachView(DetailMemberContract.DetailMemberView view) {
        this.memberView = view;
    }

    @Override
    public void onDetachView() {

    }
}
