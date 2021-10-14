package utils;

import java.util.LinkedList;
import java.util.List;

public class ObjectStore {
    private static List<Object> objectStore = new LinkedList<>();

    public static List<Object> getObjectStore() {
        return objectStore;
    }

    public static void storeObject(Object obj){
        objectStore.add(obj);
    }

}
