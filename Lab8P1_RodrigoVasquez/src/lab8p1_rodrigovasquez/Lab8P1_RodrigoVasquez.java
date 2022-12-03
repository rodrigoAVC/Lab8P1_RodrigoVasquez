package lab8p1_rodrigovasquez;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab8P1_RodrigoVasquez {

    public static void main(String[] args) {
        Scanner touchGrass = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("--------- B I E N V E N I D O ---------");
            System.out.println("1. Pocket Monsters\n2. DC vs Marvel\n3. Salir");
            System.out.print("Ingrese que ejercicio desea ejecutar: ");
            choice = touchGrass.nextInt();
            switch (choice) {
                case 1:
                    pokemon();
                    break;
                case 2:
                    superHeroes();
                    break;
                default:
                    break;
            }
        } while (choice == 1 || choice == 2);
    }

    public static void pokemon() {
        Scanner spartan = new Scanner(System.in);
        Scanner sunnari = new Scanner(System.in);
        Scanner evandel = new Scanner(System.in);
        System.out.println("--- W H O ' S   R E A D Y   F O R   A   C H A L L E N G E ? ---");
        ArrayList<Pokemon> listaP1 = new ArrayList<Pokemon>();
        int contP1 = 0;
        char optionP1 = 's';
        do {
            System.out.print("Jugador 1, ingrese un Pokemon: ");
            String nombreP1 = sunnari.next();
            System.out.print("Ingrese los puntos de vida de ese pokemon: ");
            int vida = spartan.nextInt();
            if (vida > 300) {
                System.out.println("La vida no puede ser mayor de 300");
            } else if (vida < 1) {
                System.out.println("La vida no puede ser 0 o menor");
            } else {
                System.out.print("Ingrese los puntos de ataque de ese pokemon: ");
                int ataque = spartan.nextInt();
                if (ataque < 1) {
                    System.out.println("El poder de ataque no puede ser 0 o menor");
                } else {
                    int luck = new Random().nextInt((5 - 1) + 1) + 1;
                    Pokemon pokeP1 = new Pokemon(nombreP1, vida, ataque, luck);
                    listaP1.add(pokeP1);
                    contP1++;
                    System.out.print("¿Desea ingresar otro pokemon? [S/N]: ");
                    optionP1 = evandel.next().charAt(0);
                    if (contP1 > 3) {
                        System.out.println("No se pueden ingresar mas pokemones");
                    }
                }
            }
        } while (contP1 < 4 && (optionP1 == 's' || optionP1 == 'S'));
        ArrayList<Pokemon> listaP2 = new ArrayList<Pokemon>();
        int contP2 = 0;
        char optionP2 = 's';
        do {
            System.out.print("Jugador 2, ingrese un Pokemon: ");
            String nombreP1 = sunnari.next();
            System.out.print("Ingrese los puntos de vida de ese pokemon: ");
            int vida = spartan.nextInt();
            if (vida > 300) {
                System.out.println("La vida no puede ser mayor de 300");
            } else if (vida < 1) {
                System.out.println("La vida no puede ser 0 o menor");
            } else {
                System.out.print("Ingrese los puntos de ataque de ese pokemon: ");
                int ataque = spartan.nextInt();
                if (ataque < 1) {
                    System.out.println("El poder de ataque no puede ser 0 o menor");
                } else {
                    int luck = new Random().nextInt((5 - 1) + 1) + 1;
                    Pokemon pokeP2 = new Pokemon(nombreP1, vida, ataque, luck);
                    listaP2.add(pokeP2);
                    contP2++;
                    System.out.print("¿Desea ingresar otro pokemon? [S/N]: ");
                    optionP2 = evandel.next().charAt(0);
                    if (contP2 > 3) {
                        System.out.println("No se pueden ingresar mas pokemones");
                    }
                }
            }
        } while (contP2 < 4 && (optionP2 == 's' || optionP2 == 'S'));
        System.out.println("Jugador 1: ");
        for (Pokemon pokemon : listaP1) {
            System.out.println(pokemon);
        }
        System.out.println("Jugador 2: ");
        for (Pokemon pokemon : listaP2) {
            System.out.println(pokemon);
        }
        int pokeP1 = contP1;
        int pokeP2 = contP2;
        rounds(listaP1, listaP2, pokeP1, pokeP2);
    }

    public static void rounds(ArrayList<Pokemon> listaP1, ArrayList<Pokemon> listaP2, int pokeP1, int pokeP2) {
        int rondas = 1;
        do {
            int vidaP1 = listaP1.get(0).getVida();
            int vidaP2 = listaP2.get(0).getVida();
            do {
                System.out.println("-------------------- Ronda " + rondas + " --------------------");
                int luckP1 = listaP1.get(0).getLuck();
                int luckP2 = listaP2.get(0).getLuck();
                String nombreP1 = listaP1.get(0).getNombre();
                String nombreP2 = listaP2.get(0).getNombre();
                if (luckP1 > luckP2 || luckP1 == luckP2) {
                    System.out.println(nombreP1 + " Ataca Primero       Vida: " + vidaP1 + "    Luck: " + luckP1);
                    System.out.println(nombreP2 + " Ataca Segundo       Vida: " + vidaP2 + "    Luck: " + luckP2);
                    int ataqueP1 = listaP1.get(0).getAtaque();
                    int ataqueP2 = listaP2.get(0).getAtaque();
                    vidaP1 = vidaP1 - ataqueP2;
                    listaP1.get(0).setVida(vidaP1);
                    vidaP2 = vidaP2 - ataqueP1;
                    listaP2.get(0).setVida(vidaP2);
                    System.out.println("**      Puntos Restantes:      **");
                    System.out.println(nombreP1 + " Tiene " + vidaP1 + " Restantes");
                    System.out.println(nombreP2 + " Tiene " + vidaP2 + " Restantes");
                } else if (luckP2 > luckP1) {
                    System.out.println(nombreP2 + " Ataca Primero       Vida: " + vidaP2 + "    Luck: " + luckP2);
                    System.out.println(nombreP1 + " Ataca Segundo       Vida: " + vidaP1 + "    Luck: " + luckP1);
                    int ataqueP1 = listaP1.get(0).getAtaque();
                    int ataqueP2 = listaP2.get(0).getAtaque();
                    vidaP1 = vidaP1 - ataqueP2;
                    vidaP2 = vidaP2 - ataqueP1;
                    System.out.println("**      Puntos Restantes      **");
                    System.out.println(nombreP2 + " Tiene " + vidaP2 + " Restantes");
                    System.out.println(nombreP1 + " Tiene " + vidaP1 + " Restantes");
                }
                rondas++;
                if (luckP1 > luckP2 || luckP1 == luckP2) {
                    if (vidaP1 < 1 && vidaP2 < 1) {
                        System.out.println("----  RESULTADOS  ----");
                        System.out.println(nombreP1 + " ES EL GANADOR");
                        listaP1.remove(0);
                        listaP2.remove(0);
                        pokeP1 = pokeP1 - 1;
                        pokeP2 = pokeP2 - 1;
                        rondas = 1; 
                    } else if (vidaP1 < 1) {
                        System.out.println("----  RESULTADOS  ----");
                        System.out.println(nombreP2 + " ES EL GANADOR");
                        listaP1.remove(0);
                        pokeP1 = pokeP1 - 1; 
                        rondas = 1; 
                    } else if (vidaP2 < 1) {
                        System.out.println("----  RESULTADOS  ----");
                        System.out.println(nombreP1 + " ES EL GANADOR");
                        listaP2.remove(0);
                        pokeP2 = pokeP2 - 1;
                        rondas = 1; 
                    }
                } else if (luckP2 > luckP1) {
                    if (vidaP1 < 1 && vidaP2 < 1) {
                        System.out.println("----  RESULTADOS  ----");
                        System.out.println(nombreP2 + " ES EL GANADOR");
                        listaP1.remove(0);
                        listaP2.remove(0);
                        pokeP1 = pokeP1 - 1;
                        pokeP2 = pokeP2 - 1;
                        rondas = 1; 
                    } else if (vidaP1 < 1) {
                        System.out.println("----  RESULTADOS  ----");
                        System.out.println(nombreP2 + " ES EL GANADOR");
                        listaP1.remove(0);
                        pokeP1 = pokeP1 - 1;
                        rondas = 1; 
                    } else if (vidaP2 < 1) {
                        System.out.println("----  RESULTADOS  ----");
                        System.out.println(nombreP1 + " ES EL GANADOR");
                        listaP2.remove(0);
                        pokeP2 = pokeP2 - 1;
                        rondas = 1; 
                    }
                }
            } while (vidaP1 > 0 && vidaP2 > 0);
            System.out.println("¡ C O N G R A T U L A C I O N E S !");
            if (pokeP1 == 0) {
                System.out.println("JUGADOR 1 NO PUEDE CONTINUAR");
            } else if (pokeP2 == 0) {
                System.out.println("JUGADOR 2 NO PUEDE CONTINUAR");
            }
        } while (pokeP1 > 0 && pokeP2 > 0);
    }

    public static void superHeroes() {
        Scanner strings = new Scanner(System.in);
        Scanner strings1 = new Scanner(System.in);
        System.out.println("----- D C   V S   M A R V E L -----");
        ArrayList<Superheroe> dc = new ArrayList<Superheroe>();
        Superheroe robin = new Superheroe("Damian Wayne", "Robin", "DC", "Ciudad Gótica");
        dc.add(robin);
        Superheroe batMan = new Superheroe("Bruce Wayne", "Batman", "DC", "Ciudad Gótica");
        dc.add(batMan);
        Superheroe superMan = new Superheroe("Clark Kent", "Superman", "DC", "Krypton");
        dc.add(superMan);
        Superheroe flash = new Superheroe("Barry Allen", "Flash", "DC", "Ciudad Central");
        dc.add(flash);
        Superheroe greenLantern = new Superheroe("Hal Jordan", "Green Lantern", "DC", "Ciudad Costera");
        dc.add(greenLantern);
        Superheroe wonderWoman = new Superheroe("Diana Prince", "Wonder Woman", "DC", "Themyscira");
        dc.add(wonderWoman);
        Superheroe aquaMan = new Superheroe("Arthur Curry", "Aquaman", "DC", "Atlantis");
        dc.add(aquaMan);
        Superheroe nightWing = new Superheroe("Dick Grayson", "Nightwing", "DC", "Ciudad Gótica");
        dc.add(nightWing);
        Superheroe shazam = new Superheroe("Billy Batson", "Shazam", "DC", "Fawcett City");
        dc.add(shazam);
        Superheroe raven = new Superheroe("Rachel Roth", "Raven", "DC", "Azarath");
        dc.add(raven);
        ArrayList<Superheroe> marvel = new ArrayList<Superheroe>();
        Superheroe captainAmerica = new Superheroe("Steve Rogers", "Captain America", "Marvel", "Nueva York");
        marvel.add(captainAmerica);
        Superheroe ironMan = new Superheroe("Anthony Stark", "Iron Man", "Marvel", "Nueva York");
        marvel.add(ironMan);
        Superheroe deadPool = new Superheroe("Wade Wilson", "Deadpool", "Marvel", "Canada");
        marvel.add(deadPool);
        Superheroe spiderMan = new Superheroe("Peter Parker", "Spiderman", "Marvel", "Nueva York");
        marvel.add(spiderMan);
        Superheroe wolverine = new Superheroe("James Howlett", "Wolverine", "Marvel", "Cold Lake");
        marvel.add(wolverine);
        Superheroe blackPanther = new Superheroe("T'Challa", "Black Panther", "Marvel", "Wakanda");
        marvel.add(blackPanther);
        Superheroe strange = new Superheroe("Stephen Strange", "Dr. Strange", "Marvel", "Nueva York");
        marvel.add(strange);
        Superheroe antMan = new Superheroe("Scott Lang", "Antman", "Marvel", "Coral Gables");
        marvel.add(antMan);
        Superheroe blackWidow = new Superheroe("Natasha Romanoff", "Black Widow", "Marvel", "Stalingrad");
        marvel.add(blackWidow);
        Superheroe thor = new Superheroe("Thor Odinson", "Thor", "Marvel", "Asgard");
        marvel.add(thor);
        System.out.print("¿Buscar o Agregar? ");
        String choose = strings.next();
        String choose1 = choose.toLowerCase();
        switch (choose1) {
            case "buscar":
                System.out.print("Ingrese el nombre: ");
                String nombreBuscar = strings.nextLine();
                nombreBuscar = strings.nextLine();
                for (int i = 0; i < dc.size(); i++) {
                    String nombreSuper = dc.get(i).getSuperNombre().toLowerCase();
                    String nombreBusqueda = dc.get(i).getNombre().toLowerCase(); 
                    if (nombreSuper.equalsIgnoreCase(nombreBuscar) || nombreBusqueda.equalsIgnoreCase(nombreBuscar)) {
                        System.out.println(dc.get(i));
                    }
                }
                for (int i = 0; i < marvel.size(); i++) {
                    String nombreSuper = marvel.get(i).getSuperNombre().toLowerCase();
                    String nombreBusqueda = marvel.get(i).getNombre().toLowerCase(); 
                    if (nombreSuper.equalsIgnoreCase(nombreBuscar) || nombreBusqueda.equalsIgnoreCase(nombreBuscar)) {
                        System.out.println(marvel.get(i));
                    }
                }
                break;
            case "agregar":
                System.out.print("Ingrese el nombre de heroe: ");
                String nombre = strings1.nextLine();
                System.out.print("Ingrese el nombre verdadero: ");
                String nombreReal = strings1.nextLine();
                System.out.print("Ingrese la franquicia: ");
                String company = strings1.next();
                System.out.print("Ingrese la ciudad de origen: ");
                String city = strings1.nextLine();
                strings1.nextLine();
                String company2 = company.toLowerCase();
                if (company2.equals("dc")) {
                    Superheroe newHero = new Superheroe(nombreReal, nombre, company, city);
                    dc.add(newHero);
                } else if (company2.equals("marvel")) {
                    Superheroe newHero = new Superheroe(nombreReal, nombre, company, city);
                    marvel.add(newHero);
                }
                System.out.println("¡Se ha añadido corectamente a " + nombre + " a la lista de " + company);
                break;
            default:
                System.out.println("Opción Inválida");
                break;
        }
    }
}
