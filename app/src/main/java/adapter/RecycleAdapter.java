package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marat.hvatit.tupit.R;
import com.marat.hvatit.tupit.model.Objfilm;

import java.util.ArrayList;

import static com.marat.hvatit.tupit.model.Objfilm.FAVORITE;
import static com.marat.hvatit.tupit.model.Objfilm.GRID;
import static com.marat.hvatit.tupit.model.Objfilm.NEW;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    ArrayList<Objfilm> objfilmslist;
    LayoutInflater layoutInflater;
    private ItemClickListener onItemClickListener;

    public RecycleAdapter(Context context, ArrayList<Objfilm> listfilms, ItemClickListener itemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.objfilmslist = listfilms;
        this.onItemClickListener = itemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return (objfilmslist.get(position).isFavorite()) ? NEW : FAVORITE;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        if (viewType == GRID) {
            View vGrid = layoutInflater.inflate(R.layout.filmonegradienttest, parent, false);
            viewHolder = new ViewHolder(vGrid);
        }
        if (viewType == NEW) {
            View vNew = layoutInflater.inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(vNew);
        } else {
            View vFavorite = layoutInflater.inflate(R.layout.mirror_item, parent, false);
            viewHolder = new ViewHolder(vFavorite);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
        final Objfilm film = objfilmslist.get(position);
        holder.itemView.setOnClickListener(view -> {
            onItemClickListener.onItemClick(objfilmslist.get(position));
        });
        holder.nameholder.setText(film.getName());
        holder.imdboneholder.setText(String.valueOf(film.getimdbone()));
        holder.imdbtwoholder.setText(String.valueOf(film.getimdbtwo()));
        holder.metacriticholder.setText(String.valueOf(film.getmetacritic()));
        holder.imageholder.setImageResource(film.getImage());
    }

    public interface ItemClickListener {
        void onItemClick(Objfilm objfilm);
    }

    @Override
    public int getItemCount() {
        return objfilmslist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageholder;
        final TextView imdboneholder;
        final TextView imdbtwoholder;
        final TextView metacriticholder;
        final TextView nameholder;
        View root;

        private ViewHolder(View view) {
            super(view);

            root = view;
            imdboneholder = view.findViewById(R.id.tvamdbone);
            imdbtwoholder = view.findViewById(R.id.tvamdbtwo);
            metacriticholder = view.findViewById(R.id.tvmetacritic);
            nameholder = view.findViewById(R.id.tvname);
            imageholder = view.findViewById(R.id.filmone);
        }
    }
}
