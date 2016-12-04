package ua.training;

import ua.training.controller.TextController;
import ua.training.model.text.IText;
import ua.training.model.text.Text;
import ua.training.view.ConsoleView;
import ua.training.view.IView;

public class App {

    public static void main(String[] args) {
        IText text = new Text("Первые   попытки-пытки соб'рать 3.14 и " +
                "обобщить разрозненные воспоминания современников об " +
                "увлечении Наполеоном I шахматами предприняла редакция журнала " +
                "«Le Palamede», которую тогда возглавлял известный шахматист " +
                "и литератор Луи Шарль Маэ де Лабурдонне, в 1836 и 1839 " +
                "годах. Были опубликованы две небольшие заметки, которые " +
                "привлекли к проблеме внимание общественности (заметка " +
                "1836 года называлась «Наполеон, любитель шахмат», она " +
                "была подписана инициалом «М», за которым, как предполагают, " +
                "скрывался один из издателей журнала — Мари де Мери)[8]. " +
                "14 августа 1836 года первые три номера этого издания " +
                "приобрёл Александр Сергеевич Пушкин, он успел ознакомиться " +
                "только со страницами 1—17, которые разрезал для чтения. " +
                "На страницах 12—13 была размещена статья о Наполеоне и " +
                "шахматах[9].");
        IView view = new ConsoleView();
        TextController controller = new TextController(text, view);
        controller.execute();
    }
}
