package id.co.dzaky.shimmermvp.ui.member;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.dzaky.shimmermvp.R;
import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.model.member.TeamTItem;
import id.co.dzaky.shimmermvp.repository.members.MainRepositoryInject;
import id.co.dzaky.shimmermvp.ui.member.teamj.JAdapter;
import id.co.dzaky.shimmermvp.ui.member.teamj.JContract;
import id.co.dzaky.shimmermvp.ui.member.teamj.JPresenter;
import id.co.dzaky.shimmermvp.ui.member.teamkiii.KiiiAdapter;
import id.co.dzaky.shimmermvp.ui.member.teamkiii.KiiiContract;
import id.co.dzaky.shimmermvp.ui.member.teamkiii.KiiiPresenter;
import id.co.dzaky.shimmermvp.ui.member.teamt.TAdapter;
import id.co.dzaky.shimmermvp.ui.member.teamt.TContract;
import id.co.dzaky.shimmermvp.ui.member.teamt.TPresenter;


public class MainActivity extends AppCompatActivity implements JContract.MainView, KiiiContract.MainView, TContract.MainView {

    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout shimmerViewContainer;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tvTeamJExpand)
    TextView tvTeamJExpand;
    @BindView(R.id.dropJ)
    ImageView dropJ;
    @BindView(R.id.tvTeamKIIIExpand)
    TextView tvTeamKIIIExpand;
    @BindView(R.id.dropKIII)
    ImageView dropKIII;
    @BindView(R.id.recycler_view_kiii)
    RecyclerView recyclerViewKiii;
    @BindView(R.id.tvTeamTExpand)
    TextView tvTeamTExpand;
    @BindView(R.id.dropT)
    ImageView dropT;
    @BindView(R.id.recycler_view_t)
    RecyclerView recyclerViewT;
    @BindView(R.id.relativeTeamJ)
    RelativeLayout relativeTeamJ;
    @BindView(R.id.relativeTeamK)
    RelativeLayout relativeTeamK;
    @BindView(R.id.relativeTeamT)
    RelativeLayout relativeTeamT;

    List<TeamJItem> menuResponseList;
    List<TeamKiiiItem> menuResponseListt;
    List<TeamTItem> menuResponseListtt;

    JAdapter jAdapter;
    JPresenter jPresenter;

    KiiiAdapter kiiiAdapter;
    KiiiPresenter kiiiPresenter;

    TAdapter tAdapter;
    TPresenter tPresenter;

    final int fallDown = R.anim.layout_animation_fall_down;
    final int fallUp = R.anim.layout_animation_fall_up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setView();
        jPresenter.getData();
        kiiiPresenter.getData();
        tPresenter.getData();


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setView() {
        relativeTeamJ.setVisibility(View.GONE);
        relativeTeamK.setVisibility(View.GONE);
        relativeTeamT.setVisibility(View.GONE);
        menuResponseList = new ArrayList<>();
        jPresenter = new JPresenter(MainRepositoryInject.provideToInjectJ(getApplicationContext()));
        jPresenter.onAttachView(this);
        jAdapter = new JAdapter(MainActivity.this, menuResponseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(jAdapter);
        runLayoutAnimation(recyclerView);
        recyclerView.setVisibility(View.GONE);
        relativeTeamJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickJ();

            }
        });
        tvTeamJExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickJ();

            }
        });
        dropJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickJ();
            }
        });


        menuResponseListt = new ArrayList<>();
        kiiiPresenter = new KiiiPresenter(MainRepositoryInject.provideToInjectK(getApplicationContext()));
        kiiiPresenter.onAttachView(this);
        kiiiAdapter = new KiiiAdapter(MainActivity.this, menuResponseListt);
        recyclerViewKiii.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewKiii.setAdapter(kiiiAdapter);
        recyclerViewKiii.setVisibility(View.GONE);
        relativeTeamK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickKiii();
            }
        });
        tvTeamKIIIExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickKiii();

            }
        });
        dropKIII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickKiii();

            }
        });

        menuResponseListtt = new ArrayList<>();
        tPresenter = new TPresenter(MainRepositoryInject.provideToInjectT(getApplicationContext()));
        tPresenter.onAttachView(this);
        tAdapter = new TAdapter(MainActivity.this, menuResponseListtt);
        recyclerViewT.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewT.setAdapter(tAdapter);
        recyclerViewT.setVisibility(View.GONE);
        relativeTeamT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onClickT();
            }
        });
        tvTeamTExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickT();

            }
        });
        dropT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onClickT();

            }
        });
    }

    @Override
    public void onSucces(List<TeamJItem> menuResponses, String msg) {
        menuResponseList.clear();
        menuResponseList.addAll(menuResponses);
        jAdapter.notifyDataSetChanged();
        jPresenter.onDetachView();
        shimmerViewContainer.stopShimmerAnimation();
        shimmerViewContainer.setVisibility(View.GONE);
        relativeTeamJ.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess(List<TeamKiiiItem> menuResponses, String msg) {
        menuResponseListt.clear();
        menuResponseListt.addAll(menuResponses);
        kiiiAdapter.notifyDataSetChanged();
        kiiiPresenter.onDetachView();
        shimmerViewContainer.stopShimmerAnimation();
        shimmerViewContainer.setVisibility(View.GONE);
        relativeTeamK.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccesss(List<TeamTItem> menuResponses, String msg) {
        menuResponseListtt.clear();
        menuResponseListtt.addAll(menuResponses);
        tAdapter.notifyDataSetChanged();
        tPresenter.onDetachView();
        shimmerViewContainer.stopShimmerAnimation();
        shimmerViewContainer.setVisibility(View.GONE);
        relativeTeamT.setVisibility(View.VISIBLE);
    }

    @Override
    public void onError(String msg) {
        toast(msg);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        shimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerViewContainer.stopShimmerAnimation();
    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void onClickJ(){
        if (recyclerView.getVisibility() == View.GONE) {
            recyclerView.setVisibility(View.VISIBLE);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), fallDown);
            recyclerView.setLayoutAnimation(animation);
            dropJ.animate().rotation(180).start();
        } else {
            recyclerView.setVisibility(View.GONE);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), fallUp);
            recyclerView.setLayoutAnimation(animation);
            dropJ.animate().rotation(360).start();
        }
    }

    private void onClickKiii(){
        if (recyclerViewKiii.getVisibility() == View.GONE) {
            recyclerViewKiii.setVisibility(View.VISIBLE);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), fallDown);
            recyclerViewKiii.setLayoutAnimation(animation);
            dropKIII.animate().rotation(180).start();
        } else {
            recyclerViewKiii.setVisibility(View.GONE);
            dropKIII.animate().rotation(360).start();
        }
    }

    private void onClickT(){
        if (recyclerViewT.getVisibility() == View.GONE) {
            recyclerViewT.setVisibility(View.VISIBLE);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), fallDown);
            recyclerViewT.setLayoutAnimation(animation);
            dropT.animate().rotation(180).start();
        } else {
            recyclerViewT.setVisibility(View.GONE);
            dropT.animate().rotation(360).start();
        }
    }
}
