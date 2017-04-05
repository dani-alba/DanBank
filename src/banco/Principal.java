package banco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    // BANCO
    static Banco b1 = new Banco("DAN BANK");

    public static void main(String[] args) {
        // VARIABLES
        int modo = 0;
        // CARGAR DATOS
        cargarDatos();
        // MENU
        System.out.println(titulo());
        do {
            try {
                modo = menu();
                switch (modo) {
                    case 1: //CREAR CUENTA
                        crearCuenta();
                        break;
                    case 2: // LISTA DE CUENTAS
                        listaCuentas();
                        break;
                    case 3: // INFORMACIÓN CUENTA
                        informacionCuenta();
                        break;
                    case 4:
                        gestionarTitulaes();
                        break;
                    case 5: // MODIFICAR DATOS DE LA CUENTA
                        modificarDatosCuenta();
                        break;
                    case 6: // BORRAR CUENTA
                        borrarCuenta();
                        break;
                    case 7: //AUTORIZAR PERSONAS
                        autorizarPersonas();
                        break;
                    case 8: //DESAUTORIZAR PERSONA
                        desautorizarPersona();
                        break;
                    case 9:   //INGRESAR DINERO
                        ingresarDinero();
                        break;
                    case 10: //SACAR DINERO
                        sacarDinero();
                        break;
                    case 11: // MOSTRAR REGISTRO
                        mostrarRegistro();
                        break;
                    case 12:
                        System.out.println(despedida());
                        break;

                }
                // CONTROL DEL MENU AL ELEGIR UN NÚMERO QUE NO TOCA
                if (modo > 12 || modo < 0) {
                    numMenuError();
                }
                // TRY CATCH AL METER UNA LETRA
            } catch (InputMismatchException e) {
                datoMenuError();
            }
            saltos_linea(3);
        } while (modo != 12);
    }

    public static String titulo() {
        String titulo;
        titulo = "      ___  _  ___  _ _  _ _  ___  _ _  _  ___  ___  ___         "
                + "___  ___  _ _   ___  ___  _ _  _ __ \n"
                + "     | . >| || __>| \\ || | || __>| \\ || || . \\| . |/ __>  ___  | . "
                + "\\| . || \\ | | . >| . || \\ || / / \n"
                + "     | . \\| || _> |   || ' || _> |   || || | || | |\\__ \\ |___| | | "
                + "||   ||   | | . \\|   ||   ||  \\ \n"
                + "     |___/|_||___>|_\\_||__/ |___>|_\\_||_||___/`___'<___/       |___/"
                + "|_|_||_\\_| |___/|_|_||_\\_||_\\_\\ \n";

        return titulo;
    }

    public static String despedida() {
        String despe, despe2;

        despe = "                                           "
                + "____                "
                + "_           \n"
                + "                                          "
                + "/ ___|_ __ __ _  ___(_) __ _ ___ \n"
                + "                                         "
                + "| |  _| '__/ _` |/ __| |/ _` / __|\n"
                + "                                         "
                + "| |_| | | | (_| | (__| | (_| \\__ \\\n"
                + "                                          "
                + "\\____|_|  \\__,_|\\___|_|\\__,_|___/";

        despe2 = "                  _____                                      _                            _ _       \n"
                + "                 |_   _|__ _ __   __ _  __ _   _   _ _ __   "
                + "| |__  _   _  ___"
                + " _ __     __| (_) __ _ \n"
                + "                   | |/ _ \\ '_ \\ / _` |/ _` | | | | | '_ "
                + "\\  | '_ \\| | | |/"
                + " _ \\ '_ \\   / _` | |/ _` |\n"
                + "                   | |  __/ | | | (_| | (_| | | |_| | | | | "
                + "| |_) | |_| |  __/"
                + " | | | | (_| | | (_| |\n"
                + "                   |_|\\___|_| |_|\\__, |\\__,_|  \\__,_|_| "
                + "|_| |_.__/ \\__,_|"
                + "\\___|_| |_|  \\__,_|_|\\__,_|\n"
                + "                                 |___/";

        return despe + "\n" + despe2;
    }

    public static void saltos_linea(int salt) {
        for (int i = 0; i < salt; i++) {
            System.out.println();
        }
    }

    public static void numMenuError() {
        saltos_linea(2);
        System.out.println("ERROR: Por favor, introduzca un "
                + "numero del 1 al 9");
    }

    public static void datoMenuError() {
        saltos_linea(3);
        System.out.println("ERROR: Entrada de datos errona, por favor"
                + " introduzca un dato númerico");
    }

    public static void cargarDatos() {

        // VARIABLES
        Persona per, per2, titular, titular2, titular2_1;
        Autorizacion auto, auto2;
        CuentaBancaria c1, c2;

        //TITULARES
        titular = new Persona("33444666S", "Juan Sanchez Ruiz");
        titular2 = new Persona("11222333P", "Maria Abad Espinosa ");
        titular2_1 = new Persona("77555333R", "Javier Perez Martinez");

        //CUENTAS
        c1 = new CuentaBancaria(b1.numCuenAsig(), titular);
        b1.crearCuenta(c1);
        c2 = new CuentaBancaria(b1.numCuenAsig(), titular2);
        b1.crearCuenta(c2);

        //AUTORIZACIONES
        c1.nuevoTitular(titular);
        c2.nuevoTitular(titular2);
        c2.nuevoTitular(titular2_1);

        //PERSONAS
        per = new Persona("12345678R", "Guillermo Sanchez Ruiz");
        auto = new Autorizacion(per, "1");
        c1.autorizar(auto);
        per = new Persona("36419756T", "Lucia Lopez Diaz");
        auto = new Autorizacion(per, "2");
        c1.autorizar(auto);
        per2 = new Persona("87654321L", "Pedro Cabadas Olmos");
        auto2 = new Autorizacion(per2, "1");
        c2.autorizar(auto2);
        per2 = new Persona("99555111W", "Laura Rodriguez Perez");
        auto2 = new Autorizacion(per2, "2");
        c2.autorizar(auto2);
    }

    public static int menu() {
        int modo;
        Scanner sc1 = new Scanner(System.in);

        String[] menu = {
            "CREAR CUENTA              ",
            "LISTA CUENTAS             ",
            "INFORMACIÓN DE LA CUENTA  ",
            "GESTIONAR TITULARES CUENTA",
            "MODIFICAR DATOS CUENTA    ",
            "BORRAR CUENTA             ",
            "AUTORIZAR PERSONA         ",
            "DESAUTORIZAR PERSONA      ",
            "INGRESAR DINERO           ",
            "SACAR DINERO              ",
            "MOSTRAR REGISTRO          ",
            "SALIR                     "};

        System.out.println("                                       "
                + "MENU: ELECCIÓN DE MODO");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("                          "
                    + "+---------------------------------------"
                    + "----------+");
            System.out.print("                          |     ");
            if (i < 9) {
                System.out.print("MODO: " + (i + 1));
                System.out.print("       |");
            } else {
                System.out.print("MODO: " + (i + 1));
                System.out.print("      |");
            }
            for (int j = 0; j < 1; j++) {
                System.out.println("  " + menu[i] + " |");
            }
        }
        System.out.println("                          "
                + "+---------------------------------------"
                + "----------+");
        saltos_linea(2);
        System.out.print("                          "
                + "                 ELEGIR MODO : -> ");
        modo = sc1.nextInt();

        saltos_linea(3);
        return modo;
    }

    public static void crearCuenta() {

        // VARIABLES
        String dni, nombre, continuar;
        Persona titular;
        CuentaBancaria c1;
        // SCANNER LINE
        Scanner sc = new Scanner(System.in);

        System.out.println("           CREAR CUENTA");
        System.out.println("------------------------------------");
        System.out.print("TITULAR -> || DNI : ->");
        dni = sc.nextLine();
        System.out.print("           || NOMBRE : -> ");
        nombre = sc.nextLine();

        titular = new Persona(dni, nombre);
        c1 = new CuentaBancaria(b1.numCuenAsig(), titular);
        c1.nuevoTitular(titular);

        if (b1.crearCuenta(c1)) {
            System.out.println();
            System.out.println("La cuenta nº " + c1.getNumCuenta()
                    + " con titular " + titular.toString()
                    + " ha sido creada con EXITO");

            System.out.println();
            System.out.println("¿QUIERE AÑADIR OTRO TITULAR? (SI/NO)");
            continuar = sc.nextLine();
            saltos_linea(2);

            while (continuar.equalsIgnoreCase("si")) {
                System.out.print("TITULAR -> || DNI : ->");
                dni = sc.nextLine();
                System.out.print("           || NOMBRE : -> ");
                nombre = sc.nextLine();

                titular = new Persona(dni, nombre);

                if (c1.nuevoTitular(titular)) {
                    System.out.println("El titular con dni " + dni
                            + " ha sido creado con EXITO en la cuenta nº "
                            + c1.getNumCuenta());
                } else {
                    System.out.println("ERROR: El titular con dni " + dni
                            + " NO ha sido creado en la cuenta nº "
                            + c1.getNumCuenta() + " puesto que ya existe");
                }
                System.out.println();
                System.out.println("¿QUIERE AÑADIR OTRO TITULAR? (SI/NO)");
                continuar = sc.nextLine();
                saltos_linea(2);
            }
        } else {
            System.out.println();
            System.out.println("ERROR: La cuenta nº" + c1.getNumCuenta()
                    + " ya se encuentra registrada en "
                    + b1.getNomBanco());

        }

    }

    public static void listaCuentas() {
        System.out.println("           LISTA CUENTAS:");
        System.out.println("------------------------------------");
        System.out.println(b1.toString());
    }

    public static void informacionCuenta() {

        // VARIABLES
        long nCuenta;
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("        INFORMACIÓN CUENTA:");
        System.out.println("------------------------------------");
        System.out.print("  Nº CUENTA: -> ");
        nCuenta = sc3.nextLong();

        if (b1.existe(nCuenta) != null) { // si existe la cuenta
            System.out.println(b1.buscCuent(nCuenta).informacionCuenta());
        } else {
            System.out.println("La cuenta nº " + nCuenta
                    + " no existe en " + b1.getNomBanco());
        }
    }

    public static void gestionarTitulaes() {
        // VARIABLES
        long nCuenta;
        int modo = -1, comprobante;
        String dni, nombre;
        Persona titular, desautTitu;
        CuentaBancaria buscCuenta;

        // SCANNER LINE
        Scanner sc = new Scanner(System.in);
        // SCANNER INT
        Scanner sc1 = new Scanner(System.in);
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("      GESTION DE TITULARES:");
        System.out.println("-----------------------------------");
        try {
            System.out.print("Nº CUENTA : -> ");
            nCuenta = sc3.nextLong();
            buscCuenta = b1.buscCuent(nCuenta);

            if (b1.existe(nCuenta) != null) { // si existe la cuenta
                do {
                    System.out.println();
                    System.out.println("    || AÑADIR TITULAR : -> 1");
                    System.out.println("    || ELIMINAR TITULAR : -> 2");
                    System.out.println("    || SALIR    : -> 3");
                    System.out.println("   //");

                    try {
                        System.out.print("  // ELEGIR MODO : -> ");
                        modo = sc1.nextInt();
                        if (modo <= 3 && modo > 0) { // ELEGIR MODO
                            System.out.println("  ||");
                            System.out.println("  ||");

                            switch (modo) {
                                case 1:
                                    System.out.print("  || DNI : ->");
                                    dni = sc.nextLine();
                                    System.out.print("   || NOMBRE : -> ");
                                    nombre = sc.nextLine();

                                    titular = new Persona(dni, nombre);

                                    if (buscCuenta.nuevoTitular(titular)) {
                                        System.out.println("El titular con dni " + dni
                                                + " ha sido creado con EXITO en la cuenta nº "
                                                + buscCuenta.getNumCuenta());
                                    } else {
                                        System.out.println("ERROR: El titular con dni " + dni
                                                + " NO ha sido creado en la cuenta nº "
                                                + buscCuenta.getNumCuenta()
                                                + " puesto que ya existe");
                                    }
                                    modo = 3;
                                    break;

                                case 2:
                                    comprobante = buscCuenta.getListaTitulares().size();
                                    if (comprobante != 1) {
                                        System.out.print("  || DNI : ->");
                                        dni = sc.nextLine();
                                        desautTitu = buscCuenta.removeTitu(dni);

                                        if (desautTitu != null) {
                                            System.out.println(desautTitu + " ha sido eliminado"
                                                    + " con EXITO de la cuenta nº "
                                                    + nCuenta);
                                        } else {
                                            System.out.println("ERROR: Al eliminar el"
                                                    + " titular con el dni -> " + dni
                                                    + " de la cuenta nº " + nCuenta);
                                        }
                                        modo = 3;
                                    } else {
                                        System.out.println("  || -> NO puede"
                                                + " realizar "
                                                + "esta operación puesto que "
                                                + "solo queda un titular en la "
                                                + "cuenta nº " + nCuenta);
                                    }
                                    break;

                                case 3:
                                    System.out.println("SALIR");
                                    break;
                            }
                        } else { // NUMERO DE MODO NO EXISTENTE
                            saltos_linea(2);
                            System.out.println("ERROR: Por favor, introduzca un"
                                    + " numero del 1 al 3");
                            saltos_linea(2);

                        }

                    } catch (InputMismatchException e3) { // TRY CATCH AL METER UNA LETRA
                        saltos_linea(2);
                        System.out.println("ERROR: Entrada de datos errona, "
                                + "solo acepta datos númerico");
                        sc1.next();
                        saltos_linea(2);

                    }
                } while (modo != 3);

                //  NO EXISTE LA CUENTA
            } else {
                saltos_linea(2);
                System.out.println("ERROR: El numero de cuenta "
                        + nCuenta + " no existe en "
                        + b1.getNomBanco());

            }

        } catch (InputMismatchException e1) { // TRY CATCH AL METER UNA LETRA
            saltos_linea(2);
            System.out.println("ERROR: Entrada de datos errona, "
                    + "solo acepta datos númerico");
        }
    }

    public static void modificarDatosCuenta() {

        // VARIABLES
        long nCuenta;
        int modo = -1;
        String dni, modiDni, nombre;
        Persona per;

        // SCANNER LINE
        Scanner sc = new Scanner(System.in);
        // SCANNER INT
        Scanner sc1 = new Scanner(System.in);
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("     MODIFICAR DATOS DE LA "
                + "CUENTA:");
        System.out.println("----------------------------"
                + "--------");
        try {
            System.out.print("Nº CUENTA : -> ");
            nCuenta = sc3.nextLong();

            if (b1.existe(nCuenta) != null) { // si existe la cuenta
                System.out.println();

                System.out.print("DNI DE TITULAR A MODIFICAR ->"); // elige el titular a modificar
                modiDni = sc.nextLine();

                System.out.println();
                per = new Persona(modiDni, "");
                if (b1.buscCuent(nCuenta).existeTitular(per) != null) { // si existe el titular en la cuenta
                    do {
                        System.out.println("ELIGA LOS DATOS A MODIFICAR "
                                + "DEL TITULAR DNI: " + modiDni
                                + " DE LA CUENTA Nº (" + nCuenta + ")");
                        System.out.println("    || NIF : -> 1");
                        System.out.println("    || NOMBRE : -> 2");
                        System.out.println("    || SALIR    : -> 3");
                        System.out.println("   //");

                        try {
                            System.out.print("  // ELEGIR MODO : -> ");
                            modo = sc1.nextInt();

                            if (modo <= 3 && modo > 0) { // ELEGIR MODO
                                System.out.println("  ||");
                                System.out.println("  ||");
                                switch (modo) {

                                    case 1:
                                        System.out.print("  \\\\ NUEVO NIF : ->");
                                        dni = sc.nextLine();
                                        b1.setNifTitular(nCuenta, modiDni, dni);
                                        System.out.println("La cuenta nº "
                                                + nCuenta + " ha realizado un "
                                                + " cambio al dni del titular a "
                                                + dni);
                                        modo = 3;
                                        break;

                                    case 2:
                                        System.out.print("  \\\\ NUEVO NOMBRE : ->");
                                        nombre = sc.nextLine();
                                        b1.setNombreTitular(nCuenta, modiDni, nombre);
                                        System.out.println("La cuenta nº "
                                                + nCuenta + " ha realizado un "
                                                + " cambio al nombre del titular a "
                                                + nombre);
                                        modo = 3;
                                    case 3:
                                        System.out.println("SALIR");
                                        break;
                                }

                                // CONTROL DEL MENU AL ELEGIR UN NÚMERO QUE NO TOCA
                            } else {
                                saltos_linea(2);
                                System.out.println("ERROR: Por favor, introduzca un"
                                        + " numero del 1 al 3");
                                saltos_linea(2);

                            }
                        } catch (InputMismatchException e3) { // TRY CATCH AL METER UNA LETRA
                            saltos_linea(2);
                            System.out.println("ERROR: Entrada de datos errona, "
                                    + "solo acepta datos númerico");
                            sc1.next();

                        }

                    } while (modo != 3);

                    // NO ESXISTE EL TITULAR EN DICHA CUENTA
                } else {
                    saltos_linea(2);
                    System.out.println("ERROR: no existe ningun titular "
                            + "con dni " + modiDni
                            + " en la cuenta nº " + nCuenta);

                }

                //  NO EXISTE LA CUENTA
            } else {
                saltos_linea(2);
                System.out.println("ERROR: El numero de cuenta "
                        + nCuenta + " no existe en "
                        + b1.getNomBanco());

            }

        } catch (InputMismatchException e1) { // TRY CATCH AL METER UNA LETRA
            saltos_linea(2);
            System.out.println("ERROR: Entrada de datos errona, "
                    + "solo acepta datos númerico");
        }
    }

    public static void borrarCuenta() {

        // VARIABLES
        long nCuenta;
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("           ELIMINAR CUENTA");
        System.out.println("------------------------------------");
        System.out.print("Nº DE CUENTA : ->");
        nCuenta = sc3.nextLong();

        if (b1.eliminarCuenta(nCuenta)) {
            System.out.println("La cuenta nº " + nCuenta
                    + " ha sido elimindada con EXITO");
        } else {
            System.out.println("La cuenta nº " + nCuenta
                    + " no existe en " + b1.getNomBanco());
        }
    }

    public static void autorizarPersonas() {

        // VARIABLES
        long nCuenta;
        String dni, nombre, nivel;
        Persona per;
        Autorizacion auto;
        CuentaBancaria buscCuenta;

        // SCANNER LINE
        Scanner sc = new Scanner(System.in);
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("         AUTORIZAR PERSONA:");
        System.out.println("------------------------------------");
        System.out.print("NUMº DE CUENTA : ->");
        nCuenta = sc3.nextLong();
        buscCuenta = b1.buscCuent(nCuenta);

        if (b1.existe(nCuenta) != null) {  // si existe la cuenta

            System.out.print("DNI : -> ");
            dni = sc.nextLine();

            per = new Persona(dni);
            if (buscCuenta.existeTitular(per) == null) { // si existe el titular salta, puesto que no podemos 
                System.out.print("NOMBRE : ->");                    // autorizar a alguien con un dni igual al de un titular.
                nombre = sc.nextLine();                             // Para ello, deberiamos eliminar al titular de titular
                System.out.print("NIVEL : ->");                     // y entonces añadirlo a autorizado.
                nivel = sc.nextLine();
                if (nivel.equals("1") || nivel.equals("2")) {
                    per = new Persona(dni, nombre);
                    auto = new Autorizacion(per, nivel);
                    if (buscCuenta.autorizar(auto)) {
                        System.out.println(nombre + " con dni " + dni
                                + " ha sido autorizaca con EXITO");
                        System.out.println("|-- nivel de autorizacion: -> "
                                + nivel);
                    } else {
                        System.out.println("ERROR: " + nombre + " con dni "
                                + dni + " ya se encuentra autorizada en "
                                + "la cuenta");
                    }
                } else {
                    System.out.println("ERROR: no se le puede asignar un permiso"
                            + " de nivel " + nivel + " (1 = ver saldo / 2 = ingresar "
                            + "y sacar saldo)");
                }
            } else {
                System.out.println("ERROR: no puedes autorizar la persona con "
                        + "dni " + dni + " puesto que coincide con el de un "
                        + " titular");
            }

        } else {
            System.out.println("La cuenta nº " + nCuenta
                    + " no existe en " + b1.getNomBanco());
        }
    }

    public static void desautorizarPersona() {
        // VARIABLES
        long nCuenta;
        String dni;
        Autorizacion desautPer;
        CuentaBancaria buscCuenta;

        // SCANNER LINE
        Scanner sc = new Scanner(System.in);
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("       DESAUTORIZAR PERSONA:");
        System.out.println("------------------------------------");
        System.out.print("NUMº DE CUENTA : ->");
        nCuenta = sc3.nextLong();
        buscCuenta = b1.buscCuent(nCuenta);

        if (b1.existe(nCuenta) != null) {  // si existe la cuenta

            if (!buscCuenta.getListaAutorizados().isEmpty()) { // si no esta vacia
                System.out.print("NIF ->");
                dni = sc.nextLine();
                desautPer = buscCuenta.desautorizar(dni);

                if (desautPer != null) {
                    System.out.println(desautPer + " ha sido desautorizado"
                            + " con EXITO");
                } else {
                    System.out.println("ERROR: Al desautorizar la"
                            + " persona con el dni -> " + dni);
                }
            } else {
                System.out.println("ERROR: La cuenta nº " + nCuenta
                        + " no tienen ninguna persoa autorizada");
            }

        } else {
            System.out.println("La cuenta nº " + nCuenta
                    + " no existe en " + b1.getNomBanco());
        }
    }

    public static void ingresarDinero() {
        // VARIABLES
        long nCuenta;
        double cantidad;
        String dni, nivel, descripcion;
        Persona per;
        Autorizacion auto;
        CuentaBancaria buscCuenta;

        // SCANNER LINE
        Scanner sc = new Scanner(System.in);
        // SCANNER DOUBLE
        Scanner sc2 = new Scanner(System.in);
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("        INGRESAR DINERO:");
        System.out.println("------------------------------------");
        System.out.print("NUMº DE CUENTA : ->");
        nCuenta = sc3.nextLong();
        buscCuenta = b1.buscCuent(nCuenta);
        System.out.println();

        if (b1.existe(nCuenta) != null) {  // si existe la cuenta

            System.out.print("Identifiquese con el dni ->");
            dni = sc.nextLine();
            per = new Persona(dni);
            auto = new Autorizacion(per);
            System.out.println();

            if (buscCuenta.existeTitular(auto.getPersona()) != null // si la persona esta registrada en 
                    || buscCuenta.existePersona(auto.getPersona()) != null) {// la cuenta (tanto en la lista de autorizados o titulares)

                System.out.println("¿Qué cantidad de dinero desea "
                        + "ingresar?");
                System.out.print("INGRESAR: -> ");
                cantidad = sc2.nextDouble();
                System.out.println();
                System.out.println("DESCRIPCION DE MOVIMIENTO: ------------| ");
                System.out.print("(Opcional \"tecla "
                        + "enter para saltar\")   |-> ");
                descripcion = sc.nextLine();
                nivel = buscCuenta.ingresar(dni, cantidad, descripcion); // obtengo el nivel 
                switch (nivel) {                                                     //del que ingresa
                    case "1":
                        System.out.println("DENEGADO: Su nivel de "
                                + "autorizacion (1)"
                                + " solo le permite ver el SALDO -> "
                                + buscCuenta.getSaldo());
                        break;
                    case "2":
                        System.out.println("Ha ingresado la cantidad de "
                                + cantidad + " €");
                        System.out.println("SALDO ACTUAL: -> "
                                + buscCuenta.getSaldo());

                        break;
                    case "3":
                        System.out.println("DENEGADO: imposible ingresar saldo "
                                + "negativo");
                        break;
                    case "0":
                        System.out.println("DENEGADO: Usted no esta autorizado en "
                                + "esta cuenta");
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("DENEGADO: La persona con dni "
                        + dni + " no se encuentra registrada en la"
                        + " cuenta nº" + nCuenta);
            }

        } else {
            System.out.println("DENEGADO: La cuenta nº " + nCuenta
                    + " no existe en " + b1.getNomBanco());
        }
    }

    public static void sacarDinero() {

        // VARIABLES
        long nCuenta;
        double cantidad;
        String dni, nivel, descripcion;
        Persona per;
        Autorizacion auto;
        CuentaBancaria temp, buscCuenta;

        // SCANNER LINE
        Scanner sc = new Scanner(System.in);
        // SCANNER DOUBLE
        Scanner sc2 = new Scanner(System.in);
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("        SACAR DINERO:");
        System.out.println("------------------------------------");
        System.out.print("NUMº DE CUENTA : ->");
        nCuenta = sc3.nextLong();
        buscCuenta = b1.buscCuent(nCuenta);
        temp = new CuentaBancaria(nCuenta, null);
        System.out.println();

        if (b1.existe(nCuenta) != null) { // si existe la cuenta

            System.out.print("Identifiquese con el dni ->");
            dni = sc.nextLine();
            per = new Persona(dni);
            auto = new Autorizacion(per);
            System.out.println();

            if (buscCuenta.existeTitular(auto.getPersona()) != null // si la persona esta registrada en 
                    || buscCuenta.existePersona(auto.getPersona()) != null) {  // (tanto en la lista de autorizados o titulares)

                System.out.println("¿Qué cantidad de dinero desea retirar?");
                System.out.print("SACAR: ->");
                cantidad = sc2.nextDouble();
                System.out.println();
                System.out.println("DESCRIPCION DE MOVIMIENTO: ------------| ");
                System.out.print("(Opcional \"tecla "
                        + "enter para saltar\")   |-> ");
                descripcion = sc.nextLine();
                nivel = buscCuenta.sacar(dni, cantidad, descripcion); // obtengo el nivel 
                switch (nivel) {                                                  // del que saca
                    case "1":
                        System.out.println("DENEGADO: Su nivel de "
                                + "autorizacion (1)"
                                + " solo le permite ver el SALDO -> "
                                + buscCuenta.getSaldo());
                        break;
                    case "2":
                        System.out.println("Ha sacado la cantidad de "
                                + cantidad + " €");
                        System.out.println("SALDO ACTUAL: -> "
                                + buscCuenta.getSaldo());
                        break;
                    case "3":
                        System.out.println("DENEGADO: No es posible sacar de su "
                                + "cuenta " + cantidad + " € porque "
                                + "actualmente su saldo és de "
                                + buscCuenta.getSaldo() + " €");
                        break;
                    case "4":
                        System.out.println("DENEGADO: Usted no esta autorizado en "
                                + "esta cuenta");
                        break;
                    default:
                        break;
                }

            } else {
                System.out.println("DENEGADO: La persona con dni "
                        + dni + " no se encuentra registrada en la"
                        + " cuenta nº" + nCuenta);
            }
        } else {
            System.out.println("DENEGADO: La cuenta nº " + nCuenta
                    + " no existe en " + b1.getNomBanco());
        }

    }

    public static void mostrarRegistro() {

        // VARIABLES
        long nCuenta;
        CuentaBancaria buscCuenta;
        // SCANNER LONG
        Scanner sc3 = new Scanner(System.in);

        System.out.println("             REGISTRO CUENTA:");
        System.out.println("-------------------------------------------------");
        System.out.print("  Nº CUENTA: -> ");
        nCuenta = sc3.nextLong();
        buscCuenta = b1.buscCuent(nCuenta);

        if (b1.existe(nCuenta) != null) { // si existe la cuenta
            if (buscCuenta.mostrarRegistro() != null) {
                System.out.println(buscCuenta.mostrarRegistro());
            } else {
                System.out.println("No hay registros en esta cuenta");
            }
        } else {
            System.out.println("La cuenta nº " + nCuenta
                    + " no existe en " + b1.getNomBanco());
        }
    }

}
