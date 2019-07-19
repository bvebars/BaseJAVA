import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            System.out.println("Первое: " + uuid);
            if(storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
//        return storage[0];
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i].uuid.equals(uuid)) {
              storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        return storage.length;
    }
}
