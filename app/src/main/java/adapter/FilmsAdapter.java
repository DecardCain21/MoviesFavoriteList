package adapter;

import android.content.Context;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.marat.hvatit.tupit.R;

import java.util.ArrayList;
import java.util.List;

import model.Objfilm;

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

    //Без заморочек с Id,почему?
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Реализация основого метода адаптера, формирование элемента списка
    @Override
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
    }

    public Objfilm getObjfilm(int position) {
        return (Objfilm) getItem(position);
    }
}
