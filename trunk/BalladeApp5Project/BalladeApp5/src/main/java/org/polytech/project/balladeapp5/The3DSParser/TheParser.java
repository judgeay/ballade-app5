package org.polytech.project.balladeapp5.The3DSParser;

import java.io.File;
import java.util.ArrayList;

import org.polytech.project.balladeapp5.Mesh;
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
			Vector3 v1 = new Vector3(object.vertices[object.polygons[i]],
					object.vertices[object.polygons[i] + 1],
					object.vertices[object.polygons[i] + 2]);
			Vector3 v2 = new Vector3(object.vertices[object.polygons[i + 1]],
					object.vertices[object.polygons[i + 1] + 1],
					object.vertices[object.polygons[i + 1] + 2]);
			Vector3 v3 = new Vector3(object.vertices[object.polygons[i + 2]],
					object.vertices[object.polygons[i + 2] + 1],
					object.vertices[object.polygons[i + 2] + 2]);
			m.vertices.add(v1);
			m.vertices.add(v2);
			m.vertices.add(v3);
			System.out.println("face : " + v1.toString() + ", " + v2.toString()
					+ ", " + v3.toString());
		}

		return m;
	}
}
