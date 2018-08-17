package id.co.dzaky.shimmermvp.ui.detailmember;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import id.co.dzaky.shimmermvp.R;
import id.co.dzaky.shimmermvp.repository.detailmembers.DetailMemberRepoInject;

public class DetailMember extends Activity implements DetailMemberContract.DetailMemberView {

    DetailMemberPresenter detailMemberPresenter;

    int id;
    String image;

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
    @BindView(R.id.img_member)
    CircleImageView image_member;
    @BindView(R.id.img_ig)
    ImageView imgIg;
    @BindView(R.id.img_twitter)
    ImageView imgTwitter;
    @BindView(R.id.img_yt)
    ImageView imgYt;
//    @BindView(R.id.tvTwitterLinks)
//    TextView tvTwitterLinks;
//    @BindView(R.id.tvInstagramLinks)
//    TextView tvInstagramLinks;

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
        image = getIntent().getStringExtra("image");
    }


    @Override
    public void onSucces(String surname, String nickname, String birthday, String blood, String horoskop, String height, final String twitterLink, final String igLink, final String vLink, String msg) {
        toast(surname + "\n" + msg);
        detailMemberPresenter.onDetachView();
        Glide.with(getApplicationContext())
                .load(image)
                .into(image_member);
        tvSurname.setText(surname);
        tvNickname.setText(nickname);
        tvBirthday.setText("Birthday || " + birthday);
        tvBlood.setText("Blood Type || " + blood);
        tvHoroskop.setText("Horoskop || " + horoskop);
        tvHeight.setText("Height || " + height);
//        SpannableString linkTwitter = new SpannableString(twitterLink);
//        linkTwitter.setSpan(new UnderlineSpan(), 0, linkTwitter.length(), 0);
//        tvTwitterLinks.setText(linkTwitter);
        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterLink));
                startActivity(myIntent);
            }
        });
//        SpannableString linkIG = new SpannableString(twitterLink);
//        linkIG.setSpan(new UnderlineSpan(), 0, linkIG.length(), 0);
//        tvInstagramLinks.setText(linkIG);
        imgIg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(igLink));
                startActivity(myIntent);
            }
        });
        imgYt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vLink));
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void onError(String msg) {
        toast(msg);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
