import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    Resume[] saveUuid = new Resume[1];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[saveUuid.length - 1] = r;
        saveUuid = Arrays.copyOf(storage,saveUuid.length + 1);
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (storage[1].uuid.equals(uuid)) {
                System.out.println(resume);
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] renameUuid = new Resume[size()];
        int incUuid = 0;
        //Поиск и изменение ячейки на null
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {

                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                }
            }
        }
        //Создание нового массива без дырок, ограниченной длинны
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] != null) {
                renameUuid[incUuid] = storage[i];
                incUuid++;
            }
        }

        storage = Arrays.copyOf(renameUuid, 10000);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume [] arr = new Resume[size()];
        System.out.println( "размер: " + size());

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                Arrays.copyOf(arr, arr.length + 1);
                arr[i] = storage[i];
            }
        }
        return arr;
    }

    int size() {
        int amountResume = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                amountResume++;
            }
        }
       return amountResume;
    }
}
