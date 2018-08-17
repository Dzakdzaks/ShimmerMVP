package id.co.dzaky.shimmermvp.ui.detailmember;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.dzaky.shimmermvp.R;
import id.co.dzaky.shimmermvp.model.detail.DetailItem;
import id.co.dzaky.shimmermvp.repository.detailmembers.DetailMemberRepoInject;

public class DetailMember extends Activity implements DetailMemberContract.DetailMemberView {

    DetailMemberPresenter detailMemberPresenter;

    int id;

    @BindView(R.id.tvSurname)
    TextView tvSurname;
    @BindView(R.id.tvNickname)
    TextView tvNickname;
    @BindView(R.id.tvBirthday)
    TextView tvBirthday;
    @BindView(R.id.tvBlood)
    TextView tvBlood;
    @BindView(R.id.tvHoroskop)
    TextView tvHoroskop;
    @BindView(R.id.tvHeight)
    TextView tvHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_member);
        ButterKnife.bind(this);
        setView();
        detailMemberPresenter.getData(id);

    }

    private void setView() {
        detailMemberPresenter = new DetailMemberPresenter(DetailMemberRepoInject.provideToInject(getApplicationContext()));
        detailMemberPresenter.onAttachView(this);
        id = getIntent().getIntExtra("id", 0);
    }


    @Override
    public void onSucces(String surname, String nickname, String birthday, String blood, String horoskop, String height, String msg) {
        toast(surname + "\n" + msg);
        detailMemberPresenter.onDetachView();
        tvSurname.setText("Surname : " + surname);
        tvNickname.setText("Nickname : " + nickname );
        tvBirthday.setText("Birthday : " + birthday );
        tvBlood.setText("Blood Type : " + blood );
        tvHoroskop.setText("Horoskop : " + horoskop );
        tvHeight.setText("Height : " + height );
    }

    @Override
    public void onError(String msg) {
        toast(msg);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
