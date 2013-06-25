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

        double x, y, z;
        int color = -1;
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
                throw new FileNotFoundException("Fichier non trouvé: " + path);
            }


            do {
                // Lecture de la ligne suivante
                ligne = ficTexte.readLine();
                if (ligne != null) {
                    // Traiter jusque rencontre un objet à créer (Polyline, etc.)
                    if(ligne.equals("LINE"))
                    {


                    }
                    else if(ligne.equals("POLYLINE"))
                    {
                        Mesh MeshCourante = new Mesh();
                        x = y = z = 0;
                        codeCourant = -1 ;
                        do
                        {
                            // lecture d'une ligne de données inutile
                            ligne = ficTexte.readLine();
                            codeCourant = Integer.parseInt(ligne);
                            switch (codeCourant)
                            {
                                case 0 :
                                    // Ajouter le vertex courant à la mesh
                                    MeshCourante.vertices.add(new Vector3(x, y, z));
                                    MeshCourante.colors.add(ColorAutocad.AutoCADcolors.get(color));
                                    // réinitialiser un vertex pour l'ajouter dans la prochaine passe
                                    x = y = z = 0;
                                    // couleur par défaut = noir
                                    color = 0;
                                    break;
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
                                    color = Integer.parseInt(ligne);
                                    break;
                                default :
                                    // rien à faire, simplement ne pas traiter l'information (inutile pour notre représentation)
                                    break;
                            }
                            ligne = ficTexte.readLine();
                        } while ((codeCourant != 0) && (!ligne.equals("SEQEND")));

                        result.add(MeshCourante);
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
