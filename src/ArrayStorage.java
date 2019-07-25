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
        int incUuid = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }

            if (storage[i] != null) {
                storage[incUuid] = storage[i];
                incUuid++;
            }
        }
        size--;
        storage = Arrays.copyOf(storage, 10000);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] completedResumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            Arrays.copyOf(completedResumes, completedResumes.length + 1);
            completedResumes[i] = storage[i];
        }
        return completedResumes;
    }

    int size() {
        return size;
    }
}
