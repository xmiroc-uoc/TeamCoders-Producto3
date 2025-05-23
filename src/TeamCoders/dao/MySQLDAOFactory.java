package dao;

import dao.mysql.ArticuloDAOMySQL;
import dao.mysql.ClienteDAOMySQL;
import dao.mysql.PedidoDAOMySQL;

/**
 * Fábrica concreta que implementa el patrón DAOFactory para MySQL.
 * Proporciona instancias concretas de DAOs compatibles con MySQL.
 * 
 * Esta clase encapsula la lógica de creación de los objetos DAO específicos
 * y permite desacoplar la lógica del negocio del tipo de base de datos
 * utilizada.
 */
public class MySQLDAOFactory extends DAOFactory {

    /**
     * Devuelve una instancia de {@link IClienteDAO} compatible con MySQL.
     * 
     * @return Implementación de IClienteDAO para MySQL.
     */
    @Override
    public IClienteDAO getClienteDAO() {
        return new ClienteDAOMySQL();
    }

    /**
     * Devuelve una instancia de {@link IArticuloDAO} compatible con MySQL.
     * 
     * @return Implementación de IArticuloDAO para MySQL.
     */
    @Override
    public IArticuloDAO getArticuloDAO() {
        return new ArticuloDAOMySQL();
    }

    /**
     * Devuelve una instancia de {@link IPedidoDAO} compatible con MySQL.
     * 
     * @return Implementación de IPedidoDAO para MySQL.
     */
    @Override
    public IPedidoDAO getPedidoDAO() {
        return new PedidoDAOMySQL();
    }
}
