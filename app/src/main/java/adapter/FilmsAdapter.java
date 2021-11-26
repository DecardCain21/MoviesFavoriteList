package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.marat.hvatit.tupit.R;

import java.util.ArrayList;

import com.marat.hvatit.tupit.model.Objfilm;

public class FilmsAdapter extends BaseAdapter {
    //Какого хуя тут делает контекст,и почему так?
    Context ctx;
    //Создание массива данных,для понимания с чем работать адаптеру
    ArrayList<Objfilm> objfilmslist;
    //Инициализация Inflater`a,он надувает макет(указать макет,указать где раздуть)
    LayoutInflater layoutInflater;

    //Создание конструктора кастомного адаптера(подкласса BaseAdapter)
    public FilmsAdapter(Context context, ArrayList<Objfilm> products) {
        ctx = context;
        objfilmslist = products;
        //хуй знает что он делает,но делает(использует getView,каким-то образом)
        //вызывается извне Activity,вместе с контекстом(?)
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //Создание вложенного класса ViewHolder,для реализации одноименного паттерна
    private class ViewHolder {
        final ImageView imageholder;
        final TextView imdboneholder, imdbtwoholder, metacriticholder, nameholder;

        //Создание конструктора класса,с присвоением ссылок на макет
        private ViewHolder(View view) {
            imdboneholder = view.findViewById(R.id.tvamdbone);
            imdbtwoholder = view.findViewById(R.id.tvamdbtwo);
            metacriticholder = view.findViewById(R.id.tvmetacritic);
            nameholder = view.findViewById(R.id.tvname);
            imageholder = view.findViewById(R.id.filmone);
        }
    }

    //Реализация методов родителя,класса BaseAdapter
    //Получение значения массива данных
    @Override
    public int getCount() {
        return objfilmslist.size();
    }

    //Получение конкретного значения из массива данных
    @Override
    public Object getItem(int position) {
        return objfilmslist.get(position);
    }

    public int getViewTypeCount(int position) {
        return (objfilmslist.get(position).isFavorite()) ? 1 : 2;
    }

    //Без заморочек с Id,почему?
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Создание экземпляра вложенного класса ViewHolder
        ViewHolder viewHolder;
        if (convertView == null) {
            //раздутие объекта convertView на кастомном макете item.xml
            //получение View элемента из файла item.xml,считывание атрибутов у convertView

            if (getViewTypeCount(position) == 1) {
                convertView = layoutInflater.inflate(R.layout.item, parent, false);
            } else {
                convertView = layoutInflater.inflate(R.layout.mirror_item, parent, false);
            }
            //инициализация объекта класса ViewHolder
            viewHolder = new ViewHolder(convertView);//View нужна чтоб я мог внутри ViewHolder-а использовать ее элементы из XML разметки,сетить
            //применение метода класса View,который позволяет связать представление с объектом
            convertView.setTag(viewHolder);
        } else {
            //получение представления,данных textView,imageView?
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //Создание временного объекта по позиции в массиве для привязки
        Objfilm p = getObjfilm(position);

        viewHolder.nameholder.setText(p.getName());
        viewHolder.imdboneholder.setText(String.valueOf(p.getimdbone()));
        viewHolder.imdbtwoholder.setText(String.valueOf(p.getimdbtwo()));
        viewHolder.metacriticholder.setText(String.valueOf(p.getmetacritic()));
        viewHolder.imageholder.setImageResource(p.getImage());

        //Возвращает convertView элемент с привязкой
        return convertView;
    }

    //Реализация основого метода адаптера, формирование элемента списка
   /* @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView,для оптимизации прокрутки(не создавать новые view,а переиспользовать имеющиеся)
        View view = convertView;
        //При прокрутке вниз существующий View выталкивается вверх из поля зрения
        //Вместо того, чтобы уничтожить его, теперь его можно использовать повторно
        if (view == null) {
            //(Макет(надуватель),родительский макет(main activity),рут(наследование)
            view = layoutInflater.inflate(R.layout.item, parent, false);
        }
        //Создание временного объекта по позиции в массиве для привязки
        Objfilm p = getObjfilm(position);
        //Привязка view элементов item`a|создание по шаблону
        ((TextView) view.findViewById(R.id.tvname)).setText(p.getName());
        ((TextView) view.findViewById(R.id.tvamdbone)).setText(String.valueOf(p.getimdbone()));
        ((TextView) view.findViewById(R.id.tvamdbtwo)).setText(String.valueOf(p.getimdbtwo()));
        ((TextView) view.findViewById(R.id.tvmetacritic)).setText(String.valueOf(p.getmetacritic()));
        ((ImageView) view.findViewById(R.id.filmone)).setImageResource(p.getImage());

        //Возвращает view элемент с привязкой
        return view;
    }*/


    public Objfilm getObjfilm(int position) {
        return (Objfilm) getItem(position);
    }
}
