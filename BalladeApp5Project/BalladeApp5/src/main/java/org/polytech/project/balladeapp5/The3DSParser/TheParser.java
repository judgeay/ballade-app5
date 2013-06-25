package org.polytech.project.balladeapp5.The3DSParser;

import java.io.File;
import java.util.ArrayList;

import org.polytech.project.balladeapp5.Mesh;
import org.polytech.project.balladeapp5.Vector2;
import org.polytech.project.balladeapp5.Vector3;

public class TheParser {

	public ArrayList<Mesh> parseIt() {
		File file = new File("sphere.3ds");

		Model model = null;
		try {
			model = ModelLoader.load3dModel(file);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Mesh> objects = new ArrayList<Mesh>();
		for (ModelObject o : model.objects) {
			System.out.println(o.getName());
			objects.add(convert(o));
			break;
		}
		return objects;
	}

	public Mesh convert(ModelObject object) {
		Mesh m = new Mesh();
		ArrayList<Vector3> points = new ArrayList<Vector3>();
		System.out.println(object.vertices.length);
		for (int i = 0; i < object.vertices.length; i += 3) {
			// Vector3 v = ;
			// points.add(v);
		}
		System.out.println(object.polygons.length);
		for (int i = 0; i < object.polygons.length; i += 3) {
			float x = object.vertices[object.polygons[i]];
			float y = object.vertices[object.polygons[i] + 1];
			float z = object.vertices[object.polygons[i] + 2];
			Vector3 p1 = new Vector3(x, y, z);
			x = object.vertices[object.polygons[i + 1]];
			y = object.vertices[object.polygons[i + 1] + 1];
			z = object.vertices[object.polygons[i + 1] + 2];
			Vector3 p2 = new Vector3(x, y, z);
			x = object.vertices[object.polygons[i + 2]];
			y = object.vertices[object.polygons[i + 2] + 1];
			z = object.vertices[object.polygons[i + 2] + 2];
			Vector3 p3 = new Vector3(x, y, z);
			m.vertices.add(p1);
			m.vertices.add(p2);
			m.vertices.add(p3);
		}

		for (int i = 0; i < object.textureCoordinates.length; i += 2) {
			float x = object.textureCoordinates[i];
			float y = object.textureCoordinates[i + 1];
			m.texCoords.add(new Vector2(x, y));
		}
		m.colors.add(new Vector3(200, 200, 200));
		return m;
	}
}
