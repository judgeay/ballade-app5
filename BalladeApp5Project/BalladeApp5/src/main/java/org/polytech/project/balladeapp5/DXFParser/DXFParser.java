package org.polytech.project.balladeapp5.DXFParser;

import android.util.Log;

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
        int cpt = 0;
        double x, y, z;
        int color = 0;
        int codeCourant = -1;
        // ouvrir un stream du fichier
        String ligne = "";
        // Test respect de la nomenclature des fichiers
        if (path.substring(path.length() - 5, path.length()).equalsIgnoreCase(".dxf"))
            throw new IllegalArgumentException("Wrong format - expected file format: .dxf");

        BufferedReader ficTexte;
        try {
            ficTexte = new BufferedReader(new FileReader(new File(path)));
            if (ficTexte == null) {
                throw new FileNotFoundException("Fichier non trouvÃ©: " + path);
            }


            do {
                // Lecture de la ligne suivante
                ligne = ficTexte.readLine();
                ++cpt;
                if (ligne != null) {
                    // DEBUG ++cpt;
                    //if (cpt % 500 == 0)
                    System.out.println(cpt);

                    if(ligne.equals("EOF"))
                        break; // on quit

                    // Traiter jusque rencontre un objet Ã  crÃ©er (Polyline, etc.)
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
                            // lecture d'une ligne de donnÃ©es inutile
                            ligne = ficTexte.readLine();

                            ligne = ligne.trim();
                            codeCourant = Integer.parseInt(ligne);
                            ligne = ficTexte.readLine();
                            ++cpt;
                            //if (cpt % 500 == 0)
                            System.out.println(cpt);
                            switch (codeCourant)
                            {
                                case 0 :
                                    // Ajouter le vertex courant Ã  la mesh
                                    MeshCourante.vertices.add(new Vector3(x, y, z));
                                    MeshCourante.colors.add(ColorAutocad.AutoCADcolors.get(color));
                                    // rÃ©initialiser un vertex pour l'ajouter dans la prochaine passe
                                    x = y = z = 0;
                                    // couleur par dÃ©faut = noir
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
                                    // rien Ã  faire, simplement ne pas traiter l'information (inutile pour notre reprÃ©sentation)
                                    break;
                            }
                        } while ((!ligne.equals("SEQEND"))); //(codeCourant != 0) &&

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

