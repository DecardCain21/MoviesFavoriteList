package com.marat.hvatit.tupit.model;

import com.marat.hvatit.tupit.model.interfaces.Provider;
import com.marat.hvatit.tupit.model.filmmodel.FilmGenre_ids;
import com.marat.hvatit.tupit.model.filmmodel.Filmmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneretorFilmmodel implements Provider<Filmmodel> {


    public ArrayList<Filmmodel> generateSomf(int count) {
        ArrayList<Filmmodel> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(getData(i));
        }
        return list;
    }

    public Filmmodel getData(int data){
        ArrayList <Filmmodel> filmmodelArrayList = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        String bladeRunner = "В недалеком будущем мир населен людьми и репликантами, созданными выполнять самую тяжелую работу. Работа офицера полиции Кей - держать репликантов под контролем в условиях нарастающего напряжения... Пока он случайно не становится обладателем секретной информации, которая ставит под угрозу существование всего человечества. Желая найти ключ к разгадке, Кей решает разыскать Рика Декарда, бывшего офицера специального подразделения полиции Лос-Анджелеса, который бесследно исчез много лет назад.";
        String greenBook = "1960-е годы. После закрытия нью-йоркского ночного клуба на ремонт вышибала Тони по прозвищу Болтун ищет подработку на пару месяцев. Как раз в это время Дон Ширли, утонченный светский лев, богатый и талантливый чернокожий музыкант, исполняющий классическую музыку, собирается в турне по южным штатам, где ещё сильны расистские убеждения и царит сегрегация. Он нанимает Тони в качестве водителя, телохранителя и человека, способного решать текущие проблемы. У этих двоих так мало общего, и эта поездка навсегда изменит жизнь обоих.";
        String interstate = "В легендах и мифах есть персонажи, главная задача которых — исполнять желания. У арабов — это джинны, у ирландцев — лепреконы, у китайцев — драконы, у европейцев — феи и лесные духи. А в Америке есть некто О. Ж. Грант — довольно странный и забавный человек, который тоже может исполнить любое Ваше желание. Но будьте осторожны — он очень проказлив! Вот его-то и встречает однажды Нейл Оливер. Нейл вполне доволен своей жизнью: у него обеспеченные родители, симпатичная невеста и впереди блестящая карьера юриста. Но с недавних пор по ночам ему стала сниться загадочная девушка, которую он никак не может выбросить из головы. Чудаковатый Грант приглашает Нейла совершить поездку по таинственной автостраде 60, которой нет ни на одной карте США. И Нейл бросает все и пускается в самое невероятное и рискованное путешествие в своей жизни, решив, во что бы то ни стало разыскать незнакомку из своих снов.";
        String reservoirDogs = "Это должно было стать идеальным преступлением. Задумав ограбить ювелирный магазин, криминальный босс Джо Кэбот собрал вместе шестерых опытных и совершенно незнакомых друг с другом преступников. Но с самого начала все пошло не так, и обычный грабеж превратился в кровавую бойню.";
        String starWars = "Идёт третий год Войн клонов. Галактическая Республика, некогда бывшая спокойным и гармоничным государством, превратилась в поле битвы между армиями клонов, возглавляемых канцлером Палпатином, и армадами дроидов, которых ведёт граф Дуку, тёмный лорд ситхов. Республика медленно погружается во тьму. Лишь рыцари-джедаи, защитники мира и справедливости, могут противостоять злу, которое вскоре поглотит галактику. Но настоящая битва идёт в душе у молодого рыцаря-джедая Энакина, который разрывается между долгом джедая и любовью к своей жене, сенатору Падме Амидале. И от того, какое чувство в нём победит, зависит будущее всего мира.";
        String theGreenMile = "Пол Эджкомб - начальник блока смертников в тюрьме «Холодная гора», каждый из узников которого однажды проходит «зеленую милю» по пути к месту казни. Пол повидал много заключённых и надзирателей за время работы. Однако гигант Джон Коффи, обвинённый в страшном преступлении, стал одним из самых необычных обитателей блока.";
        String theHobbit = "Бильбо Бэггинс становится участником грандиозного путешествия, цель которого — вернуть Королевство гномов Эребор, захваченное драконом Смогом. Неожиданно к нему присоединяется волшебник Гэндальф Серый, и Бильбо оказывается в компании тринадцати гномов под предводительством легендарного воина Торина Дубощита. Опасными тропами это путешествие приводит их в Дикие Земли, кишащие гоблинами и орками, смертоносными варгами и меняющими облик, гигантскими пауками и колдунами. Там скромный Бильбо Бэггинс и становится обладателем «прелестного» кольца Голлума, которое таит в себе странные и неожиданные возможности… Это простое золотое кольцо связано с судьбой Средиземья настолько тесно, что Бильбо и представить себе этого не может.";
        String theLordofTheRings = "Сказания о Средиземье — это хроника Великой войны за Кольцо, войны, длившейся не одну тысячу лет. Тот, кто владел Кольцом, получал власть над всеми живыми тварями, но был обязан служить злу. Тихая деревня, где живут хоббиты. Волшебник Гэндальф, придя на 111-й день рождения к своему старому другу Бильбо Бэггинсу, начинает вести разговор о кольце, которое Бильбо нашёл много лет назад. Это кольцо принадлежало когда-то тёмному властителю Средиземья Саурону, и оно даёт большую власть своему обладателю. Теперь Саурон хочет вернуть себе власть над Средиземьем. Бильбо отдаёт найденное кольцо своему племяннику Фродо, который пытается научиться справляться с тем страшным могуществом, которое даёт ему кольцо…";
        String thorRagnarok = "Вернувшись в Асгард в поисках таинственного врага, ведущего охоту на Камни Бесконечности, Тор обнаруживает, что действия его брата Локи, захватившего трон Асгарда, привели к приближению наиболее страшного события — Рагнарёка. По легенде, это ознаменует последнюю битву Асгарда, последствием которой станет его полное уничтожение. В попытке предотвратить это событие, Тору предстоит прибегнуть к помощи своего товарища из Мстителей — Халка. Вместе, им предстоит столкнуться лицом к лицу со злейшим врагом всех девяти миров — огненным демоном Суртуром, целью которого является исполнение пророчества о Рагнарёке и уничтожение девяти миров.";
        String warrior = "Младший сын спившегося боксера возвращается домой, чтобы отец тренировал его для предстоящего турнира по боевым искусствам. Однако, на этом пути бойцу придется столкнуться со своим старшим братом.";

        //.........................................................
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+1,"eng","Bladerunner 2049"+String.valueOf(i),bladeRunner,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+2,"eng","Greenbook"+String.valueOf(i),greenBook,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+3,"eng","Interstate 60"+String.valueOf(i),interstate,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+4,"eng","Reservoir dogs"+String.valueOf(i),reservoirDogs,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+5,"eng","Star Wars episode 3"+String.valueOf(i),starWars,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+6,"eng","The Green Mile"+String.valueOf(i),theGreenMile,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+7,"eng","The Hobbit"+String.valueOf(i),theHobbit,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+8,"eng","The Lord of the Rings"+String.valueOf(i),theLordofTheRings,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+9,"eng","Thor:Ragnarok"+String.valueOf(i),thorRagnarok,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        filmmodelArrayList.add(new Filmmodel(random.nextBoolean(),"Backdroppath",new FilmGenre_ids(new int[]{1,2,3}),100+10,"eng","Warrior"+String.valueOf(i),warrior,100+i,"Posterpath"+String.valueOf(i),"Releasedata"+String.valueOf(i),"Film"+String.valueOf(i),random.nextBoolean(),i,i,random.nextBoolean()));
        return filmmodelArrayList.get(data);
    }

    @Override
    public List<Filmmodel> provide() {
        return generateSomf(10);
    }
}
