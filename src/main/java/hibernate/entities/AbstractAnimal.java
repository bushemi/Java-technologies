package hibernate.entities;

/**
 * Created by root on 20.06.17.
 */
public abstract class AbstractAnimal {
    int weight=0;
    int height=0;
    long id=0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
