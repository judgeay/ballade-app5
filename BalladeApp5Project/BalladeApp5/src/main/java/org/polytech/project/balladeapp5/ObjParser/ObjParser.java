package org.polytech.project.balladeapp5.ObjParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.polytech.project.balladeapp5.Mesh;
import org.polytech.project.balladeapp5.Vector2;
import org.polytech.project.balladeapp5.Vector3;

import android.content.res.Resources;

public class ObjParser {
	private final String VERTEX = "v";
	private final String FACE = "f";
	private final String TEXCOORD = "vt";
	private final String NORMAL = "vn";
	private final String OBJECT = "o";

	private String _path;

	public ObjParser(String path) {
		this._path = path;
	}

	public ArrayList<Mesh> parse() throws FileNotFoundException {
		FileInputStream fileIn;
		String line;

		BufferedReader file = new BufferedReader(new FileReader(new File(this._path)));
		ArrayList<Mesh> meshes = new ArrayList<Mesh>();
		if (file == null) {
            throw new FileNotFoundException("Fichier manquant : " + this._path);
        }

		// public ArrayList<Vector3> vertices;
		// public ArrayList<Vector2> texCoords;
		// public ArrayList<Vector3> normals;
		// public ArrayList<Vector3> colors;

		try {
			while ((line = file.readLine()) != null) {
				// remove duplicate whitespace
				// line = line.replaceAll("\\s+", " ");
				// String[] parts = line.split(" ");
				StringTokenizer parts = new StringTokenizer(line, " ");
				int numTokens = parts.countTokens();
				if (numTokens == 0)
					continue;
				String type = parts.nextToken();

				if (type.equals(VERTEX)) {
					Mesh current = meshes.get(meshes.size());
					double x = Float.parseFloat(parts.nextToken());
					double y = Float.parseFloat(parts.nextToken());
					double z = Float.parseFloat(parts.nextToken());
					current.vertices.add(new Vector3(x, y, z));
				} else if (type.equals(TEXCOORD)) {
					Mesh current = meshes.get(meshes.size());
					double u = Float.parseFloat(parts.nextToken());
					double v = Float.parseFloat(parts.nextToken()) * -1f;
					current.texCoords.add(new Vector2(u, v));
				} else if (type.equals(NORMAL)) {
					Mesh current = meshes.get(meshes.size());
					double x = Float.parseFloat(parts.nextToken());
					double y = Float.parseFloat(parts.nextToken());
					double z = Float.parseFloat(parts.nextToken());
					current.normals.add(new Vector3(x, y, z));
				} else if (type.equals(OBJECT)) {
					meshes.add(new Mesh());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return meshes;
	}
}
