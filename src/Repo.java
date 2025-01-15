import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a generic repository.
 * @param <T>
 */
public class Repo<T> {
    private List<T> entities = new ArrayList<>();

    public void create(T entity) {
        entities.add(entity);
    }

    public T readById(int id) {
        for (T entity : entities) {
            try {
                int entityId = (int) entity.getClass().getDeclaredField("id").get(entity);
                if (entityId == id) {
                    return entity;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean update(int id, T updatedEntity) {
        for (int i = 0; i < entities.size(); i++) {
            try {
                int entityId = (int) entities.get(i).getClass().getDeclaredField("id").get(entities.get(i));
                if (entityId == id) {
                    entities.set(i, updatedEntity);
                    return true; // Update successful
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return entities.removeIf(entity -> {
            try {
                int entityId = (int) entity.getClass().getDeclaredField("id").get(entity);
                return entityId == id;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        });
    }

    public List<T> getAll() {
        return entities;
    }
}
