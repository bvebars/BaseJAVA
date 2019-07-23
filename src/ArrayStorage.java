import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int incSave = 1;
    private int size = size();

    void clear() {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null){
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        storage[incSave - 1] = r;
        storage = Arrays.copyOf(storage,incSave + 1);
        incSave++;
    }

    Resume get(String uuid) {
    size = size();
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) {
                    System.out.println(storage[i]);
                    return storage[i];
                }
            }

        }
        return null;
    }

    void delete(String uuid) {
        Resume[] renameUuid = new Resume[3];
        int incUuid = 0;
        //Поиск и изменение ячейки на null
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) {

                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                }
            }
        }
        //Создание нового массива без дырок, ограниченной длинны
        for (int i = 0; i < size; i++) {
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
    size = size();
        Resume [] completedResumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) {
                Arrays.copyOf(completedResumes, completedResumes.length + 1);
                completedResumes[i] = storage[i];
            }
        }
        return completedResumes;
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
