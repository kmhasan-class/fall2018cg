package bd.edu.seu.fall2018cg.assignment1.model;

/**
 *
 * @author  <a href="mailto:kmhasan@seu.edu.bd">Monirul Hasan</a>
 */
public class Vertex {
    private double x;
    private double y;
    private double z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("v %12.6f %12.6f %12.6f", x, y, z);
    }
}
