package bd.edu.seu.fall2018cg.assignment1.model;

/**
 *
 * @author  <a href="mailto:kmhasan@seu.edu.bd">Monirul Hasan</a>
 */
public class Prism extends Mesh {
    private int sides;
    private double radius;
    private double height;

    public Prism(String name, int sides, double radius, double height) {
        super(name);
        this.sides = sides;
        this.radius = radius;
        this.height = height;
        generateMesh();
    }

    public Prism(int sides, double radius, double height) {
        this(null, sides, radius, height);
    }

    private void generateMesh() {
        double theta = 2 * Math.PI / sides;

        for (int i = 0; i < sides; i++) {
            double x = radius * Math.cos(theta * i);
            double y = radius * Math.sin(theta * i);
            double z = 0.0;
            getVertexList().add(new Vertex(x, y, z));
        }

        for (int i = 0; i < sides; i++) {
            double x = radius * Math.cos(theta * i);
            double y = radius * Math.sin(theta * i);
            double z = height;
            getVertexList().add(new Vertex(x, y, z));
        }

        // to understand how these numbers are generated and connected to form a face,
        // have a look at the prism.png file
        Face bottomFace = new Face();
        for (int i = sides; i >= 1; i--)
            bottomFace.getVertexIndexList().add(i);
        getFaceList().add(bottomFace);

        Face topFace = new Face();
        for (int i = sides + 1; i <= sides + sides; i++)
            topFace.getVertexIndexList().add(i);
        getFaceList().add(topFace);

        for (int i = 0; i < sides; i++) {
            Face sideFace = new Face();
            sideFace.getVertexIndexList().add((i) % (sides) + 1);
            sideFace.getVertexIndexList().add((i + 1) % (sides) + 1);
            sideFace.getVertexIndexList().add((i + 1) % (sides) + 1 + sides);
            sideFace.getVertexIndexList().add((i + sides) % (2 * sides) + 1);
            getFaceList().add(sideFace);
        }

    }
}
