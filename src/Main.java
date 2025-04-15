import java.util.Scanner;

public class Main {

    static int totalIngresos = 0;
    static int ventasVip = 0;
    static int ventasPlatea = 0;
    static int ventasGeneral = 0;
    static int ventasGlobales = 0;
    static int cantEntradasUsuario = 0;
    static boolean huboCompra = false;
    static String ultimaUbicacion = "";
    static int ultimoTotal = 0;
    static int ultimaCantEntradas = 0;
    static String ultimoDescuento = "";


    public static void CalculoPrecio(int edad , boolean esEstudiante , int entradas, double descuento) {

        if (edad > 65) { //Aplicando descuentos
            System.out.println("Se te aplica el descuento de tercera edad");
            descuento = 0.15;
            ultimoDescuento = "Tercera Edad ";
        } else if (esEstudiante) {
            System.out.println("Se te aplica el descuento de estudiante");
            descuento = 0.1;
            ultimoDescuento = "Estudiante ";
        }

        if (entradas > 1) {
            System.out.println("Aplicas a un descuento por compra de multiples entradas");
            descuento += 0.1;
            ultimoDescuento += "Entradas multiples";
        }

        Scanner scanner = new Scanner(System.in);
        int ubicacion;
        int total = 0;

        while (true) { //Validando ubicacion y calculando precio de venta
            ubicacion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Descuento de " + descuento);
            switch (ubicacion) {//Calcula precios en base a ubicación, cantidad de entradas compradas y descuento

                case 1:
                    System.out.println("Has escogido la ubicacion VIP de valor $25000");
                    total = (int) ((25000 * entradas) - (25000 * entradas * descuento));
                    System.out.println("El total asciende a " + total + " pesos");
                    ultimaCantEntradas = entradas;
                    ultimoTotal = total;
                    ultimaUbicacion = "VIP";
                    ventasGlobales += entradas;
                    ventasVip += entradas;
                    totalIngresos += total;
                    break;

                case 2:
                    System.out.println("Has escogido la ubicacion Platea de valor $15000");
                    total = (int) ((15000 * entradas) - (15000 * entradas * descuento));
                    System.out.println("El total asciende a " + total + " pesos");
                    ultimaCantEntradas = entradas;
                    ultimoTotal = total;
                    ultimaUbicacion = "Platea";
                    ventasGlobales += entradas;
                    ventasPlatea += entradas;
                    totalIngresos += total;
                    break;

                case 3:
                    System.out.println("Has escogido la ubicacion General de valor $10000");
                    total = (int) ((10000 * entradas) - (10000 * entradas * descuento));
                    System.out.println("El total asciende a " + total + " pesos");
                    ultimaCantEntradas = entradas;
                    ultimoTotal = total;
                    ultimaUbicacion = "General";
                    ventasGlobales += entradas;
                    ventasGeneral += entradas;
                    totalIngresos += total;
                    break;

                default:
                    System.out.println("No has escogido tu ubicacion de forma correcta, inténtalo de nuevo");
                    break;

            }

            System.out.println("Gracias por tu compra! disfruta la función!");
            huboCompra = true; //Deja registro de que hubo al menos una primera compra
            break;
        }
    }


    public static void main(String[] args) {
        System.out.println("Bienvenido/a al Teatro Moro! Por favor, escoge alguna de las siguientes opciones");
        int cantidadEntradasVendidas = 0;

        int opcion = 0; //Variable entradas de usuario para menú
        boolean salir = false; //Booleano que cambia a True cuando el usuario quiera salir del programa
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n--- OPCIONES ---");
            System.out.println("1. Comprar Entradas");
            System.out.println("2. Ver promociones");
            System.out.println("3. Buscar Entradas");
            System.out.println("4. Eliminar Entradas");
            System.out.println("5. Salir del programa");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 5: //Opción de salir del programa
                    System.out.println("Adios!");
                    salir = true;
                    break;

                case 1: //Ingreso de datos del usuario (Edad/Estudiante/Cant entradas a comprar)
                    double descuento = 0;
                    int edad = 0;
                    String preguntaEstudiante = "";
                    boolean esEstudiante = false;

                    while (true) { //Validación de edad ingresada
                        System.out.println("Ingresa tu edad: ");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                        if (edad > 10 && edad < 100) {
                            break;
                        } else {
                            System.out.println("La edad ingresada no es correcta, por favor, intentalo de nuevo");
                        }
                    }

                    while (true) { //Validando calidad de estudiante
                        System.out.println("Eres estudiante? Sí/No");
                        preguntaEstudiante = scanner.nextLine();
                        if (preguntaEstudiante.equalsIgnoreCase("SI") || preguntaEstudiante.equalsIgnoreCase("SÍ")) {
                            esEstudiante = true;
                            break;
                        } else if (preguntaEstudiante.equalsIgnoreCase("NO")) {
                            break;
                        } else {
                            System.out.println("Respuesta no valida, por favor, intenta de nuevo");
                        }
                    }


                    System.out.println("¿Cuántas entradas deseas comprar? Existe un máximo de 5 por cliente");

                    while (true) { //Pidiendo y validando cantidad de entradas a comprar
                        cantEntradasUsuario = scanner.nextInt();
                        scanner.nextLine();

                        if (cantEntradasUsuario <= 0 || cantEntradasUsuario > 5) {
                            System.out.println("Eligió una cantidad invalida de entradas, por favor elige nuevamente");
                        } else if (cantEntradasUsuario > 1 && cantEntradasUsuario <= 5) {
                            cantidadEntradasVendidas = cantidadEntradasVendidas + cantEntradasUsuario;
                            break;
                        } else {
                            cantidadEntradasVendidas++;
                            break;
                        }
                    }

                    System.out.println("Las ubicaciones disponibles son las siguientes, escoja (1/2/3)\n");
                    System.out.println("1. VIP - Precio = $25000");
                    System.out.println("2. Platea - Precio = $15000");
                    System.out.println("3. General - Precio = $10000");

                    if (cantEntradasUsuario == 1) {
                        CalculoPrecio(edad , esEstudiante , 1 , descuento);
                    } else {
                        CalculoPrecio(edad , esEstudiante , cantEntradasUsuario , descuento);
                    }
                    break;

                case 2:
                    System.out.println("Tenemos los siguientes descuentos disponibles");
                    System.out.println("---DESCUENTOS---");
                    System.out.println("1. Estudiante -->  10% de descuento");
                    System.out.println("2. Tercera edad --> 15% de descuento");
                    System.out.println("3. Compra de más de una entrada --> 10% de descuento al total");
                    break;

                case 3:
                    System.out.println("---Estadísticas globales---");
                    System.out.println("Total de ingresos: $" + totalIngresos);
                    System.out.println("Total de entradas vendidas:" + cantidadEntradasVendidas);
                    System.out.println("Total de entradas VIP vendidas: " + ventasVip);
                    System.out.println("Total de entradas Platea vendidas: " + ventasPlatea);
                    System.out.println("Total de entradas General vendidas: " + ventasGeneral);

                    if (huboCompra == false) {
                        System.out.println("No han habido ventas");
                    } else {
                        System.out.println("Se mostrara la ultima compra:");
                        System.out.println("Ultima ubicacion: " + ultimaUbicacion);
                        System.out.println("Ultima cantidad de entradas compradas: " + ultimaCantEntradas);
                        System.out.println("Ultimo descuento utilizado: " + ultimoDescuento);
                        System.out.println("Ultimo total gastado: " + ultimoTotal);
                    }
                    break;


                case 4:
                    System.out.println("Se borrará la o las ultimas entradas que se compraron");
                    System.out.println("Borrando ultima compra...");
                    huboCompra = false;
                    ultimaUbicacion = "";
                    ultimoTotal = 0;
                    ultimaCantEntradas = 0;
                    ultimoDescuento = "";

                    break;

                default:
                    System.out.println("No has escogido una opcion correcta, intenta de nuevo");
                    break;


            }

        } while (salir == false);


    }


}