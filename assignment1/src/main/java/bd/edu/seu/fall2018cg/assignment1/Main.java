package bd.edu.seu.fall2018cg.assignment1;

import bd.edu.seu.fall2018cg.assignment1.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public Main() {
        try {
            // Read the entire input file as stream
            // note that the first line no longer specifies the number of inputs to process
            Files.lines(Paths.get("input.txt"))
                    // for each line of input
                    .forEach(line -> {
                        // split the line into tokens using space as the delimiter
                        String[] tokens = line.split("\\ ");
                        // prepare an object name that we can use for the file as well as the object itself
                        String objectName = Arrays.asList(tokens).stream().collect(Collectors.joining("_"));

                        // the first token tells us what type of object it is
                        // for each object we read additional parameters from the remaining tokens
                        // then we create the mesh and write them to their corresponding obj files
                        // the obj files are placed under the obj directory
                        switch (tokens[0]) {
                            case "prism":
                                int sides = Integer.parseInt(tokens[1]);
                                double prismRadius = Double.parseDouble(tokens[2]);
                                double prismHeight = Double.parseDouble(tokens[3]);
                                Prism prism = new Prism(objectName, sides, prismRadius, prismHeight);
                                prism.writeObjToFile("obj/" + objectName + ".obj");
                                break;
                            case "cube":
                                double length = Double.parseDouble(tokens[1]);
                                Cube cube = new Cube(objectName, length);
                                cube.writeObjToFile("obj/" + objectName + ".obj");
                                break;
                            case "sphere":
                                double sphereRadius = Double.parseDouble(tokens[1]);
                                int rings = Integer.parseInt(tokens[2]);
                                int segments = Integer.parseInt(tokens[3]);
                                Sphere sphere = new Sphere(objectName, sphereRadius, rings, segments);
                                sphere.writeObjToFile("obj/" + objectName + ".obj");
                                break;
                            case "helix":
                                double innerRadius = Double.parseDouble(tokens[1]);
                                double outerRadius = Double.parseDouble(tokens[2]);
                                double distanceBetweenRings = Double.parseDouble(tokens[2]);
                                double helixHeight = Double.parseDouble(tokens[3]);
                                Helix helix = new Helix(objectName, innerRadius, outerRadius, distanceBetweenRings, helixHeight);
                                helix.writeObjToFile("obj/" + objectName + ".obj");
                                break;
                            default:
                                break;
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Main();
    }
}
