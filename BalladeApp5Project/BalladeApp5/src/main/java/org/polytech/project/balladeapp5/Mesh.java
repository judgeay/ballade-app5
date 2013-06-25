package org.polytech.project.balladeapp5;

import java.util.ArrayList;

/**
 * Created by remipraud on 18/06/13.
 */
public class Mesh
{
    public ArrayList<Vector3> vertices;
    public ArrayList<Vector2> texCoords;
    public ArrayList<Vector3> normals;
    public ArrayList<Vector3> colors;

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