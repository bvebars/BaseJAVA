import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        size--;
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (storage[i].uuid.equals(uuid)) {
                j++;
            }
            storage[i] = storage[j];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] completedResumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            completedResumes[i] = storage[i];
        }
        return completedResumes;
    }

    int size() {
        return size;
    }
}
