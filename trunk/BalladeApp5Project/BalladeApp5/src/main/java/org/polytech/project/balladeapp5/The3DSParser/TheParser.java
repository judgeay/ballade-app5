package org.polytech.project.balladeapp5.The3DSParser;

import java.io.File;
import java.util.ArrayList;

import org.polytech.project.balladeapp5.Mesh;
import org.polytech.project.balladeapp5.Vector2;
import org.polytech.project.balladeapp5.Vector3;

public class TheParser {

	/**
	 * Genere une liste de maillages. Retourne une liste vide si erreur
	 * d'ouverture, lecture, ou fichier vide.
	 * 
	 * @param path
	 *            Chemin vers le fichier 3DS.
	 * @return ArrayList<Mesh>
	 */
	public ArrayList<Mesh> parseIt(String path) {
		File file = new File(path);

		Model model = null;
		try {
			model = ModelLoader.load3dModel(file);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Mesh> objects = new ArrayList<Mesh>();
		if (file == null || model == null) {
			return objects;
		}

		for (ModelObject o : model.objects) {
			objects.add(convert(o));
		}
		return objects;
	}

	public Mesh convert(ModelObject object) {
		Mesh m = new Mesh();
		for (int i = 0; i < object.polygons.length; i += 3) {
			// premier point
			float x = object.vertices[3 * object.polygons[i]];
			float y = object.vertices[3 * object.polygons[i] + 1];
			float z = object.vertices[3 * object.polygons[i] + 2];
			Vector3 p1 = new Vector3(x, y, z);
			// second point
			x = object.vertices[3 * object.polygons[i + 1]];
			y = object.vertices[3 * object.polygons[i + 1] + 1];
			z = object.vertices[3 * object.polygons[i + 1] + 2];
			Vector3 p2 = new Vector3(x, y, z);
			// troisieme point
			x = object.vertices[3 * object.polygons[i + 2]];
			y = object.vertices[3 * object.polygons[i + 2] + 1];
			z = object.vertices[3 * object.polygons[i + 2] + 2];
			Vector3 p3 = new Vector3(x, y, z);
			// ajout des points (issus des polygones) au maillage
			// (dans le bon sens pour l'affichage)
			m.vertices.add(p1);
			m.vertices.add(p2);
			m.vertices.add(p3);
			// recherche de la normale
			Vector3 n1 = new Vector3(p2.x() - p1.x(), p2.y() - p1.y(), p2.z()
					- p1.z());
			Vector3 n2 = new Vector3(p3.x() - p2.x(), p3.y() - p2.y(), p3.z()
					- p2.z());
			m.normals.add(n1.cross(n2));
		}

		for (int i = 0; i < object.textureCoordinates.length; i += 2) {
			// recuperation des coordonnees de texture
			float x = object.textureCoordinates[i];
			float y = object.textureCoordinates[i + 1];
			m.texCoords.add(new Vector2(x, y));
			m.colors.add(new Vector3(200, 200, 200));
		}
		return m;
	}
}
