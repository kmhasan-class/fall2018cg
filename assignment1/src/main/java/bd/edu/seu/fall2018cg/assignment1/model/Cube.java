package bd.edu.seu.fall2018cg.assignment1.model;

/**
 *
 * @author  <a href="mailto:kmhasan@seu.edu.bd">Monirul Hasan</a>
 */
public class Cube extends Prism {
    /**
     * Constructs a cube with a given name and a set length for each side.
     *
     * @param name is the name of the object/mesh
     * @param length is the length of each side
     */
    public Cube(String name, double length) {
        // a cube can be thought of a special case of a prism
        // it has 4 sides for the base and the top
        // the height of the prism is the same as the length of each side
        // we need to calculate the radius of the base of the prism based on the length
        // we can find this radius with a simple calculation of the length of the hypotenuse of a right angled triangle
        super(name,4, length / Math.sqrt(2), length);
    }

    /**
     * Constructs a cube with a set length for each side. Name would be set to null.
     *
     * @param length is the length of each side
     */
    public Cube(double length) {
        this(null, length);
    }
}
