package id.co.dzaky.shimmermvp.ui.member.teamkiii;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.dzaky.shimmermvp.R;
import id.co.dzaky.shimmermvp.model.member.TeamJItem;
import id.co.dzaky.shimmermvp.model.member.TeamKiiiItem;
import id.co.dzaky.shimmermvp.repository.detailmembers.DetailMemberRemote;
import id.co.dzaky.shimmermvp.ui.detailmember.DetailMember;
import id.co.dzaky.shimmermvp.ui.member.teamj.JAdapter;

public class KiiiAdapter extends RecyclerView.Adapter<KiiiAdapter.ViewHolder> {

    Context context;
    List<TeamKiiiItem> menuResponseList;



    public KiiiAdapter(Context context, List<TeamKiiiItem> menuResponseList) {
        this.context = context;
        this.menuResponseList = menuResponseList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.linear)
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipe_list_layout, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final TeamKiiiItem teamKiiiItem = menuResponseList.get(i);
        final int id = teamKiiiItem.getId();
        final String img = teamKiiiItem.getImage();
        setFadeAnimation(viewHolder.itemView);
        viewHolder.name.setText(teamKiiiItem.getSurname());
        Glide.with(context)
                .load(img)
                .into(viewHolder.thumbnail);
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailMember.class);
                i.putExtra("id", id);
                i.putExtra("image", img);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuResponseList.size();
    }

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        view.startAnimation(anim);
    }
}
