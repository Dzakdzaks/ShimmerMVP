package id.co.dzaky.shimmermvp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.dzaky.shimmermvp.R;
import id.co.dzaky.shimmermvp.model.member.TeamJItem;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<TeamJItem> menuResponseList;


    public MainAdapter(Context context, List<TeamJItem> menuResponseList) {
        this.context = context;
        this.menuResponseList = menuResponseList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.name)
        TextView name;
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
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int i) {
        final TeamJItem teamJ = menuResponseList.get(i);
        viewHolder.name.setText(teamJ.getSurname());
        Glide.with(context)
                .load(teamJ.getImage())
                .into(viewHolder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return menuResponseList.size();
    }
}
