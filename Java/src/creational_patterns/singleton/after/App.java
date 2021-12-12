package creational_patterns.singleton.after;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, ClassNotFoundException {
        /* synchronized */
        Settings settings = Settings.getInstance();
        Settings settings2 = Settings.getInstance();
        System.out.println(settings == settings2);
        /* eager initialization */
        Settings2 settings3 = Settings2.getInstance();
        Settings2 settings4 = Settings2.getInstance();
        System.out.println(settings3 == settings4);
        /* double checked locking */
        Settings3 settings5 = Settings3.getInstance();
        Settings3 settings6 = Settings3.getInstance();
        System.out.println(settings5 == settings6);
        /* static inner class */
        Settings4 settings7 = Settings4.getInstance();
        Settings4 settings8 = Settings4.getInstance();
        System.out.println(settings7 == settings8);
        /* Enum */
        Settings5 settings9 = Settings5.INSTANCE;
        Settings5 settings10 = Settings5.INSTANCE;
        System.out.println(settings9 == settings10);

        /* Reflection */
        Settings instance = Settings.getInstance();
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings instance2 = constructor.newInstance();
        System.out.println(instance == instance2);

        /* Serialization & Deserialization */
        Settings instance3 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(instance);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            instance3 = (Settings) in.readObject();
        }
        System.out.println(instance == instance3);
    }
}
