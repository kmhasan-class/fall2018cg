package bd.edu.seu.fall2018cg.assignment1.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  <a href="mailto:kmhasan@seu.edu.bd">Monirul Hasan</a>
 */
public class Mesh {
    private String name;
    private List<Vertex> vertexList;
    private List<Face> faceList;

    public Mesh() {
        vertexList = new ArrayList<>();
        faceList = new ArrayList<>();
    }

    public Mesh(String name) {
        this();
        this.name = name;
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public List<Face> getFaceList() {
        return faceList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("o ").append(name).append('\n');
        vertexList
                .stream()
                .forEach(vertex -> sb.append(vertex).append('\n'));
        faceList
                .stream()
                .forEach(face -> sb.append(face).append('\n'));
        return sb.toString();
    }

    public void writeObjToFile(String filename) {
        try {
            Files.write(Paths.get("./" + filename), toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
