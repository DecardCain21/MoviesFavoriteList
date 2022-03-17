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

public class FilmListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Objfilm> objfilmslist = new ArrayList<>();
    LayoutInflater layoutInflater;
    private ItemClickListener onItemClickListener;
    //private boolean isGrid = false;


    public FilmListAdapter(Context context,List<Objfilm> objfilmslist, ItemClickListener itemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.onItemClickListener = itemClickListener;
        this.objfilmslist = objfilmslist;
    }

    /*public void setGrid(boolean isGrid){
        this.isGrid = isGrid;
    }*/

    @Override
    public int getItemViewType(int position) {
        return 0;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View vNew = layoutInflater.inflate(R.layout.item, parent, false);
        vh = new ViewHolder(vNew);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Objfilm film = objfilmslist.get(position);
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).bindView(film, onItemClickListener);
        }
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
