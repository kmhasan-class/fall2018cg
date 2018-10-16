package bd.edu.seu.fall2018cg.assignment1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author  <a href="mailto:kmhasan@seu.edu.bd">Monirul Hasan</a>
 */
public class Face {
    /**
     * An ArrayList of vertex indices. The numbering of vertices start at 1. There is no validation on this class
     * that ensures that we are using vertices from within the right range.
     */
    private List<Integer> vertexIndexList;

    public Face() {
        vertexIndexList = new ArrayList<>();
    }

    public List<Integer> getVertexIndexList() {
        return vertexIndexList;
    }

    /**
     * Creates a String representation of the face that is suitable for the .obj format
     *
     * @return a String starting with "f" for face followed by the vertex indices. Each vertex index is preceded by
     * a single space.
     */
    public String toString() {
        return "f " + vertexIndexList
                .stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(" "));
    }
}
