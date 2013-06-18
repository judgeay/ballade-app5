package org.polytech.project.balladeapp5;

import java.util.ArrayList;

/**
 * Created by remipraud on 18/06/13.
 */
public class Mesh
{
    ArrayList<Vector3> vertices;
    ArrayList<Vector2> texCoords;
    ArrayList<Vector3> normals;
    ArrayList<Vector3> colors;

    // Indices for vertex/texcoord/normal values in the
    // vertices/texCoords/normals arrays
    ArrayList<Index> indices;

    public Mesh()
    {
        vertices = new ArrayList<Vector3>();
        texCoords = new ArrayList<Vector2>();
        normals = new ArrayList<Vector3>();
        colors = new ArrayList<Vector3>();

        indices = new ArrayList<Index>();
    }
}