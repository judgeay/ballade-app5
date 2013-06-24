package org.polytech.project.balladeapp5.DXFParser;

import org.polytech.project.balladeapp5.Mesh;
import org.polytech.project.balladeapp5.Vector3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florent si si rpzt les fleuves de la Seine & Marne !! on 20/06/13.
 */
public class DXFParser {

    public static List<Mesh> ParseDXFFile (String path) throws IOException
    {
        ArrayList<Mesh> result = new ArrayList<Mesh>();
        Mesh myMesh;
        boolean vertexAjoute = false;
        double x, y, z;
        int codeCourant = -1;
        // ouvrir un stream du fichier
        String ligne = "";
        // Test respect de la nomenclature des fichiers
        if (path.substring(path.length() - 4, path.length()).equalsIgnoreCase(".dxf"))
           throw new IllegalArgumentException("Wrong format - expected file format: .dxf");

        BufferedReader ficTexte;
        try {
            ficTexte = new BufferedReader(new FileReader(new File(path)));
            if (ficTexte == null) {
                throw new FileNotFoundException("Fichier non trouvé: "
                        + fichier);
            }
            do {
                ligne = ficTexte.readLine();
                if (ligne != null) {
                    // Traiter jusque rencontre un objet à créer (Polyline, etc.)
                    if(ligne.equals("LINE"))
                    {


                    }
                    else if(ligne.equals("POLYLINE"))
                    {
                        ligne = ficTexte.readLine();
                        Mesh MeshCourante = new Mesh();
                        while (!ligne.equals("VERTEX"))
                            ligne = ficTexte.readLine();

                        do {
                            x = y = z = 0;
                            Vector3 myVector = new Vector3();
                            Vector3 myColor = new Vector3();
                                ligne = ficTexte.readLine();
                                if (ligne != null) {
                                    codeCourant = Integer.parseInt(ligne);
                                    // Fin de description du vertex
                                    if (codeCourant == 0)
                                    {
                                        newMesh.vertices.add(myVector);
                                        newMesh.colors.add(myColor);
                                        vertexAjoute = true;
                                        ligne = ficTexte.readLine();
                                        break;
                                    }
                                    ligne = ficTexte.readLine();
                                    switch (codeCourant)
                                    {
                                        case 10 :
                                            x = Double.parseDouble(ligne);
                                            break;
                                        case 20 :
                                            y = Double.parseDouble(ligne);
                                            break;
                                        case 30 :
                                            z = Double.parseDouble(ligne);
                                            break;
                                        case 62 :
                                            myColor = ColorAutocad.AutoCADcolors.get(Integer.parseInt(ligne));
                                            break;
                                        default :
                                            // lire la ligne de données inutile pour notre projet
                                            ligne = ficTexte.readLine();
                                            break;
                                    }

                                }
                                newMesh.vertices = null;
                            } while (!vertexAjoute);

                            if (newMesh.colors.size() == 0)
                                newMesh.colors.add(0, new Vector3(0,0,0));

                            result.add(newMesh);
                        }


                    }
                }
            } while (ficTexte != null);
            ficTexte.close();
        } catch (FileNotFoundException fException) {
            System.out.println(fException.getMessage());
        } catch (IOException IOEx) {
            System.out.println(IOEx.getMessage());
        }
        return result;
    }

}
