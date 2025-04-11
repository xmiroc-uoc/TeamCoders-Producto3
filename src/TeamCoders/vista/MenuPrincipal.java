package vista;

/**
 * Clase principal encargada de mostrar el menú principal de la aplicación.
 * Gestiona la navegación del usuario hacia los submenús de clientes, artículos y pedidos.
 */
public class MenuPrincipal {
    
    private ClienteVista clienteVista = new ClienteVista();
    private ArticuloVista articuloVista = new ArticuloVista();
    private PedidoVista pedidoVista = new PedidoVista();

    /**
     * Muestra el menú principal de la aplicación, permitiendo al usuario acceder a los distintos submenús.
     */
    public void mostrarMenuPrincipal() {
        int option;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Artículos");
            System.out.println("3. Gestión de Pedidos");
            System.out.println("0. Salir");
            
            // Se lee la opción del usuario, validando el rango permitido
            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0,3);

            // Lógica de navegación entre submenús según la opción elegida
            switch (option) {
                case 1:
                    clienteVista.mostrarMenuClientes();
                    break;
                case 2:
                    articuloVista.mostrarMenuArticulo();
                    break;
                case 3:
                    pedidoVista.mostrarMenuPedido();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación... ");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (option != 0);
    }

}
