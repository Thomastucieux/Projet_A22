package packmain;

import java.io.Console;
import java.util.Scanner;
import packglad.Facade;

public class Menu
{
  public static void main(String[] args)
  {
      Facade.lancerJeu();
      Scanner sc = new Scanner(System.in);
      boolean fin = false;
      while ( ! fin )
      {
          
          // affichage du menu
          System.out.println("==========================================================================");
          menu();
          System.out.println();
          System.out.println("==========================================================================");
          // saisie choix
          int choix = sc.nextInt();
          int idG, idA, idE;
          

          switch (choix)
          {
              case 0:
                  Facade.lancerJeuDEssai();
                  break;

              case 1: // Creer un Retiaire 
                  System.out.println("Nom du retiaire ? ");
                  String nomret = sc.next();
                  System.out.println("Agilite ? ");
                  int agilite = sc.nextInt(); 
                  System.out.println("Id ethnie ? ");
                  idE =  sc.nextInt();
                  idG = Facade.creerRetiaire(nomret, agilite, idE); 
                  System.out.println("Creation de retiaire avec identifiant: " + idG);
                  break;

              case 2: // Creer un Mirmillon 
                  System.out.println("Nom du mirmillon ? ");
                  String nommir = sc.next();
                  System.out.println("Poids ? ");
                  int poids = sc.nextInt(); 
                  System.out.println("Id ethnie ? ");
                  idE =  sc.nextInt();
                  idG = Facade.creerMirmillon(nommir, poids, idE); 
                  System.out.println("Creation de mirmillon avec identifiant: " + idG);
                  break;

              case 3: // Creer une arme 
                  System.out.println("Nom de l'arme ? ");
                  String nom = sc.next();
                  System.out.println("Puissance offensive ? ");
                  int puissanceOff =  sc.nextInt();
                  System.out.println("Puissance defensive ? ");
                  int puissanceDef =  sc.nextInt();
                  idA = Facade.creerUneArme(nom, puissanceOff, puissanceDef);
                  System.out.println("Creation d'une arme d'identifiant: " + idA);
                  break;

              case 4: // Autoriser l'arme d'identifiant ida aux mirmillons 
                  System.out.println("Id de l'arme ? ");
                  idA =  sc.nextInt();
                  Facade.autoriserArmeAuxMirmillons(idA);
                  break;

              case 5: // Autoriser l'arme d'identifiant ida aux retiaires 
                  System.out.println("Id de l'arme ? ");
                  idA =  sc.nextInt();
                  Facade.autoriserArmeAuxRetiaires(idA);
                  break;
              
              case 6: // Lister armes autorisees pour mirmillons
                     
                  for (int ida: Facade.listerArmesDispoMirmillon()) {
                     System.out.println(Facade.decrireArme(ida));
                  }
                  break;

              case 7: // Lister armes autorisees pour retiaires
                     
                  for (int ida: Facade.listerArmesDispoRetiaire()) {
                     System.out.println(Facade.decrireArme(ida));
                  }
                  break;

              case 8: // Debut de combat ; lister tous les gladiateurs : salut et armes
                  for (int idg: Facade.listerTousGladiateurs()) {
                     System.out.print(Facade.faireSaluerGladiateur(idg));
                         System.out.print(" ; Mes armes : ");
                         for(Integer i:Facade.declarerArmes(idg))System.out.print(Facade.nomDeLArme(i)+", ");
                         System.out.println();
                     }
                  break;

              case 9: // Lister les gladiateurs d'une ethnie avec leur rapport complet
                  System.out.println("Id ethnie ? ");
                  idE =  sc.nextInt();
                  // TODO : ligne d'entête (libelles colonnes)
                  for (int idg: Facade.listerGladiateursDEthnie(idE)) {
                     System.out.println(Facade.faireRapport(idg));
                  }
                  break;

              case 10: // Lister les ethnies 
                 
                  for (int ide: Facade.listerEthnies()) {
                     System.out.println(Facade.decrireEthnie(ide));
                  }
                  break;

              case 11: // Afficher le rapport d'un gladiateur (d'identifiant idg)");
                 
                  System.out.println("Id gladiateur ? ");
                  idG =  sc.nextInt();
                  System.out.println(Facade.faireRapport(idG));
                  break;

              case 12 : // Donner une arme a� un gladiateur 
                  System.out.println("Id arme ? ");
                  idA = sc.nextInt();
                  System.out.println("Id gladiateur ? ");
                  idG = sc.nextInt();
                  Facade.donnerUneArme(idA, idG);
                  break;
              
              case 13 : // Frapper (agresseur, victime, arme)
                  System.out.println("Id agresseur ? ");
                  int idAgresseur =  sc.nextInt();
                  System.out.println("Id victime ? ");
                  int idVictime =  sc.nextInt();
                  System.out.println("Id arme ? ");
                  int idArme =  sc.nextInt();
                  Facade.frapper(idAgresseur, idVictime, idArme);
                  break;

              case 14 : // Desarmer un gladiateur 
                  System.out.println("Id gladiateur ? ");
                  idG =  sc.nextInt();
                  System.out.println("Id arme ? ");
                  idA =  sc.nextInt();
                  Facade.desarmer(idG, idA);
                  break;

              case 15 : //Afficher le(s) vainqueur(s) avec le score et les rapports de tous les gladiateurs
              System.out.println("    ====== scores ==============");
              for (Integer ide : Facade.listerEthnies())
                  System.out.println(Facade.decrireEthnie(ide));
              System.out.println();
              System.out.println("    ====== rapports ==============");
              
              for (Integer idg : Facade.listerTousGladiateurs())
                  System.out.println(Facade.faireRapport(idg));
              System.out.println("    ===== vainqueurs ===============");
              for(Integer ide:Facade.vainqueurs())System.out.println(Facade.decrireEthnie(ide));
              System.out.println();
                  break;

              case 16: // suppression d'un gladiateur
                  System.out.println("Id gladiateur ? ");
                  idG = sc.nextInt();
                  Facade.supprimerGlad(idG);
                  break;

              case 98: // modifier parametres du jeu
                  System.out.println("Vie initiale ? ");
                  int vie =  sc.nextInt();
                  System.out.println("Force retiaires ? ");
                  int force =  sc.nextInt();
                  System.out.println("Poids max (mirmillons) ? ");
                  int poidsMax =  sc.nextInt();
                  System.out.println("Agilite max (retiaires) ? ");
                  int agiliteMax =  sc.nextInt();
                  Facade.parametrage(vie, force, poidsMax, agiliteMax);
                  break;

              case 99:
                  fin = true;
                  break;

              default: 
                  System.out.println("Erreur choix !");
                  break;   
          }

      }
  } // end Main


  static void menu()
  {
      System.out.println("0.  Lancer le jeu d'essai initial	");
      System.out.println("1.  Creer un retiaire");
      System.out.println("2.  Creer un mirmillon");
      System.out.println("3.  Creer une arme");
      System.out.println("4.  Autoriser l'arme d'identifiant ida aux mirmillons");
      System.out.println("5.  Autoriser l'arme d'identifiant ida aux retiaires");
      System.out.println();
      System.out.println("6.  Lister les armes disponibles aux mirmillons");
      System.out.println("7.  Lister les armes disponibles aux retiaires");
      System.out.println("8.  (Debut de combat) : Lister tous les gladiateurs : salut et armes");
      System.out.println("9.  Lister les gladiateurs d'une ethnie avec leur rapport complet");
      System.out.println("10. Lister les ethnies");
      System.out.println("11. Afficher le rapport d'un gladiateur (d'identifiant idg)");
      System.out.println();
      System.out.println("12. Donner une arme a un gladiateur");
      System.out.println("13. Frapper (idg agresseur, idg agresse, ida arme utilisee)");
      System.out.println("14. Desarmer un gladiateur");
      System.out.println("15. (Fin de combat) : Affiche le(s) vainqueur(s) et les rapports de tous les gladiateurs");
      System.out.println("16. Supprimer un gladiateur");
      System.out.println("98. Modifier parametres du jeu (vie initiale, force retiaires, poids et agilite max");
      System.out.println("99. Quitter le jeu");
      System.out.print("Choix ? (0..16 ou 98 ou 99) ");

  }
}
