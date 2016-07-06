package ua.com.smiddle.agent_scripting.core;

/**
 * Исполнительный класс. Конфигурация подключения к базе данных в persistence.xml
 * @version 1.0
 * @author KSA
 */

public class AppInitializer {

    public static void main(String[] args) {
        Executor e = new Executor();
        /*
        установка параметров
         */
        // указать количество пользователей, которые будут участвовать в тесте
        e.setUserCount(60);
        // установить уровень логирования, макс. - 3
        e.setDEBUG_LEVEL(0);
        // установить адрес хоста серверного приложения
        e.setHost("http://172.22.2.34:80/AgentScripting");
        //индентификатор скрипта
        e.setScriptID(9L);
        /*
        подготовка (проверка наличия пользователей, создание потоков и их подготовка)
         */
        e.prepare();
        /*
        выполнить проверку и вывести показатели в консоль
         */
        e.execute();
    }
}
