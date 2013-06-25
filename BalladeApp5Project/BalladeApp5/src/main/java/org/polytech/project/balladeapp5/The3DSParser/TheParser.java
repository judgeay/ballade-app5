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
		}
		return objects;
	}

	public Mesh convert(ModelObject object) {
		Mesh m = new Mesh();
		System.out.println(object.vertices.length);
		for (int i = 0; i < object.vertices.length; i += 3) {
			Vector3 v = new Vector3(object.vertices[i], object.vertices[i + 1],
					object.vertices[i + 2]);
			m.vertices.add(v);
		}
		/*
		 * for (int i = 0; i < object.polygons.length; i++) { float v1 =
		 * object.vertices[object.polygons[i]]; float v2 =
		 * object.vertices[object.polygons[i] + 1]; float v3 =
		 * object.vertices[object.polygons[i] + 2]; }
		 */
		return m;
	}
}
