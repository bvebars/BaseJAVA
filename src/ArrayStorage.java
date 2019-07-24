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
    }

    void save(Resume r) {
        storage[storage.length - 10000] = r;
        storage = Arrays.copyOf(storage, storage.length + 1);
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            System.out.println(storage[i]);
            if (storage[i].uuid.equals(uuid)) {

                System.out.println(storage[i]);
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] renameUuid = new Resume[size];
        int incUuid = 0;

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }

            if (storage[i] != null) {
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
        Resume[] completedResumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            Arrays.copyOf(completedResumes, completedResumes.length + 1);
            completedResumes[i] = storage[i];
        }
        return completedResumes;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            }
        }
        return size;
    }
}
