package hibernate.entities;

/**
 * Created by root on 20.06.17.
 */
public class Elephant extends AbstractAnimal {
    private int earWidth;

    public Elephant() {
    }

    public Elephant(int earWidth) {
        this.earWidth = earWidth;
    }
    public Elephant(int earWidth,int weight,int height) {
        setEarWidth(earWidth);
        setHeight(height);
        setWeight(weight);
    }

    public int getEarWidth() {
        return earWidth;
    }

    public void setEarWidth(int earWidth) {
        this.earWidth = earWidth;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Elephant{");
        sb.append(" id=").append(id);
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", earWidth=").append(earWidth);
        sb.append('}');
        return sb.toString();
    }
}
