package hibernate.entities;

/**
 * Created by root on 20.06.17.
 */
public class Dragon extends AbstractAnimal {
    private int maxFlyingTime;

    public Dragon() {
    }

    public Dragon(int maxFlyingTime) {
        this.maxFlyingTime = maxFlyingTime;
    }

    public Dragon(int maxFlyingTime,int weight,int height) {
        setMaxFlyingTime(maxFlyingTime);
        setHeight(height);
        setWeight(weight);
    }


    public int getMaxFlyingTime() {
        return maxFlyingTime;
    }

    public void setMaxFlyingTime(int maxFlyingTime) {
        this.maxFlyingTime = maxFlyingTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dragon{");
        sb.append(" id=").append(id);
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", maxFlyingTime=").append(maxFlyingTime);
        sb.append('}');
        return sb.toString();
    }
}
