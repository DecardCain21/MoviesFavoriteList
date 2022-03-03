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

import static com.marat.hvatit.tupit.model.interfaces.RowType.FAVORITE_ROW_TYPE;
import static com.marat.hvatit.tupit.model.interfaces.RowType.GRID_ROW_TYPE;
import static com.marat.hvatit.tupit.model.interfaces.RowType.NEW_ROW_TYPE;

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Objfilm> objfilmslist = new ArrayList<>();
    LayoutInflater layoutInflater;
    private ItemClickListener onItemClickListener;


    public RecycleAdapter(Context context, ItemClickListener itemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.onItemClickListener = itemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (objfilmslist.get(position).getFilmType() == GRID_ROW_TYPE) {
            return GRID_ROW_TYPE;
        }
        if (objfilmslist.get(position).getFilmType() == NEW_ROW_TYPE) {
            return NEW_ROW_TYPE;
        }
        if (objfilmslist.get(position).getFilmType() == FAVORITE_ROW_TYPE) {
            return FAVORITE_ROW_TYPE;
        } else {
            return 0;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == GRID_ROW_TYPE) {
            View vGrid = layoutInflater.inflate(R.layout.filmonegradienttest, parent, false);
            vh = new ViewHolderGrid(vGrid);
        } else if (viewType == NEW_ROW_TYPE) {
            View vNew = layoutInflater.inflate(R.layout.item, parent, false);
            vh = new ViewHolder(vNew);
        } else {
            View vFavorite = layoutInflater.inflate(R.layout.mirror_item, parent, false);
            vh = new ViewHolder(vFavorite);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Objfilm film = objfilmslist.get(position);
        if(holder instanceof ViewHolder) {
            ((ViewHolder)holder).bindView(film, onItemClickListener);
        }
        if(holder instanceof ViewHolderGrid){
            ((ViewHolderGrid)holder).bindView(film,onItemClickListener);
        }
    }


    public void update(List<Objfilm> list) {
        this.objfilmslist = list;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClick(Objfilm objfilm);
    }

    @Override
    public int getItemCount() {
        return objfilmslist.size();
    }

    public static class ViewHolderGrid extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameholder;
        View root;

        public ViewHolderGrid(View view) {
            super(view);

            root = view;
            imageView = view.findViewById(R.id.filmone);
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

        public void bindView(Objfilm objfilm, ItemClickListener itemClickListener) {
            itemView.setOnClickListener(view -> {
                itemClickListener.onItemClick(objfilm);
            });
            nameholder.setText(objfilm.getName());
            imdboneholder.setText(String.valueOf(objfilm.getimdbone()));
            imdbtwoholder.setText(String.valueOf(objfilm.getimdbtwo()));
            metacriticholder.setText(String.valueOf(objfilm.getmetacritic()));
            imageholder.setImageResource(objfilm.getImage());
        }
    }
}
