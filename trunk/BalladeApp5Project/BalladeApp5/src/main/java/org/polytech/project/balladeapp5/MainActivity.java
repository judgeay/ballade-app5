package org.polytech.project.balladeapp5;

import java.awt.Menu;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polytech.project.balladeapp5.KMLParser.Kml;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		super.onStart();

		InputStream is = null;

		System.out.println("toto");

		File file = new File("/sdcard/KML_Samples.kml");

		try {
			is = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Serializer serializer = new Persister();
		Kml kml = null;

		try {
			kml = serializer.read(Kml.class, is);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (kml.getDocument() != null) {
			List<String> allCoordinates = kml.getDocument().getAllCoordinates();
			List<Mesh> finalMesh = updateMesh(allCoordinates);
			System.out.println(finalMesh.size());
			for (Mesh mesh : finalMesh) {
				System.out.println(mesh.vertices.get(0).x());
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static List<Mesh> updateMesh(List<String> coordList) {
		List<Mesh> meshList = new ArrayList<Mesh>();
		for (String current : coordList) {
			String[] vertices = current.split("\n");
			List<String> verticesList = Arrays.asList(vertices);
			Mesh temp = new Mesh();

			for (String currentVertex : verticesList) {
				String[] returnValue = currentVertex.split(",");
				List<String> list = Arrays.asList(returnValue);
				int isOk = list.size() % 3;
				if (isOk == 0) {
					Vector3 test = new Vector3(Double.parseDouble(list.get(0)),
							Double.parseDouble(list.get(1)),
							Double.parseDouble(list.get(2)));
					temp.vertices.add(test);
				}
			}
			meshList.add(temp);
		}

		return meshList;
	}
}
