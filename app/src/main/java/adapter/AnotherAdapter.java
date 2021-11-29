package adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.marat.hvatit.tupit.R;

import java.util.ArrayList;

import com.marat.hvatit.tupit.model.Objfilm;

import static com.marat.hvatit.tupit.model.Objfilm.FAVORITE;
import static com.marat.hvatit.tupit.model.Objfilm.NEW;

public class AnotherAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Objfilm> objfilmslist;
    LayoutInflater layoutInflater;


    public AnotherAdapter(Context context, ArrayList<Objfilm> products) {
        ctx = context;
        objfilmslist = products;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    private class ViewHolder {
        final ImageView imageholder;
        final TextView imdboneholder, imdbtwoholder, metacriticholder, nameholder;
        View root;


        private ViewHolder(View view) {
            root = view;
            imdboneholder = view.findViewById(R.id.tvamdbone);
            imdbtwoholder = view.findViewById(R.id.tvamdbtwo);
            metacriticholder = view.findViewById(R.id.tvmetacritic);
            nameholder = view.findViewById(R.id.tvname);
            imageholder = view.findViewById(R.id.filmone);
        }
    }

    @Override
    public int getCount() {
        return objfilmslist.size();
    }


    @Override
    public Object getItem(int position) {
        return objfilmslist.get(position);
    }

    public int getViewTypeCount(int position) {
        return (objfilmslist.get(position).isFavorite()) ? NEW : FAVORITE;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {

            if (getViewTypeCount(position) == NEW) {
                viewHolder = createViewHolder(parent,R.layout.item);
            } else {
                viewHolder = createViewHolder(parent,R.layout.mirror_item);
            }
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bindView(viewHolder, position);
        return viewHolder.root;
    }

    @NonNull
    private ViewHolder createViewHolder(final ViewGroup parent,final int layout) {
        ViewHolder viewHolder;
        View view = layoutInflater.inflate(layout, parent, false);
        viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return viewHolder;
    }


    private void bindView(final ViewHolder viewHolder, final int position) {
        final Objfilm film = getObjfilm(position);
        viewHolder.nameholder.setText(film.getName());
        viewHolder.imdboneholder.setText(String.valueOf(film.getimdbone()));
        viewHolder.imdbtwoholder.setText(String.valueOf(film.getimdbtwo()));
        viewHolder.metacriticholder.setText(String.valueOf(film.getmetacritic()));
        viewHolder.imageholder.setImageResource(film.getImage());
    }


    public Objfilm getObjfilm(int position) {
        return (Objfilm) getItem(position);
    }
}