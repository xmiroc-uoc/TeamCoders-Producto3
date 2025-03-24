package controlador;

import modelo.*;
import vista.*;

import java.util.*;


public class Tienda {
   
    private Datos datos = new Datos();
    private TiendaView menu = new TiendaView();
    static Scanner teclado = new Scanner(System.in);


    public void navegarTienda(){
        String opcion = "";

        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuGeneral();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    System.out.println("Ha escogido Gestión de Articulos\n");
                    navegarArticulos(opcion);
                    break;
                case "2":
                    System.out.println("Ha escogido Gestión de Clientes\n");
                    navegarClientes(opcion);
                    break;
                case "3":
                    System.out.println("Ha escogido Gestión de Pedidos\n");
                    navegarPedidos(opcion);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Escoja entre las opciones disponibles.\n");
                    break;
            }
        }
    }

    public void navegarArticulos(String opcion){
        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuArticulos();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    agregarArticulo();
                    break;
                case "2":
                    datos.mostrarArticulo();
                    System.out.print("\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Escoja entre las opciones disponibles.\n");
                    break;
            }
        }
    }

    public void navegarClientes(String opcion){
        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuClientes();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    agregarCliente();
                    break;
                case "2":
                    datos.mostrarClientes();
                    System.out.print("\n");
                    break;
                case "3":
                    datos.mostrarClientesEstandar();
                    System.out.print("\n");
                    break;
                case "4":
                    datos.mostrarClientesPremium();
                    System.out.print("\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Escoja entre las opciones disponibles.\n");
                    break;
            }
        }
    }

    public void navegarPedidos(String opcion){
        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuPedidos();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    agregarPedido();
                    break;
                case "2":
                    eliminarPedido();
                    break;
                case "3":
                    datos.mostrarPedidosPendientes();
                    System.out.print("\n");
                    break;
                case "4":
                    datos.mostrarPedidosEnviados();
                    System.out.print("\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Escoja entre las opciones disponibles.\n");
                    break;
            }
        }
    }

    public void agregarArticulo(){
        String codigo = "";
        int tiempoPreparacion;
        float gastosEnvio;
        float precioVenta;
        String descripcion = "";

        System.out.println("Introduzca el codigo\n");
        codigo = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el timepo de preparación en minutos\n");
        tiempoPreparacion = teclado.nextInt();
        System.out.print("\n");

        System.out.println("Introduzca los gastos de envio\n");
        gastosEnvio = teclado.nextFloat();
        System.out.print("\n");

        System.out.println("Introduzca el precio de venta\n");
        precioVenta = teclado.nextFloat();
        System.out.print("\n");

        System.out.println("Introduzca una descripción\n");
        teclado.nextLine();
        descripcion = teclado.nextLine();
        System.out.print("\n");

        Articulo newArticulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
        
        datos.agregarArticulo(newArticulo);
    }

    public void agregarCliente(){
        String nombre = "";
        String domicilio = "";
        String nif = "";
        String email = "";
        String opcion = "";
        boolean opcionPosible = false;

        while(!opcionPosible){
            System.out.println("Que tipo de cliente quiere agregar:\r\n" + //
                            "1. Cliente Estándar\r\n" + //
                            "2. Cliente Premium");
            
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            if(opcion.equals("1") || opcion.equals("2")){
                opcionPosible = true;
            }else{
                System.out.println("Escoja entre las opciones disponibles.\\n");
            }
        }
        

        System.out.println("Introduzca el nombre\n");
        nombre = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el domicilio\n");
        domicilio = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el NIF\n");
        nif = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el mail\n");
        email = teclado.nextLine();
        System.out.print("\n");

        if(opcion.equals("1")){
            Cliente newCliente = new ClienteEstandar(nombre, domicilio, nif, email);
            datos.agregarCliente(newCliente);
        }else{
            int cuotaAnual;
            
            System.out.println("Introduzca la cuota anual\n");
            cuotaAnual = teclado.nextInt();
            teclado.nextLine();
            System.out.print("\n");

            Cliente newCliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
            datos.agregarCliente(newCliente);
        }
    }

    public void agregarPedido(){
        int numPedido;
        int unidades;
        Cliente clienteSeleccionado;
        Articulo articuloSeleccionado;
        

        System.out.println("Introduzca numero de pedido\n");
        numPedido = teclado.nextInt();
        System.out.print("\n");

        System.out.println("Introduzca el numero de unidades\n");
        unidades = teclado.nextInt();
        System.out.print("\n");

        String opcion = "";
        boolean opcionPosible = false;

        while(!opcionPosible){
            System.out.println("1. Seleccionar entre los clientes existentes\r\n" + //
                            "2. Agregar nuevo cliente");
            
            System.out.print("\n");
            teclado.nextLine();
            opcion = teclado.nextLine();
            System.out.print("\n");

            if(opcion.equals("1") || opcion.equals("2")){
                opcionPosible = true;
            }else{
                System.out.println("Escoja entre las opciones disponibles.");
            }
        }

        if(opcion.equals("2")){
            agregarCliente();
            clienteSeleccionado = datos.getClientes().get((datos.getClientes().size())-1);
        }else{
            int opcionCliente = 0;
            while(opcionPosible){
                System.out.println("Seleccione un cliente");
                datos.mostrarClientes();
                System.out.println("\n");
                
                opcionCliente = teclado.nextInt();
                if(opcionCliente > 0 && opcionCliente <= datos.getClientes().size()){
                    opcionPosible = false;
                }
            }
            clienteSeleccionado = datos.getClientes().get(opcionCliente - 1);
        }

        int opcionArticulo = 0;
        boolean opcionArtPosible = false;

        while(!opcionArtPosible){
            System.out.println("Seleccione un articulo");
            datos.mostrarArticulo();
            System.out.println("\n");

            opcionArticulo = teclado.nextInt();
            if(opcionArticulo>0 && opcionArticulo <= datos.getArticulos().size()){
                opcionArtPosible = true;
            }else{
                System.out.println("Escoja entre las opciones disponibles.");
            }
        }

        articuloSeleccionado = datos.getArticulos().get(opcionArticulo - 1);

        Date fecha = new Date();
        Pedido newPedido = new Pedido(numPedido, unidades, fecha, clienteSeleccionado, articuloSeleccionado);
        datos.agregarPedido(newPedido);
    }

    public void eliminarPedido(){
        int opcionPedido = 0;
        boolean opcionPedPosible = false;

        while (!opcionPedPosible) {
            System.out.println("Escoja el pedido que quiere eliminar");
            datos.mostrarPedidos();
            System.out.println("\n");

            opcionPedido = teclado.nextInt();
            if(opcionPedido>0 && opcionPedido <= datos.getPedidos().size()){
                opcionPedPosible = true;
                boolean eliminarPosible = checkPedidoEnviado(datos.getPedidos().get(opcionPedido-1));
                if(eliminarPosible){
                    datos.eliminarPedido(datos.getPedidos().get(opcionPedido - 1));
                }else{
                    System.out.println("Este pedido no se puede eliminar");
                }
                
            }else{
                System.out.println("Escoja entre las opciones disponibles.");
            }

        }
    }

    public boolean checkPedidoEnviado(Pedido pedido){
        boolean eliminar = false;
        Calendar calendar = Calendar.getInstance();
        Date actualidad = new Date();
        calendar.setTime(pedido.getFechaPedido());
        calendar.add(Calendar.MINUTE, pedido.getArticulo().getTiempoPreparacion());
        if(!calendar.getTime().before(actualidad)){
            eliminar = true;
        }

        return eliminar;
    }

}
