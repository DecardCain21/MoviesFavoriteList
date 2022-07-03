package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marat.hvatit.tupit.R;
import com.marat.hvatit.tupit.model.Objfilm;

import java.util.ArrayList;
import java.util.List;

import static com.marat.hvatit.tupit.model.interfaces.RowType.GRID_ROW_TYPE;

public class FilmGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Objfilm> objfilmslist = new ArrayList<>();
    LayoutInflater layoutInflater;
    private ItemClickListener onItemClickListener;
    //private boolean isUngrid = true;


    public FilmGridAdapter(Context context, List<Objfilm> objfilmslist, ItemClickListener itemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.onItemClickListener = itemClickListener;
        this.objfilmslist = objfilmslist;
    }

    /*public void setUngrid(boolean isGrid) {
        this.isUngrid = isGrid;
    }*/

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View vGrid = layoutInflater.inflate(R.layout.filmonegradienttest, parent, false);
        vh = new FilmGridAdapter.ViewHolderGrid(vGrid);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Objfilm film = objfilmslist.get(position);
        if (holder instanceof ViewHolderGrid) {
            ((ViewHolderGrid) holder).bindView(film, onItemClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return objfilmslist.size();
    }

    public interface ItemClickListener {
        void onItemClick(Objfilm objfilm);
    }


    public static class ViewHolderGrid extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameholder;
        View root;

        public ViewHolderGrid(View view) {
            super(view);
            root = view;
            imageView = view.findViewById(R.id.filmonexy);
            nameholder = view.findViewById(R.id.tvname);
        }

        public void bindView(Objfilm objfilm, ItemClickListener itemClickListener) {
            itemView.setOnClickListener(view -> {
                itemClickListener.onItemClick(objfilm);
            });
            nameholder.setText(objfilm.getName());
            imageView.setImageResource(objfilm.getImage());
        }
    }
}
